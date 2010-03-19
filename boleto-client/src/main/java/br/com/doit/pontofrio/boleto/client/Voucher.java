package br.com.doit.pontofrio.boleto.client;

import java.math.BigDecimal;
import java.util.Date;

import com.thoughtworks.xstream.XStream;

public class Voucher
{
	public static Voucher fromXml( final String voucherXml )
	{
		XStream xstream = new XStream();

		xstream.alias( "voucher", Voucher.class );
		xstream.registerConverter( new DateConverter() );

		return (Voucher) xstream.fromXML( voucherXml );
	}

	private final Date paymentDate;

	private final BigDecimal paidAmount;

	public Voucher( final Date paymentDate, final BigDecimal amountPaid )
	{
		super();

		this.paymentDate = paymentDate;
		this.paidAmount = amountPaid;
	}

	public BigDecimal getPaidAmount()
	{
		return paidAmount;
	}

	public Date getPaymentDate()
	{
		return paymentDate;
	}

}
