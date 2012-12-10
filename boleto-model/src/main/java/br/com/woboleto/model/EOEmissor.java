package br.com.woboleto.model;

import br.com.caelum.stella.boleto.Emissor;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EOEmissor extends _EOEmissor
{
	public Emissor toStellaEmissor()
	{
		Emissor emissor = Emissor.newEmissor();

		if(agencia() != null)
		{
			emissor.withAgencia(agencia());
		}

		if(carteira() != null)
		{
			emissor.withCarteira(carteira());
		}

		if(cedente() != null)
		{
			emissor.withCedente(cedente());
		}

		if(codigoFornecidoPelaAgencia() != null)
		{
			emissor.withCodigoFornecidoPelaAgencia(codigoFornecidoPelaAgencia());
		}

		if(codigoOperacao() != null)
		{
			emissor.withCodigoOperacao(codigoOperacao());
		}

		if(contaCorrente() != null)
		{
			emissor.withContaCorrente(contaCorrente());
		}

		if(digitoVerificadorAgencia() != null)
		{
			emissor.withDigitoAgencia(digitoVerificadorAgencia().charAt(0));
		}

		if(digitoVerificadorContaCorrente() != null)
		{
			emissor.withDigitoContaCorrente(digitoVerificadorContaCorrente().charAt(0));
		}

		if(digitoVerificadorNossoNumero() != null)
		{
			emissor.withDigitoNossoNumero(digitoVerificadorNossoNumero().charAt(0));
		}

		if(nossoNumero() != null)
		{
			emissor.withNossoNumero(nossoNumero());
		}

		if(numeroConvenio() != null)
		{
			emissor.withNumeroConvenio(numeroConvenio());
		}

		return emissor;
	}
}
