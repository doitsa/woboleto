package br.com.doit.boleto.templates;

import org.jboleto.JBoleto;

public class ItauBoleto extends WOBoletoBean {
	public ItauBoleto() {
		super();

		setBanco(JBoleto.ITAU);

		setLocalPagamento("AT\u00c9 O VENCIMENTO, PREFERENCIALMENTE NO ITA\u00da");
		setLocalPagamento2("AP\u00d3S O VENCIMENTO, SOMENTE NO ITA\u00da");
		setInstrucao1("AP\u00d3S O VENCIMENTO COBRAR MULTA DE 2%");
		setInstrucao2("AP\u00d3S O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
		setInstrucao3("");
		setInstrucao4("");
	}
	
	public void setNossoNumeroBanco(String nossoNumero) {
		
		super.setNossoNumero(nossoNumero,8);
		
	}
}
