package br.com.doit.pontofrio.resource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

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
	protected static final String HASH_QUERY_PARAM = "hash";

	private final EOEditingContext editingContext;

	@Context
	private UriInfo uriInfo;

	public BoletoResource()
	{
		editingContext = ERXEC.newEditingContext();
	}

	BoletoResource(EOEditingContext editingContext, UriInfo uriInfo)
	{
		this.editingContext = editingContext;
		this.uriInfo = uriInfo;
	}

	@GET
	@Produces("image/png")
	public byte[] boletoAsPng(@PathParam("order_id") final String orderId, @QueryParam(HASH_QUERY_PARAM) String hash)
	{
		if(hash == null)
		{
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity("The validation hash provided is invalid").build());
		}

		Invoice invoice = fetchIvoice(orderId);

		if(!hash.equalsIgnoreCase(invoice.validationKey()))
		{
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity("The validation hash provided is invalid").build());
		}

		Boleto boleto = invoice.boleto().toStellaBoleto();

		BoletoGenerator gerador = createBoletoGenerator(boleto);

		return gerador.toPNG();
	}

	@GET
	@Path("/comprovante")
	@Produces(MediaType.TEXT_XML)
	public Response comprovanteAsXml(@PathParam("order_id") final String orderId)
	{
		Invoice invoice = fetchIvoice(orderId);

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

	BoletoGenerator createBoletoGenerator(Boleto boleto)
	{
		return new BoletoGenerator(boleto);
	}

	private Invoice fetchIvoice(final String orderId)
	{
		Invoice invoice = Invoice.fetchInvoice(editingContext, Invoice.EXTERNAL_ID_KEY, orderId);

		if(invoice == null)
		{
			throw new NotFoundException(String.format("The invoice number %s cannot be found", orderId), uriInfo.getAbsolutePath());
		}

		return invoice;
	}
}
