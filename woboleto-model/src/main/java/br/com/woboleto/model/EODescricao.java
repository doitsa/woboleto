package br.com.woboleto.model;

import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EODescricao extends _EODescricao
{
	@Override
	protected void init(EOEditingContext ec) {
		super.init(ec);
		
		setTipo("1");
	}
}
