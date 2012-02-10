package br.com.doit.boleto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.log4j.Logger;
import org.jboleto.Banco;
import org.jboleto.JBoleto;
import org.jboleto.control.HtmlGenerator;
import org.jboleto.control.PDFGenerator;

import br.com.doit.boleto.model.Boleto;
import br.com.doit.boleto.templates.WOBoletoBean;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;


public class BoletoGenerator
{
	static final Logger LOGGER = Logger.getLogger(BoletoGenerator.class);
	
	/**
	 * @param boletoBean Um bean com as informa\u00e7\u00f5es do boleto
	 * @return Retorna o arquivo que representa a imagem do c\u00f3digo de
	 *         barras
	 * @throws IOException Se ocorrer um erro ao criar a imagem do c\u00f3digo
	 *             de barras
	 */
	public static File generateBarCode( final WOBoletoBean boletoBean ) throws IOException
	{
		Banco banco = BancoFactory.createBanco( boletoBean );

		File barcodeFile = File.createTempFile( banco.getCodigoBarras(), ".gif" );

		HtmlGenerator generator = new HtmlGenerator();

		generator.geraCodBar( new FileOutputStream( barcodeFile ), banco.getCodigoBarras() );

		return barcodeFile;
	}
	
	public static  WOBoletoBean createWOBoletoBean(Boleto boleto) {
		
		WOBoletoBean woBoletoBean = BancoFactory.createBoletoTemplate( boleto.banco() );

		woBoletoBean.setDataCriada( boleto.dataCriada() );

		woBoletoBean.setDataDocumento( boleto.dataDocumento() );
		woBoletoBean.setDataProcessamento( boleto.dataProcessamento() );

		woBoletoBean.setCedente( boleto.cedente() );
		woBoletoBean.setCarteira( boleto.carteira() );

		woBoletoBean.setNomeSacado( boleto.nomeSacado() );
		woBoletoBean.setEnderecoSacado( boleto.enderecoSacado() );
		woBoletoBean.setBairroSacado( boleto.bairroSacado() );
		woBoletoBean.setCidadeSacado( boleto.cidadeSacado() );
		woBoletoBean.setUfSacado( boleto.ufSacado() );
		woBoletoBean.setCepSacado( boleto.cepSacado() );
		woBoletoBean.setCpfSacado( boleto.cpfSacado() );

		woBoletoBean.setLocalPagamento( boleto.localPagamento() );
		woBoletoBean.setLocalPagamento2( boleto.localPagamento2() );
		
		woBoletoBean.setDataVencimento( boleto.dataVencimento() );
		woBoletoBean.setInstrucao1( boleto.instrucao1() );
		woBoletoBean.setInstrucao2( boleto.instrucao2() );
		woBoletoBean.setInstrucao3( boleto.instrucao3() );
		woBoletoBean.setInstrucao4( boleto.instrucao4() );
		woBoletoBean.setInstrucao5( boleto.instrucao5() );

		woBoletoBean.setAgencia( boleto.agencia() );
		woBoletoBean.setContaCorrente( boleto.contaCorrente() ); 

		woBoletoBean.setNumConvenio( boleto.numConvenio() );
		woBoletoBean.setNossoNumeroBanco( boleto.nossoNumero() );
		woBoletoBean.setValorBoleto( boleto.valorBoleto() );

		// demais campos, eventualmente necessarios para criar o banco
		woBoletoBean.setEmail( boleto.email() );
		woBoletoBean.setMoeda( boleto.moeda() );

		woBoletoBean.setCodCliente( boleto.codCliente() );
		woBoletoBean.setCodigoBarras( boleto.codigoBarras() );
		woBoletoBean.setCodigoFornecidoAgencia( boleto.codigoFornecidoAgencia() );
		woBoletoBean.setCodigoOperacao( boleto.codigoOperacao() );

		woBoletoBean.setDvAgencia( boleto.dvAgencia() );
		woBoletoBean.setDvCodigoFornecidoAgencia( boleto.dvCodigoFornecidoAgencia() );
		woBoletoBean.setDvContaCorrente( boleto.dvContaCorrente() );
		woBoletoBean.setDvNossoNumero( boleto.dvNossoNumero() );

		woBoletoBean.setEnderecoCodBar( boleto.enderecoCodBar() );
		woBoletoBean.setEspecieDocumento( boleto.especieDocumento() );

		woBoletoBean.setIos( boleto.ios() );

		woBoletoBean.setValorMoeda( boleto.valorMoeda() );
		
		return woBoletoBean;
		
	}
 
