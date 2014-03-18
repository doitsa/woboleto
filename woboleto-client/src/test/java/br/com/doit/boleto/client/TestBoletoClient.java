package br.com.doit.boleto.client;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.doit.boleto.pojo.Boleto;
import br.com.doit.boleto.pojo.Requisicao;

import com.sun.jersey.test.framework.JerseyTest;

@RunWith(MockitoJUnitRunner.class)
public class TestBoletoClient extends JerseyTest {
	
	public TestBoletoClient() {
		super("br.com.doit.boleto.client");
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private Boleto boleto = new Boleto();

	private BoletoClient client;

	@Test
	public void criarBoleto() throws Exception {
		Requisicao requisicao = client.criarBoleto(boleto);

		assertThat(requisicao.getHash(), is("b130ca1d89cc884cf8857641bc1ed784"));
		assertThat(requisicao.getSequential(), is(1));
	}

	@Test
	public void retornarExcecaoQuandoBoletoForNulo() throws Exception {
		exception.expect(IllegalArgumentException.class);
		
		client.criarBoleto(null);
	}

	@Before
	public void setup() {
		client = new BoletoClient(resource());
	}

}
