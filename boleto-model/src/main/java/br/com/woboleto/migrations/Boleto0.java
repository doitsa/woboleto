package br.com.woboleto.migrations;

import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class Boleto0 extends ERXMigrationDatabase.Migration
{
	@Override
	public void downgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
	{
		// DO NOTHING
	}

	@Override
	public void upgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
	{
		ERXMigrationTable sacadoTable = database.newTableNamed("boleto_sacado");

		sacadoTable.newStringColumn("bairro", 255, true);
		sacadoTable.newStringColumn("cep", 50, true);
		sacadoTable.newStringColumn("cidade", 255, true);
		sacadoTable.newStringColumn("cpf", 50, true);
		sacadoTable.newStringColumn("endereco", 255, true);
		sacadoTable.newIntegerColumn("id", false);
		sacadoTable.newStringColumn("nome", 255, true);
		sacadoTable.newStringColumn("uf", 2, true);
		sacadoTable.create();
		sacadoTable.setPrimaryKey("id");

		ERXMigrationTable emissorTable = database.newTableNamed("boleto_emissor");

		emissorTable.newIntegerColumn("agencia", true);
		emissorTable.newIntegerColumn("carteira", true);
		emissorTable.newStringColumn("cedente", 255, true);
		emissorTable.newIntegerColumn("codigo_fornecido_pela_agencia", true);
		emissorTable.newIntegerColumn("codigo_operacao", true);
		emissorTable.newBigIntegerColumn("conta_corrente", true);
		emissorTable.newStringColumn("digito_verificador_agencia", 1, true);
		emissorTable.newStringColumn("digito_verificador_conta_corrente", 1, true);
		emissorTable.newStringColumn("digito_verificador_nosso_numero", 1, true);
		emissorTable.newIntegerColumn("id", false);
		emissorTable.newBigIntegerColumn("nosso_numero", true);
		emissorTable.newBigIntegerColumn("numero_convenio", true);
		emissorTable.create();
		emissorTable.setPrimaryKey("id");

		ERXMigrationTable boletoTable = database.newTableNamed("boleto");

		boletoTable.newIntBooleanColumn("aceite", false);
		boletoTable.newStringColumn("banco", 50, false);
		boletoTable.newTimestampColumn("data_documento", true);
		boletoTable.newTimestampColumn("data_processamento", true);
		boletoTable.newTimestampColumn("data_vencimento", true);
		boletoTable.newIntegerColumn("emissor_id", false);
		boletoTable.newStringColumn("especie_documento", 16, true);
		boletoTable.newIntegerColumn("id", false);
		boletoTable.newStringColumn("numero_documento", 16, true);
		boletoTable.newBigDecimalColumn("quantidade_moeda", 30, 2, true);
		boletoTable.newIntegerColumn("sacado_id", false);
		boletoTable.newBigDecimalColumn("valor", 30, 2, true);
		boletoTable.newBigDecimalColumn("valor_moeda", 30, 2, true);
		boletoTable.create();
		boletoTable.setPrimaryKey("id");

		ERXMigrationTable informacaoTable = database.newTableNamed("boleto_informacao");

		informacaoTable.newIntegerColumn("boleto_id", false);
		informacaoTable.newIntegerColumn("id", false);
		informacaoTable.newStringColumn("tipo", 1, false);
		informacaoTable.newStringColumn("valor", 255, false);
		informacaoTable.create();
		informacaoTable.setPrimaryKey("id");

		// boletoTable.addForeignKey( "emissor_id", "boleto_emissor", "id" );
		// boletoTable.addForeignKey( "sacado_id", "boleto_sacado", "id" );
	}
}
