package br.com.doit.boleto.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.woboleto.model.BancoEnum;
import br.com.woboleto.model.EOBoleto;
import br.com.woboleto.model.EOEmissor;
import br.com.woboleto.model.EOLocalPagamento;
import br.com.woboleto.model.EORequisicao;
import br.com.woboleto.model.EOSacado;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOObjectStore;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;
import com.wounit.annotations.Dummy;
import com.wounit.rules.MockEditingContext;

import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXEC.Factory;

/**
 * @author Rodrigo de Sousa
 * 
 *         TODO: Teste geração de PDF/PNG
 */
@RunWith(MockitoJUnitRunner.class)
public class TestBoletoResource {
	private BoletoResource resource = new BoletoResource();

	@Rule
	public MockEditingContext editingContext = new MockEditingContext("Boleto");

	@Dummy
	private EOBoleto boleto;

	@Dummy
	private EORequisicao requisicao;

	@Dummy(size = 1)
	NSArray<EOLocalPagamento> locais;

	@Test
	public void saveBoletoIfDataIsCorrect() throws Exception {
		Response response = resource.salvarBoleto(boleto);

		assertThat(response.getStatus(), is(201));
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

		byte[] resultado = resource.gerarBoletoPNG(123,
				"634df2662567459339a52706b718340b");

		// OutputStream out = new
		// FileOutputStream("/Users/rdskill/Documents/workspace/woboleto/boleto-service/src/test/resources/boleto.png");

		// IOUtils.write(resultado, out);

		InputStream expectedInput = getClass().getResourceAsStream(
				"/boleto.png");

		ByteArrayInputStream result = new ByteArrayInputStream(resultado);

		assertTrue(IOUtils.contentEquals(result, expectedInput));
	}

	@Test
	@Ignore("Ignora esse teste pois não é possível gerar um PDF idêntico a cada execução dos testes")
	public void retornarBoletoPDFQuandoRequisicaoExistir() throws Exception {
		byte[] resultado = resource.gerarBoletoPDF(123,
				"634df2662567459339a52706b718340b");

		InputStream expectedInput = getClass().getResourceAsStream(
				"/boleto.pdf");

		ByteArrayInputStream result = new ByteArrayInputStream(resultado);

		assertTrue(IOUtils.contentEquals(result, expectedInput));
	}

	@Before
	public void setup() {
		locais.get(0).setValor("PAGAR PREFERENCIALMENTE NO BANCO SANTANDER");

		EOEmissor eoEmissor = new EOEmissor();
		eoEmissor.setCedente("Instituto Qualisa");
		eoEmissor.setContaCorrente(3903125L);
		eoEmissor.setCarteira(102);
		eoEmissor.setNossoNumero(3827130004722L);

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

		// TODO: Utilizar factory do WOUnit quando ela existir
		ERXEC.setFactory(new Factory() {
			public boolean useSharedEditingContext() {
				return false;
			}

			public void setUseSharedEditingContext(boolean value) {
			}

			public void setDefaultNoValidationDelegate(Object delegate) {
			}

			public void setDefaultEditingContextDelegate(Object delegate) {
			}

			public void setDefaultDelegateOnEditingContext(EOEditingContext ec,
					boolean validation) {
			}

			public void setDefaultDelegateOnEditingContext(EOEditingContext ec) {
			}

			public Object defaultNoValidationDelegate() {
				return null;
			}

			public Object defaultEditingContextDelegate() {
				return null;
			}

			public EOEditingContext _newEditingContext(
					EOObjectStore objectStore, boolean validationEnabled) {
				return null;
			}

			public EOEditingContext _newEditingContext(EOObjectStore objectStore) {
				return null;
			}

			public EOEditingContext _newEditingContext(boolean validationEnabled) {
				return null;
			}

			public EOEditingContext _newEditingContext() {
				return editingContext;
			}
		});

	}
}
