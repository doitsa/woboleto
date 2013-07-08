package br.com.woboleto.model;

import br.com.caelum.stella.boleto.Sacado;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EOSacado extends _EOSacado
{
	public Sacado toStellaSacado()
	{
		Sacado sacado = Sacado.novoSacado();

		sacado.comBairro( bairro() );
		sacado.comCep( cep() );
		sacado.comCidade( cidade() );
		sacado.comCpf( cpf() );
		sacado.comEndereco( endereco() );
		sacado.comNome( nome() );
		sacado.comUf( uf() );

		return sacado;
	}
}
