package br.com.woboleto.model;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.caelum.stella.boleto.bancos.Caixa;
import br.com.caelum.stella.boleto.bancos.Itau;
import br.com.caelum.stella.boleto.bancos.Santander;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public enum BancoEnum
{
	BANCO_DO_BRASIL( new BancoDoBrasil() ), BRADESCO( new Bradesco() ), CAIXA_ECONOMICA( new Caixa() ), ITAU( new Itau() ), SANTANDER( new Santander() ), OUTRO( null );

	private final Banco banco;

	private BancoEnum( final Banco banco )
	{
		this.banco = banco;
	}

	public Banco toStellaBanco()
	{
		if( banco == null )
		{
			throw new UnsupportedOperationException( "O banco " + this.toString() + " n\u00e3o possui um correspondente na biblioteca Stella boleto." );
		}

		return banco;
	}
}
