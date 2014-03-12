package br.com.woboleto.model;

import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EOLocalPagamento extends _EOLocalPagamento {
	@Override
	protected void init(EOEditingContext ec) {
		super.init(ec);

		setTipo("3");
	}
}
