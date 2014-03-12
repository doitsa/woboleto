package br.com.woboleto.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import br.com.woboleto.model.EODescricao;
import br.com.woboleto.model.EOInstrucao;
import br.com.woboleto.model.EOLocalPagamento;

import com.wounit.rules.MockEditingContext;

public class TestAbstractInformacao {
	@Rule
	public final MockEditingContext editingContext = new MockEditingContext(
			"Boleto");

	@Test
	public void inicializacaoDescricao() throws Exception {
		EODescricao descricao = EODescricao.createEODescricao(editingContext,
				null);

		assertThat(descricao.tipo(), is("1"));
	}

	@Test
	public void inicializacaoInstrucao() throws Exception {
		EOInstrucao instrucao = EOInstrucao.createEOInstrucao(editingContext,
				null);

		assertThat(instrucao.tipo(), is("2"));
	}

	@Test
	public void inicializacaoLocalPagamento() throws Exception {
		EOLocalPagamento localPagamento = EOLocalPagamento
				.createEOLocalPagamento(editingContext, null);

		assertThat(localPagamento.tipo(), is("3"));
	}
}
