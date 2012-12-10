// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to EOLocalPagamento.java instead.
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
public abstract class _EOLocalPagamento extends br.com.woboleto.model.AbstractInformacao {
	public static final String ENTITY_NAME = "EOLocalPagamento";

// Attribute Keys
  public static final ERXKey<String> TIPO = new ERXKey<String>("tipo");
  public static final ERXKey<String> VALOR = new ERXKey<String>("valor");
  // Relationship Keys

	// Attributes
	public static final String TIPO_KEY = "tipo";
	public static final String VALOR_KEY = "valor";

	// Relationships

  private static Logger logger = Logger.getLogger(_EOLocalPagamento.class);

  public EOLocalPagamento localInstanceIn(EOEditingContext editingContext) {
    EOLocalPagamento localInstance = (EOLocalPagamento)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }


  public static EOLocalPagamento createEOLocalPagamento(EOEditingContext editingContext, String valor
) {
    EOLocalPagamento eo = (EOLocalPagamento) EOUtilities.createAndInsertInstance(editingContext, _EOLocalPagamento.ENTITY_NAME);
		eo.setValor(valor);
    return eo;
  }

  public static NSArray<EOLocalPagamento> fetchAllEOLocalPagamentos(EOEditingContext editingContext) {
    return _EOLocalPagamento.fetchAllEOLocalPagamentos(editingContext, null);
  }

  public static NSArray<EOLocalPagamento> fetchAllEOLocalPagamentos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOLocalPagamento.fetchEOLocalPagamentos(editingContext, null, sortOrderings);
  }

  public static NSArray<EOLocalPagamento> fetchEOLocalPagamentos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOLocalPagamento.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOLocalPagamento> eoObjects = (NSArray<EOLocalPagamento>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<EOLocalPagamento> fetchEOLocalPagamentos(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchEOLocalPagamentos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<EOLocalPagamento> fetchEOLocalPagamentos(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchEOLocalPagamentos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static EOLocalPagamento fetchEOLocalPagamento(EOEditingContext editingContext, String keyName, Object value) {
    return _EOLocalPagamento.fetchEOLocalPagamento(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOLocalPagamento fetchEOLocalPagamento(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOLocalPagamento> eoObjects = _EOLocalPagamento.fetchEOLocalPagamentos(editingContext, qualifier, null);
    EOLocalPagamento eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOLocalPagamento)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOLocalPagamento that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOLocalPagamento fetchRequiredEOLocalPagamento(EOEditingContext editingContext, String keyName, Object value) {
    return _EOLocalPagamento.fetchRequiredEOLocalPagamento(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOLocalPagamento fetchRequiredEOLocalPagamento(EOEditingContext editingContext, EOQualifier qualifier) {
    EOLocalPagamento eoObject = _EOLocalPagamento.fetchEOLocalPagamento(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOLocalPagamento that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOLocalPagamento localInstanceIn(EOEditingContext editingContext, EOLocalPagamento eo) {
    EOLocalPagamento localInstance = (eo == null) ? null : (EOLocalPagamento)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
