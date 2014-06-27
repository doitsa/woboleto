package br.com.doit.boleto.providers;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import br.com.woboleto.model.BancoEnum;
import br.com.woboleto.model.EOBoleto;

import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSTimestamp;
import com.wounit.rules.MockEditingContext;

/**
 * @author rdskill
 */
public class TestEnterpriseObjectReader {

	@Rule
	public MockEditingContext editingContext = new MockEditingContext("Boleto");
	private EnterpriseObjectReader<EOBoleto> reader;

	@Test
	public void returnEnterpriseObjectWhenParsingJson() throws Exception {
		EOEnterpriseObject result = reader.readFrom(EOBoleto.class, null, null,
				null, null, getClass().getResourceAsStream("/boleto1.json"));

		assertThat(result, notNullValue());
		assertThat(result, instanceOf(EOBoleto.class));
		assertThat(editingContext.insertedObjects(), hasItem(result));
	}

	@Test
	public void objectIsReadableWhenObjectTypeIsEnterpriseObjectAndMediaTypeJSON()
			throws Exception {
		boolean result = reader.isReadable(EOBoleto.class, null, null,
				MediaType.APPLICATION_JSON_TYPE);

		assertThat(result, is(true));
	}

	@Test
	public void objectIsNotReadableWhenTypeIsNotAnEnterpriseObject()
			throws Exception {
		boolean result = reader.isReadable(String.class, null, null,
				MediaType.APPLICATION_JSON_TYPE);

		assertThat(result, is(false));
	}

	@Test
	public void objectIsNotReadableWhenMediaTypeIsNotJSON() throws Exception {
		boolean result = reader.isReadable(EOBoleto.class, null, null,
				MediaType.APPLICATION_XML_TYPE);

		assertThat(result, is(false));
	}

	@Test
	public void setStringFieldWhenParsingJson() throws Exception {
		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto2.json"));

		assertThat(result.numeroDocumento(), is("1234567"));

	}

	@Test
	public void setDataFieldWhenParsingJson() throws Exception {
		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto7.json"));
		
		DateTime dataDoc = new DateTime(2014, 2, 1, 0, 0, 0, 0);
		Date dataDocumentoDate = dataDoc.toDate();
		NSTimestamp dataDocumento = new NSTimestamp(dataDocumentoDate);
		
		assertThat(result.dataDocumento(), is(dataDocumento));
	}

	@Test
	public void setEnumFieldWhenParsingJson() throws Exception {
		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto3.json"));

		assertThat(result.banco(), is(BancoEnum.ITAU));
	}

	@Test
	public void setBooleanFieldWhenParsingJson() throws Exception {
		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto8.json"));

		assertThat(result.aceite(), is(false));
	}

	@Test
	public void setBigDecimalFieldWhenParsingJson() throws Exception {
		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto5.json"));

		assertThat(result.valor(), is(new BigDecimal("10.0")));
	}

	@Test
	public void setToOneRelationshipWhenParsingJson() throws Exception {
		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto4.json"));

		assertThat(result.beneficiario(), notNullValue());
		assertThat(result.beneficiario().agencia(), is("1"));
		assertThat(editingContext.insertedObjects(), hasItem(result.beneficiario()));
	}

	@Test
	public void returnBigDecimalNullWhenNumberIsNull() throws Exception {
		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto9.json"));

		assertThat(result.valor(), is(new BigDecimal("0")));
	}

	@Test
	public void setToManyRelationshipWhenParsingJson() throws Exception {
		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto6.json"));

		assertThat(result.descricoes().size(), is(2));
		assertThat(result.descricoes().get(0).valor(), is("descricao 1"));
		assertThat(result.descricoes().get(1).valor(), is("descricao 2"));
	}

	@Test
	public void ignoreNullToManyRelationshipWhenParsingJson() throws Exception {
		InputStream json = getClass().getResourceAsStream("/boleto10.json");

		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null, null, json);

		assertThat(result.descricoes(), notNullValue());
		assertThat(result.descricoes().size(), is(0));
	}

	@Test
	public void ignoreNullToOneRelationshipWhenParsingJson() throws Exception {
		InputStream json = getClass().getResourceAsStream("/boleto11.json");

		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null, null, json);

		assertThat(result.beneficiario(), nullValue());
	}

	@Test
	public void throwExceptionWhenParsingJsonWithInvalidField() throws Exception {
		InputStream json = getClass().getResourceAsStream("/boleto12.json");

		try {
			reader.readFrom(EOBoleto.class, null, null, null, null, json);

			fail("Must throw an exception");
		} catch (WebApplicationException exception) {
			assertThat(exception.getMessage(), is("The entity EOBoleto has neither an attribute nor a relationship named 'invalid'."));
			assertThat(exception.getResponse().getStatus(), is(400));
		}
	}
	
	@Test
	public void verifyIfDataIsOkWhenSendingTwoRequisitions() throws Exception {
		EOBoleto result = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto13.json"));
				
		EOBoleto result2 = reader.readFrom(EOBoleto.class, null, null, null,
				null, getClass().getResourceAsStream("/boleto14.json"));
		
		assertThat(result.banco(), is(BancoEnum.BANCO_DO_BRASIL));
		assertThat(result.valor(), is(new BigDecimal(1000)));
		assertThat(result2.banco(), is(BancoEnum.BRADESCO));
		assertThat(result2.valor(), is(new BigDecimal(100)));
	}

	@Before
	public void setup() {
		reader = new EnterpriseObjectReader<EOBoleto>();
	}
}
