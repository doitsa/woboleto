package br.com.woboleto.model;

import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EOInstrucao extends _EOInstrucao
{
	@Override
	protected void init(EOEditingContext ec) {
		super.init(ec);
		
		setTipo("2");
	}
}
