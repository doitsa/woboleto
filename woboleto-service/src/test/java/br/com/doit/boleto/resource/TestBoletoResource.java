package br.com.doit.boleto.resource;

import static com.wounit.matchers.EOAssert.hasBeenSaved;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.bancos.GeradorDeLinhaDigitavel;
import br.com.woboleto.model.BancoEnum;
import br.com.woboleto.model.EOBeneficiario;
import br.com.woboleto.model.EOBoleto;
import br.com.woboleto.model.EOEndereco;
import br.com.woboleto.model.EOLocalPagamento;
import br.com.woboleto.model.EOPagador;
import br.com.woboleto.model.EORequisicao;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;
import com.wounit.annotations.Dummy;
import com.wounit.rules.MockEditingContext;

/**
 * @author Rodrigo de Sousa
 */
@RunWith(MockitoJUnitRunner.class)
public class TestBoletoResource {
	private BoletoResource resource;

	@Rule
	public MockEditingContext editingContext = new MockEditingContext("Boleto");

	@Dummy
	private EOBoleto boleto;

	@Dummy
	private EORequisicao requisicao;

	@Dummy(size = 1)
	NSArray<EOLocalPagamento> locais;

	@Spy
	@Dummy
	private EORequisicao novaRequisicao;

	@Test
	public void validarDadosDoBoletoESalvarQuandoEstiverCorreto()
			throws Exception {
		Response response = resource.salvarBoleto(boleto);

		Banco banco = boleto.banco().toStellaBanco();
		String codigoDeBarras = banco.geraCodigoDeBarrasPara(boleto
				.toStellaBoleto());

		GeradorDeLinhaDigitavel gerador = new GeradorDeLinhaDigitavel();
		String linhaDigitavel = gerador.geraLinhaDigitavelPara(codigoDeBarras,
				banco);

		assertThat(response.getStatus(), is(201));
		assertThat(response.getEntity(), is((Object)"{\"hash\":\"abcd1234\",\"sequential\":1}"));
		assertThat(requisicao, hasBeenSaved());
		assertThat(boleto.linhaDigitavel(), is(linhaDigitavel));
	}

	@Test
	public void lancarExcecaoQuandoBoletoEstaNull() throws Exception {
		try {
			resource.salvarBoleto(null);
			fail("Deveria ter dado uma exceção");
		} catch (WebApplicationException exception) {
			assertThat(exception.getResponse().getStatus(), is(400));
			assertThat(exception.getCause().getMessage(),
					is("Não foi possível criar o boleto"));
		}
	}

	@Test
	public void lancarExcecaoQuandoHashEstiverNulo() throws Exception {
		try {
			boleto = null;

			resource.gerarBoletoPDF(1, null);
			fail("Deveria ter dado uma exceção");
		} catch (WebApplicationException exception) {
			assertThat(exception.getResponse().getStatus(), is(400));
			assertThat(exception.getCause().getMessage(),
					is("É necessário informar o número da requisição e o hash"));
		}
	}

	@Test
	public void lancarExcecaoQuandoSequencialEstiverNulo() throws Exception {
		try {
			boleto = null;

			resource.gerarBoletoPDF(null, "634df2662567459339a52706b718340b");
			fail("Deveria ter dado uma exceção");
		} catch (WebApplicationException exception) {
			assertThat(exception.getResponse().getStatus(), is(400));
			assertThat(exception.getCause().getMessage(),
					is("É necessário informar o número da requisição e o hash"));
		}
	}
	
	@Test
	public void lancarExcecaoQuandoBoletoForInvalido() throws Exception {
		try {
			EOBeneficiario eoBeneficiario = EOBeneficiario.createEOBeneficiario(editingContext);
			eoBeneficiario.setNumeroConvenio(null);
			eoBeneficiario.setNossoNumero("123");
			
			boleto.setBeneficiario(eoBeneficiario);
			
			resource.salvarBoleto(boleto);
		} catch (WebApplicationException exception) {
			assertThat(exception.getResponse().getStatus(), is(400));
			assertThat(exception.getMessage(), is("Não foi possível criar o boleto. Verificar dados enviados."));
		}
	}

