package br.com.woboleto.model;

import er.extensions.eof.ERXEOControlUtilities;

public class EORequisicao extends _EORequisicao {
	@Override
	public void willInsert() {
		super.willInsert();

		Integer resultado = maiorSequencial();
		
		if (resultado == null) {
			resultado = 0;
		}
		
		setSequential(resultado + 1);
	}

	Integer maiorSequencial() {
		return (Integer) ERXEOControlUtilities.aggregateFunctionWithQualifier(editingContext(), ENTITY_NAME, SEQUENTIAL_KEY, "MAX", null);
	}
}
