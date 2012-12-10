package br.com.woboleto.model;

import br.com.caelum.stella.boleto.Sacado;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EOSacado extends _EOSacado
{
	public Sacado toStellaSacado()
	{
		Sacado sacado = Sacado.newSacado();

		sacado.withBairro( bairro() );
		sacado.withCep( cep() );
		sacado.withCidade( cidade() );
		sacado.withCpf( cpf() );
		sacado.withEndereco( endereco() );
		sacado.withNome( nome() );
		sacado.withUf( uf() );

		return sacado;
	}
}
