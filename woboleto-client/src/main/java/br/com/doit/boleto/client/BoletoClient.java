package br.com.doit.boleto.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.print.DocFlavor.BYTE_ARRAY;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.doit.boleto.exception.BoletoException;
import br.com.doit.boleto.pojo.Boleto;
import br.com.doit.boleto.pojo.Requisicao;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.impl.provider.entity.ByteArrayProvider;
import com.sun.research.ws.wadl.Response;

public class BoletoClient {

	private WebResource resource = null;

	public BoletoClient(String url) {
		ClientConfig clientConfig = new DefaultClientConfig();
		 clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		
		Client client = Client.create(clientConfig);

		resource = client.resource(url);
	}

	protected BoletoClient(WebResource webResource) {
		this.resource = webResource;
	}

	public Requisicao criarBoleto(Boleto boleto) {
		if (boleto == null) {
			throw new IllegalArgumentException("Invalid argument");
		}

		try {
			ObjectMapper mapper = new ObjectMapper();

			String boletoS = mapper.writeValueAsString(boleto);

			String response = resource.path("boletos").type(MediaType.APPLICATION_JSON).post(String.class, boletoS);

			return mapper.readValue(response, Requisicao.class);
		} catch (Exception exception) {
			throw new BoletoException("Não foi possível criar o boleto",
					exception);
		}
	}
	
	public InputStream retornaPdf(String hash, Integer sequencial) {
		return new ByteArrayInputStream(resource.path("boletos").path(sequencial.toString()+".pdf").queryParam("hash", hash).get(byte[].class));
	}
}
