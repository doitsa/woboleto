package br.com.doit.boleto.test.core;

import org.jboleto.JBoleto;
import org.junit.Test;

import com.webobjects.foundation.NSDictionary;

import br.com.doit.boleto.BoletoGenerator;
import br.com.doit.boleto.EmailGenerator;
import br.com.doit.boleto.templates.WOBoletoBean;
import br.com.doit.boleto.test.basic.AbstractBoletoTest;
import br.com.doit.boleto.testdata.BoletoTestData;

public class BoletoGeneratorTests extends AbstractBoletoTest {
	
	public void gerarHTMLBoleto()
	{

		String subject = "hallo @@ba@@";
		subject = subject.replaceAll( "@@ba@@", "cedente" );
		
		
		
		System.out.println( ">>> " + subject);

	}

//	@Test
//	public void gerarPDFBoleto()
//	{
//
//		 WOBoletoBean jBoleto = BoletoTestData.BANCO_DO_BRASIL();
//		
//		 JBoleto boleto = EmailGenerator.preparePDF( jBoleto, new NSDictionary<String,String>(),
//		 mockEditingContext() );
//
//		 boleto.closeBoleto(
//		 "C:\\Dokumente und Einstellungen\\Georg\\Desktop\\Boleto1.pdf" );
//
//	}

}
