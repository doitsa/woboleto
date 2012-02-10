package br.com.doit.boleto.templates;

import org.jboleto.JBoleto;

public class CaixaEconomicaBoleto extends WOBoletoBean {

	public CaixaEconomicaBoleto() {

		super();

		setBanco(JBoleto.CAIXA_ECONOMICA);

		setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO CAIXA ECONOMICA");
		setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO CAIXA ECONOMICA");
		setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
		setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
		setInstrucao3("");
		setInstrucao4("");

	}

	public void setNossoNumeroBanco(String nossoNumero) {

		super.setNossoNumero(nossoNumero, 8);

	}
}
