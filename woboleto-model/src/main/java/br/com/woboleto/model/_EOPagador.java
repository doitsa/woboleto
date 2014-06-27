// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to EOPagador.java instead.
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
public abstract class _EOPagador extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "EOPagador";

// Attribute Keys
  public static final ERXKey<String> DOCUMENTO = new ERXKey<String>("documento");
  public static final ERXKey<String> NOME = new ERXKey<String>("nome");
  // Relationship Keys
  public static final ERXKey<br.com.woboleto.model.EOEndereco> ENDERECO = new ERXKey<br.com.woboleto.model.EOEndereco>("endereco");

	// Attributes
	public static final String DOCUMENTO_KEY = "documento";
	public static final String NOME_KEY = "nome";

	// Relationships
	public static final String ENDERECO_KEY = "endereco";

  private static Logger logger = Logger.getLogger(_EOPagador.class);

  public EOPagador localInstanceIn(EOEditingContext editingContext) {
    EOPagador localInstance = (EOPagador)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String documento() {
    return (String) storedValueForKey("documento");
  }

  public void setDocumento(String value) {
    if (_EOPagador.logger.isDebugEnabled()) {
    	_EOPagador.logger.debug( "updating documento from " + documento() + " to " + value);
    }
    takeStoredValueForKey(value, "documento");
  }

  public String nome() {
    return (String) storedValueForKey("nome");
  }

  public void setNome(String value) {
    if (_EOPagador.logger.isDebugEnabled()) {
    	_EOPagador.logger.debug( "updating nome from " + nome() + " to " + value);
    }
    takeStoredValueForKey(value, "nome");
  }

  public br.com.woboleto.model.EOEndereco endereco() {
    return (br.com.woboleto.model.EOEndereco)storedValueForKey("endereco");
  }

  protected void setEnderecoRelationship(br.com.woboleto.model.EOEndereco value) {
    if (_EOPagador.logger.isDebugEnabled()) {
      _EOPagador.logger.debug("updating endereco from " + endereco() + " to " + value);
    }
    if (value == null) {
    	br.com.woboleto.model.EOEndereco oldValue = endereco();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "endereco");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "endereco");
    }
  }

  public void setEndereco(br.com.woboleto.model.EOEndereco value) {
      this.takeStoredValueForKey(value, "endereco");
  }


  public static EOPagador createEOPagador(EOEditingContext editingContext) {
    EOPagador eo = (EOPagador) EOUtilities.createAndInsertInstance(editingContext, _EOPagador.ENTITY_NAME);
    return eo;
  }

  public static NSArray<EOPagador> fetchAllEOPagadors(EOEditingContext editingContext) {
    return _EOPagador.fetchAllEOPagadors(editingContext, null);
  }

  public static NSArray<EOPagador> fetchAllEOPagadors(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOPagador.fetchEOPagadors(editingContext, null, sortOrderings);
  }

  public static NSArray<EOPagador> fetchEOPagadors(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOPagador.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOPagador> eoObjects = (NSArray<EOPagador>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<EOPagador> fetchEOPagadors(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchEOPagadors(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<EOPagador> fetchEOPagadors(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchEOPagadors(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static EOPagador fetchEOPagador(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPagador.fetchEOPagador(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPagador fetchEOPagador(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOPagador> eoObjects = _EOPagador.fetchEOPagadors(editingContext, qualifier, null);
    EOPagador eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOPagador)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOPagador that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPagador fetchRequiredEOPagador(EOEditingContext editingContext, String keyName, Object value) {
    return _EOPagador.fetchRequiredEOPagador(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOPagador fetchRequiredEOPagador(EOEditingContext editingContext, EOQualifier qualifier) {
    EOPagador eoObject = _EOPagador.fetchEOPagador(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOPagador that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOPagador localInstanceIn(EOEditingContext editingContext, EOPagador eo) {
    EOPagador localInstance = (eo == null) ? null : (EOPagador)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
