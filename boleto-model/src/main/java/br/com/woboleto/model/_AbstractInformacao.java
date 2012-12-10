// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to AbstractInformacao.java instead.
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
public abstract class _AbstractInformacao extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "AbstractInformacao";

// Attribute Keys
  public static final ERXKey<String> TIPO = new ERXKey<String>("tipo");
  public static final ERXKey<String> VALOR = new ERXKey<String>("valor");
  // Relationship Keys

	// Attributes
	public static final String TIPO_KEY = "tipo";
	public static final String VALOR_KEY = "valor";

	// Relationships

  private static Logger logger = Logger.getLogger(_AbstractInformacao.class);

  public AbstractInformacao localInstanceIn(EOEditingContext editingContext) {
    AbstractInformacao localInstance = (AbstractInformacao)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String tipo() {
    return (String) storedValueForKey("tipo");
  }

  public void setTipo(String value) {
    if (_AbstractInformacao.logger.isDebugEnabled()) {
    	_AbstractInformacao.logger.debug( "updating tipo from " + tipo() + " to " + value);
    }
    takeStoredValueForKey(value, "tipo");
  }

  public String valor() {
    return (String) storedValueForKey("valor");
  }

  public void setValor(String value) {
    if (_AbstractInformacao.logger.isDebugEnabled()) {
    	_AbstractInformacao.logger.debug( "updating valor from " + valor() + " to " + value);
    }
    takeStoredValueForKey(value, "valor");
  }


  public static AbstractInformacao createAbstractInformacao(EOEditingContext editingContext, String tipo
, String valor
) {
    AbstractInformacao eo = (AbstractInformacao) EOUtilities.createAndInsertInstance(editingContext, _AbstractInformacao.ENTITY_NAME);
		eo.setTipo(tipo);
		eo.setValor(valor);
    return eo;
  }

  public static NSArray<AbstractInformacao> fetchAllAbstractInformacaos(EOEditingContext editingContext) {
    return _AbstractInformacao.fetchAllAbstractInformacaos(editingContext, null);
  }

  public static NSArray<AbstractInformacao> fetchAllAbstractInformacaos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _AbstractInformacao.fetchAbstractInformacaos(editingContext, null, sortOrderings);
  }

  public static NSArray<AbstractInformacao> fetchAbstractInformacaos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_AbstractInformacao.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<AbstractInformacao> eoObjects = (NSArray<AbstractInformacao>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<AbstractInformacao> fetchAbstractInformacaos(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchAbstractInformacaos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<AbstractInformacao> fetchAbstractInformacaos(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchAbstractInformacaos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static AbstractInformacao fetchAbstractInformacao(EOEditingContext editingContext, String keyName, Object value) {
    return _AbstractInformacao.fetchAbstractInformacao(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static AbstractInformacao fetchAbstractInformacao(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<AbstractInformacao> eoObjects = _AbstractInformacao.fetchAbstractInformacaos(editingContext, qualifier, null);
    AbstractInformacao eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (AbstractInformacao)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one AbstractInformacao that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static AbstractInformacao fetchRequiredAbstractInformacao(EOEditingContext editingContext, String keyName, Object value) {
    return _AbstractInformacao.fetchRequiredAbstractInformacao(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static AbstractInformacao fetchRequiredAbstractInformacao(EOEditingContext editingContext, EOQualifier qualifier) {
    AbstractInformacao eoObject = _AbstractInformacao.fetchAbstractInformacao(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no AbstractInformacao that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static AbstractInformacao localInstanceIn(EOEditingContext editingContext, AbstractInformacao eo) {
    AbstractInformacao localInstance = (eo == null) ? null : (AbstractInformacao)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
