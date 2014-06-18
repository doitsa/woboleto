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
import br.com.caelum.stella.boleto.bancos.GeradorDeLinhaDigitavel;
import br.com.woboleto.model.BancoEnum;
import br.com.woboleto.model.EOBoleto;
import br.com.woboleto.model.EOEmissor;
import br.com.woboleto.model.EOLocalPagamento;
import br.com.woboleto.model.EORequisicao;
import br.com.woboleto.model.EOSacado;

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
			EOEmissor eoEmissor = EOEmissor.createEOEmissor(editingContext);
			eoEmissor.setNumeroConvenio(null);
			eoEmissor.setNossoNumero("123");
			
			boleto.setEmissor(eoEmissor);
			
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

		EOEmissor eoEmissor = new EOEmissor();
		eoEmissor.setCedente("Instituto Qualisa");
		eoEmissor.setNumeroConvenio("3903125");
		eoEmissor.setCarteira("102");
		eoEmissor.setNossoNumero("382713000472");

		DateTime dataDoc = new DateTime(2014, 2, 1, 0, 0, 0, 0);
		DateTime dataVenc = new DateTime(2014, 2, 10, 0, 0, 0, 0);

		Date dataDocumentoDate = dataDoc.toDate();
		Date dataVencimentoDate = dataVenc.toDate();

		EOSacado eoSacado = new EOSacado();
		eoSacado.setNome("DOit Serviços de Informática SA");
		eoSacado.setEndereco("Rua do Rócio, 199");
		eoSacado.setBairro("Itaim");
		eoSacado.setCep("04552-000");
		eoSacado.setCidade("São Paulo");
		eoSacado.setUf("SP");

		NSTimestamp dataDocumento = new NSTimestamp(dataDocumentoDate);
		NSTimestamp dataVencimento = new NSTimestamp(dataVencimentoDate);

		boleto.setEmissor(eoEmissor);
		boleto.setSacado(eoSacado);
		boleto.setValor(new BigDecimal(1.00));
		boleto.setNumeroDocumento("1234");
		boleto.setDataDocumento(dataDocumento);
		boleto.setDataProcessamento(dataDocumento);
		boleto.setDataVencimento(dataVencimento);
		boleto.addToLocaisPagamentoRelationship(locais.get(0));
		boleto.locaisPagamento();
		boleto.setEspecieDocumento("DM");

		boleto.setBanco(BancoEnum.SANTANDER);

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

}
