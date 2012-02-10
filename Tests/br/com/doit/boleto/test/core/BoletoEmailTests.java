package br.com.doit.boleto.test.core;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.junit.Test;

import br.com.doit.boleto.test.basic.AbstractBoletoTest;

import com.webobjects.foundation.NSArray;

import er.extensions.foundation.ERXProperties;
import er.javamail.ERJavaMail;
import er.javamail.ERMailDeliveryPlainText;

public class BoletoEmailTests extends AbstractBoletoTest
{
	/** passa sem email mas nao funcionou!? */
	@Test
	public void sendMail()
	{	

		ERXProperties.setStringForKey( "false", "er.javamail.centralize" );
		ERXProperties.setStringForKey( "equipe@doit.com.br", "er.javamail.adminEmail" );
		ERXProperties.setStringForKey( "false", "er.javamail.debugEnabled" );
		ERXProperties.setStringForKey( "6000", "er.javamail.milliSecondsWaitIfSenderOverflowed" );
		ERXProperties.setStringForKey( "mail.doit.com.br", "er.javamail.smtpHost" );
		ERXProperties.setStringForKey( "true", "er.javamail.smtpAuth" );
		ERXProperties.setStringForKey( "equipe@doit.com.br", "er.javamail.smtpUser" );
		ERXProperties.setStringForKey( "doit1010", "er.javamail.smtpPassword" );
		
		ERJavaMail.sharedInstance().finishInitialization();
		
		try
		{
			String from = "equipe@doit.com.br";
			String to = "georg@moleque.com.br";
			String subject = "test";

			ERMailDeliveryPlainText mailDelivery = new ERMailDeliveryPlainText();

			mailDelivery.setTextContent( "Moin" );

			mailDelivery.newMail();

			mailDelivery.setFromAddress( from );
			mailDelivery.setReplyToAddress( from );
			mailDelivery.setSubject( subject );
			mailDelivery.setToAddresses( new NSArray<String>( to.split( "," ) ) );

			mailDelivery.sendMail();
			
			System.out.println( ">>> mandou email ... " );
			
		}
		catch( AddressException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch( MessagingException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch( Exception e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
