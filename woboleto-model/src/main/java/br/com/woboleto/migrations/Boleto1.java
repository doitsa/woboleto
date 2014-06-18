package br.com.woboleto.migrations;

import static er.extensions.jdbc.ERXJDBCUtilities.executeUpdate;

import com.webobjects.eoaccess.EOAdaptorChannel;
import com.webobjects.eoaccess.EOModel;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class Boleto1 extends ERXMigrationDatabase.Migration
{
    @Override
    public void downgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
    {
        // DO NOTHING
    }
    
    
    
    @Override
    public void upgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
    {
        ERXMigrationTable eoRequisicaoTable = database.existingTableNamed("requisicao");
        eoRequisicaoTable.newStringColumn("versao", 16, true);
        
    }
    
    @Override
    public void upgrade(EOEditingContext editingContext, EOAdaptorChannel channel, EOModel model) throws Throwable {
        super.upgrade(editingContext, channel, model);
        executeUpdate(channel, "UPDATE requisicao SET versao = '2.0.5';");
        executeUpdate(channel, "ALTER TABLE requisicao ALTER COLUMN versao SET NOT NULL;");
        
    }
}
