package br.com.doit.pontofrio.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;
import br.com.doit.pontofrio.model.Invoice;
import br.com.doit.pontofrio.model.Voucher;

import com.sun.jersey.api.NotFoundException;
import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;

@Path("/boletos/{order_id}")
public class BoletoResource
{
	private final EOEditingContext editingContext = ERXEC.newEditingContext();

	@Context
	private UriInfo uriInfo;

	@GET
	@Produces("image/png")
	public byte[] boletoAsPng(@PathParam("order_id") final String orderId)
	{
		Boleto boleto = fetchBoleto(orderId);

		BoletoGenerator gerador = new BoletoGenerator(boleto);

		return gerador.toPNG();
	}

	@Path("/comprovante")
	@Produces(MediaType.TEXT_XML)
	public Response comprovanteAsXml(@PathParam("order_id") final String orderId)
	{
		Invoice invoice = Invoice.fetchInvoice(editingContext, Invoice.EXTERNAL_ID_KEY, orderId);

		if(invoice == null)
		{
			throw new NotFoundException(String.format("N\u00e3o foi poss\u00edvel encontrar um pedido com id: %s", orderId), uriInfo.getAbsolutePath());
		}

		Voucher voucher = invoice.voucher();

		if(voucher == null)
		{
			return Response.noContent().build();
		}

		StringBuilder buffer = new StringBuilder();

		DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

		buffer.append("<voucher>\n\t<paymentDate>");
		buffer.append(dateFormatter.format(voucher.paymentDate()));
		buffer.append("</paymentDate>\n\t<paidAmount>");
		buffer.append(voucher.paidAmount().toString());
		buffer.append("</paidAmount>\n</voucher>");

		return Response.ok(buffer.toString(), MediaType.TEXT_XML_TYPE).build();
	}

	private Boleto fetchBoleto(final String orderId)
	{
		Invoice invoice = Invoice.fetchInvoice(editingContext, Invoice.EXTERNAL_ID_KEY, orderId);

		if(invoice == null)
		{
			throw new NotFoundException(String.format("N\u00e3o foi poss\u00edvel encontrar um pedido com id: %s", orderId), uriInfo.getAbsolutePath());
		}

		return invoice.boleto().toStellaBoleto();
	}
}
