package br.com.woboleto.model;

import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EOLocalPagamento extends _EOLocalPagamento
{
	@Override
	public void awakeFromInsertion( final EOEditingContext ec )
	{
		super.awakeFromInsertion( ec );

		if( tipo() == null )
		{
			setTipo( "3" );
		}
	}
}
