package br.com.doit.boleto.templates;

import org.jboleto.JBoleto;

public class BancoDoBrasilBoleto extends WOBoletoBean
{
	public BancoDoBrasilBoleto()
	{
		super();

		setBanco( JBoleto.BANCO_DO_BRASIL );

		setLocalPagamento( "ATE O VENCIMENTO, PREFERENCIALMENTE NO BANCO DO BRASIL" );
		setLocalPagamento2( "APOS O VENCIMENTO, SOMENTE NO BANCO DO BRASIL" );
		setInstrucao1( "APOS O VENCIMENTO COBRAR MULTA DE 2%" );
		setInstrucao2( "APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO" );
		setInstrucao3( "" );
		setInstrucao4( "" );
	}
	
	public void setNossoNumeroBanco(String nossoNumero) {
		
		super.setNossoNumero(nossoNumero, 10);
		
	}
}
