package br.com.doit.pontofrio.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import com.wounit.rules.MockEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class TestInvoice {
	@Rule
	public final MockEditingContext editingContext = new MockEditingContext(
			"Store", "Boleto");

	@Test
	public void validationKeyForNotNullOrderId() throws Exception {
		Invoice invoice = Invoice.createInvoice(editingContext, "1234", null);

		assertThat(invoice.validationKey(),
				is("a127017b6c0b6fce41423b3171b8bad7"));
	}

	@Test
	public void validationKeyForNullOrderId() throws Exception {
		Invoice invoice = Invoice.createInvoice(editingContext, null, null);

		assertThat(invoice.validationKey(), nullValue());
	}
}
