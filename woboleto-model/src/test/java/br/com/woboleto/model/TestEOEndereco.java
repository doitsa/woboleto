package br.com.woboleto.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import br.com.caelum.stella.boleto.Endereco;

import com.wounit.annotations.UnderTest;
import com.wounit.rules.MockEditingContext;

public class TestEOEndereco
{
	@Rule
	public final MockEditingContext editingContext = new MockEditingContext( "Boleto" );

	@UnderTest
	protected EOEndereco endereco;
	
	@Test
	public void converteEnderecoParaEnderecoStella() throws Exception
	{
		endereco.setBairro( "Vila Perdida" );
		endereco.setCep( "12345678" );
		endereco.setCidade( "Itaquaquecetuba" );
		endereco.setLogradouro( "Rua sem sa\u00edda" );
		endereco.setUf( "SP" );
		
		Endereco result = endereco.toStellaEndereco();
		
		
		assertThat( result.getBairro(), is( "Vila Perdida" ) );
		assertThat( result.getCep(), is( "12345678" ) );
		assertThat( result.getCidade(), is( "Itaquaquecetuba" ) );
		assertThat( result.getLogradouro(), is( "Rua sem sa\u00edda" ) );
		assertThat( result.getUf(), is( "SP" ) );
		}

	@Test
	public void converteEnderecoVazioParaEnderecoStella() throws Exception
	{
		Endereco result = endereco.toStellaEndereco();

		assertThat( result, notNullValue() );
	}
}