	@Test
	public void lancarExcecaoQuandoBoletoNaoExistir() throws Exception {
		try {
			boleto = null;

			resource.gerarBoletoPDF(1, "634df2662567459339a52706b718340b");
			fail("Deveria ter dado uma exceção");
		} catch (WebApplicationException exception) {
			assertThat(exception.getResponse().getStatus(), is(404));
			assertThat(exception.getCause().getMessage(),
					is("Não há boleto com o ID informado"));
		}
	}

	@Test
	public void retornarBoletoPNGQuandoRequisicaoExistir() throws Exception {
		byte[] resultado = resource.gerarBoletoPNG(123,	"634df2662567459339a52706b718340b");

		// Essa assertiva não garante muita coisa.
                // Pelo menos dessa forma garantimos que a lógica de gerar o PNG não está com nenhum erro grave.
		assertThat(resultado, notNullValue());
	}

	@Test
	public void retornarBoletoPDFQuandoRequisicaoExistir() throws Exception {
		byte[] resultado = resource.gerarBoletoPDF(123,	"634df2662567459339a52706b718340b");

		// Essa assertiva não garante muita coisa.
		// Pelo menos dessa forma garantimos que a lógica de gerar o PDF não está com nenhum erro grave.
		assertThat(resultado, notNullValue());
	}

	@Before
	public void setup() {
		locais.get(0).setValor("PAGAR PREFERENCIALMENTE NO BANCO SANTANDER");

		EOBeneficiario eoBeneficiario = new EOBeneficiario();
		eoBeneficiario.setNomeBeneficiario("Instituto Qualisa");
		eoBeneficiario.setNumeroConvenio("3903125");
		eoBeneficiario.setCarteira("102");
		eoBeneficiario.setNossoNumero("382713000472");

		DateTime dataDoc = new DateTime(2014, 2, 1, 0, 0, 0, 0);
		DateTime dataVenc = new DateTime(2014, 2, 10, 0, 0, 0, 0);

		EOPagador eoPagador = new EOPagador();
		eoPagador.setNome("DOit Serviços de Informática SA");
		
		EOEndereco eoEndereco = new EOEndereco();
		eoEndereco.setBairro("Itaim");
		eoEndereco.setCep("04552-000");
		eoEndereco.setCidade("São Paulo");
		eoEndereco.setUf("SP");

		eoPagador.setEndereco(eoEndereco);
		
		boleto.setPagador(eoPagador);
		boleto.setNumeroDocumento("1234");
		boleto.addToLocaisPagamentoRelationship(locais.get(0));
		boleto.locaisPagamento();

		editarBoleto(BancoEnum.SANTANDER, eoBeneficiario, dataDoc, dataVenc, new BigDecimal(1.00));
		
		requisicao.setBoleto(boleto);
		requisicao.setSequential(123);
		requisicao.setHash("634df2662567459339a52706b718340b");
		
		doNothing().when(novaRequisicao).willInsert();
		
		novaRequisicao.setSequential(1);
		novaRequisicao.setHash("abcd1234");

		resource = spy(new BoletoResource());

		doReturn(novaRequisicao).when(resource).criarRequisicao(editingContext, boleto);
	}
	
	@Test
	public void gerarBoletosAntigosComOMesmoCodigoDeBarrasELinhaDigitavel() throws Exception {
		boleto.setCodigoDeBarras("102030405060708090");
		boleto.setLinhaDigitavel("01802.304203.02345");
		
		resource.salvarBoleto(boleto);
		
		assertThat(boleto.codigoDeBarras(), is("102030405060708090"));
		assertThat(boleto.linhaDigitavel(), is("01802.304203.02345"));
	}
	
