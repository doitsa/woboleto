package br.com.doit.pontofrio.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.transformer.BoletoGenerator;
import br.com.doit.pontofrio.model.Invoice;
import br.com.woboleto.model.EOBoleto;

import com.wounit.annotations.Dummy;
import com.wounit.rules.MockEditingContext;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class TestBoletoResource {
	@Rule
	public final MockEditingContext ec = new MockEditingContext("Store",
			"Boleto");

	@Dummy
	private Invoice mockInvoice;

	@Dummy
	private EOBoleto mockBoleto;

	private BoletoResource resource;

	@Test
	public void exceptionIfHashKeyIsNotValid() throws Exception {
		mockInvoice.setValidationKey("yyyyy");

		try {
			resource.boletoAsPng("1234", "xxxxx");

			fail();
		} catch (WebApplicationException exception) {
			assertThat(exception.getResponse().getStatus(),
					is(Response.Status.BAD_REQUEST.getStatusCode()));
			assertThat(exception.getResponse().getEntity().toString(),
					is("The validation hash provided is invalid"));
		}
	}

	@Test
	public void exceptionIfHashKeyIsNull() throws Exception {
		try {
			resource.boletoAsPng("1234", null);

			fail();
		} catch (WebApplicationException exception) {
			assertThat(exception.getResponse().getStatus(),
					is(Response.Status.BAD_REQUEST.getStatusCode()));
			assertThat(exception.getResponse().getEntity().toString(),
					is("The validation hash provided is invalid"));
		}
	}

	@Test
	public void generateBoletoIfValidationKeyIsCorrect() throws Exception {
		resource = Mockito.spy(resource);

		BoletoGenerator mockBoletoGenerator = Mockito
				.mock(BoletoGenerator.class);

		Mockito.doReturn(mockBoletoGenerator).when(resource)
				.createBoletoGenerator(Mockito.any(Boleto.class));

		resource.boletoAsPng("1234", "xxx");

		Mockito.verify(mockBoletoGenerator, Mockito.times(1)).toPNG();
	}

	@Before
	public void setup() {
		UriInfo mockUriInfo = Mockito.mock(UriInfo.class);

		resource = new BoletoResource(ec, mockUriInfo);

		mockInvoice.setExternalId("1234");
		mockInvoice.setValidationKey("xxx");
		mockInvoice.setBoletoRelationship(mockBoleto);
	}
}
