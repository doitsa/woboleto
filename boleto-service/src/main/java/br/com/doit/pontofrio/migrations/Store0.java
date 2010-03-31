package br.com.doit.pontofrio.migrations;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;
import er.extensions.migration.ERXModelVersion;

public class Store0 extends ERXMigrationDatabase.Migration
{
	@Override
	public void downgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
	{
		// DO NOTHING
	}

	@Override
	public NSArray<ERXModelVersion> modelDependencies()
	{
		return new NSArray<ERXModelVersion>(new ERXModelVersion("Boleto", 0));
	}

	@Override
	public void upgrade(final EOEditingContext editingContext, final ERXMigrationDatabase database) throws Throwable
	{
		ERXMigrationTable voucherTable = database.newTableNamed("store_voucher");

		voucherTable.newBigDecimalColumn("paid_amount", 30, 2, false);
		voucherTable.newIntegerColumn("id", false);
		voucherTable.newTimestampColumn("payment_date", false);
		voucherTable.create();
		voucherTable.setPrimaryKey("id");

		ERXMigrationTable invoiceTable = database.newTableNamed("store_invoice");

		invoiceTable.newIntegerColumn("boleto_id", false);
		invoiceTable.newStringColumn("external_id", 16, false);
		invoiceTable.newIntegerColumn("id", false);
		invoiceTable.newStringColumn("validation_key", 255, false);
		invoiceTable.newIntegerColumn("voucher_id", true);
		invoiceTable.create();
		invoiceTable.setPrimaryKey("id");

		// invoiceTable.addForeignKey("boleto_id", "boleto", "id");
		// invoiceTable.addForeignKey("voucher_id", "store_voucher", "id");
	}
}
