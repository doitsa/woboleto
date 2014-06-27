// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to EOBeneficiario.java instead.
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
public abstract class _EOBeneficiario extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "EOBeneficiario";

// Attribute Keys
  public static final ERXKey<String> AGENCIA = new ERXKey<String>("agencia");
  public static final ERXKey<String> CARTEIRA = new ERXKey<String>("carteira");
  public static final ERXKey<String> CODIGO_BENEFICIARIO = new ERXKey<String>("codigoBeneficiario");
  public static final ERXKey<String> DIGITO_VERIFICADOR_AGENCIA = new ERXKey<String>("digitoVerificadorAgencia");
  public static final ERXKey<String> DIGITO_VERIFICADOR_CODIGO_BENEFICIARIO = new ERXKey<String>("digitoVerificadorCodigoBeneficiario");
  public static final ERXKey<String> DIGITO_VERIFICADOR_NOSSO_NUMERO = new ERXKey<String>("digitoVerificadorNossoNumero");
  public static final ERXKey<String> DOCUMENTO = new ERXKey<String>("documento");
  public static final ERXKey<String> NOME_BENEFICIARIO = new ERXKey<String>("nomeBeneficiario");
  public static final ERXKey<String> NOSSO_NUMERO = new ERXKey<String>("nossoNumero");
  public static final ERXKey<String> NUMERO_CONVENIO = new ERXKey<String>("numeroConvenio");
  // Relationship Keys

	// Attributes
	public static final String AGENCIA_KEY = "agencia";
	public static final String CARTEIRA_KEY = "carteira";
	public static final String CODIGO_BENEFICIARIO_KEY = "codigoBeneficiario";
	public static final String DIGITO_VERIFICADOR_AGENCIA_KEY = "digitoVerificadorAgencia";
	public static final String DIGITO_VERIFICADOR_CODIGO_BENEFICIARIO_KEY = "digitoVerificadorCodigoBeneficiario";
	public static final String DIGITO_VERIFICADOR_NOSSO_NUMERO_KEY = "digitoVerificadorNossoNumero";
	public static final String DOCUMENTO_KEY = "documento";
	public static final String NOME_BENEFICIARIO_KEY = "nomeBeneficiario";
	public static final String NOSSO_NUMERO_KEY = "nossoNumero";
	public static final String NUMERO_CONVENIO_KEY = "numeroConvenio";

	// Relationships

  private static Logger logger = Logger.getLogger(_EOBeneficiario.class);

  public EOBeneficiario localInstanceIn(EOEditingContext editingContext) {
    EOBeneficiario localInstance = (EOBeneficiario)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String agencia() {
    return (String) storedValueForKey("agencia");
  }

  public void setAgencia(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating agencia from " + agencia() + " to " + value);
    }
    takeStoredValueForKey(value, "agencia");
  }

  public String carteira() {
    return (String) storedValueForKey("carteira");
  }

  public void setCarteira(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating carteira from " + carteira() + " to " + value);
    }
    takeStoredValueForKey(value, "carteira");
  }

  public String codigoBeneficiario() {
    return (String) storedValueForKey("codigoBeneficiario");
  }

  public void setCodigoBeneficiario(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating codigoBeneficiario from " + codigoBeneficiario() + " to " + value);
    }
    takeStoredValueForKey(value, "codigoBeneficiario");
  }

  public String digitoVerificadorAgencia() {
    return (String) storedValueForKey("digitoVerificadorAgencia");
  }

  public void setDigitoVerificadorAgencia(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating digitoVerificadorAgencia from " + digitoVerificadorAgencia() + " to " + value);
    }
    takeStoredValueForKey(value, "digitoVerificadorAgencia");
  }

  public String digitoVerificadorCodigoBeneficiario() {
    return (String) storedValueForKey("digitoVerificadorCodigoBeneficiario");
  }

  public void setDigitoVerificadorCodigoBeneficiario(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating digitoVerificadorCodigoBeneficiario from " + digitoVerificadorCodigoBeneficiario() + " to " + value);
    }
    takeStoredValueForKey(value, "digitoVerificadorCodigoBeneficiario");
  }

  public String digitoVerificadorNossoNumero() {
    return (String) storedValueForKey("digitoVerificadorNossoNumero");
  }

  public void setDigitoVerificadorNossoNumero(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating digitoVerificadorNossoNumero from " + digitoVerificadorNossoNumero() + " to " + value);
    }
    takeStoredValueForKey(value, "digitoVerificadorNossoNumero");
  }

  public String documento() {
    return (String) storedValueForKey("documento");
  }

  public void setDocumento(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating documento from " + documento() + " to " + value);
    }
    takeStoredValueForKey(value, "documento");
  }

  public String nomeBeneficiario() {
    return (String) storedValueForKey("nomeBeneficiario");
  }

  public void setNomeBeneficiario(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating nomeBeneficiario from " + nomeBeneficiario() + " to " + value);
    }
    takeStoredValueForKey(value, "nomeBeneficiario");
  }

  public String nossoNumero() {
    return (String) storedValueForKey("nossoNumero");
  }

  public void setNossoNumero(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating nossoNumero from " + nossoNumero() + " to " + value);
    }
    takeStoredValueForKey(value, "nossoNumero");
  }

  public String numeroConvenio() {
    return (String) storedValueForKey("numeroConvenio");
  }

  public void setNumeroConvenio(String value) {
    if (_EOBeneficiario.logger.isDebugEnabled()) {
    	_EOBeneficiario.logger.debug( "updating numeroConvenio from " + numeroConvenio() + " to " + value);
    }
    takeStoredValueForKey(value, "numeroConvenio");
  }


  public static EOBeneficiario createEOBeneficiario(EOEditingContext editingContext) {
    EOBeneficiario eo = (EOBeneficiario) EOUtilities.createAndInsertInstance(editingContext, _EOBeneficiario.ENTITY_NAME);
    return eo;
  }

  public static NSArray<EOBeneficiario> fetchAllEOBeneficiarios(EOEditingContext editingContext) {
    return _EOBeneficiario.fetchAllEOBeneficiarios(editingContext, null);
  }

  public static NSArray<EOBeneficiario> fetchAllEOBeneficiarios(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOBeneficiario.fetchEOBeneficiarios(editingContext, null, sortOrderings);
  }

  public static NSArray<EOBeneficiario> fetchEOBeneficiarios(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOBeneficiario.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOBeneficiario> eoObjects = (NSArray<EOBeneficiario>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<EOBeneficiario> fetchEOBeneficiarios(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchEOBeneficiarios(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<EOBeneficiario> fetchEOBeneficiarios(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchEOBeneficiarios(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static EOBeneficiario fetchEOBeneficiario(EOEditingContext editingContext, String keyName, Object value) {
    return _EOBeneficiario.fetchEOBeneficiario(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOBeneficiario fetchEOBeneficiario(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOBeneficiario> eoObjects = _EOBeneficiario.fetchEOBeneficiarios(editingContext, qualifier, null);
    EOBeneficiario eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOBeneficiario)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOBeneficiario that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOBeneficiario fetchRequiredEOBeneficiario(EOEditingContext editingContext, String keyName, Object value) {
    return _EOBeneficiario.fetchRequiredEOBeneficiario(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOBeneficiario fetchRequiredEOBeneficiario(EOEditingContext editingContext, EOQualifier qualifier) {
    EOBeneficiario eoObject = _EOBeneficiario.fetchEOBeneficiario(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOBeneficiario that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOBeneficiario localInstanceIn(EOEditingContext editingContext, EOBeneficiario eo) {
    EOBeneficiario localInstance = (eo == null) ? null : (EOBeneficiario)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
