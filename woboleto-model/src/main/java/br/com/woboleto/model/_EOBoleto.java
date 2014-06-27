// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to EOBoleto.java instead.
package br.com.woboleto.model;

import er.extensions.eof.*;
import er.extensions.foundation.*;
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _EOBoleto extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "EOBoleto";

// Attribute Keys
  public static final ERXKey<Boolean> ACEITE = new ERXKey<Boolean>("aceite");
  public static final ERXKey<br.com.woboleto.model.BancoEnum> BANCO = new ERXKey<br.com.woboleto.model.BancoEnum>("banco");
  public static final ERXKey<String> CODIGO_DE_BARRAS = new ERXKey<String>("codigoDeBarras");
  public static final ERXKey<NSTimestamp> DATA_DOCUMENTO = new ERXKey<NSTimestamp>("dataDocumento");
  public static final ERXKey<NSTimestamp> DATA_PROCESSAMENTO = new ERXKey<NSTimestamp>("dataProcessamento");
  public static final ERXKey<NSTimestamp> DATA_VENCIMENTO = new ERXKey<NSTimestamp>("dataVencimento");
  public static final ERXKey<String> ESPECIE_DOCUMENTO = new ERXKey<String>("especieDocumento");
  public static final ERXKey<String> LINHA_DIGITAVEL = new ERXKey<String>("linhaDigitavel");
  public static final ERXKey<String> NUMERO_DOCUMENTO = new ERXKey<String>("numeroDocumento");
  public static final ERXKey<java.math.BigDecimal> QUANTIDADE_MOEDA = new ERXKey<java.math.BigDecimal>("quantidadeMoeda");
  public static final ERXKey<java.math.BigDecimal> VALOR = new ERXKey<java.math.BigDecimal>("valor");
  public static final ERXKey<java.math.BigDecimal> VALOR_MOEDA = new ERXKey<java.math.BigDecimal>("valorMoeda");
  // Relationship Keys
  public static final ERXKey<br.com.woboleto.model.EOBeneficiario> BENEFICIARIO = new ERXKey<br.com.woboleto.model.EOBeneficiario>("beneficiario");
  public static final ERXKey<br.com.woboleto.model.EODescricao> DESCRICOES = new ERXKey<br.com.woboleto.model.EODescricao>("descricoes");
  public static final ERXKey<br.com.woboleto.model.EOInstrucao> INSTRUCOES = new ERXKey<br.com.woboleto.model.EOInstrucao>("instrucoes");
  public static final ERXKey<br.com.woboleto.model.EOLocalPagamento> LOCAIS_PAGAMENTO = new ERXKey<br.com.woboleto.model.EOLocalPagamento>("locaisPagamento");
  public static final ERXKey<br.com.woboleto.model.EOPagador> PAGADOR = new ERXKey<br.com.woboleto.model.EOPagador>("pagador");

	// Attributes
	public static final String ACEITE_KEY = "aceite";
	public static final String BANCO_KEY = "banco";
	public static final String CODIGO_DE_BARRAS_KEY = "codigoDeBarras";
	public static final String DATA_DOCUMENTO_KEY = "dataDocumento";
	public static final String DATA_PROCESSAMENTO_KEY = "dataProcessamento";
	public static final String DATA_VENCIMENTO_KEY = "dataVencimento";
	public static final String ESPECIE_DOCUMENTO_KEY = "especieDocumento";
	public static final String LINHA_DIGITAVEL_KEY = "linhaDigitavel";
	public static final String NUMERO_DOCUMENTO_KEY = "numeroDocumento";
	public static final String QUANTIDADE_MOEDA_KEY = "quantidadeMoeda";
	public static final String VALOR_KEY = "valor";
	public static final String VALOR_MOEDA_KEY = "valorMoeda";

	// Relationships
	public static final String BENEFICIARIO_KEY = "beneficiario";
	public static final String DESCRICOES_KEY = "descricoes";
	public static final String INSTRUCOES_KEY = "instrucoes";
	public static final String LOCAIS_PAGAMENTO_KEY = "locaisPagamento";
	public static final String PAGADOR_KEY = "pagador";

  private static Logger logger = Logger.getLogger(_EOBoleto.class);

  public EOBoleto localInstanceIn(EOEditingContext editingContext) {
    EOBoleto localInstance = (EOBoleto)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public Boolean aceite() {
    return (Boolean) storedValueForKey("aceite");
  }

  public void setAceite(Boolean value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating aceite from " + aceite() + " to " + value);
    }
    takeStoredValueForKey(value, "aceite");
  }

  public br.com.woboleto.model.BancoEnum banco() {
    return (br.com.woboleto.model.BancoEnum) storedValueForKey("banco");
  }

  public void setBanco(br.com.woboleto.model.BancoEnum value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating banco from " + banco() + " to " + value);
    }
    takeStoredValueForKey(value, "banco");
  }

  public String codigoDeBarras() {
    return (String) storedValueForKey("codigoDeBarras");
  }

  public void setCodigoDeBarras(String value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating codigoDeBarras from " + codigoDeBarras() + " to " + value);
    }
    takeStoredValueForKey(value, "codigoDeBarras");
  }

  public NSTimestamp dataDocumento() {
    return (NSTimestamp) storedValueForKey("dataDocumento");
  }

  public void setDataDocumento(NSTimestamp value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating dataDocumento from " + dataDocumento() + " to " + value);
    }
    takeStoredValueForKey(value, "dataDocumento");
  }

  public NSTimestamp dataProcessamento() {
    return (NSTimestamp) storedValueForKey("dataProcessamento");
  }

  public void setDataProcessamento(NSTimestamp value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating dataProcessamento from " + dataProcessamento() + " to " + value);
    }
    takeStoredValueForKey(value, "dataProcessamento");
  }

  public NSTimestamp dataVencimento() {
    return (NSTimestamp) storedValueForKey("dataVencimento");
  }

  public void setDataVencimento(NSTimestamp value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating dataVencimento from " + dataVencimento() + " to " + value);
    }
    takeStoredValueForKey(value, "dataVencimento");
  }

  public String especieDocumento() {
    return (String) storedValueForKey("especieDocumento");
  }

  public void setEspecieDocumento(String value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating especieDocumento from " + especieDocumento() + " to " + value);
    }
    takeStoredValueForKey(value, "especieDocumento");
  }

  public String linhaDigitavel() {
    return (String) storedValueForKey("linhaDigitavel");
  }

  public void setLinhaDigitavel(String value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating linhaDigitavel from " + linhaDigitavel() + " to " + value);
    }
    takeStoredValueForKey(value, "linhaDigitavel");
  }

  public String numeroDocumento() {
    return (String) storedValueForKey("numeroDocumento");
  }

  public void setNumeroDocumento(String value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating numeroDocumento from " + numeroDocumento() + " to " + value);
    }
    takeStoredValueForKey(value, "numeroDocumento");
  }

  public java.math.BigDecimal quantidadeMoeda() {
    return (java.math.BigDecimal) storedValueForKey("quantidadeMoeda");
  }

  public void setQuantidadeMoeda(java.math.BigDecimal value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating quantidadeMoeda from " + quantidadeMoeda() + " to " + value);
    }
    takeStoredValueForKey(value, "quantidadeMoeda");
  }

  public java.math.BigDecimal valor() {
    return (java.math.BigDecimal) storedValueForKey("valor");
  }

  public void setValor(java.math.BigDecimal value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating valor from " + valor() + " to " + value);
    }
    takeStoredValueForKey(value, "valor");
  }

  public java.math.BigDecimal valorMoeda() {
    return (java.math.BigDecimal) storedValueForKey("valorMoeda");
  }

  public void setValorMoeda(java.math.BigDecimal value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
    	_EOBoleto.logger.debug( "updating valorMoeda from " + valorMoeda() + " to " + value);
    }
    takeStoredValueForKey(value, "valorMoeda");
  }

  public br.com.woboleto.model.EOBeneficiario beneficiario() {
    return (br.com.woboleto.model.EOBeneficiario)storedValueForKey("beneficiario");
  }

  protected void setBeneficiarioRelationship(br.com.woboleto.model.EOBeneficiario value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
      _EOBoleto.logger.debug("updating beneficiario from " + beneficiario() + " to " + value);
    }
    if (value == null) {
    	br.com.woboleto.model.EOBeneficiario oldValue = beneficiario();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "beneficiario");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "beneficiario");
    }
  }

  public void setBeneficiario(br.com.woboleto.model.EOBeneficiario value) {
      this.takeStoredValueForKey(value, "beneficiario");
  }

  public br.com.woboleto.model.EOPagador pagador() {
    return (br.com.woboleto.model.EOPagador)storedValueForKey("pagador");
  }

  protected void setPagadorRelationship(br.com.woboleto.model.EOPagador value) {
    if (_EOBoleto.logger.isDebugEnabled()) {
      _EOBoleto.logger.debug("updating pagador from " + pagador() + " to " + value);
    }
    if (value == null) {
    	br.com.woboleto.model.EOPagador oldValue = pagador();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "pagador");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "pagador");
    }
  }

  public void setPagador(br.com.woboleto.model.EOPagador value) {
      this.takeStoredValueForKey(value, "pagador");
  }

  public NSArray<br.com.woboleto.model.EODescricao> descricoes() {
    return (NSArray<br.com.woboleto.model.EODescricao>)storedValueForKey("descricoes");
  }

  public NSArray<br.com.woboleto.model.EODescricao> descricoes(EOQualifier qualifier) {
    return descricoes(qualifier, null);
  }

  public NSArray<br.com.woboleto.model.EODescricao> descricoes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<br.com.woboleto.model.EODescricao> results;
      results = descricoes();
      if (qualifier != null) {
        results = (NSArray<br.com.woboleto.model.EODescricao>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<br.com.woboleto.model.EODescricao>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToDescricoesRelationship(br.com.woboleto.model.EODescricao object) {
    if (_EOBoleto.logger.isDebugEnabled()) {
      _EOBoleto.logger.debug("adding " + object + " to descricoes relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "descricoes");
  }

  public void removeFromDescricoesRelationship(br.com.woboleto.model.EODescricao object) {
    if (_EOBoleto.logger.isDebugEnabled()) {
      _EOBoleto.logger.debug("removing " + object + " from descricoes relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "descricoes");
  }

  public br.com.woboleto.model.EODescricao createDescricoesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("EODescricao");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "descricoes");
    return (br.com.woboleto.model.EODescricao) eo;
  }

  public void deleteDescricoesRelationship(br.com.woboleto.model.EODescricao object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "descricoes");
    editingContext().deleteObject(object);
  }

  public void deleteAllDescricoesRelationships() {
    Enumeration objects = descricoes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteDescricoesRelationship((br.com.woboleto.model.EODescricao)objects.nextElement());
    }
  }

  public NSArray<br.com.woboleto.model.EOInstrucao> instrucoes() {
    return (NSArray<br.com.woboleto.model.EOInstrucao>)storedValueForKey("instrucoes");
  }

  public NSArray<br.com.woboleto.model.EOInstrucao> instrucoes(EOQualifier qualifier) {
    return instrucoes(qualifier, null);
  }

  public NSArray<br.com.woboleto.model.EOInstrucao> instrucoes(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<br.com.woboleto.model.EOInstrucao> results;
      results = instrucoes();
      if (qualifier != null) {
        results = (NSArray<br.com.woboleto.model.EOInstrucao>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<br.com.woboleto.model.EOInstrucao>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToInstrucoesRelationship(br.com.woboleto.model.EOInstrucao object) {
    if (_EOBoleto.logger.isDebugEnabled()) {
      _EOBoleto.logger.debug("adding " + object + " to instrucoes relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "instrucoes");
  }

  public void removeFromInstrucoesRelationship(br.com.woboleto.model.EOInstrucao object) {
    if (_EOBoleto.logger.isDebugEnabled()) {
      _EOBoleto.logger.debug("removing " + object + " from instrucoes relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "instrucoes");
  }

  public br.com.woboleto.model.EOInstrucao createInstrucoesRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("EOInstrucao");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "instrucoes");
    return (br.com.woboleto.model.EOInstrucao) eo;
  }

  public void deleteInstrucoesRelationship(br.com.woboleto.model.EOInstrucao object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "instrucoes");
    editingContext().deleteObject(object);
  }

  public void deleteAllInstrucoesRelationships() {
    Enumeration objects = instrucoes().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteInstrucoesRelationship((br.com.woboleto.model.EOInstrucao)objects.nextElement());
    }
  }

  public NSArray<br.com.woboleto.model.EOLocalPagamento> locaisPagamento() {
    return (NSArray<br.com.woboleto.model.EOLocalPagamento>)storedValueForKey("locaisPagamento");
  }

  public NSArray<br.com.woboleto.model.EOLocalPagamento> locaisPagamento(EOQualifier qualifier) {
    return locaisPagamento(qualifier, null);
  }

  public NSArray<br.com.woboleto.model.EOLocalPagamento> locaisPagamento(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<br.com.woboleto.model.EOLocalPagamento> results;
      results = locaisPagamento();
      if (qualifier != null) {
        results = (NSArray<br.com.woboleto.model.EOLocalPagamento>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<br.com.woboleto.model.EOLocalPagamento>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
    return results;
  }

  public void addToLocaisPagamentoRelationship(br.com.woboleto.model.EOLocalPagamento object) {
    if (_EOBoleto.logger.isDebugEnabled()) {
      _EOBoleto.logger.debug("adding " + object + " to locaisPagamento relationship");
    }
    addObjectToBothSidesOfRelationshipWithKey(object, "locaisPagamento");
  }

  public void removeFromLocaisPagamentoRelationship(br.com.woboleto.model.EOLocalPagamento object) {
    if (_EOBoleto.logger.isDebugEnabled()) {
      _EOBoleto.logger.debug("removing " + object + " from locaisPagamento relationship");
    }
    removeObjectFromBothSidesOfRelationshipWithKey(object, "locaisPagamento");
  }

  public br.com.woboleto.model.EOLocalPagamento createLocaisPagamentoRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("EOLocalPagamento");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "locaisPagamento");
    return (br.com.woboleto.model.EOLocalPagamento) eo;
  }

  public void deleteLocaisPagamentoRelationship(br.com.woboleto.model.EOLocalPagamento object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "locaisPagamento");
    editingContext().deleteObject(object);
  }

  public void deleteAllLocaisPagamentoRelationships() {
    Enumeration objects = locaisPagamento().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteLocaisPagamentoRelationship((br.com.woboleto.model.EOLocalPagamento)objects.nextElement());
    }
  }


  public static EOBoleto createEOBoleto(EOEditingContext editingContext, Boolean aceite
, String codigoDeBarras
, String linhaDigitavel
, br.com.woboleto.model.EOBeneficiario beneficiario, br.com.woboleto.model.EOPagador pagador) {
    EOBoleto eo = (EOBoleto) EOUtilities.createAndInsertInstance(editingContext, _EOBoleto.ENTITY_NAME);
		eo.setAceite(aceite);
		eo.setCodigoDeBarras(codigoDeBarras);
		eo.setLinhaDigitavel(linhaDigitavel);
    eo.setBeneficiarioRelationship(beneficiario);
    eo.setPagadorRelationship(pagador);
    return eo;
  }

  public static NSArray<EOBoleto> fetchAllEOBoletos(EOEditingContext editingContext) {
    return _EOBoleto.fetchAllEOBoletos(editingContext, null);
  }

  public static NSArray<EOBoleto> fetchAllEOBoletos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOBoleto.fetchEOBoletos(editingContext, null, sortOrderings);
  }

  public static NSArray<EOBoleto> fetchEOBoletos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOBoleto.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOBoleto> eoObjects = (NSArray<EOBoleto>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<EOBoleto> fetchEOBoletos(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchEOBoletos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<EOBoleto> fetchEOBoletos(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchEOBoletos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static EOBoleto fetchEOBoleto(EOEditingContext editingContext, String keyName, Object value) {
    return _EOBoleto.fetchEOBoleto(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOBoleto fetchEOBoleto(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOBoleto> eoObjects = _EOBoleto.fetchEOBoletos(editingContext, qualifier, null);
    EOBoleto eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOBoleto)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOBoleto that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOBoleto fetchRequiredEOBoleto(EOEditingContext editingContext, String keyName, Object value) {
    return _EOBoleto.fetchRequiredEOBoleto(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOBoleto fetchRequiredEOBoleto(EOEditingContext editingContext, EOQualifier qualifier) {
    EOBoleto eoObject = _EOBoleto.fetchEOBoleto(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOBoleto that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOBoleto localInstanceIn(EOEditingContext editingContext, EOBoleto eo) {
    EOBoleto localInstance = (eo == null) ? null : (EOBoleto)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
