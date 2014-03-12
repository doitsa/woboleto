// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to EOInstrucao.java instead.
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
public abstract class _EOInstrucao extends br.com.woboleto.model.AbstractInformacao {
	public static final String ENTITY_NAME = "EOInstrucao";

// Attribute Keys
  public static final ERXKey<String> TIPO = new ERXKey<String>("tipo");
  public static final ERXKey<String> VALOR = new ERXKey<String>("valor");
  // Relationship Keys

	// Attributes
	public static final String TIPO_KEY = "tipo";
	public static final String VALOR_KEY = "valor";

	// Relationships

  private static Logger logger = Logger.getLogger(_EOInstrucao.class);

  public EOInstrucao localInstanceIn(EOEditingContext editingContext) {
    EOInstrucao localInstance = (EOInstrucao)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }


  public static EOInstrucao createEOInstrucao(EOEditingContext editingContext, String valor
) {
    EOInstrucao eo = (EOInstrucao) EOUtilities.createAndInsertInstance(editingContext, _EOInstrucao.ENTITY_NAME);
		eo.setValor(valor);
    return eo;
  }

  public static NSArray<EOInstrucao> fetchAllEOInstrucaos(EOEditingContext editingContext) {
    return _EOInstrucao.fetchAllEOInstrucaos(editingContext, null);
  }

  public static NSArray<EOInstrucao> fetchAllEOInstrucaos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EOInstrucao.fetchEOInstrucaos(editingContext, null, sortOrderings);
  }

  public static NSArray<EOInstrucao> fetchEOInstrucaos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EOInstrucao.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EOInstrucao> eoObjects = (NSArray<EOInstrucao>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<EOInstrucao> fetchEOInstrucaos(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchEOInstrucaos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<EOInstrucao> fetchEOInstrucaos(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchEOInstrucaos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static EOInstrucao fetchEOInstrucao(EOEditingContext editingContext, String keyName, Object value) {
    return _EOInstrucao.fetchEOInstrucao(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOInstrucao fetchEOInstrucao(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EOInstrucao> eoObjects = _EOInstrucao.fetchEOInstrucaos(editingContext, qualifier, null);
    EOInstrucao eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EOInstrucao)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EOInstrucao that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOInstrucao fetchRequiredEOInstrucao(EOEditingContext editingContext, String keyName, Object value) {
    return _EOInstrucao.fetchRequiredEOInstrucao(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EOInstrucao fetchRequiredEOInstrucao(EOEditingContext editingContext, EOQualifier qualifier) {
    EOInstrucao eoObject = _EOInstrucao.fetchEOInstrucao(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EOInstrucao that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EOInstrucao localInstanceIn(EOEditingContext editingContext, EOInstrucao eo) {
    EOInstrucao localInstance = (eo == null) ? null : (EOInstrucao)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
