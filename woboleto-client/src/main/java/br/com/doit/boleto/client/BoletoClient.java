package br.com.doit.boleto.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;

import br.com.doit.boleto.exception.BoletoException;
import br.com.doit.boleto.pojo.Boleto;
import br.com.doit.boleto.pojo.Requisicao;

public class BoletoClient {

	private WebTarget target = null;

	public BoletoClient(String url) {
		Client client = ClientBuilder.newClient(new ClientConfig()
				.register(JsonProcessingFeature.class));

		target = client.target(url);
	}

	protected BoletoClient(WebTarget webTarget) {
		this.target = webTarget;
	}

	public Requisicao criarBoleto(Boleto boleto) {
		if (boleto == null) {
			throw new IllegalArgumentException("Invalid argument");
		}

		try {
			Builder request = target.path("boletos").request();

			ObjectMapper mapper = new ObjectMapper();

			String boletoS = mapper.writeValueAsString(boleto);

			Response response = request.post(Entity.entity(boletoS, MediaType.APPLICATION_JSON));

			return mapper.readValue(response.readEntity(String.class), Requisicao.class);
		} catch (Exception exception) {
			throw new BoletoException("Não foi possível criar o boleto",
					exception);
		}
	}
}
