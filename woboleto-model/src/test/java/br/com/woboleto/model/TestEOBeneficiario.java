package br.com.woboleto.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import com.wounit.annotations.UnderTest;
import com.wounit.rules.MockEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class TestEOBeneficiario
{
	@Rule
	public final MockEditingContext editingContext = new MockEditingContext( "Boleto" );

	@UnderTest
	private EOBeneficiario beneficiario;

	@Test
	public void converteBeneficiarioParaBeneficiarioStella() throws Exception
	{
		beneficiario.setAgencia("1234");
		beneficiario.setCarteira("175");
		beneficiario.setNomeBeneficiario( "Teste" );
		beneficiario.setCodigoBeneficiario("45678");
		beneficiario.setDigitoVerificadorAgencia( "6" );
		beneficiario.setDigitoVerificadorCodigoBeneficiario( "7" );
		beneficiario.setDigitoVerificadorNossoNumero( "8" );
		beneficiario.setNossoNumero("22222");
		beneficiario.setNumeroConvenio("33333");

		br.com.caelum.stella.boleto.Beneficiario result = beneficiario.toStellaBeneficiario();

		assertThat( result.getAgencia(), is( "1234" ) );
		assertThat( result.getCarteira(), is( "175" ) );
		assertThat( result.getNomeBeneficiario(), is( "Teste" ) );
		assertThat( result.getCodigoBeneficiario(), is( "45678" ) );
		assertThat( result.getDigitoAgencia(), is( "6" ) );
		assertThat( result.getDigitoCodigoBeneficiario(), is( "7" ) );
		assertThat( result.getDigitoNossoNumero(), is( "8" ) );
		assertThat( result.getNossoNumero(), is( "22222" ) );
		assertThat( result.getNumeroConvenio(), is( "33333" ) );
	}

	@Test
	public void converteBeneficiarioVazioParaBeneficiarioStella() throws Exception
	{
		br.com.caelum.stella.boleto.Beneficiario result = beneficiario.toStellaBeneficiario();

		assertThat( result, notNullValue() );
	}
}
