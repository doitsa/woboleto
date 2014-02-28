package br.com.doit.boleto.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import br.com.doit.boleto.client.JsonDateSerializer;

@XmlRootElement
public class Boleto {
	private boolean aceite;
	private BancoEnum banco;
	private Date dataDocumento;
	private Date dataProcessamento;
	private Date dataVencimento;
	private String especieDocumento;
	private String numeroDocumento;
	private BigDecimal quantidadeMoeda;
	private BigDecimal valor;
	private BigDecimal valorMoeda;
	private ArrayList<Descricao> descricoes;
	private Emissor emissor;
	private ArrayList<Instrucao> instrucoes;
	private ArrayList<LocalPagamento> locaisPagamento;
	private Sacado sacado;

	public boolean isAceite() {
		return aceite;
	}

	public void setAceite(boolean aceite) {
		this.aceite = aceite;
	}

	public BancoEnum getBanco() {
		return banco;
	}

	public void setBanco(BancoEnum banco) {
		this.banco = banco;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDataProcessamento() {
		return dataProcessamento;
	}

	public void setDataProcessamento(Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getEspecieDocumento() {
		return especieDocumento;
	}

	public void setEspecieDocumento(String especieDocumento) {
		this.especieDocumento = especieDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public BigDecimal getQuantidadeMoeda() {
		return quantidadeMoeda;
	}

	public void setQuantidadeMoeda(BigDecimal quantidadeMoeda) {
		this.quantidadeMoeda = quantidadeMoeda;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorMoeda() {
		return valorMoeda;
	}

	public void setValorMoeda(BigDecimal valorMoeda) {
		this.valorMoeda = valorMoeda;
	}

	public ArrayList<Descricao> getDescricoes() {
		return descricoes;
	}

	public void setDescricoes(ArrayList<Descricao> descricoes) {
		this.descricoes = descricoes;
	}

	public Emissor getEmissor() {
		return emissor;
	}

	public void setEmissor(Emissor emissor) {
		this.emissor = emissor;
	}

	public ArrayList<Instrucao> getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(ArrayList<Instrucao> instrucoes) {
		this.instrucoes = instrucoes;
	}

	public ArrayList<LocalPagamento> getLocaisPagamento() {
		return locaisPagamento;
	}

	public void setLocaisPagamento(ArrayList<LocalPagamento> locaisPagamento) {
		this.locaisPagamento = locaisPagamento;
	}

	public Sacado getSacado() {
		return sacado;
	}

	public void setSacado(Sacado sacado) {
		this.sacado = sacado;
	}
}