	@Test
	public void gerarCodigoDeBarrasBoletoSantander() throws Exception {
		EOBeneficiario eoBeneficiario = new EOBeneficiario();
		eoBeneficiario.setNomeBeneficiario("Instituto Qualisa");
		eoBeneficiario.setNumeroConvenio("3903125");
		eoBeneficiario.setCarteira("102");
		eoBeneficiario.setNossoNumero("2263");
		
		DateTime dataDoc = new DateTime(2014, 5, 5, 0, 0, 0, 0);
		DateTime dataVenc = new DateTime(2014, 5, 9, 0, 0, 0, 0);
		
		Boleto stellaBoleto = editarBoleto(BancoEnum.SANTANDER, eoBeneficiario, dataDoc, dataVenc, new BigDecimal("1563.79"));
		
		assertThat(stellaBoleto.getCodigoDeBarras(), is("03391605800001563799390312500000000226320102"));
		assertThat(stellaBoleto.getLinhaDigitavel(), is("03399.39035  12500.000000  02263.201028  1  60580000156379"));
	}
	
	@Test
	public void gerarCodigoDeBarrasBoletoBancoDoBrasil() throws Exception {
		EOBeneficiario eoBeneficiario = new EOBeneficiario();
		eoBeneficiario.setNomeBeneficiario("studio felix arquitetura e design");
		eoBeneficiario.setCodigoBeneficiario("8093");
		eoBeneficiario.setDigitoVerificadorCodigoBeneficiario("4");
		eoBeneficiario.setAgencia("4039");
		eoBeneficiario.setDigitoVerificadorAgencia("8");
		eoBeneficiario.setNumeroConvenio("2548144");
		eoBeneficiario.setCarteira("18");
		eoBeneficiario.setNossoNumero("677");
		
		DateTime dataDoc = new DateTime(2014, 5, 15, 0, 0, 0, 0);
		DateTime dataVenc = new DateTime(2014, 5, 22, 0, 0, 0, 0);
		
		Boleto stellaBoleto = editarBoleto(BancoEnum.BANCO_DO_BRASIL, eoBeneficiario, dataDoc, dataVenc, new BigDecimal("4925.00"));
		
		assertThat(stellaBoleto.getCodigoDeBarras(), is("00193607100004925000000002548144000000067718"));
		assertThat(stellaBoleto.getLinhaDigitavel(), is("00190.00009  02548.144001  00000.677187  3  60710000492500"));
	}
	
	@Test
	public void gerarCodigoDeBarrasBoletoItau() throws Exception {
		EOBeneficiario eoBeneficiario = new EOBeneficiario();
		eoBeneficiario.setNomeBeneficiario("studio mk27");
		eoBeneficiario.setAgencia("8462");
		eoBeneficiario.setCodigoBeneficiario("05825");
		eoBeneficiario.setDigitoVerificadorCodigoBeneficiario("9");
		eoBeneficiario.setCarteira("174");
		eoBeneficiario.setNossoNumero("14936");
		eoBeneficiario.setNumeroConvenio("0000");
		
		DateTime dataDoc = new DateTime(2014, 5, 5, 0, 0, 0, 0);
		DateTime dataVenc = new DateTime(2014, 5, 20, 0, 0, 0, 0);
		
		Boleto stellaBoleto = editarBoleto(BancoEnum.ITAU, eoBeneficiario, dataDoc, dataVenc, new BigDecimal("19708.50"));
		
		assertThat(stellaBoleto.getCodigoDeBarras(), is("34196606900019708501740001493688462058259000"));
		assertThat(stellaBoleto.getLinhaDigitavel(), is("34191.74002  01493.688467  20582.590004  6  60690001970850"));
	}
	
	public Boleto editarBoleto(BancoEnum banco, EOBeneficiario beneficiario, DateTime dataDoc, DateTime dataVenc, BigDecimal valor) {
		boleto.setBeneficiario(beneficiario);
		boleto.setBanco(banco);
		boleto.setDataDocumento(dataTimeToNSTimestamp(dataDoc));
		boleto.setDataProcessamento(dataTimeToNSTimestamp(dataDoc));
		boleto.setDataVencimento(dataTimeToNSTimestamp(dataVenc));
		boleto.setValor(valor);
		
		return boleto.toStellaBoleto();
	}
	
	public NSTimestamp dataTimeToNSTimestamp(DateTime dataTime) {
		Date data = dataTime.toDate();
		return new NSTimestamp(data);
	}
}