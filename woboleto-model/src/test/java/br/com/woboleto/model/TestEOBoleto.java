package br.com.woboleto.model;

import static com.wounit.matchers.EOAssert.cannotBeSavedBecause;
import static com.wounit.matchers.EOAssert.confirm;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.caelum.stella.boleto.Boleto;

import com.webobjects.foundation.NSTimestamp;
import com.wounit.annotations.Dummy;
import com.wounit.annotations.UnderTest;
import com.wounit.rules.MockEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class TestEOBoleto {
	@UnderTest
	@Spy
	private EOBoleto boleto;

	@Dummy
	private EOBeneficiario beneficiario;

	@Dummy
	private EOPagador pagador;

	@Rule
	public final MockEditingContext editingContext = new MockEditingContext("Boleto");

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

		assertThat(result.getBeneficiario(), notNullValue());
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

		assertThat(result.getPagador(), notNullValue());
	}

	@Test
	public void inicializacaoBoleto() throws Exception {
		EOBoleto boleto = EOBoleto.createEOBoleto(editingContext);

		assertThat(boleto.aceite(), is(false));
	}

	@Test
	public void setarDigitoNossoNumeroQuandoBancoForItau() throws Exception {
		beneficiario.setAgencia("167");
		beneficiario.setCodigoBeneficiario("45145");
		beneficiario.setCarteira("157");
		beneficiario.setNossoNumero("21897666");

		boleto.setBanco(BancoEnum.ITAU);

		br.com.caelum.stella.boleto.Boleto result = boleto.toStellaBoleto();

		assertThat(result.getBeneficiario().getDigitoNossoNumero(), is("6"));
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
		boleto.setPagador(pagador);
		boleto.setBeneficiario(beneficiario);
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
	
	@Test
	public void gerarBoletosAntigosComOMesmoCodigoDeBarrasELinhaDigitavel() throws Exception {
		populateBoletoWithSampleData();
		
		when(boleto.isNewObject()).thenReturn(false);
		
		Boleto stellaBoleto = boleto.toStellaBoleto();
		
		assertThat(stellaBoleto.getCodigoDeBarras(), is("102030405060708090"));
		assertThat(stellaBoleto.getLinhaDigitavel(), is("01802.304203.02345"));
	}
	
	@Test
	public void gerarBoletosNovosCodigoDeBarrasELinhaDigitavelNovos() throws Exception {
		populateBoletoWithSampleData();
		
		beneficiario.setAgencia("8462");
		beneficiario.setCodigoBeneficiario("05825");
		beneficiario.setDigitoVerificadorCodigoBeneficiario("9");
		beneficiario.setCarteira("174");
		beneficiario.setNossoNumero("14936");
		beneficiario.setNumeroConvenio("0000");
		
		boleto.setBeneficiario(beneficiario);
		
		boleto.setNumeroDocumento("1234");
		
		DateTime dataDoc = new DateTime(2014, 5, 5, 0, 0, 0, 0);
		DateTime dataVenc = new DateTime(2014, 5, 20, 0, 0, 0, 0);
		
		boleto.setDataDocumento(dataTimeToNSTimestamp(dataDoc));
		boleto.setDataProcessamento(dataTimeToNSTimestamp(dataDoc));
		boleto.setDataVencimento(dataTimeToNSTimestamp(dataVenc));
		
		when(boleto.isNewObject()).thenReturn(true);
		
		Boleto stellaBoleto = boleto.toStellaBoleto();
		
		assertThat(stellaBoleto.getCodigoDeBarras(), is("34193606900000010001740001493688462058259000"));
		assertThat(stellaBoleto.getLinhaDigitavel(), is("34191.74002  01493.688467  20582.590004  3  60690000001000"));
	}

	private void populateBoletoWithSampleData() {
		boleto.setBanco(BancoEnum.ITAU);
		boleto.setDataVencimento(new NSTimestamp());
		boleto.setNumeroDocumento("1234");
		boleto.setValor(BigDecimal.TEN);
		boleto.setCodigoDeBarras("102030405060708090");
		boleto.setLinhaDigitavel("01802.304203.02345");
	}
	
	public NSTimestamp dataTimeToNSTimestamp(DateTime dataTime) {
		Date data = dataTime.toDate();
		return new NSTimestamp(data);
	}
	
}
