// $LastChangedRevision$ DO NOT EDIT.  Make changes to Invoice.java instead.
package br.com.doit.pontofrio.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _Invoice extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Invoice";

	// Attributes
	public static final String EXTERNAL_ID_KEY = "externalId";
	public static final String VALIDATION_KEY_KEY = "validationKey";

	// Relationships
	public static final String BOLETO_KEY = "boleto";
	public static final String VOUCHER_KEY = "voucher";

  private static Logger LOG = Logger.getLogger(_Invoice.class);

  public Invoice localInstanceIn(EOEditingContext editingContext) {
    Invoice localInstance = (Invoice)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public String externalId() {
    return (String) storedValueForKey("externalId");
  }

  public void setExternalId(String value) {
    if (_Invoice.LOG.isDebugEnabled()) {
    	_Invoice.LOG.debug( "updating externalId from " + externalId() + " to " + value);
    }
    takeStoredValueForKey(value, "externalId");
  }

  public String validationKey() {
    return (String) storedValueForKey("validationKey");
  }

  public void setValidationKey(String value) {
    if (_Invoice.LOG.isDebugEnabled()) {
    	_Invoice.LOG.debug( "updating validationKey from " + validationKey() + " to " + value);
    }
    takeStoredValueForKey(value, "validationKey");
  }

  public br.com.woboleto.model.EOBoleto boleto() {
    return (br.com.woboleto.model.EOBoleto)storedValueForKey("boleto");
  }

  public void setBoletoRelationship(br.com.woboleto.model.EOBoleto value) {
    if (_Invoice.LOG.isDebugEnabled()) {
      _Invoice.LOG.debug("updating boleto from " + boleto() + " to " + value);
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
  
  public br.com.doit.pontofrio.model.Voucher voucher() {
    return (br.com.doit.pontofrio.model.Voucher)storedValueForKey("voucher");
  }

  public void setVoucherRelationship(br.com.doit.pontofrio.model.Voucher value) {
    if (_Invoice.LOG.isDebugEnabled()) {
      _Invoice.LOG.debug("updating voucher from " + voucher() + " to " + value);
    }
    if (value == null) {
    	br.com.doit.pontofrio.model.Voucher oldValue = voucher();
    	if (oldValue != null) {
    		removeObjectFromBothSidesOfRelationshipWithKey(oldValue, "voucher");
      }
    } else {
    	addObjectToBothSidesOfRelationshipWithKey(value, "voucher");
    }
  }
  

  public static Invoice createInvoice(EOEditingContext editingContext, String externalId
, String validationKey
, br.com.woboleto.model.EOBoleto boleto) {
    Invoice eo = (Invoice) EOUtilities.createAndInsertInstance(editingContext, _Invoice.ENTITY_NAME);    
		eo.setExternalId(externalId);
		eo.setValidationKey(validationKey);
    eo.setBoletoRelationship(boleto);
    return eo;
  }

  public static NSArray<Invoice> fetchAllInvoices(EOEditingContext editingContext) {
    return _Invoice.fetchAllInvoices(editingContext, null);
  }

  public static NSArray<Invoice> fetchAllInvoices(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Invoice.fetchInvoices(editingContext, null, sortOrderings);
  }

  public static NSArray<Invoice> fetchInvoices(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Invoice.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Invoice> eoObjects = (NSArray<Invoice>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Invoice fetchInvoice(EOEditingContext editingContext, String keyName, Object value) {
    return _Invoice.fetchInvoice(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Invoice fetchInvoice(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Invoice> eoObjects = _Invoice.fetchInvoices(editingContext, qualifier, null);
    Invoice eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Invoice)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Invoice that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Invoice fetchRequiredInvoice(EOEditingContext editingContext, String keyName, Object value) {
    return _Invoice.fetchRequiredInvoice(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Invoice fetchRequiredInvoice(EOEditingContext editingContext, EOQualifier qualifier) {
    Invoice eoObject = _Invoice.fetchInvoice(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Invoice that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Invoice localInstanceIn(EOEditingContext editingContext, Invoice eo) {
    Invoice localInstance = (eo == null) ? null : (Invoice)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
