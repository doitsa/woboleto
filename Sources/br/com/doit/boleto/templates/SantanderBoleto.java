package br.com.doit.boleto.templates;

import org.jboleto.JBoleto;

public class SantanderBoleto extends WOBoletoBean {
		
	public  SantanderBoleto() {
		
		super();
		
		setBanco(JBoleto.SANTANDER);
        
        setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO SANTANDER");
        setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO SANTANDER");
        setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
        setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
        setInstrucao3("");
        setInstrucao4("");
        
	}
	
	public void setNossoNumeroBanco(String nossoNumero) {

		setNossoNumero(nossoNumero, 7);

	}
}
