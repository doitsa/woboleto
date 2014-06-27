// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to EOEndereco.java instead.
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
public abstract class _EOEndereco extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "EOEndereco";

// Attribute Keys
  public static final ERXKey<String> BAIRRO = new ERXKey<String>("bairro");
  public static final ERXKey<String> CEP = new ERXKey<String>("cep");
  public static final ERXKey<String> CIDADE = new ERXKey<String>("cidade");
  public static final ERXKey<String> LOGRADOURO = new ERXKey<String>("logradouro");
  public static final ERXKey<String> UF = new ERXKey<String>("uf");
  // Relationship Keys

	// Attributes
	public static final String BAIRRO_KEY = "bairro";
	public static final String CEP_KEY = "cep";
	public static final String CIDADE_KEY = "cidade";
	public static final String LOGRADOURO_KEY = "logradouro";
	public static final String UF_KEY = "uf";

	// Relationships

  private static Logger logger = Logger.getLogger(_EOEndereco.class);

  public EOEndereco localInstanceIn(EOEditingContext editingContext) {
    EOEndereco localInstance = (EOEndereco)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String bairro() {
    return (String) storedValueForKey("bairro");
  }

  public void setBairro(String value) {
    if (_EOEndereco.logger.isDebugEnabled()) {
    	_EOEndereco.logger.debug( "updating bairro from " + bairro() + " to " + value);
    }
    takeStoredValueForKey(value, "bairro");
  }

  public String cep() {
    return (String) storedValueForKey("cep");
  }

  public void setCep(String value) {
    if (_EOEndereco.logger.isDebugEnabled()) {
    	_EOEndereco.logger.debug( "updating cep from " + cep() + " to " + value);
    }
    takeStoredValueForKey(value, "cep");
  }

  public String cidade() {
    return (String) storedValueForKey("cidade");
  }

  public void setCidade(String value) {
    if (_EOEndereco.logger.isDebugEnabled()) {
    	_EOEndereco.logger.debug( "updating cidade from " + cidade() + " to " + value);
    }
    takeStoredValueForKey(value, "cidade");
  }

  public String logradouro() {
    return (String) storedValueForKey("logradouro");
  }

  public void setLogradouro(String value) {
    if (_EOEndereco.logger.isDebugEnabled()) {
    	_EOEndereco.logger.debug( "updating logradouro from " + logradouro() + " to " + value);
    }
    takeStoredValueForKey(value, "logradouro");
  }

  public String uf() {
    return (String) storedValueForKey("uf");
  }

  public void setUf(String value) {
    if (_EOEndereco.logger.isDebugEnabled()) {
    	_EOEndereco.logger.debug( "updating uf from " + uf() + " to " + value);
    }
    takeStoredValueForKey(value, "uf");
  }


  public static EOEndereco createEOEndereco(EOEditingContext editingContext) {
    EOEndereco eo = (EOEndereco) EOUtilities.createAndInsertInstance(editingContext, _EOEndereco.ENTITY_NAME);
    return eo;
  }

  public static NSArray<EOEndereco> fetchAllEOEnderecos(EOEditingContext editingContext) {
    return _EOEndereco.fetchAllEOEnderecos(editingContext, null);
  }

  public static NSArray<EOEndereco> fetchAllEOEnderecos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOEndereco.fetchEOEnderecos(editingContext, null, sortOrderings);
  }

  public static NSArray<EOEndereco> fetchEOEnderecos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOEndereco.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOEndereco> eoObjects = (NSArray<EOEndereco>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<EOEndereco> fetchEOEnderecos(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchEOEnderecos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<EOEndereco> fetchEOEnderecos(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchEOEnderecos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static EOEndereco fetchEOEndereco(EOEditingContext editingContext, String keyName, Object value) {
    return _EOEndereco.fetchEOEndereco(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOEndereco fetchEOEndereco(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOEndereco> eoObjects = _EOEndereco.fetchEOEnderecos(editingContext, qualifier, null);
    EOEndereco eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOEndereco)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOEndereco that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOEndereco fetchRequiredEOEndereco(EOEditingContext editingContext, String keyName, Object value) {
    return _EOEndereco.fetchRequiredEOEndereco(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOEndereco fetchRequiredEOEndereco(EOEditingContext editingContext, EOQualifier qualifier) {
    EOEndereco eoObject = _EOEndereco.fetchEOEndereco(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOEndereco that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOEndereco localInstanceIn(EOEditingContext editingContext, EOEndereco eo) {
    EOEndereco localInstance = (eo == null) ? null : (EOEndereco)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
