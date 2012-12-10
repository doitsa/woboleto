// $LastChangedRevision$ DO NOT EDIT.  Make changes to Voucher.java instead.
package br.com.doit.pontofrio.model;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import java.math.*;
import java.util.*;
import org.apache.log4j.Logger;

@SuppressWarnings("all")
public abstract class _Voucher extends  EOGenericRecord {
	public static final String ENTITY_NAME = "Voucher";

	// Attributes
	public static final String PAID_AMOUNT_KEY = "paidAmount";
	public static final String PAYMENT_DATE_KEY = "paymentDate";

	// Relationships

  private static Logger LOG = Logger.getLogger(_Voucher.class);

  public Voucher localInstanceIn(EOEditingContext editingContext) {
    Voucher localInstance = (Voucher)EOUtilities.localInstanceOfObject(editingContext, this);
    if (localInstance == null) {
      throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
    }
    return localInstance;
  }

  public java.math.BigDecimal paidAmount() {
    return (java.math.BigDecimal) storedValueForKey("paidAmount");
  }

  public void setPaidAmount(java.math.BigDecimal value) {
    if (_Voucher.LOG.isDebugEnabled()) {
    	_Voucher.LOG.debug( "updating paidAmount from " + paidAmount() + " to " + value);
    }
    takeStoredValueForKey(value, "paidAmount");
  }

  public NSTimestamp paymentDate() {
    return (NSTimestamp) storedValueForKey("paymentDate");
  }

  public void setPaymentDate(NSTimestamp value) {
    if (_Voucher.LOG.isDebugEnabled()) {
    	_Voucher.LOG.debug( "updating paymentDate from " + paymentDate() + " to " + value);
    }
    takeStoredValueForKey(value, "paymentDate");
  }


  public static Voucher createVoucher(EOEditingContext editingContext, java.math.BigDecimal paidAmount
, NSTimestamp paymentDate
) {
    Voucher eo = (Voucher) EOUtilities.createAndInsertInstance(editingContext, _Voucher.ENTITY_NAME);    
		eo.setPaidAmount(paidAmount);
		eo.setPaymentDate(paymentDate);
    return eo;
  }

  public static NSArray<Voucher> fetchAllVouchers(EOEditingContext editingContext) {
    return _Voucher.fetchAllVouchers(editingContext, null);
  }

  public static NSArray<Voucher> fetchAllVouchers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Voucher.fetchVouchers(editingContext, null, sortOrderings);
  }

  public static NSArray<Voucher> fetchVouchers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Voucher.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Voucher> eoObjects = (NSArray<Voucher>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  public static Voucher fetchVoucher(EOEditingContext editingContext, String keyName, Object value) {
    return _Voucher.fetchVoucher(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Voucher fetchVoucher(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Voucher> eoObjects = _Voucher.fetchVouchers(editingContext, qualifier, null);
    Voucher eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    }
    else if (count == 1) {
      eoObject = (Voucher)eoObjects.objectAtIndex(0);
    }
    else {
      throw new IllegalStateException("There was more than one Voucher that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Voucher fetchRequiredVoucher(EOEditingContext editingContext, String keyName, Object value) {
    return _Voucher.fetchRequiredVoucher(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Voucher fetchRequiredVoucher(EOEditingContext editingContext, EOQualifier qualifier) {
    Voucher eoObject = _Voucher.fetchVoucher(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Voucher that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Voucher localInstanceIn(EOEditingContext editingContext, Voucher eo) {
    Voucher localInstance = (eo == null) ? null : (Voucher)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }
}
