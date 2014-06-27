package br.com.woboleto.migrations;

import javax.sql.rowset.CachedRowSet;

import com.webobjects.eoaccess.EOAdaptorChannel;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;

import static er.extensions.jdbc.ERXJDBCUtilities.executeUpdate;
import static er.extensions.jdbc.ERXJDBCUtilities.fetchRowSet;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class Boleto2 extends ERXMigrationDatabase.Migration
{
	
	 @Override
	 public void upgrade(EOEditingContext editingContext, EOAdaptorChannel channel, EOModel model) throws Throwable {
		 super.upgrade(editingContext, channel, model);
		 
		 try (CachedRowSet rowSet = fetchRowSet(channel, "SELECT id FROM emissor;")) {
	            while (rowSet.next()) {
	                int id = rowSet.getInt(1);

	                executeUpdate(channel, "INSERT INTO beneficiario SELECT agencia, carteira, conta_corrente, digito_verificador_agencia, digito_verificador_conta_corrente, " +
	                		"digito_verificador_nosso_numero, null, "+id+", cedente, nosso_numero, numero_convenio FROM emissor WHERE id = "+id+";");
	                executeUpdate(channel, "UPDATE boleto b SET beneficiario_id = "+id+" WHERE emissor_id = "+id+";");
	                executeUpdate(channel, "ALTER SEQUENCE beneficiario_seq RESTART WITH "+(id+1)+";");
	            }
	        }
		 
		 try (CachedRowSet rowSet = fetchRowSet(channel, "SELECT id FROM sacado;")) {
	            while (rowSet.next()) {
	                int id = rowSet.getInt(1);
	                
	                executeUpdate(channel, "INSERT INTO endereco SELECT bairro, cep, cidade, id, endereco, uf FROM sacado WHERE id = "+id+";");
	                executeUpdate(channel, "ALTER SEQUENCE endereco_seq RESTART WITH "+(id+1)+";");
	                executeUpdate(channel, "INSERT INTO pagador SELECT cpf, "+id+", "+id+", nome FROM sacado WHERE id = "+id+";");
	                executeUpdate(channel, "ALTER SEQUENCE pagador_seq RESTART WITH "+(id+1)+";");
	                executeUpdate(channel, "UPDATE boleto b SET pagador_id = "+id+" WHERE sacado_id = "+id+";");
	            }
	        }
	 }
	
    @Override
    public void downgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
    {
        // DO NOTHING
    }
    
    @Override
    public void upgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
    {
    	ERXMigrationTable eoEnderecoTable = database.newTableNamed("endereco");
		eoEnderecoTable.newStringColumn("bairro", 255, true);
		eoEnderecoTable.newStringColumn("cep", 50, true);
		eoEnderecoTable.newStringColumn("cidade", 255, true);
		eoEnderecoTable.newIntegerColumn("id", false);
		eoEnderecoTable.newStringColumn("logradouro", 255, true);
		eoEnderecoTable.newStringColumn("uf", 2, true);
		eoEnderecoTable.create();
	 	eoEnderecoTable.setPrimaryKey("id");
    	
    	ERXMigrationTable eoBeneficiarioTable = database.newTableNamed("beneficiario");
		eoBeneficiarioTable.newStringColumn("agencia", 255, true);
		eoBeneficiarioTable.newStringColumn("carteira", 255, true);
		eoBeneficiarioTable.newStringColumn("codigo_beneficiario", 255, true);
		eoBeneficiarioTable.newStringColumn("digito_verificador_agencia", 10, true);
		eoBeneficiarioTable.newStringColumn("digito_verificador_codigo_beneficiario", 10, true);
		eoBeneficiarioTable.newStringColumn("digito_verificador_nosso_numero", 10, true);
		eoBeneficiarioTable.newStringColumn("documento", 255, true);
		eoBeneficiarioTable.newIntegerColumn("id", false);
		eoBeneficiarioTable.newStringColumn("nome_beneficiario", 255, true);
		eoBeneficiarioTable.newStringColumn("nosso_numero", 255, true);
		eoBeneficiarioTable.newStringColumn("numero_convenio", 255, true);
		eoBeneficiarioTable.create();
	 	eoBeneficiarioTable.setPrimaryKey("id");
	 	
	 	ERXMigrationTable eoBoletoTable = database.existingTableNamed("boleto");
		eoBoletoTable.newIntegerColumn("beneficiario_id", true);
		eoBoletoTable.newIntegerColumn("pagador_id", true);
	 	eoBoletoTable.addForeignKey("beneficiario_id", "emissor", "id");
		eoBoletoTable.addForeignKey("pagador_id", "sacado", "id");

		eoBoletoTable.existingColumnNamed("emissor_id").setAllowsNull(true);
		eoBoletoTable.existingColumnNamed("sacado_id").setAllowsNull(true);
		
		
		ERXMigrationTable eoPagadorTable = database.newTableNamed("pagador");
		eoPagadorTable.newStringColumn("documento", 50, true);
		eoPagadorTable.newIntegerColumn("endereco_id", true);
		eoPagadorTable.newIntegerColumn("id", false);
		eoPagadorTable.newStringColumn("nome", 255, true);
		eoPagadorTable.create();
	 	eoPagadorTable.setPrimaryKey("id");

		eoPagadorTable.addForeignKey("endereco_id", "endereco", "id");
    }
}
