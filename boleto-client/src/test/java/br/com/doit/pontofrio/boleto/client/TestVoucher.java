package br.com.doit.pontofrio.boleto.client;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

public class TestVoucher
{
	@Test
	public void parseVoucherFromXml() throws Exception
	{
		StringBuilder buffer = new StringBuilder();

		DateFormat dateFormatter = new SimpleDateFormat( "dd/MM/yyyy" );

		buffer.append( "<voucher>\n\t<paymentDate>" );
		buffer.append( dateFormatter.format( new Date() ) );
		buffer.append( "</paymentDate>\n\t<paidAmount>" );
		buffer.append( "1.20" );
		buffer.append( "</paidAmount>\n</voucher>" );

		Voucher voucher = Voucher.fromXml( buffer.toString() );

		assertThat( voucher.getPaymentDate(), is( new LocalDate().toDateMidnight().toDate() ) );
		assertThat( voucher.getPaidAmount(), is( new BigDecimal( "1.20" ) ) );
	}
}
