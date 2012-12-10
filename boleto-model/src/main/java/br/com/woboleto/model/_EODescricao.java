// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to EODescricao.java instead.
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
public abstract class _EODescricao extends br.com.woboleto.model.AbstractInformacao {
	public static final String ENTITY_NAME = "EODescricao";

// Attribute Keys
  public static final ERXKey<String> TIPO = new ERXKey<String>("tipo");
  public static final ERXKey<String> VALOR = new ERXKey<String>("valor");
  // Relationship Keys

	// Attributes
	public static final String TIPO_KEY = "tipo";
	public static final String VALOR_KEY = "valor";

	// Relationships

  private static Logger logger = Logger.getLogger(_EODescricao.class);

  public EODescricao localInstanceIn(EOEditingContext editingContext) {
    EODescricao localInstance = (EODescricao)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }


  public static EODescricao createEODescricao(EOEditingContext editingContext, String valor
) {
    EODescricao eo = (EODescricao) EOUtilities.createAndInsertInstance(editingContext, _EODescricao.ENTITY_NAME);
		eo.setValor(valor);
    return eo;
  }

  public static NSArray<EODescricao> fetchAllEODescricaos(EOEditingContext editingContext) {
    return _EODescricao.fetchAllEODescricaos(editingContext, null);
  }

  public static NSArray<EODescricao> fetchAllEODescricaos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EODescricao.fetchEODescricaos(editingContext, null, sortOrderings);
  }

  public static NSArray<EODescricao> fetchEODescricaos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EODescricao.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EODescricao> eoObjects = (NSArray<EODescricao>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<EODescricao> fetchEODescricaos(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchEODescricaos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<EODescricao> fetchEODescricaos(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchEODescricaos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static EODescricao fetchEODescricao(EOEditingContext editingContext, String keyName, Object value) {
    return _EODescricao.fetchEODescricao(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EODescricao fetchEODescricao(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EODescricao> eoObjects = _EODescricao.fetchEODescricaos(editingContext, qualifier, null);
    EODescricao eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EODescricao)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EODescricao that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EODescricao fetchRequiredEODescricao(EOEditingContext editingContext, String keyName, Object value) {
    return _EODescricao.fetchRequiredEODescricao(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EODescricao fetchRequiredEODescricao(EOEditingContext editingContext, EOQualifier qualifier) {
    EODescricao eoObject = _EODescricao.fetchEODescricao(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EODescricao that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EODescricao localInstanceIn(EOEditingContext editingContext, EODescricao eo) {
    EODescricao localInstance = (eo == null) ? null : (EODescricao)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
