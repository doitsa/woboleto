package br.com.doit.boleto.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.woboleto.model.EOBoleto;
import br.com.woboleto.model.EORequisicao;

import com.webobjects.eocontrol.EOEditingContext;

import er.extensions.eof.ERXEC;

@Path("/boletos")
public class BoletoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvarBoleto(EOBoleto eoBoleto) throws URISyntaxException {
		if (eoBoleto == null) {
			throw new WebApplicationException(new IllegalArgumentException(
					"Não foi possível criar o boleto"), 400);
		}

		EOEditingContext editingContext = eoBoleto.editingContext();

		editingContext.saveChanges();

		return Response.created(new URI("teste")).build();
	}

	@GET
	@Produces("application/pdf")
	public byte[] gerarBoletoPDF(@PathParam("request_id") Integer requestId) {
		GeradorDeBoleto gerador = consultarRequisicao(requestId);

		gerador.geraPDF("Teste.pdf");
		
		return gerador.geraPDF();
	}

	@GET
	@Produces("image/png")
	public byte[] gerarBoletoPNG(@PathParam("request_id") Integer requestId) {
		GeradorDeBoleto gerador = consultarRequisicao(requestId);

		gerador.geraPNG("Teste.png");
		
		return gerador.geraPNG();
	}

	public GeradorDeBoleto consultarRequisicao(Integer requestId) {
		EOEditingContext editingContext = ERXEC.newEditingContext();

		EORequisicao eoRequisicao = EORequisicao.fetchEORequisicao(
				editingContext, EORequisicao.SEQUENTIAL.is(requestId));

		if (eoRequisicao == null) {
			throw new WebApplicationException(new IllegalArgumentException(
					"Não há boleto com o ID informado"), 404);
		}

		Boleto boleto = eoRequisicao.boleto().toStellaBoleto();

		GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

		return gerador;
	}
}
