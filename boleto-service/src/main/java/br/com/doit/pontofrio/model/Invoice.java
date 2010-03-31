package br.com.doit.pontofrio.model;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.wobr.boleto.model.EOBoleto;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class Invoice extends _Invoice
{
	public static Invoice createInvoice(EOEditingContext editingContext, String externalId, EOBoleto boleto)
	{
		Invoice invoice = (Invoice) EOUtilities.createAndInsertInstance(editingContext, ENTITY_NAME);

		invoice.setExternalId(externalId);
		invoice.setBoletoRelationship(boleto);

		return invoice;
	}

	@Override
	public void setExternalId(String value)
	{
		super.setExternalId(value);

		if(value != null)
		{
			setValidationKey(DigestUtils.md5Hex("(#%(!" + value + "xInfFGks"));
		}
	}
}
