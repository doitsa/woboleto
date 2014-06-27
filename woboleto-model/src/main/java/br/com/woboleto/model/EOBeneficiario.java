package br.com.woboleto.model;

import br.com.caelum.stella.boleto.Beneficiario;

public class EOBeneficiario extends _EOBeneficiario {
	public Beneficiario toStellaBeneficiario()
	{
		Beneficiario beneficiario = Beneficiario.novoBeneficiario();

		if(agencia() != null)
		{
			beneficiario.comAgencia(agencia());
		}

		if(carteira() != null)
		{
			beneficiario.comCarteira(carteira());
		}

		if(nomeBeneficiario() != null)
		{
			beneficiario.comNomeBeneficiario(nomeBeneficiario());
		}

		if(codigoBeneficiario() != null)
		{
			beneficiario.comCodigoBeneficiario(codigoBeneficiario());
		}

		if(digitoVerificadorAgencia() != null)
		{
			beneficiario.comDigitoAgencia(digitoVerificadorAgencia().substring(0));
		}

		if(digitoVerificadorCodigoBeneficiario() != null)
		{
			beneficiario.comDigitoCodigoBeneficiario(digitoVerificadorCodigoBeneficiario().substring(0));
		}

		if(digitoVerificadorNossoNumero() != null)
		{
			beneficiario.comDigitoNossoNumero(digitoVerificadorNossoNumero());
		}

		if(nossoNumero() != null)
		{
			beneficiario.comNossoNumero(nossoNumero());
		}

		if(numeroConvenio() != null)
		{
			beneficiario.comNumeroConvenio(numeroConvenio());
		}

		return beneficiario;
	}
}
