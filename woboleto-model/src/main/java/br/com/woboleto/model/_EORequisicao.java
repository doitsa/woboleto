// $LastChangedRevision: 4733 $ DO NOT EDIT.  Make changes to EORequisicao.java instead.
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
public abstract class _EORequisicao extends  ERXGenericRecord {
	public static final String ENTITY_NAME = "EORequisicao";

// Attribute Keys
  public static final ERXKey<String> HASH = new ERXKey<String>("hash");
  public static final ERXKey<Integer> SEQUENTIAL = new ERXKey<Integer>("sequential");
  // Relationship Keys
  public static final ERXKey<br.com.woboleto.model.EOBoleto> BOLETO = new ERXKey<br.com.woboleto.model.EOBoleto>("boleto");

	// Attributes
	public static final String HASH_KEY = "hash";
	public static final String SEQUENTIAL_KEY = "sequential";

	// Relationships
	public static final String BOLETO_KEY = "boleto";

  private static Logger logger = Logger.getLogger(_EORequisicao.class);

  public EORequisicao localInstanceIn(EOEditingContext editingContext) {
    EORequisicao localInstance = (EORequisicao)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String hash() {
    return (String) storedValueForKey("hash");
  }

  public void setHash(String value) {
    if (_EORequisicao.logger.isDebugEnabled()) {
    	_EORequisicao.logger.debug( "updating hash from " + hash() + " to " + value);
    }
    takeStoredValueForKey(value, "hash");
  }

  public Integer sequential() {
    return (Integer) storedValueForKey("sequential");
  }

  public void setSequential(Integer value) {
    if (_EORequisicao.logger.isDebugEnabled()) {
    	_EORequisicao.logger.debug( "updating sequential from " + sequential() + " to " + value);
    }
    takeStoredValueForKey(value, "sequential");
  }

  public br.com.woboleto.model.EOBoleto boleto() {
    return (br.com.woboleto.model.EOBoleto)storedValueForKey("boleto");
  }

  protected void setBoletoRelationship(br.com.woboleto.model.EOBoleto value) {
    if (_EORequisicao.logger.isDebugEnabled()) {
      _EORequisicao.logger.debug("updating boleto from " + boleto() + " to " + value);
    }
    if (value == null) {
    	br.com.woboleto.model.EOBoleto oldValue = boleto();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "boleto");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "boleto");
    }
  }

  public void setBoleto(br.com.woboleto.model.EOBoleto value) {
      this.takeStoredValueForKey(value, "boleto");
  }


  public static EORequisicao createEORequisicao(EOEditingContext editingContext, String hash
, Integer sequential
, br.com.woboleto.model.EOBoleto boleto) {
    EORequisicao eo = (EORequisicao) EOUtilities.createAndInsertInstance(editingContext, _EORequisicao.ENTITY_NAME);
		eo.setHash(hash);
		eo.setSequential(sequential);
    eo.setBoletoRelationship(boleto);
    return eo;
  }

  public static NSArray<EORequisicao> fetchAllEORequisicaos(EOEditingContext editingContext) {
    return _EORequisicao.fetchAllEORequisicaos(editingContext, null);
  }

  public static NSArray<EORequisicao> fetchAllEORequisicaos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _EORequisicao.fetchEORequisicaos(editingContext, null, sortOrderings);
  }

  public static NSArray<EORequisicao> fetchEORequisicaos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_EORequisicao.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<EORequisicao> eoObjects = (NSArray<EORequisicao>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static NSArray<EORequisicao> fetchEORequisicaos(EOEditingContext editingContext, String keyName, Object value, NSArray<EOSortOrdering> sortOrderings) {
	return fetchEORequisicaos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }

  public static NSArray<EORequisicao> fetchEORequisicaos(EOEditingContext editingContext, String keyName, Object value, String sortAscKey) {
	NSArray<EOSortOrdering> sortOrderings = new NSArray<EOSortOrdering>(EOSortOrdering.sortOrderingWithKey(sortAscKey, EOSortOrdering.CompareAscending));
	return fetchEORequisicaos(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value), sortOrderings);
  }


  public static EORequisicao fetchEORequisicao(EOEditingContext editingContext, String keyName, Object value) {
    return _EORequisicao.fetchEORequisicao(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORequisicao fetchEORequisicao(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<EORequisicao> eoObjects = _EORequisicao.fetchEORequisicaos(editingContext, qualifier, null);
    EORequisicao eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (EORequisicao)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one EORequisicao that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORequisicao fetchRequiredEORequisicao(EOEditingContext editingContext, String keyName, Object value) {
    return _EORequisicao.fetchRequiredEORequisicao(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static EORequisicao fetchRequiredEORequisicao(EOEditingContext editingContext, EOQualifier qualifier) {
    EORequisicao eoObject = _EORequisicao.fetchEORequisicao(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no EORequisicao that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static EORequisicao localInstanceIn(EOEditingContext editingContext, EORequisicao eo) {
    EORequisicao localInstance = (eo == null) ? null : (EORequisicao)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }



}
