package br.com.doit.boleto.templates;

import org.jboleto.JBoleto;

public class BradescoBoleto extends WOBoletoBean {
	
	public BradescoBoleto() {
		
		super();
		
		setBanco(JBoleto.BRADESCO);
        
        setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO BRADESCO");
        setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO BRADESCO");
        setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
        setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
        setInstrucao3("");
        setInstrucao4("");
        
	}
	
	public void setNossoNumeroBanco(String nossoNumero) {
		
		super.setNossoNumero(nossoNumero, 11);
		
	}

}
