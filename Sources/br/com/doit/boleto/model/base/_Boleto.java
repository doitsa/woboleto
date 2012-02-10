// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to br.com.doit.boleto.model.Boleto.java instead.
package br.com.doit.boleto.model.base;

import er.extensions.foundation.*;
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _Boleto extends  er.extensions.eof.ERXGenericRecord {
	public static final String ENTITY_NAME = "Boleto";

	// Attributes
	public static final String ACEITE_KEY = "aceite";
	public static final String ACRESCIMO_KEY = "acrescimo";
	public static final String AGENCIA_KEY = "agencia";
	public static final String BAIRRO_SACADO_KEY = "bairroSacado";
	public static final String BANCO_KEY = "banco";
	public static final String CARTEIRA_KEY = "carteira";
	public static final String CEDENTE_KEY = "cedente";
	public static final String CEP_SACADO_KEY = "cepSacado";
	public static final String CIDADE_SACADO_KEY = "cidadeSacado";
	public static final String COD_CLIENTE_KEY = "codCliente";
	public static final String CODIGO_BARRAS_KEY = "codigoBarras";
	public static final String CODIGO_FORNECIDO_AGENCIA_KEY = "codigoFornecidoAgencia";
	public static final String CODIGO_OPERACAO_KEY = "codigoOperacao";
	public static final String CONTA_CORRENTE_KEY = "contaCorrente";
	public static final String CPF_SACADO_KEY = "cpfSacado";
	public static final String DATA_CRIADA_KEY = "dataCriada";
	public static final String DATA_DOCUMENTO_KEY = "dataDocumento";
	public static final String DATA_PROCESSAMENTO_KEY = "dataProcessamento";
	public static final String DATA_VENCIMENTO_KEY = "dataVencimento";
	public static final String DESCRICOES_KEY = "descricoes";
	public static final String DV_AGENCIA_KEY = "dvAgencia";
	public static final String DV_CODIGO_FORNECIDO_AGENCIA_KEY = "dvCodigoFornecidoAgencia";
	public static final String DV_CONTA_CORRENTE_KEY = "dvContaCorrente";
	public static final String DV_NOSSO_NUMERO_KEY = "dvNossoNumero";
	public static final String EMAIL_KEY = "email";
	public static final String ENDERECO_COD_BAR_KEY = "enderecoCodBar";
	public static final String ENDERECO_SACADO_KEY = "enderecoSacado";
	public static final String ESPECIE_DOCUMENTO_KEY = "especieDocumento";
	public static final String IMAGEM_MARKETING_KEY = "imagemMarketing";
	public static final String INSTRUCAO1_KEY = "instrucao1";
	public static final String INSTRUCAO2_KEY = "instrucao2";
	public static final String INSTRUCAO3_KEY = "instrucao3";
	public static final String INSTRUCAO4_KEY = "instrucao4";
	public static final String INSTRUCAO5_KEY = "instrucao5";
	public static final String IOS_KEY = "ios";
	public static final String LINHA_DIGITAVEL_KEY = "linhaDigitavel";
	public static final String LOCAL_PAGAMENTO_KEY = "localPagamento";
	public static final String LOCAL_PAGAMENTO2_KEY = "localPagamento2";
	public static final String MOEDA_KEY = "moeda";
	public static final String NO_DOCUMENTO_KEY = "noDocumento";
	public static final String NOME_SACADO_KEY = "nomeSacado";
	public static final String NOSSO_NUMERO_KEY = "nossoNumero";
	public static final String NUM_CONVENIO_KEY = "numConvenio";
	public static final String QTD_MOEDA_KEY = "qtdMoeda";
	public static final String STATUS_KEY = "status";
	public static final String UF_SACADO_KEY = "ufSacado";
	public static final String VALOR_BOLETO_KEY = "valorBoleto";
	public static final String VALOR_MOEDA_KEY = "valorMoeda";

	// Relationships

  private static Logger logger = Logger.getLogger(_Boleto.class);

  public br.com.doit.boleto.model.Boleto localInstanceIn(EOEditingContext editingContext) {
    br.com.doit.boleto.model.Boleto localInstance = (br.com.doit.boleto.model.Boleto)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String aceite() {
    return (String) storedValueForKey("aceite");
  }

  public void setAceite(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating aceite from " + aceite() + " to " + value);
    }
    takeStoredValueForKey(value, "aceite");
  }

  public String acrescimo() {
    return (String) storedValueForKey("acrescimo");
  }

  public void setAcrescimo(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating acrescimo from " + acrescimo() + " to " + value);
    }
    takeStoredValueForKey(value, "acrescimo");
  }

  public String agencia() {
    return (String) storedValueForKey("agencia");
  }

  public void setAgencia(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating agencia from " + agencia() + " to " + value);
    }
    takeStoredValueForKey(value, "agencia");
  }

  public String bairroSacado() {
    return (String) storedValueForKey("bairroSacado");
  }

  public void setBairroSacado(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating bairroSacado from " + bairroSacado() + " to " + value);
    }
    takeStoredValueForKey(value, "bairroSacado");
  }

  public Integer banco() {
    return (Integer) storedValueForKey("banco");
  }

  public void setBanco(Integer value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating banco from " + banco() + " to " + value);
    }
    takeStoredValueForKey(value, "banco");
  }

  public String carteira() {
    return (String) storedValueForKey("carteira");
  }

  public void setCarteira(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating carteira from " + carteira() + " to " + value);
    }
    takeStoredValueForKey(value, "carteira");
  }

  public String cedente() {
    return (String) storedValueForKey("cedente");
  }

  public void setCedente(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating cedente from " + cedente() + " to " + value);
    }
    takeStoredValueForKey(value, "cedente");
  }

  public String cepSacado() {
    return (String) storedValueForKey("cepSacado");
  }

  public void setCepSacado(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating cepSacado from " + cepSacado() + " to " + value);
    }
    takeStoredValueForKey(value, "cepSacado");
  }

  public String cidadeSacado() {
    return (String) storedValueForKey("cidadeSacado");
  }

  public void setCidadeSacado(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating cidadeSacado from " + cidadeSacado() + " to " + value);
    }
    takeStoredValueForKey(value, "cidadeSacado");
  }

  public String codCliente() {
    return (String) storedValueForKey("codCliente");
  }

  public void setCodCliente(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating codCliente from " + codCliente() + " to " + value);
    }
    takeStoredValueForKey(value, "codCliente");
  }

  public String codigoBarras() {
    return (String) storedValueForKey("codigoBarras");
  }

  public void setCodigoBarras(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating codigoBarras from " + codigoBarras() + " to " + value);
    }
    takeStoredValueForKey(value, "codigoBarras");
  }

  public String codigoFornecidoAgencia() {
    return (String) storedValueForKey("codigoFornecidoAgencia");
  }

  public void setCodigoFornecidoAgencia(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating codigoFornecidoAgencia from " + codigoFornecidoAgencia() + " to " + value);
    }
    takeStoredValueForKey(value, "codigoFornecidoAgencia");
  }

  public String codigoOperacao() {
    return (String) storedValueForKey("codigoOperacao");
  }

  public void setCodigoOperacao(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating codigoOperacao from " + codigoOperacao() + " to " + value);
    }
    takeStoredValueForKey(value, "codigoOperacao");
  }

  public String contaCorrente() {
    return (String) storedValueForKey("contaCorrente");
  }

  public void setContaCorrente(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating contaCorrente from " + contaCorrente() + " to " + value);
    }
    takeStoredValueForKey(value, "contaCorrente");
  }

  public String cpfSacado() {
    return (String) storedValueForKey("cpfSacado");
  }

  public void setCpfSacado(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating cpfSacado from " + cpfSacado() + " to " + value);
    }
    takeStoredValueForKey(value, "cpfSacado");
  }

  public NSTimestamp dataCriada() {
    return (NSTimestamp) storedValueForKey("dataCriada");
  }

  public void setDataCriada(NSTimestamp value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating dataCriada from " + dataCriada() + " to " + value);
    }
    takeStoredValueForKey(value, "dataCriada");
  }

  public String dataDocumento() {
    return (String) storedValueForKey("dataDocumento");
  }

  public void setDataDocumento(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating dataDocumento from " + dataDocumento() + " to " + value);
    }
    takeStoredValueForKey(value, "dataDocumento");
  }

  public String dataProcessamento() {
    return (String) storedValueForKey("dataProcessamento");
  }

  public void setDataProcessamento(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating dataProcessamento from " + dataProcessamento() + " to " + value);
    }
    takeStoredValueForKey(value, "dataProcessamento");
  }

  public String dataVencimento() {
    return (String) storedValueForKey("dataVencimento");
  }

  public void setDataVencimento(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating dataVencimento from " + dataVencimento() + " to " + value);
    }
    takeStoredValueForKey(value, "dataVencimento");
  }

  public String descricoes() {
    return (String) storedValueForKey("descricoes");
  }

  public void setDescricoes(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating descricoes from " + descricoes() + " to " + value);
    }
    takeStoredValueForKey(value, "descricoes");
  }

  public String dvAgencia() {
    return (String) storedValueForKey("dvAgencia");
  }

  public void setDvAgencia(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating dvAgencia from " + dvAgencia() + " to " + value);
    }
    takeStoredValueForKey(value, "dvAgencia");
  }

  public String dvCodigoFornecidoAgencia() {
    return (String) storedValueForKey("dvCodigoFornecidoAgencia");
  }

  public void setDvCodigoFornecidoAgencia(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating dvCodigoFornecidoAgencia from " + dvCodigoFornecidoAgencia() + " to " + value);
    }
    takeStoredValueForKey(value, "dvCodigoFornecidoAgencia");
  }

  public String dvContaCorrente() {
    return (String) storedValueForKey("dvContaCorrente");
  }

  public void setDvContaCorrente(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating dvContaCorrente from " + dvContaCorrente() + " to " + value);
    }
    takeStoredValueForKey(value, "dvContaCorrente");
  }

  public String dvNossoNumero() {
    return (String) storedValueForKey("dvNossoNumero");
  }

  public void setDvNossoNumero(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating dvNossoNumero from " + dvNossoNumero() + " to " + value);
    }
    takeStoredValueForKey(value, "dvNossoNumero");
  }

  public String email() {
    return (String) storedValueForKey("email");
  }

  public void setEmail(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating email from " + email() + " to " + value);
    }
    takeStoredValueForKey(value, "email");
  }

  public String enderecoCodBar() {
    return (String) storedValueForKey("enderecoCodBar");
  }

  public void setEnderecoCodBar(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating enderecoCodBar from " + enderecoCodBar() + " to " + value);
    }
    takeStoredValueForKey(value, "enderecoCodBar");
  }

  public String enderecoSacado() {
    return (String) storedValueForKey("enderecoSacado");
  }

  public void setEnderecoSacado(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating enderecoSacado from " + enderecoSacado() + " to " + value);
    }
    takeStoredValueForKey(value, "enderecoSacado");
  }

  public String especieDocumento() {
    return (String) storedValueForKey("especieDocumento");
  }

  public void setEspecieDocumento(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating especieDocumento from " + especieDocumento() + " to " + value);
    }
    takeStoredValueForKey(value, "especieDocumento");
  }

  public String imagemMarketing() {
    return (String) storedValueForKey("imagemMarketing");
  }

  public void setImagemMarketing(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating imagemMarketing from " + imagemMarketing() + " to " + value);
    }
    takeStoredValueForKey(value, "imagemMarketing");
  }

  public String instrucao1() {
    return (String) storedValueForKey("instrucao1");
  }

  public void setInstrucao1(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating instrucao1 from " + instrucao1() + " to " + value);
    }
    takeStoredValueForKey(value, "instrucao1");
  }

  public String instrucao2() {
    return (String) storedValueForKey("instrucao2");
  }

  public void setInstrucao2(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating instrucao2 from " + instrucao2() + " to " + value);
    }
    takeStoredValueForKey(value, "instrucao2");
  }

  public String instrucao3() {
    return (String) storedValueForKey("instrucao3");
  }

  public void setInstrucao3(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating instrucao3 from " + instrucao3() + " to " + value);
    }
    takeStoredValueForKey(value, "instrucao3");
  }

  public String instrucao4() {
    return (String) storedValueForKey("instrucao4");
  }

  public void setInstrucao4(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating instrucao4 from " + instrucao4() + " to " + value);
    }
    takeStoredValueForKey(value, "instrucao4");
  }

  public String instrucao5() {
    return (String) storedValueForKey("instrucao5");
  }

  public void setInstrucao5(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating instrucao5 from " + instrucao5() + " to " + value);
    }
    takeStoredValueForKey(value, "instrucao5");
  }

  public String ios() {
    return (String) storedValueForKey("ios");
  }

  public void setIos(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating ios from " + ios() + " to " + value);
    }
    takeStoredValueForKey(value, "ios");
  }

  public String linhaDigitavel() {
    return (String) storedValueForKey("linhaDigitavel");
  }

  public void setLinhaDigitavel(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating linhaDigitavel from " + linhaDigitavel() + " to " + value);
    }
    takeStoredValueForKey(value, "linhaDigitavel");
  }

  public String localPagamento() {
    return (String) storedValueForKey("localPagamento");
  }

  public void setLocalPagamento(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating localPagamento from " + localPagamento() + " to " + value);
    }
    takeStoredValueForKey(value, "localPagamento");
  }

  public String localPagamento2() {
    return (String) storedValueForKey("localPagamento2");
  }

  public void setLocalPagamento2(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating localPagamento2 from " + localPagamento2() + " to " + value);
    }
    takeStoredValueForKey(value, "localPagamento2");
  }

  public String moeda() {
    return (String) storedValueForKey("moeda");
  }

  public void setMoeda(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating moeda from " + moeda() + " to " + value);
    }
    takeStoredValueForKey(value, "moeda");
  }

  public String noDocumento() {
    return (String) storedValueForKey("noDocumento");
  }

  public void setNoDocumento(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating noDocumento from " + noDocumento() + " to " + value);
    }
    takeStoredValueForKey(value, "noDocumento");
  }

  public String nomeSacado() {
    return (String) storedValueForKey("nomeSacado");
  }

  public void setNomeSacado(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating nomeSacado from " + nomeSacado() + " to " + value);
    }
    takeStoredValueForKey(value, "nomeSacado");
  }

  public String nossoNumero() {
    return (String) storedValueForKey("nossoNumero");
  }

  public void setNossoNumero(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating nossoNumero from " + nossoNumero() + " to " + value);
    }
    takeStoredValueForKey(value, "nossoNumero");
  }

  public String numConvenio() {
    return (String) storedValueForKey("numConvenio");
  }

  public void setNumConvenio(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating numConvenio from " + numConvenio() + " to " + value);
    }
    takeStoredValueForKey(value, "numConvenio");
  }

  public String qtdMoeda() {
    return (String) storedValueForKey("qtdMoeda");
  }

  public void setQtdMoeda(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating qtdMoeda from " + qtdMoeda() + " to " + value);
    }
    takeStoredValueForKey(value, "qtdMoeda");
  }

  public Integer status() {
    return (Integer) storedValueForKey("status");
  }

  public void setStatus(Integer value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating status from " + status() + " to " + value);
    }
    takeStoredValueForKey(value, "status");
  }

  public String ufSacado() {
    return (String) storedValueForKey("ufSacado");
  }

  public void setUfSacado(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating ufSacado from " + ufSacado() + " to " + value);
    }
    takeStoredValueForKey(value, "ufSacado");
  }

  public String valorBoleto() {
    return (String) storedValueForKey("valorBoleto");
  }

  public void setValorBoleto(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating valorBoleto from " + valorBoleto() + " to " + value);
    }
    takeStoredValueForKey(value, "valorBoleto");
  }

  public String valorMoeda() {
    return (String) storedValueForKey("valorMoeda");
  }

  public void setValorMoeda(String value) {
    if (_Boleto.logger.isDebugEnabled()) {
    	_Boleto.logger.debug( "updating valorMoeda from " + valorMoeda() + " to " + value);
    }
    takeStoredValueForKey(value, "valorMoeda");
  }


  public static br.com.doit.boleto.model.Boleto createBoleto(EOEditingContext editingContext, Integer banco
) {
    br.com.doit.boleto.model.Boleto eo = (br.com.doit.boleto.model.Boleto) EOUtilities.createAndInsertInstance(editingContext, _Boleto.ENTITY_NAME);
		eo.setBanco(banco);
    return eo;
  }

  public static NSArray<br.com.doit.boleto.model.Boleto> fetchAllBoletos(EOEditingContext editingContext) {
    return _Boleto.fetchAllBoletos(editingContext, null);
  }

  public static NSArray<br.com.doit.boleto.model.Boleto> fetchAllBoletos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Boleto.fetchBoletos(editingContext, null, sortOrderings);
  }

  public static NSArray<br.com.doit.boleto.model.Boleto> fetchBoletos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Boleto.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<br.com.doit.boleto.model.Boleto> eoObjects = (NSArray<br.com.doit.boleto.model.Boleto>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<br.com.doit.boleto.model.Boleto> fetchBoletos(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchBoletos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<br.com.doit.boleto.model.Boleto> fetchBoletos(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchBoletos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static br.com.doit.boleto.model.Boleto fetchBoleto(EOEditingContext editingContext, String keyName, Object value) {
    return _Boleto.fetchBoleto(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static br.com.doit.boleto.model.Boleto fetchBoleto(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<br.com.doit.boleto.model.Boleto> eoObjects = _Boleto.fetchBoletos(editingContext, qualifier, null);
    br.com.doit.boleto.model.Boleto eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (br.com.doit.boleto.model.Boleto)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Boleto that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static br.com.doit.boleto.model.Boleto fetchRequiredBoleto(EOEditingContext editingContext, String keyName, Object value) {
    return _Boleto.fetchRequiredBoleto(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static br.com.doit.boleto.model.Boleto fetchRequiredBoleto(EOEditingContext editingContext, EOQualifier qualifier) {
    br.com.doit.boleto.model.Boleto eoObject = _Boleto.fetchBoleto(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Boleto that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static br.com.doit.boleto.model.Boleto localInstanceIn(EOEditingContext editingContext, br.com.doit.boleto.model.Boleto eo) {
    br.com.doit.boleto.model.Boleto localInstance = (eo == null) ? null : (br.com.doit.boleto.model.Boleto)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
