package br.com.woboleto.migrations;

import com.webobjects.eoaccess.EOAdaptorChannel;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class Boleto3 extends ERXMigrationDatabase.Migration
{
	 @Override
	 public void upgrade(EOEditingContext editingContext, EOAdaptorChannel channel, EOModel model) throws Throwable {
		 super.upgrade(editingContext, channel, model);
	 }
	
    @Override
    public void downgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
    {
        // DO NOTHING
    }
    
    @Override
    public void upgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
    {
	 	ERXMigrationTable eoBoletoTable = database.existingTableNamed("boleto");
	 	eoBoletoTable.existingColumnNamed("emissor_id").delete();
	 	eoBoletoTable.existingColumnNamed("sacado_id").delete();
		
		database.existingTableNamed("emissor").drop();
		database.existingTableNamed("sacado").drop();
    }
}
