package br.com.doit.boleto.pojo;

public class Beneficiario {
    private String agencia;
    private String carteira;
    private String nomeBeneficiario;
    private String codigoBeneficiario;
    private String digitoVerificadorAgencia;
    private String digitoVerificadorCodigoBeneficiario;
    private String digitoVerificadorNossoNumero;
    private String nossoNumero;
    private String numeroConvenio;
    private String documento;
    private String posto;
    private String codigoDoBeneficiario;

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

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public String getCodigoBeneficiario() {
        return codigoBeneficiario;
    }

    public void setContaCorrente(String codigoBeneficiario) {
        this.codigoBeneficiario = codigoBeneficiario;
    }

    public String getDigitoVerificadorAgencia() {
        return digitoVerificadorAgencia;
    }

    public void setDigitoVerificadorAgencia(String digitoVerificadorAgencia) {
        this.digitoVerificadorAgencia = digitoVerificadorAgencia;
    }

    public String getDigitoVerificadorCodigoBeneficiario() {
        return digitoVerificadorCodigoBeneficiario;
    }

    public void setDigitoVerificadorCodigoBeneficiario(String digitoVerificadorCodigoBeneficiario) {
        this.digitoVerificadorCodigoBeneficiario = digitoVerificadorCodigoBeneficiario;
    }

    public String getDigitoVerificadorNossoNumero() {
        return digitoVerificadorNossoNumero;
    }

    public void setDigitoVerificadorNossoNumero(String digitoVerificadorNossoNumero) {
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getCodigoDoBeneficiario() {
        return codigoDoBeneficiario;
    }

    public void setCodigoDoBeneficiario(String codigoDoBeneficiario) {
        this.codigoDoBeneficiario = codigoDoBeneficiario;
    }
}
