package br.com.doit.boleto.testdata;

import java.util.Vector;

import org.jboleto.JBoleto;

import br.com.doit.boleto.BancoFactory;
import br.com.doit.boleto.templates.BancoDoBrasilBoleto;
import br.com.doit.boleto.templates.ItauBoleto;
import br.com.doit.boleto.templates.WOBoletoBean;

public class BoletoTestData
{
	public static WOBoletoBean BANCO_DO_BRASIL()
	{

		WOBoletoBean woBoletoBean = BancoFactory.createBoletoTemplate( JBoleto.BANCO_DO_BRASIL );

		woBoletoBean.setDataDocumento( "31/05/2009" );
		woBoletoBean.setDataProcessamento( "31/05/2009" );

		woBoletoBean.setCedente( "KOBI System" );
		woBoletoBean.setCarteira( "17" );

		woBoletoBean.setNomeSacado( "ARCOR" );
		//woBoletoBean.setEnderecoSacado( "Rua Teste" );
		//woBoletoBean.setBairroSacado( "Barra" );
		//woBoletoBean.setCidadeSacado( "Rio de Janeiro" );
		//woBoletoBean.setUfSacado( "RJ" );
		//woBoletoBean.setCepSacado( "22753-501" );
		//woBoletoBean.setCpfSacado( "0000000000000" );

		Vector descricoes = new Vector();
		//woBoletoBean.setDescricoes( descricoes );

		woBoletoBean.setDataVencimento( "10/06/2009" );

		woBoletoBean.setAgencia( "3415" );
		woBoletoBean.setContaCorrente( "00543004" ); // completar com zeros
		woBoletoBean.setDvContaCorrente( "1" );		// quando necessario

		woBoletoBean.setNumConvenio( "1101354" );
		woBoletoBean.setNossoNumeroBanco( "5963971");
		woBoletoBean.setValorBoleto( "1.00" );

		return woBoletoBean;
	}

	public static WOBoletoBean ITAU()
	{

		WOBoletoBean woBoletoBean = new ItauBoleto();

		woBoletoBean.setDataDocumento( "31/05/2006" );
		woBoletoBean.setDataProcessamento( "31/05/2006" );

		woBoletoBean.setCedente( "AINODE Solucoes" );
		woBoletoBean.setCarteira( "175" );

		woBoletoBean.setNomeSacado( "GtTurbo" );
		woBoletoBean.setEnderecoSacado( "Rua Araticum 951" );
		woBoletoBean.setBairroSacado( "Anil" );
		woBoletoBean.setCidadeSacado( "Rio de Janeiro" );
		woBoletoBean.setUfSacado( "RJ" );
		woBoletoBean.setCepSacado( "22753-501" );
		woBoletoBean.setCpfSacado( "87524988753" );

		Vector descricoes = new Vector();
		descricoes.add( "Hospedagem I - teste descricao1 - R$ 39,90" );
		descricoes.add( "Manutencao - teste ricao2 - R$ 32,90" );
		descricoes.add( "Sistema - teste ssssde descricao3 - R$ 45,90" );
		descricoes.add( "Extra - teste de descricao4 - R$ 78,90" );
		woBoletoBean.setDescricoes( descricoes );

		// jBoletoBean.setImagemMarketing("/home/fabio/template_logo.png");

		woBoletoBean.setDataVencimento( "10/06/2006" );

		woBoletoBean.setAgencia( "2971" );
		woBoletoBean.setContaCorrente( "08690" );
		woBoletoBean.setDvContaCorrente( "1" );

		woBoletoBean.setNossoNumero( "34556", 8 );
		woBoletoBean.setNoDocumento( "34556" );
		woBoletoBean.setValorBoleto( "2.00" );

		return woBoletoBean;
	}

}
