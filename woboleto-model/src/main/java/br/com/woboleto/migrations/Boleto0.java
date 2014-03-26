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
        ERXMigrationTable abstractInformacaoTable = database.newTableNamed("informacao");
        abstractInformacaoTable.newIntegerColumn("boleto_id", false);
        abstractInformacaoTable.newIntegerColumn("id", false);
        abstractInformacaoTable.newStringColumn("tipo", 1, false);
        abstractInformacaoTable.newStringColumn("valor", 255, false);
        abstractInformacaoTable.create();
        abstractInformacaoTable.setPrimaryKey("id");

        ERXMigrationTable eoBoletoTable = database.newTableNamed("boleto");
        eoBoletoTable.newFlagBooleanColumn("aceite", false);
        eoBoletoTable.newStringColumn("banco", 50, true);
        eoBoletoTable.newLargeStringColumn("codigo_de_barras", false);
        eoBoletoTable.newDateColumn("data_documento", true);
        eoBoletoTable.newDateColumn("data_processamento", true);
        eoBoletoTable.newDateColumn("data_vencimento", true);
        eoBoletoTable.newIntegerColumn("emissor_id", false);
        eoBoletoTable.newStringColumn("especie_documento", 16, true);
        eoBoletoTable.newIntegerColumn("id", false);
        eoBoletoTable.newLargeStringColumn("linha_digitavel", false);
        eoBoletoTable.newStringColumn("numero_documento", 16, true);
        eoBoletoTable.newBigDecimalColumn("quantidade_moeda", 30, 2, true);
        eoBoletoTable.newIntegerColumn("sacado_id", false);
        eoBoletoTable.newBigDecimalColumn("valor", 30, 2, true);
        eoBoletoTable.newBigDecimalColumn("valor_moeda", 30, 2, true);
        eoBoletoTable.create();
        eoBoletoTable.setPrimaryKey("id");

        ERXMigrationTable eoEmissorTable = database.newTableNamed("emissor");
        eoEmissorTable.newStringColumn("agencia", 255, true);
		eoEmissorTable.newStringColumn("carteira", 255, true);
		eoEmissorTable.newStringColumn("cedente", 255, true);
		eoEmissorTable.newStringColumn("codigo_fornecido_pela_agencia", 255, true);
		eoEmissorTable.newStringColumn("codigo_operacao", 255, true);
		eoEmissorTable.newStringColumn("conta_corrente", 255, true);
		eoEmissorTable.newStringColumn("digito_verificador_agencia", 10, true);
		eoEmissorTable.newStringColumn("digito_verificador_conta_corrente", 10, true);
		eoEmissorTable.newStringColumn("digito_verificador_nosso_numero", 10, true);
		eoEmissorTable.newIntegerColumn("id", false);
		eoEmissorTable.newStringColumn("nosso_numero", 255, true);
		eoEmissorTable.newStringColumn("numero_convenio", 255, true);
		eoEmissorTable.create();
	 	eoEmissorTable.setPrimaryKey("id");

        ERXMigrationTable eoRequisicaoTable = database.newTableNamed("requisicao");
        eoRequisicaoTable.newIntegerColumn("boleto_id", false);
        eoRequisicaoTable.newIntegerColumn("id", false);
        eoRequisicaoTable.newLargeStringColumn("hash", false);
        eoRequisicaoTable.newIntegerColumn("sequential", false);
        eoRequisicaoTable.create();
        eoRequisicaoTable.setPrimaryKey("id");

        ERXMigrationTable eoSacadoTable = database.newTableNamed("sacado");
        eoSacadoTable.newStringColumn("bairro", 255, true);
        eoSacadoTable.newStringColumn("cep", 50, true);
        eoSacadoTable.newStringColumn("cidade", 255, true);
        eoSacadoTable.newStringColumn("cpf", 50, true);
        eoSacadoTable.newStringColumn("endereco", 255, true);
        eoSacadoTable.newIntegerColumn("id", false);
        eoSacadoTable.newStringColumn("nome", 255, true);
        eoSacadoTable.newStringColumn("uf", 2, true);
        eoSacadoTable.create();
        eoSacadoTable.setPrimaryKey("id");

        eoBoletoTable.addForeignKey("emissor_id", "emissor", "id");
        eoBoletoTable.addForeignKey("sacado_id", "sacado", "id");
        eoRequisicaoTable.addForeignKey("boleto_id", "boleto", "id");
    }
}
