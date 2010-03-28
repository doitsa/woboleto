package br.com.doit.pontofrio.boleto.client;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse.Status;
import com.sun.jersey.api.representation.Form;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class BoletoClient
{
	public static void main( final String[] args ) throws BoletoOperationException
	{
		BoletoClient client = new BoletoClient();

		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put( "orderId", "1234" );
		parameters.put( "customerCpf", "123.456.789-09" );
		parameters.put( "customerName", "Teste DOit" );

		DateFormat dateFormatter = new SimpleDateFormat( "dd/MM/yyyy" );

		parameters.put( "dueDate", dateFormatter.format( new Date() ) );
		parameters.put( "amount", "1.00" );

		System.out.println( client.createBoleto( parameters ) );
	}

	/**
	 * Requisita a cria\u00e7\u00e3o de um boleto via o servi\u00e7o de
	 * gera\u00e7\u00e3o de boletos do Ponto Frio.
	 * <p>
	 * Os seguintes par\u00e2metros s\u00e3o aceitos para cria\u00e7\u00e3o do
	 * boleto
	 * <ul>
	 * <li><b>orderId</b>: o id do pedido (obrigat\u00f3rio)</li>
	 * <li><b>dueDate</b>: a data de vencimento do boleto que ser\u00e1 gerado
	 * (obrigat\u00f3rio)</li>
	 * <li><b>amount</b>: o valor do boleto que ser\u00e1 gerado
	 * (obrigat\u00f3rio)</li>
	 * <li><b>customerCpf</b>: o CPF ou CNPJ do cliente</li>
	 * <li><b>customerName</b>: o nome do cliente</li>
	 * </ul>
	 * 
	 * @param parameters Um conjunto de par\u00e2metros para cria\u00e7\u00e3o
	 *            do boleto
	 * @return A {@link URI} para acessar o boleto que foi gerado
	 * @throws BoletoOperationException caso algum erro aconteça durante a
	 *             comunicação
	 */
	public URI createBoleto( final Map<String, String> parameters ) throws BoletoOperationException
	{
		Client client = Client.create();

		client.setFollowRedirects( true );

		WebResource resource = client.resource( "http://localhost:8080/boleto-service/boletos" );

		Form form = new Form();

		Set<String> keys = parameters.keySet();

		for( String key : keys )
		{
			form.add( key, parameters.get( key ) );
		}

		ClientResponse response = resource.post( ClientResponse.class, form );

		if( !Status.CREATED.equals( response.getClientResponseStatus() ) )
		{
			throw new BoletoOperationException( "Ocorreu um erro ao criar o boleto. Status: " + response.getStatus() );
		}

		return response.getLocation();
	}

	public Voucher requestVoucher( final String orderId )
	{
		Client client = Client.create();

		client.setFollowRedirects( true );

		WebResource resource = client.resource( "http://localhost:8080/boleto-service/boletos/" + orderId + "/comprovante" );

		String voucherXml = resource.get( String.class );

		if( voucherXml == null )
		{
			return null;
		}

		return Voucher.fromXml( voucherXml );
	}
}
