package br.com.doit.boleto.pojo;

public enum Banco {

    BANCO_DO_BRASIL("001", "Banco do Brasil"), BRADESCO("237", "Bradesco"), CAIXA("104", "Caixa Economica"), HSBC("399", "HSBC"), ITAU("341", "Itau"), SANTANDER("033", "Santander"), SAFRA("422", "Safra"), SICREDI("748", "Sicredi");

    private final String codigo;
    private final String nome;

    private Banco(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}
