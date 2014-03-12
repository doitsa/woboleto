package br.com.doit.boleto.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

@Path("/boletos")
public class BoletoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response salvarBoleto(String eoBoleto) throws URISyntaxException, JsonGenerationException, JsonMappingException, IOException {
		String json = "{\"hash\":\"b130ca1d89cc884cf8857641bc1ed784\",\"sequential\":1}";
		
		return Response.created(new URI("boletos/1?hash=b130ca1d89cc884cf8857641bc1ed784")).entity(json).build();
	}
}
