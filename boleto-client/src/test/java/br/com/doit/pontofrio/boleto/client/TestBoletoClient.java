package br.com.doit.pontofrio.boleto.client;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class TestBoletoClient
{
	@Test
	@Ignore("precisa ser repensado")
	public void acceptNullParametersAsArgument() throws Exception
	{
		BoletoClient client = new BoletoClient("http://localhost:8080");

		client = Mockito.spy(client);

		Client mockClient = Mockito.mock(Client.class);

		Mockito.doReturn(mockClient).when(client).createClient();

		WebResource mockResource = Mockito.mock(WebResource.class);

		Mockito.when(mockClient.resource("http://localhost:8080/boletos")).thenReturn(mockResource);

		ClientResponse mockResponse = Mockito.mock(ClientResponse.class);

		Mockito.doReturn(mockResponse).when(client).postResource(Mockito.any(Form.class));
		Mockito.when(mockResponse.getClientResponseStatus()).thenReturn(ClientResponse.Status.CREATED);

		client.createBoleto("1234", new Date(), BigDecimal.ONE, null);

		Mockito.verify(mockClient, Mockito.times(1)).resource("http://localhost:8080/boletos");
	}

	@Test(expected = IllegalArgumentException.class)
	public void cannotCreateBoletoClientWithNullBaseUri() throws Exception
	{
		new BoletoClient(null);
	}

	@Test
	public void cannotCreateBoletoWithNullAmount() throws Exception
	{
		checkExceptionOnBoletoClientCreation("123", new Date(), null, Collections.<String, String> emptyMap(), "Cannot create boleto with null amount");
	}

	@Test
	public void cannotCreateBoletoWithNullDueDate() throws Exception
	{
		checkExceptionOnBoletoClientCreation("123", null, BigDecimal.ONE, Collections.<String, String> emptyMap(), "Cannot create boleto with null dueDate");
	}

	@Test
	public void cannotCreateBoletoWithNullOrderId() throws Exception
	{
		checkExceptionOnBoletoClientCreation(null, new Date(), BigDecimal.ONE, Collections.<String, String> emptyMap(), "Cannot create boleto with null orderId");
	}

	@Test
	public void cannotRequestVoucherForNullOrderId() throws Exception
	{
		BoletoClient client = new BoletoClient("http://localhost:8080");

		try
		{
			client.requestVoucher(null);

			fail();
		}
		catch(Exception exception)
		{
			assertThat(exception, instanceOf(IllegalArgumentException.class));
			assertThat(exception.getMessage(), is("Cannot request voucher for null orderId"));
		}
	}

	private void checkExceptionOnBoletoClientCreation(String orderId, Date dueDate, BigDecimal amount, Map<String, String> parameters, String exceptionMessage)
	{
		BoletoClient client = new BoletoClient("http://localhost:8080");

		try
		{
			client.createBoleto(orderId, dueDate, amount, parameters);

			fail();
		}
		catch(Exception exception)
		{
			assertThat(exception, instanceOf(IllegalArgumentException.class));
			assertThat(exception.getMessage(), is(exceptionMessage));
		}
	}
}
