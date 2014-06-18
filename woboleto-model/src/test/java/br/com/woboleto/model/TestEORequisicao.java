package br.com.woboleto.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.wounit.annotations.Dummy;
import com.wounit.annotations.UnderTest;
import com.wounit.rules.MockEditingContext;

import er.extensions.foundation.ERXProperties;

/**
 * TODO: setar sequencial quando nova requisicao for salva
 * 
 * @author rdskill
 */
@RunWith(MockitoJUnitRunner.class)
public class TestEORequisicao {
	@Rule
	public MockEditingContext mockEditingContext = new MockEditingContext(
			"Boleto");

	@Spy
	@UnderTest
	private EORequisicao requisicao;

	@Dummy
	private EOBoleto boleto;

	@Test
	public void setarSequencialInicialQuandoPrimeiraRequisicaoForSalva()
			throws Exception {
		doReturn(null).when(requisicao).maiorSequencial();
		
		mockEditingContext.saveChanges();

		assertThat(requisicao.sequential(), is(1));
	}

	@Test
	public void setarSequencialQuandoRequisicaoForSalva() throws Exception {
		doReturn(20).when(requisicao).maiorSequencial();
		
		mockEditingContext.saveChanges();
		
		assertThat(requisicao.sequential(), is(21));
	}
	
	@Test
	public void criarHashQuandoRequisicaoForSalva() throws Exception {
		doReturn(null).when(requisicao).maiorSequencial();
		
		mockEditingContext.saveChanges();
		
		assertThat(requisicao.hash(), is("634df2662567459339a52706b718340b"));
	}
	
	@Before
	public void setup() {
		ERXProperties.setStringForKey("1.0", "application.version");
		
		requisicao.setBoleto(boleto);
	}

}
