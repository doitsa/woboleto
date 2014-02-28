package br.com.doit.boleto.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.woboleto.model.EOBoleto;
import br.com.woboleto.model.EORequisicao;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXEC;
import er.extensions.foundation.ERXDictionaryUtilities;

@Path("/boletos")
public class BoletoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarBoleto(EOBoleto eoBoleto) throws URISyntaxException, JsonGenerationException, JsonMappingException, IOException {
		if (eoBoleto == null) {
			throw new WebApplicationException(new IllegalArgumentException(
					"Não foi possível criar o boleto"), 400);
		}
		EOEditingContext editingContext = eoBoleto.editingContext();
		
		EORequisicao eoRequisicao = EORequisicao.createEORequisicao(editingContext, null, null, eoBoleto);
		
		editingContext.saveChanges();
		
		Map<String, Object> dictionary = ERXDictionaryUtilities.dictionaryFromObjectWithKeys(eoRequisicao, new NSArray<String>(new String[] {EORequisicao.SEQUENTIAL_KEY, EORequisicao.HASH_KEY}));

		ObjectMapper mapper = new ObjectMapper();
		
		String mapAsJson = mapper.writeValueAsString(dictionary);
		
		return Response.created(new URI("boletos/"+eoRequisicao.sequential().toString()+"?hash="+eoRequisicao.hash())).entity(mapAsJson).build();
	}
	
	@Path("/{sequencial}.pdf")
	@GET
	@Produces("application/pdf")
	public byte[] gerarBoletoPDF(@PathParam("sequencial") Integer sequencial, @QueryParam("hash") String hash) {
		GeradorDeBoleto gerador = consultarRequisicao(sequencial, hash);

		return gerador.geraPDF();
	}

	@Path("/{sequencial}.png")
	@GET
	@Produces("image/png")
	public byte[] gerarBoletoPNG(@PathParam("sequencial") Integer sequencial, @QueryParam("hash") String hash) {
		GeradorDeBoleto gerador = consultarRequisicao(sequencial, hash);

		return gerador.geraPNG();
	}

	private GeradorDeBoleto consultarRequisicao(Integer requestId, String hash) {
		if (requestId == null || hash == null) {
			throw new WebApplicationException(new IllegalArgumentException(
					"É necessário informar o número da requisição e o hash"), 400);
		}
		
		EOEditingContext editingContext = ERXEC.newEditingContext();

		EORequisicao eoRequisicao = EORequisicao.fetchEORequisicao(
				editingContext, EORequisicao.SEQUENTIAL.is(requestId).and(EORequisicao.HASH.is(hash)));

		if (eoRequisicao == null) {
			throw new WebApplicationException(new IllegalArgumentException(
					"Não há boleto com o ID informado"), 404);
		}

		Boleto boleto = eoRequisicao.boleto().toStellaBoleto();

		GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

		return gerador;
	}
}
