package br.com.doit.boleto.pojo;

public class Emissor {
	private String agencia;
	private String carteira;
	private String cedente;
	private String codigoFornecidoPelaAgencia;
	private String codigoOperacao;
	private String contaCorrente;
	private String digitoVerificadorAgencia;
	private String digitoVerificadorContaCorrente;
	private String digitoVerificadorNossoNumero;
	private String nossoNumero;
	private String numeroConvenio;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	public String getCedente() {
		return cedente;
	}

	public void setCedente(String cedente) {
		this.cedente = cedente;
	}

	public String getCodigoFornecidoPelaAgencia() {
		return codigoFornecidoPelaAgencia;
	}

	public void setCodigoFornecidoPelaAgencia(String codigoFornecidoPelaAgencia) {
		this.codigoFornecidoPelaAgencia = codigoFornecidoPelaAgencia;
	}

	public String getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(String codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String getDigitoVerificadorAgencia() {
		return digitoVerificadorAgencia;
	}

	public void setDigitoVerificadorAgencia(String digitoVerificadorAgencia) {
		this.digitoVerificadorAgencia = digitoVerificadorAgencia;
	}

	public String getDigitoVerificadorContaCorrente() {
		return digitoVerificadorContaCorrente;
	}

	public void setDigitoVerificadorContaCorrente(
			String digitoVerificadorContaCorrente) {
		this.digitoVerificadorContaCorrente = digitoVerificadorContaCorrente;
	}

	public String getDigitoVerificadorNossoNumero() {
		return digitoVerificadorNossoNumero;
	}

	public void setDigitoVerificadorNossoNumero(
			String digitoVerificadorNossoNumero) {
		this.digitoVerificadorNossoNumero = digitoVerificadorNossoNumero;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getNumeroConvenio() {
		return numeroConvenio;
	}

	public void setNumeroConvenio(String numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}
}
