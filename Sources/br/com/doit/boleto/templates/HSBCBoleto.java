package br.com.doit.boleto.templates;

import org.jboleto.JBoleto;

public class HSBCBoleto extends WOBoletoBean {
	
	public  HSBCBoleto() {
		
		super();
		
		setBanco(JBoleto.HSBC);
        
        setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO HSBC");
        setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO HSBC");
        setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
        setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
        setInstrucao3("");
        setInstrucao4("");
        
	}
	
	public void setNossoNumeroBanco(String nossoNumero) {
		
		super.setNossoNumero(nossoNumero, 13);
		
	}
}
