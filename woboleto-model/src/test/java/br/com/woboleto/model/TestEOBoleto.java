package br.com.woboleto.model;

import static com.wounit.matchers.EOAssert.cannotBeSavedBecause;
import static com.wounit.matchers.EOAssert.confirm;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.math.BigDecimal;
import java.util.Calendar;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import br.com.caelum.stella.boleto.Boleto;
import br.com.woboleto.model.BancoEnum;
import br.com.woboleto.model.EOBoleto;
import br.com.woboleto.model.EODescricao;
import br.com.woboleto.model.EOInstrucao;
import br.com.woboleto.model.EOLocalPagamento;

import com.webobjects.foundation.NSTimestamp;
import com.wounit.annotations.UnderTest;
import com.wounit.rules.MockEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class TestEOBoleto {
	@UnderTest
	private EOBoleto boleto;

	@Rule
	public final MockEditingContext editingContext = new MockEditingContext(
			"Boleto");

	@Test
	public void converteCamposBoletoParaStellaBoleto() throws Exception {
		boleto.setAceite(true);
		boleto.setBanco(BancoEnum.BANCO_DO_BRASIL);
		boleto.setEspecieDocumento("especie");
		boleto.setNumeroDocumento("1234");
		boleto.setQuantidadeMoeda(BigDecimal.ONE);
		boleto.setValor(new BigDecimal("15.76"));
		boleto.setValorMoeda(new BigDecimal("7.99"));

		br.com.caelum.stella.boleto.Boleto result = boleto.toStellaBoleto();

		assertThat(result.getAceite(), is(true));
		assertThat(result.getBanco(),
				is(BancoEnum.BANCO_DO_BRASIL.toStellaBanco()));
		assertThat(result.getEspecieDocumento(), is("especie"));
		assertThat(result.getNumeroDoDocumento(), is("1234"));
		assertThat(result.getQuantidadeDeMoeda(), is(BigDecimal.ONE));
		assertThat(result.getValorBoleto(), is(new BigDecimal("15.76")));
		assertThat(result.getValorMoeda(), is(new BigDecimal("7.99")));
	}

	@Test
	public void converteDatasParaStellaBoleto() throws Exception {
		boleto.setDataDocumento(newNSTimestamp(1, 5, 2008));
		boleto.setDataProcessamento(newNSTimestamp(2, 5, 2008));
		boleto.setDataVencimento(newNSTimestamp(3, 5, 2008));

		br.com.caelum.stella.boleto.Boleto result = boleto.toStellaBoleto();

		assertThat(result.getDatas().getDocumento(), is(newDate(1, 5, 2008)));
		assertThat(result.getDatas().getProcessamento(),
				is(newDate(2, 5, 2008)));
		assertThat(result.getDatas().getVencimento(), is(newDate(3, 5, 2008)));
	}

	@Test
	public void converteDescricoesParaStellaBoleto() throws Exception {
		boleto.addToDescricoesRelationship(EODescricao.createEODescricao(
				editingContext, "descricao 1"));
		boleto.addToDescricoesRelationship(EODescricao.createEODescricao(
				editingContext, "descricao 2"));
		boleto.addToDescricoesRelationship(EODescricao.createEODescricao(
				editingContext, "descricao 3"));
		boleto.addToDescricoesRelationship(EODescricao.createEODescricao(
				editingContext, "descricao 4"));
		boleto.addToDescricoesRelationship(EODescricao.createEODescricao(
				editingContext, "descricao 5"));

		br.com.caelum.stella.boleto.Boleto result = boleto.toStellaBoleto();

		assertThat(
				result.getDescricoes(),
				hasItems("descricao 1", "descricao 2", "descricao 3",
						"descricao 4", "descricao 5"));
	}

	@Test
	public void converteEmissorParaStellaBoleto() throws Exception {
		br.com.caelum.stella.boleto.Boleto result = boleto.toStellaBoleto();

		assertThat(result.getEmissor(), notNullValue());
	}

	@Test
	public void converteInstrucoesParaStellaBoleto() throws Exception {
		boleto.addToInstrucoesRelationship(EOInstrucao.createEOInstrucao(
				editingContext, "instrucao 1"));
		boleto.addToInstrucoesRelationship(EOInstrucao.createEOInstrucao(
				editingContext, "instrucao 2"));
		boleto.addToInstrucoesRelationship(EOInstrucao.createEOInstrucao(
				editingContext, "instrucao 3"));
		boleto.addToInstrucoesRelationship(EOInstrucao.createEOInstrucao(
				editingContext, "instrucao 4"));
		boleto.addToInstrucoesRelationship(EOInstrucao.createEOInstrucao(
				editingContext, "instrucao 5"));

		br.com.caelum.stella.boleto.Boleto result = boleto.toStellaBoleto();

		assertThat(
				result.getInstrucoes(),
				hasItems("instrucao 1", "instrucao 2", "instrucao 3",
						"instrucao 4", "instrucao 5"));
	}

	@Test
	public void converteLocaisDePagamentoParaStellaBoleto() throws Exception {
		boleto.addToLocaisPagamentoRelationship(EOLocalPagamento
				.createEOLocalPagamento(editingContext, "local 1"));
		boleto.addToLocaisPagamentoRelationship(EOLocalPagamento
				.createEOLocalPagamento(editingContext, "local 2"));

		br.com.caelum.stella.boleto.Boleto result = boleto.toStellaBoleto();

		assertThat(result.getLocaisDePagamento(),
				hasItems("local 1", "local 2"));
	}

	@Test
	public void converteSacadoParaStellaBoleto() throws Exception {
		br.com.caelum.stella.boleto.Boleto result = boleto.toStellaBoleto();

		assertThat(result.getSacado(), notNullValue());
	}

	@Test
	public void inicializacaoBoleto() throws Exception {
		EOBoleto boleto = EOBoleto.createEOBoleto(editingContext);

		assertThat(boleto.aceite(), is(false));
	}
	
	@Test
	public void colocarDigitoVerificadorNossoNumeroQuandoBancoForSantander() throws Exception {
		boleto.setBanco(BancoEnum.SANTANDER);
		
		EOEmissor emissor = EOEmissor.createEOEmissor(editingContext);
		emissor.setNossoNumero("12");
		boleto.setEmissor(emissor);
		
		br.com.caelum.stella.boleto.Boleto result = boleto.toStellaBoleto();
		
		assertThat(result.getEmissor().getNossoNumero(), is("124"));
	}

	@Test
	public void naoPodeTerMaisDeDoisLocaisDePagamento() throws Exception {
		populateBoletoWithSampleData();

		for (int i = 0; i < 3; i++) {
			boleto.addToLocaisPagamentoRelationship(EOLocalPagamento
					.createEOLocalPagamento(editingContext, "local " + i));
		}

		confirm(boleto,
				cannotBeSavedBecause("O boleto pode conter no m\u00e1ximo 2 locais de pagamento"));
	}
	
	@Before
	public void setup() {
		boleto.setSacado(EOSacado.createEOSacado(editingContext));
		boleto.setEmissor(EOEmissor.createEOEmissor(editingContext));
	}

	@Test
	public void naoSetaValoresQueEstaoNulos() throws Exception {
		Boleto boletoEsperado = Boleto.novoBoleto();

		Boleto resultado = boleto.toStellaBoleto();

		assertThat(resultado.getAceite(), is(boletoEsperado.getAceite()));
		assertThat(resultado.getCodigoEspecieMoeda(),
				is(boletoEsperado.getCodigoEspecieMoeda()));
		assertThat(resultado.getEspecieDocumento(),
				is(boletoEsperado.getEspecieDocumento()));
		assertThat(resultado.getEspecieMoeda(),
				is(boletoEsperado.getEspecieMoeda()));
		assertThat(resultado.getNumeroDoDocumento(),
				is(boletoEsperado.getNumeroDoDocumento()));
		assertThat(resultado.getQuantidadeDeMoeda(),
				is(boletoEsperado.getQuantidadeDeMoeda()));
		assertThat(resultado.getValorBoleto(),
				is(boletoEsperado.getValorBoleto()));
		assertThat(resultado.getValorFormatado(),
				is(boletoEsperado.getValorFormatado()));
		assertThat(resultado.getValorMoeda(),
				is(boletoEsperado.getValorMoeda()));
	}

	private Calendar newDate(final int day, final int month, final int year) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new LocalDate(year, month, day).toDateMidnight()
				.toDate());

		return calendar;
	}

	private NSTimestamp newNSTimestamp(final int day, final int month,
			final int year) {
		return new NSTimestamp(new LocalDate(year, month, day).toDateMidnight()
				.toDate());
	}

	private void populateBoletoWithSampleData() {
		boleto.setBanco(BancoEnum.ITAU);
		boleto.setDataVencimento(new NSTimestamp());
		boleto.setNumeroDocumento("1234");
		boleto.setValor(BigDecimal.TEN);
	}
}
