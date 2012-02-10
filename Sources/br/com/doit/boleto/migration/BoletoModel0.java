package br.com.doit.boleto.migration;

import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class BoletoModel0 extends ERXMigrationDatabase.Migration {

	@Override
	public void downgrade(EOEditingContext arg0, ERXMigrationDatabase arg1)
			throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upgrade(EOEditingContext arg0, ERXMigrationDatabase database)
			throws Throwable {
		
		ERXMigrationTable boletoTable = database.newTableNamed("boleto");
		
		boletoTable.newIntegerColumn("id", false);
		
		/** meta dados */
		boletoTable.newTimestampColumn( "dataCriada",true);
		boletoTable.newIntegerColumn( "status", true );
		boletoTable.newIntegerColumn( "banco", true );
		
		/** dados boleto*/
		boletoTable.newStringColumn("aceite", 255, true);
		boletoTable.newStringColumn("acrescimo", 255, true);
		boletoTable.newStringColumn("agencia", 255, true);
		boletoTable.newStringColumn("bairroSacado", 255, true);
		boletoTable.newStringColumn("carteira", 255, true);
		boletoTable.newStringColumn("cedente", 255, true);
		boletoTable.newStringColumn("cepSacado", 255, true);
		boletoTable.newStringColumn("cidadeSacado", 255, true);
		boletoTable.newStringColumn("codCliente", 255, true);
		boletoTable.newStringColumn("codigoBarras", 255, true);
		boletoTable.newStringColumn("codigoFornecidoAgencia", 255, true);
		boletoTable.newStringColumn("codigoOperacao", 255, true);
		boletoTable.newStringColumn("contaCorrente", 255, true);
		boletoTable.newStringColumn("cpfSacado", 255, true);
		boletoTable.newStringColumn("dataDocumento", 255, true);
		boletoTable.newStringColumn("dataProcessamento", 255, true);
		boletoTable.newStringColumn("dataVencimento", 255, true);
		boletoTable.newStringColumn("descricoes", 255, true);
		boletoTable.newStringColumn("dvAgencia", 255, true);
		boletoTable.newStringColumn("dvCodigoFornecidoAgencia", 255, true);
		boletoTable.newStringColumn("dvContaCorrente", 255, true);
		boletoTable.newStringColumn("dvNossoNumero", 255, true);
		boletoTable.newStringColumn("email", 255, true);
		boletoTable.newStringColumn("enderecoCodBar", 255, true);
		boletoTable.newStringColumn("enderecoSacado", 255, true);
		boletoTable.newStringColumn("especieDocumento", 255, true);
		boletoTable.newStringColumn("imagemMarketing", 255, true);
		boletoTable.newStringColumn("instrucao1", 255, true);
		boletoTable.newStringColumn("instrucao2", 255, true);
		boletoTable.newStringColumn("instrucao3", 255, true);
		boletoTable.newStringColumn("instrucao4", 255, true);
		boletoTable.newStringColumn("instrucao5", 255, true);
		boletoTable.newStringColumn("ios", 255, true);      //porque tem dois setIOS ??
		boletoTable.newStringColumn("linhaDigitavel", 255, true);
		boletoTable.newStringColumn("localPagamento", 255, true);
		boletoTable.newStringColumn("localPagamento2", 255, true);
		boletoTable.newStringColumn("moeda", 255, true);
		boletoTable.newStringColumn("noDocumento", 255, true);
		boletoTable.newStringColumn("nomeSacado", 255, true);
		boletoTable.newStringColumn("nossoNumero", 255, true);
		boletoTable.newStringColumn("numConvenio", 255, true);
		boletoTable.newStringColumn("qtdMoeda", 255, true);
		boletoTable.newStringColumn("tituloBoletoHtml", 255, true);
		boletoTable.newStringColumn("ufSacado", 255, true);
		boletoTable.newStringColumn("valorBoleto", 255, true);
		boletoTable.newStringColumn("valorMoeda", 255, true);
		
		boletoTable.create();
		boletoTable.setPrimaryKey("id");
		
	}

}
