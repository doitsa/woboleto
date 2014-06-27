package br.com.woboleto.model;

import br.com.caelum.stella.boleto.Pagador;

public class EOPagador extends _EOPagador {
	public Pagador toStellaPagador()
	{
		Pagador pagador = Pagador.novoPagador();

		if (documento() != null) {
			pagador.comDocumento( documento() );
		}
		
		if (nome() != null) {
			pagador.comNome( nome() );
		}
		
		if (endereco() != null) {
			pagador.comEndereco(endereco().toStellaEndereco());
		}
		
		return pagador;
	}
}
