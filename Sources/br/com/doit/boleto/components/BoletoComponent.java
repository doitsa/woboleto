package br.com.doit.boleto.components;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jboleto.Banco;

import br.com.doit.boleto.BancoFactory;
import br.com.doit.boleto.BoletoGenerator;
import br.com.doit.boleto.EmailGenerator;
import br.com.doit.boleto.templates.WOBoletoBean;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSDictionary;

/**
 * @author Georg Componente para retornar um boleta na pagina
 * @binding boletoBean contem todos os dados do boleto (+ banco)
 */
public class BoletoComponent extends WOComponent
{
	private static final Logger LOGGER = Logger.getLogger( BoletoComponent.class );

	private WOBoletoBean boletoBean;

	private Banco banco;
	
	private NSDictionary<String, String> emailParams;

	public NSDictionary<String, String> getEmailParams()
	{
		return emailParams;
	}

	public void setEmailParams( NSDictionary<String, String> emailParams )
	{
		this.emailParams = emailParams;
	}

	private NSData barcodeImageData;

	public BoletoComponent( final WOContext context )
	{
		super( context );
	}

	@Override
	public void awake()
	{
		super.awake();

		banco = null;
		barcodeImageData = null;
	}

	public Banco banco()
	{
		if( banco == null )
		{
			banco = BancoFactory.createBanco( boletoBean );
		}

		return banco;
	}

	// para nao aparecer quando foi preenchido sem cidade
	public boolean mostraTracoCidade()
	{

		return !StringUtils.isEmpty( boletoBean.getCidadeSacado() );

	}

	public NSData bancoImage() throws IOException
	{
		// Tem que transformar o numero do banco em inteiro porque o nome dos
		// arquivos de imagem de bancos nao possuem zeros a esquerda
		String imagePath = "/img/" + Integer.valueOf( banco().getNumero() ) + ".gif";

		LOGGER.debug( "Caminho para a imagem do banco: " + imagePath );

		URL imageUrl = getClass().getResource( imagePath );

		if( imageUrl == null )
		{
			LOGGER.warn( "N\u00e3o foi poss\u00edvel encontrar a imagem do banco no caminho: " + imagePath );

			return null;
		}

		return new NSData( imageUrl );
	}

	public WOBoletoBean boletoBean()
	{
		return boletoBean;
	}

	public NSData boletoTemplateImage() throws IOException
	{
		URL imageUrl = getClass().getResource( "/img/templateHTML.gif" );

		return new NSData( imageUrl );
	}

	public NSData codigoBarrasImage() throws IOException
	{
		if( barcodeImageData == null )
		{
			LOGGER.debug( "Gerando o c\u00f3digo de barras para o boleto..." );

			File barcodeImageFile = BoletoGenerator.generateBarCode( boletoBean );

			barcodeImageData = new NSData( barcodeImageFile.toURL() );
		}

		return barcodeImageData;
	}

	public void setBoletoBean( final WOBoletoBean boleto )
	{
		boletoBean = boleto;
	}

	public boolean canSendEmail()
	{

		return !StringUtils.isEmpty( boletoBean.getEmail() );

	}

	public WOActionResults sendEmail()
	{

		boolean successo = EmailGenerator.sendEmailWithBoleto( boletoBean, emailParams, session().defaultEditingContext() );

		return null;
	}
}