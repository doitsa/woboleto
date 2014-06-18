package br.com.woboleto.stella;

import br.com.caelum.stella.boleto.Boleto;

public class StellaBoleto extends Boleto {
	private static final long serialVersionUID = 1L;

	private String linhaDigitavel = null;
	private String codigoDeBarras = null;
	
	@Override
	public String getCodigoDeBarras() {
		if (codigoDeBarras != null) {
			return codigoDeBarras;
		}
		return super.getCodigoDeBarras();
	}
	
	@Override
	public String getLinhaDigitavel() {
		if (linhaDigitavel != null) {
			return linhaDigitavel;
		}
		return super.getLinhaDigitavel();
	}
	
	public void comLinhaDigitavel(String linhaDigitavel) {
		this.linhaDigitavel = linhaDigitavel;
	}
	
	public void comCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	
}
