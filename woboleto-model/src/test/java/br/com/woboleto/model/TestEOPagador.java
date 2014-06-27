package br.com.woboleto.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import br.com.caelum.stella.boleto.Pagador;

import com.wounit.annotations.UnderTest;
import com.wounit.rules.MockEditingContext;

public class TestEOPagador
{
	@Rule
	public final MockEditingContext editingContext = new MockEditingContext( "Boleto" );

	@UnderTest
	protected EOPagador pagador;
	
	@Test
	public void convertePagadorParaPagadorStella() throws Exception
	{
		pagador.setDocumento( "12345678909" );
		pagador.setNome( "Seu Madruga" );
		
		Pagador result = pagador.toStellaPagador();
		
		assertThat( result.getDocumento(), is( "12345678909" ) );
		assertThat( result.getNome(), is( "Seu Madruga" ) );
		}

	@Test
	public void convertePagadorVazioParaPagadorStella() throws Exception
	{
		Pagador result = pagador.toStellaPagador();

		assertThat( result, notNullValue() );
	}
}
