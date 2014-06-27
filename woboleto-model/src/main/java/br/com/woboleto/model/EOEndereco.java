package br.com.woboleto.model;

import br.com.caelum.stella.boleto.Endereco;

public class EOEndereco extends _EOEndereco {
	
	public Endereco toStellaEndereco()
	{
		Endereco endereco = Endereco.novoEndereco();

		if (bairro() != null) {
			endereco.comBairro(bairro());
		}
		if (cidade() != null) {
			endereco.comCidade(cidade());
		}
		if (cep() != null) {
			endereco.comCep(cep());
		}
		if (logradouro() != null) {
			endereco.comLogradouro(logradouro());
		}
		if(uf() != null) {
			endereco.comUf(uf());
		}
		
		return endereco;
	}
}
