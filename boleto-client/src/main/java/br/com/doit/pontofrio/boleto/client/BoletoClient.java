package br.com.doit.pontofrio.boleto.client;

import java.math.BigDecimal;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.representation.Form;

/**
 * O BoletoClient \u00e9 uma classe que cuida da comunica\u00e7\u00e3o com o
 * servi\u00e7o de gera\u00e7\u00e3o de boletos do Ponto Frio. Por meio desta
 * classe \u00e9 poss\u00edvel realizar todas as opera\u00e7\u00f5es
 * relacionadas com o pagamento do tipo Boleto, sem ter que se preocupar com
 * como a comunica\u00e7\u00e3o \u00e9 feita.
 * 
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class BoletoClient
{
	public static void main(final String[] args) throws BoletoOperationException
	{
		BoletoClient client = new BoletoClient("http://localhost:8080/boleto-service");

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put("customerName", "Fulano");
		parameters.put("customerCpf", "123.456.789-09");

		System.out.println(client.createBoleto("12345678", new Date(), BigDecimal.ONE, parameters));

		System.out.println("Voucher: " + client.requestVoucher("12345678"));
	}

	private final String baseUri;

	/**
	 * Cria um novo cliente para comunica\u00e7\u00e3o com o servi\u00e7o de
	 * gera\u00e7\u00e3o de boletos de cobran\u00e7a do Ponto Frio.
	 * 
	 * @param baseUri
	 *            A URI base para acessar o servi\u00e7o de gera\u00e7\u00e3o de
	 *            boletos
	 */
	public BoletoClient(String baseUri)
	{
		if(baseUri == null)
		{
			throw new IllegalArgumentException("The baseUri parameter cannot be null");
		}

		this.baseUri = baseUri;
	}

	/**
	 * Requisita a cria\u00e7\u00e3o de um boleto via o servi\u00e7o de
	 * gera\u00e7\u00e3o de boletos do Ponto Frio.
	 * <p>
	 * Os seguintes par\u00e2metros s\u00e3o aceitos para cria\u00e7\u00e3o do
	 * boleto
	 * <ul>
	 * <li><b>customerCpf</b>: o CPF ou CNPJ do cliente</li>
	 * <li><b>customerName</b>: o nome do cliente</li>
	 * </ul>
	 * 
	 * @param orderId
	 *            O id do pedido para o qual o boleto ser\u00e1 gerado
	 * @param dueDate
	 *            A data de vencimento do boleto
	 * @param amount
	 *            O valor do boleto
	 * @param parameters
	 *            Um conjunto de par\u00e2metros para cria\u00e7\u00e3o do
	 *            boleto
	 * @return A {@link URI} para acessar o boleto que foi gerado
	 * @throws BoletoOperationException
	 *             caso algum erro aconte\u00e7a durante a comunica\u00e7\u00e3o
	 *             com o servi\u00e7o
	 */
	public URI createBoleto(String orderId, Date dueDate, BigDecimal amount, Map<String, String> parameters) throws BoletoOperationException
	{
		if(orderId == null)
		{
			throw new IllegalArgumentException("Cannot create boleto with null orderId");
		}

		if(dueDate == null)
		{
			throw new IllegalArgumentException("Cannot create boleto with null dueDate");
		}

		if(amount == null)
		{
			throw new IllegalArgumentException("Cannot create boleto with null amount");
		}

		DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

		Form form = new Form();

		form.add("orderId", orderId);
		form.add("dueDate", dateFormatter.format(dueDate));
		form.add("amount", amount.toString());

		if(parameters != null)
		{
			Set<String> keys = parameters.keySet();

			for(String key : keys)
			{
				form.add(key, parameters.get(key));
			}
		}

		ClientResponse response = postResource(form);

		if(!Status.CREATED.equals(response.getClientResponseStatus()))
		{
			throw new BoletoOperationException("Ocorreu um erro ao criar o boleto. Status: " + response.getStatus());
		}

		return response.getLocation();
	}

	Client createClient()
	{
		Client client = Client.create();

		client.setFollowRedirects(true);

		return client;
	}

	ClientResponse postResource(Form form)
	{
		Client client = createClient();

		WebResource resource = client.resource(String.format("%s/boletos", baseUri));

		return resource.header("Authorization", "b027df2995d9fc3d795f91745f449bd8").post(ClientResponse.class, form);
	}

	/**
	 * Requisita o comprovante de pagamento de um boleto gerado para o pedido
	 * passado por par\u00e2metro.
	 * 
	 * @param orderId
	 *            O id do pedido para o qual o pagamento est\u00e1 sendo
	 *            verificado
	 * @return Um {@link Voucher} comprovando o pagamento ou <code>null</code>
	 *         caso o pagamento ainda n\u00e3o tenha sido realizaado
	 * @throws BoletoOperationException
	 *             caso algum erro aconte\u00e7a durante a comunica\u00e7\u00e3o
	 *             com o servi\u00e7o
	 */
	public Voucher requestVoucher(final String orderId) throws BoletoOperationException
	{
		if(orderId == null)
		{
			throw new IllegalArgumentException("Cannot request voucher for null orderId");
		}

		Client client = createClient();

		WebResource resource = client.resource(String.format("%s/boletos/%s/comprovante", baseUri, orderId));

		String voucherXml = null;

		try
		{
			voucherXml = resource.get(String.class);
		}
		catch(UniformInterfaceException exception)
		{
			if(ClientResponse.Status.NO_CONTENT.equals(exception.getResponse().getClientResponseStatus()))
			{
				return null;
			}

			throw new BoletoOperationException(exception);
		}

		return Voucher.fromXml(voucherXml);
	}
}
