package br.com.doit.boleto.pojo;

public class Emissor {
	private Integer agencia;
	private Integer carteira;
	private String cedente;
	private Integer codigoFornecidoPelaAgencia;
	private Integer codigoOperacao;
	private Long contaCorrente;
	private String digitoVerificadorAgencia;
	private String digitoVerificadorContaCorrente;
	private String digitoVerificadorNossoNumero;
	private Long nossoNumero;
	private Long numeroConvenio;

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getCarteira() {
		return carteira;
	}

	public void setCarteira(Integer carteira) {
		this.carteira = carteira;
	}

	public String getCedente() {
		return cedente;
	}

	public void setCedente(String cedente) {
		this.cedente = cedente;
	}

	public Integer getCodigoFornecidoPelaAgencia() {
		return codigoFornecidoPelaAgencia;
	}

	public void setCodigoFornecidoPelaAgencia(Integer codigoFornecidoPelaAgencia) {
		this.codigoFornecidoPelaAgencia = codigoFornecidoPelaAgencia;
	}

	public Integer getCodigoOperacao() {
		return codigoOperacao;
	}

	public void setCodigoOperacao(Integer codigoOperacao) {
		this.codigoOperacao = codigoOperacao;
	}

	public Long getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
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

	public Long getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(Long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public Long getNumeroConvenio() {
		return numeroConvenio;
	}

	public void setNumeroConvenio(Long numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}
}
