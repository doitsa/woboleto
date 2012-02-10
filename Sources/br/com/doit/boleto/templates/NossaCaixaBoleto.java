package br.com.doit.boleto.templates;

import org.jboleto.JBoleto;

public class NossaCaixaBoleto extends WOBoletoBean {

	public NossaCaixaBoleto() {

		super();

		setBanco(JBoleto.NOSSACAIXA);

		setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO NOSSA CAIXA");
		setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO NOSSA CAIXA");
		setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
		setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
		setInstrucao3("");
		setInstrucao4("");

	}

	public void setNossoNumeroBanco(String nossoNumero) {

		setNossoNumero(nossoNumero, 7);

	}

}
