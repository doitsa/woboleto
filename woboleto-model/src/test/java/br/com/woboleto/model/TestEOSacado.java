package br.com.woboleto.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import com.wounit.annotations.UnderTest;
import com.wounit.rules.MockEditingContext;

import br.com.caelum.stella.boleto.Sacado;
import br.com.woboleto.model.EOSacado;

public class TestEOSacado
{
	@Rule
	public final MockEditingContext editingContext = new MockEditingContext( "Boleto" );

	@UnderTest
	protected EOSacado sacado;

	@Test
	public void converteSacadoParaSacadoStella() throws Exception
	{
		sacado.setBairro( "Vila Perdida" );
		sacado.setCep( "12345678" );
		sacado.setCidade( "Itaquaquecetuba" );
		sacado.setCpf( "12345678909" );
		sacado.setEndereco( "Rua sem sa\u00edda" );
		sacado.setNome( "Seu Madruga" );
		sacado.setUf( "SP" );

		Sacado result = sacado.toStellaSacado();

		assertThat( result.getBairro(), is( "Vila Perdida" ) );
		assertThat( result.getCep(), is( "12345678" ) );
		assertThat( result.getCidade(), is( "Itaquaquecetuba" ) );
		assertThat( result.getCpf(), is( "12345678909" ) );
		assertThat( result.getEndereco(), is( "Rua sem sa\u00edda" ) );
		assertThat( result.getNome(), is( "Seu Madruga" ) );
		assertThat( result.getUf(), is( "SP" ) );
	}

	@Test
	public void converteSacadoVazioParaSacadoStella() throws Exception
	{
		Sacado result = sacado.toStellaSacado();

		assertThat( result, notNullValue() );
	}
}
