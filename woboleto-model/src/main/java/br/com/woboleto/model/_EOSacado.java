// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to EOSacado.java instead.
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
public abstract class _EOSacado extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "EOSacado";

// Attribute Keys
  public static final ERXKey<String> BAIRRO = new ERXKey<String>("bairro");
  public static final ERXKey<String> CEP = new ERXKey<String>("cep");
  public static final ERXKey<String> CIDADE = new ERXKey<String>("cidade");
  public static final ERXKey<String> CPF = new ERXKey<String>("cpf");
  public static final ERXKey<String> ENDERECO = new ERXKey<String>("endereco");
  public static final ERXKey<String> NOME = new ERXKey<String>("nome");
  public static final ERXKey<String> UF = new ERXKey<String>("uf");
  // Relationship Keys

	// Attributes
	public static final String BAIRRO_KEY = "bairro";
	public static final String CEP_KEY = "cep";
	public static final String CIDADE_KEY = "cidade";
	public static final String CPF_KEY = "cpf";
	public static final String ENDERECO_KEY = "endereco";
	public static final String NOME_KEY = "nome";
	public static final String UF_KEY = "uf";

	// Relationships

  private static Logger logger = Logger.getLogger(_EOSacado.class);

  public EOSacado localInstanceIn(EOEditingContext editingContext) {
    EOSacado localInstance = (EOSacado)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String bairro() {
    return (String) storedValueForKey("bairro");
  }

  public void setBairro(String value) {
    if (_EOSacado.logger.isDebugEnabled()) {
    	_EOSacado.logger.debug( "updating bairro from " + bairro() + " to " + value);
    }
    takeStoredValueForKey(value, "bairro");
  }

  public String cep() {
    return (String) storedValueForKey("cep");
  }

  public void setCep(String value) {
    if (_EOSacado.logger.isDebugEnabled()) {
    	_EOSacado.logger.debug( "updating cep from " + cep() + " to " + value);
    }
    takeStoredValueForKey(value, "cep");
  }

  public String cidade() {
    return (String) storedValueForKey("cidade");
  }

  public void setCidade(String value) {
    if (_EOSacado.logger.isDebugEnabled()) {
    	_EOSacado.logger.debug( "updating cidade from " + cidade() + " to " + value);
    }
    takeStoredValueForKey(value, "cidade");
  }

  public String cpf() {
    return (String) storedValueForKey("cpf");
  }

  public void setCpf(String value) {
    if (_EOSacado.logger.isDebugEnabled()) {
    	_EOSacado.logger.debug( "updating cpf from " + cpf() + " to " + value);
    }
    takeStoredValueForKey(value, "cpf");
  }

  public String endereco() {
    return (String) storedValueForKey("endereco");
  }

  public void setEndereco(String value) {
    if (_EOSacado.logger.isDebugEnabled()) {
    	_EOSacado.logger.debug( "updating endereco from " + endereco() + " to " + value);
    }
    takeStoredValueForKey(value, "endereco");
  }

  public String nome() {
    return (String) storedValueForKey("nome");
  }

  public void setNome(String value) {
    if (_EOSacado.logger.isDebugEnabled()) {
    	_EOSacado.logger.debug( "updating nome from " + nome() + " to " + value);
    }
    takeStoredValueForKey(value, "nome");
  }

  public String uf() {
    return (String) storedValueForKey("uf");
  }

  public void setUf(String value) {
    if (_EOSacado.logger.isDebugEnabled()) {
    	_EOSacado.logger.debug( "updating uf from " + uf() + " to " + value);
    }
    takeStoredValueForKey(value, "uf");
  }


  public static EOSacado createEOSacado(EOEditingContext editingContext) {
    EOSacado eo = (EOSacado) EOUtilities.createAndInsertInstance(editingContext, _EOSacado.ENTITY_NAME);
    return eo;
  }

  public static NSArray<EOSacado> fetchAllEOSacados(EOEditingContext editingContext) {
    return _EOSacado.fetchAllEOSacados(editingContext, null);
  }

  public static NSArray<EOSacado> fetchAllEOSacados(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOSacado.fetchEOSacados(editingContext, null, sortOrderings);
  }

  public static NSArray<EOSacado> fetchEOSacados(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOSacado.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOSacado> eoObjects = (NSArray<EOSacado>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<EOSacado> fetchEOSacados(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchEOSacados(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<EOSacado> fetchEOSacados(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchEOSacados(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static EOSacado fetchEOSacado(EOEditingContext editingContext, String keyName, Object value) {
    return _EOSacado.fetchEOSacado(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOSacado fetchEOSacado(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOSacado> eoObjects = _EOSacado.fetchEOSacados(editingContext, qualifier, null);
    EOSacado eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOSacado)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOSacado that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOSacado fetchRequiredEOSacado(EOEditingContext editingContext, String keyName, Object value) {
    return _EOSacado.fetchRequiredEOSacado(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOSacado fetchRequiredEOSacado(EOEditingContext editingContext, EOQualifier qualifier) {
    EOSacado eoObject = _EOSacado.fetchEOSacado(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOSacado that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOSacado localInstanceIn(EOEditingContext editingContext, EOSacado eo) {
    EOSacado localInstance = (eo == null) ? null : (EOSacado)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
