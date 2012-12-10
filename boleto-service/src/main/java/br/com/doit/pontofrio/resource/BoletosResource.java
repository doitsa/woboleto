package br.com.doit.pontofrio.resource;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.doit.pontofrio.model.Invoice;
import br.com.woboleto.model.BancoEnum;
import br.com.woboleto.model.EOBoleto;
import br.com.woboleto.model.EOInstrucao;
import br.com.woboleto.model.EOLocalPagamento;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.eof.ERXEC;

@Path("/boletos")
public class BoletosResource
{
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createBoleto(final MultivaluedMap<String, String> parameters, @Context final UriInfo uriInfo, @HeaderParam("Authorization") String token) throws URISyntaxException
	{
		System.out.println("Token: " + token);

		EOEditingContext editingContext = ERXEC.newEditingContext();

		EOBoleto boleto = EOBoleto.createEOBoleto(editingContext);

		String orderId = parameters.getFirst("orderId");
		String customerCpf = parameters.getFirst("customerCpf");
		String customerName = parameters.getFirst("customerName");
		String dueDate = parameters.getFirst("dueDate");
		String amount = parameters.getFirst("amount");

		boleto.setNumeroDocumento("");
		boleto.setEspecieDocumento("Mercan");
		boleto.setBanco(BancoEnum.ITAU);

		boleto.emissor().setCedente("PONTOFRIO.COM COMERCIO ELETRONICO S/A     CNPJ:09.358.108/0001-25");
		boleto.emissor().setAgencia(911);
		boleto.emissor().setContaCorrente(10077L);
		boleto.emissor().setDigitoVerificadorContaCorrente("4");
		boleto.emissor().setCarteira(175);
		boleto.emissor().setNossoNumero(Long.valueOf(orderId));

		boleto.sacado().setCpf("     CPF/CNPJ: " + customerCpf == null ? "" : customerCpf);
		boleto.sacado().setNome(customerName == null ? "" : customerName);
		boleto.sacado().setBairro("");
		boleto.sacado().setCep("");
		boleto.sacado().setCidade("");
		boleto.sacado().setEndereco("");
		boleto.sacado().setUf("");

		boleto.addToLocaisPagamentoRelationship(EOLocalPagamento.createEOLocalPagamento(editingContext, "At\u00e9 o vencimento, pag\u00e1vel em qualquer banco."));

		boleto.addToInstrucoesRelationship(EOInstrucao.createEOInstrucao(editingContext, "N\u00c3O RECEBER AP\u00d3S O VENCIMENTO."));
		boleto.addToInstrucoesRelationship(EOInstrucao.createEOInstrucao(editingContext, "N\u00c3O RECEBER COM VALOR DIFERENTE DO CAMPO VALOR DO DOCUMENTO."));
		boleto.addToInstrucoesRelationship(EOInstrucao.createEOInstrucao(editingContext, "N\u00c3O ACEITAR PAGAMENTO EM CHEQUE."));

		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

		try
		{
			boleto.setDataVencimento(new NSTimestamp(dateFormatter.parse(dueDate)));
		}
		catch(ParseException exception)
		{
			exception.printStackTrace();
		}

		boleto.setDataDocumento(new NSTimestamp());
		boleto.setDataProcessamento(new NSTimestamp());
		boleto.setValor(new BigDecimal(amount));

		Invoice invoice = Invoice.createInvoice(editingContext, orderId, boleto);

		editingContext.saveChanges();

		URI uri = uriInfo.getRequestUriBuilder().path(orderId).queryParam(BoletoResource.HASH_QUERY_PARAM, invoice.validationKey()).build().normalize();

		Response response = Response.created(uri).build();

		return response;
	}
}
