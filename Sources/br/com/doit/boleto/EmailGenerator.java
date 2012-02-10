package br.com.doit.boleto;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jboleto.JBoleto;
import org.jboleto.control.PDFGenerator;

import br.com.doit.boleto.templates.WOBoletoBean;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableArray;

import er.javamail.ERMailDeliveryPlainText;
import er.javamail.ERMailFileAttachment;

public class EmailGenerator
{

	public static final String KEY_EMAIL_TEXT = "KEY_EMAIL_TEXT";

	public static final String KEY_EMAIL_SUBJECT = "KEY_EMAIL_SUBJECT";

	public static final String KEY_EMAIL_FROM = "KEY_EMAIL_FROM";

	public static final String KEY_EMAIL_REPLY_TO = "KEY_EMAIL_REPLY_TO";

	public static final String KEY_EMAIL_ATTACHMENT_NAME = "KEY_EMAIL_ATTACHMENT_NAME";

	public static final String KEY_EMAIL_BCC = "KEY_EMAIL_BCC";

	public static final String JOKER_SACADO = "@@sacado@@";

	public static final String JOKER_CEDENTE = "@@cedente@@";

	private static final Logger LOGGER = Logger.getLogger( EmailGenerator.class );

	/** preparar para gerar um pdf */
	public static JBoleto preparePDF( WOBoletoBean jBoletoBean, EOEditingContext editingContext )
	{

		try
		{
			PDFGenerator generator = new PDFGenerator( jBoletoBean, jBoletoBean.getBanco() );

			JBoleto jBoleto = new JBoleto( generator, jBoletoBean, jBoletoBean.getBanco() );

			jBoleto.addBoleto();

			return jBoleto;

		}
		catch( Exception e )
		{
			e.printStackTrace();

			return null;
		}

	}
	
	/** subsituir Joker nos textos */
	public static String replaceJoker( String s, WOBoletoBean jBoletoBean )
	{

		s = StringUtils.trimToEmpty( s );

		return s.replaceAll( JOKER_CEDENTE, jBoletoBean.getCedente() ).replaceAll( JOKER_SACADO, jBoletoBean.getNomeSacado() );
	}

	/**
	 * persistir boleto no banco gerar boleto como pdf, mandar um email com pdf
	 * anexado
	 */
	public static boolean sendEmailWithBoleto( WOBoletoBean jBoletoBean, NSDictionary<String, String> parametros, EOEditingContext editingContext )
	{

		try
		{

			LOGGER.debug( ">>> send Email com pdf anexado ..." );

			JBoleto jBoleto = preparePDF( jBoletoBean, editingContext );

			File file = File.createTempFile( "boleto_" + jBoletoBean.getCedente(), ".pdf" );

			jBoleto.closeBoleto( file.getPath() );

			/** new mail: preencher campos */
			ERMailDeliveryPlainText mailDelivery = new ERMailDeliveryPlainText();

			mailDelivery.newMail();

			mailDelivery.setToAddress( jBoletoBean.getEmail() );

			/** copias ocultas */
			try
			{
				String bcc = StringUtils.trimToEmpty( parametros.get( KEY_EMAIL_BCC ) );

				if( StringUtils.isNotEmpty( bcc ) )
				{
					NSMutableArray<String> nsBcc = new NSMutableArray<String>();

					String bccs[] = bcc.split( "," );

					for( int i = 0; i < bccs.length; i++ )
					{
						nsBcc.add( StringUtils.trim( bccs[i] ) );
					}

					mailDelivery.setBCCAddresses( nsBcc );
				}
			}
			catch( Exception e )
			{
				LOGGER.error( "Erro ao setar copias ocultas: " + e.getMessage() );
			}

			String from = StringUtils.trimToEmpty( parametros.get( KEY_EMAIL_FROM ) );

			mailDelivery.setFromAddress( from );

			String replyTo = StringUtils.trimToEmpty( parametros.get( KEY_EMAIL_REPLY_TO ) );

			if( StringUtils.isNotEmpty( replyTo ) )
			{
				mailDelivery.setReplyToAddress( replyTo );
			}

			String subject = replaceJoker( parametros.get( KEY_EMAIL_SUBJECT ), jBoletoBean );

			mailDelivery.setSubject( subject );

			String text = replaceJoker( parametros.get( KEY_EMAIL_TEXT ), jBoletoBean );

			mailDelivery.setTextContent( text );

			String nomeAnexo = replaceJoker( parametros.get( KEY_EMAIL_ATTACHMENT_NAME ), jBoletoBean );

			ERMailFileAttachment pdf = new ERMailFileAttachment( nomeAnexo, "1", file );

			mailDelivery.addAttachment( pdf );

			mailDelivery.sendMail();

			LOGGER.debug( ">>> enviou Email com sucesso!" );

			return true;

		}
		catch( AddressException e )
		{
			e.printStackTrace();
		}
		catch( MessagingException e )
		{
			e.printStackTrace();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}

		return false;

	}

}
