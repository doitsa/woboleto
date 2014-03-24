package br.com.woboleto.model;

import br.com.caelum.stella.boleto.Emissor;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EOEmissor extends _EOEmissor
{
	public Emissor toStellaEmissor()
	{
		Emissor emissor = Emissor.novoEmissor();

		if(agencia() != null)
		{
			emissor.comAgencia(agencia());
		}

		if(carteira() != null)
		{
			emissor.comCarteira(carteira());
		}

		if(cedente() != null)
		{
			emissor.comCedente(cedente());
		}

		if(codigoFornecidoPelaAgencia() != null)
		{
			emissor.comCodigoFornecidoPelaAgencia(codigoFornecidoPelaAgencia());
		}

		if(codigoOperacao() != null)
		{
			emissor.comCodigoOperacao(codigoOperacao());
		}

		if(contaCorrente() != null)
		{
			emissor.comContaCorrente(contaCorrente());
		}

		if(digitoVerificadorAgencia() != null)
		{
			emissor.comDigitoAgencia(digitoVerificadorAgencia().substring(0));
		}

		if(digitoVerificadorContaCorrente() != null)
		{
			emissor.comDigitoContaCorrente(digitoVerificadorContaCorrente().substring(0));
		}

		if(digitoVerificadorNossoNumero() != null)
		{
			emissor.comDigitoNossoNumero(digitoVerificadorNossoNumero());
		}

		if(nossoNumero() != null)
		{
			emissor.comNossoNumero(nossoNumero());
		}

		if(numeroConvenio() != null)
		{
			emissor.comNumeroConvenio(numeroConvenio());
		}

		return emissor;
	}
}
