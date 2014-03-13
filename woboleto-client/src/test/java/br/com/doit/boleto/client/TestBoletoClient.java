package br.com.doit.boleto.client;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.doit.boleto.pojo.BancoEnum;
import br.com.doit.boleto.pojo.Boleto;
import br.com.doit.boleto.pojo.Descricao;
import br.com.doit.boleto.pojo.Emissor;
import br.com.doit.boleto.pojo.Instrucao;
import br.com.doit.boleto.pojo.LocalPagamento;
import br.com.doit.boleto.pojo.Requisicao;
import br.com.doit.boleto.pojo.Sacado;

@RunWith(MockitoJUnitRunner.class)
public class TestBoletoClient extends JerseyTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	private Boleto boleto = new Boleto();

	private BoletoClient client;

	@Override
	protected Application configure() {
		return new ResourceConfig(BoletoResource.class);
	}

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

		ArrayList<Descricao> descricoes = new ArrayList<Descricao>();
		ArrayList<Instrucao> instrucoes = new ArrayList<Instrucao>();

		ArrayList<LocalPagamento> locaisPagamento = new ArrayList<LocalPagamento>();
		LocalPagamento localPagamento = new LocalPagamento();
		localPagamento.setValor("PAGAR PREFERENCIALMENTE NO BANCO SANTANDER");
		locaisPagamento.add(localPagamento);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DATE, 24);
		cal.set(Calendar.YEAR, 2014);

		Date data = new Date();
		data = cal.getTime();

		Emissor emissor = new Emissor();
		emissor.setCedente("Instituto Qualisa");
		emissor.setContaCorrente("3903125");
		emissor.setCarteira("102");
		emissor.setNossoNumero("3827130004722");

		Sacado sacado = new Sacado();
		sacado.setNome("Boleto Client");
		sacado.setEndereco("Rua do Rocio, 199");
		sacado.setBairro("Itaim");
		sacado.setCep("04552-000");
		sacado.setCidade("São Paulo");
		sacado.setUf("SP");

		boleto.setBanco(BancoEnum.SANTANDER);
		boleto.setDataDocumento(data);
		boleto.setDataProcessamento(data);
		boleto.setDataVencimento(data);
		boleto.setDescricoes(descricoes);
		boleto.setEmissor(emissor);
		boleto.setEspecieDocumento("DM");
		boleto.setInstrucoes(instrucoes);
		boleto.setLocaisPagamento(locaisPagamento);
		boleto.setNumeroDocumento("1234");
		boleto.setQuantidadeMoeda(null);
		boleto.setSacado(sacado);
		boleto.setValor(new BigDecimal(100.00));
		boleto.setValorMoeda(null);

		client = new BoletoClient(target());
	}

}
