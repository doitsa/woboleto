package br.com.doit.boleto.templates;

import org.jboleto.JBoleto;

public class UnibancoBoleto extends WOBoletoBean
{
	public UnibancoBoleto()
	{
		super();

		setBanco( JBoleto.UNIBANCO );

		setLocalPagamento( "ATE O VENCIMENTO, PREFERENCIALMENTE NO UNIBANCO" );
		setLocalPagamento2( "APOS O VENCIMENTO, SOMENTE NO UNIBANCO" );
		setInstrucao1( "APOS O VENCIMENTO COBRAR MULTA DE 2%" );
		setInstrucao2( "APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO" );
		setInstrucao3( "" );
		setInstrucao4( "" );
	}

	@Override
	public void setNossoNumeroBanco( final String nossoNumero )
	{
		setNossoNumero( nossoNumero, 14 );
	}
}