	/** criar Boleto para no contexto passado */
	public static Boleto createBoleto( WOBoletoBean woBoleto, EOEditingContext editingContext )
	{

		Boleto boleto = Boleto.createBoleto( editingContext, woBoleto.getBanco() );

		boleto.setStatus( Boleto.STATUS_FIRST_CREATED );
		boleto.setDataCriada( new NSTimestamp() );

		boleto.setDataDocumento( woBoleto.getDataDocumento() );
		boleto.setDataProcessamento( woBoleto.getDataProcessamento() );

		boleto.setCedente( woBoleto.getCedente() );
		boleto.setCarteira( woBoleto.getCarteira() );

		boleto.setNomeSacado( woBoleto.getNomeSacado() );
		boleto.setEnderecoSacado( woBoleto.getEnderecoSacado() );
		boleto.setBairroSacado( woBoleto.getBairroSacado() );
		boleto.setCidadeSacado( woBoleto.getCidadeSacado() );
		boleto.setUfSacado( woBoleto.getUfSacado() );
		boleto.setCepSacado( woBoleto.getCepSacado() );
		boleto.setCpfSacado( woBoleto.getCpfSacado() );

		boleto.setLocalPagamento( woBoleto.getLocalPagamento() );
		boleto.setLocalPagamento2( woBoleto.getLocalPagamento2() );

		// Vector descricoes = new Vector();
		// jBoletoBean.setDescricoes(descricoes);

		boleto.setDataVencimento( woBoleto.getDataVencimento() );
		boleto.setInstrucao1( woBoleto.getInstrucao1() );
		boleto.setInstrucao2( woBoleto.getInstrucao2() );
		boleto.setInstrucao3( woBoleto.getInstrucao3() );
		boleto.setInstrucao4( woBoleto.getInstrucao4() );
		boleto.setInstrucao5( woBoleto.getInstrucao5() );

		boleto.setAgencia( woBoleto.getAgencia() );
		boleto.setContaCorrente( woBoleto.getContaCorrente() ); // completar com
		// zeros quando
		// necessario

		boleto.setNumConvenio( woBoleto.getNumConvenio() );
		boleto.setNossoNumero( woBoleto.getNossoNumero() );
		boleto.setValorBoleto( woBoleto.getValorBoleto() );

		// demais campos, eventualmente necessarios para criar o banco
		boleto.setEmail( woBoleto.getEmail() );
		boleto.setMoeda( woBoleto.getMoeda() );

		boleto.setCodCliente( woBoleto.getCodCliente() );
		boleto.setCodigoBarras( woBoleto.getCodigoBarras() );
		boleto.setCodigoFornecidoAgencia( woBoleto.getCodigoFornecidoAgencia() );
		boleto.setCodigoOperacao( woBoleto.getCodigoOperacao() );

		boleto.setDvAgencia( woBoleto.getDvAgencia() );
		boleto.setDvCodigoFornecidoAgencia( woBoleto.getDvCodigoFornecidoAgencia() );
		boleto.setDvContaCorrente( woBoleto.getDvContaCorrente() );
		boleto.setDvNossoNumero( woBoleto.getDvNossoNumero() );

		boleto.setEnderecoCodBar( woBoleto.getEnderecoCodBar() );
		boleto.setEspecieDocumento( woBoleto.getEspecieDocumento() );

		boleto.setIos( woBoleto.getIos() );

		boleto.setValorMoeda( woBoleto.getValorMoeda() );

		return boleto;

	}

}
