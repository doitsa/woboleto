package br.com.woboleto.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import br.com.woboleto.model.EOEmissor;

import com.wounit.annotations.UnderTest;
import com.wounit.rules.MockEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class TestEOEmissor
{
	@Rule
	public final MockEditingContext editingContext = new MockEditingContext( "Boleto" );

	@UnderTest
	private EOEmissor emissor;

	@Test
	public void converteEmissorParaEmissorStella() throws Exception
	{
		emissor.setAgencia( 1234 );
		emissor.setCarteira( 175 );
		emissor.setCedente( "Teste" );
		emissor.setCodigoFornecidoPelaAgencia( 10 );
		emissor.setCodigoOperacao( 50 );
		emissor.setContaCorrente( 45678L );
		emissor.setDigitoVerificadorAgencia( "6" );
		emissor.setDigitoVerificadorContaCorrente( "7" );
		emissor.setDigitoVerificadorNossoNumero( "8" );
		emissor.setNossoNumero( 22222L );
		emissor.setNumeroConvenio( 33333L );

		br.com.caelum.stella.boleto.Emissor result = emissor.toStellaEmissor();

		assertThat( result.getAgencia(), is( 1234 ) );
		assertThat( result.getCarteira(), is( 175 ) );
		assertThat( result.getCedente(), is( "Teste" ) );
		assertThat( result.getCodigoFornecidoPelaAgencia(), is( 10 ) );
		assertThat( result.getCodigoOperacao(), is( 50 ) );
		assertThat( result.getContaCorrente(), is( 45678L ) );
		assertThat( result.getDigitoAgencia(), is( '6' ) );
		assertThat( result.getDigitoContaCorrente(), is( '7' ) );
		assertThat( result.getDigitoNossoNumero(), is( "8" ) );
		assertThat( result.getNossoNumero(), is( 22222L ) );
		assertThat( result.getNumeroConvenio(), is( 33333L ) );
	}

	@Test
	public void converteEmissorVazioParaEmissorStella() throws Exception
	{
		br.com.caelum.stella.boleto.Emissor result = emissor.toStellaEmissor();

		assertThat( result, notNullValue() );
	}
}
