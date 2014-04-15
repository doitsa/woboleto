package br.com.doit.boleto.providers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang.UnhandledException;
import org.codehaus.jackson.map.ObjectMapper;

import com.webobjects.eoaccess.EOAttribute;
import com.webobjects.eoaccess.EOEntity;
import com.webobjects.eoaccess.EORelationship;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;

import er.extensions.eof.ERXEC;
import er.extensions.eof.ERXEOControlUtilities;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class EnterpriseObjectReader<T extends EOEnterpriseObject> implements MessageBodyReader<T> {
	private static final List<JsonFormatter<?>> FORMATTERS = new ArrayList<JsonFormatter<?>>();

	static {
		FORMATTERS.add(new EnumJsonFormatter());
		FORMATTERS.add(new NumberJsonFormatter());
		FORMATTERS.add(new DateJsonFormatter());
		FORMATTERS.add(new AnyObjectJsonFormatter());
	}

	@Override
	public boolean isReadable(Class<?> clazz, Type type, Annotation[] annotations, MediaType mediaType) {
		String tipo = mediaType.getType() + "/" + mediaType.getSubtype();
		return tipo.equals(MediaType.APPLICATION_JSON) && EOEnterpriseObject.class.isAssignableFrom(clazz);
	}

	@Override
	public T readFrom(Class<T> clazz, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> map, InputStream input) throws IOException, WebApplicationException {
		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		Map<String, Object> data = mapper.readValue(input, Map.class);
		
		EOEditingContext editingContext = ERXEC.newEditingContext();

		T eo = ERXEOControlUtilities.createAndInsertObject(editingContext, clazz);

		populateEO(eo, data);

		return eo;
	}

	private void populateEO(EOEnterpriseObject eo, Map<String, Object> data) {
		Set<String> keys = data.keySet();

		EOEntity entity = EOUtilities.entityForObject(eo.editingContext(), eo);

		for (String key : keys) {
			EOAttribute attribute = entity.attributeNamed(key);
			EORelationship relationship = entity.relationshipNamed(key);

			if (attribute != null) {
				populateEOAttribute(eo, data, attribute);
			} else if (relationship != null) {
				populateEORelationship(eo, data, relationship);
			} else {
				throw new WebApplicationException("The entity " + entity.name() + " has neither an attribute nor a relationship named '" + key + "'.", 400);
			}
		}
	}

	private void populateEOAttribute(EOEnterpriseObject eo, Map<String, Object> data, EOAttribute attribute) {
		String className = attribute.valueTypeClassName();
		String key = attribute.name();

		try {
			Class<?> attributeClass = Class.forName(className);

			for (JsonFormatter<?> formatter : FORMATTERS) {
				if (formatter.canFormat(attributeClass)) {
					Object value = formatter.format(attributeClass, data.get(key));

					eo.takeValueForKey(value, key);

					break;
				}
			}
		} catch (ClassNotFoundException exception) {
			throw new UnhandledException(exception);
		}
	}

	private void populateEORelationship(EOEnterpriseObject eo, Map<String, Object> data, EORelationship relationship) {
		String key = relationship.name();
		Object value = data.get(key);

		if (value == null) {
			return;
		}

		EOEntity destinationEntity = relationship.destinationEntity();

		if (relationship.isToMany()) {
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> listOfData = (List<Map<String, Object>>) value;

			for (Map<String, Object> relatedData : listOfData) {
				EOEnterpriseObject relatedEO = createAndPopulateEO(destinationEntity.name(), relatedData, eo.editingContext());

				eo.addObjectToBothSidesOfRelationshipWithKey(relatedEO, key);
			}
		} else {
			@SuppressWarnings("unchecked")
			EOEnterpriseObject relatedEO = createAndPopulateEO(destinationEntity.name(), (Map<String, Object>) value, eo.editingContext());

			eo.takeValueForKey(relatedEO, key);
		}
	}

	private EOEnterpriseObject createAndPopulateEO(String entityName, Map<String, Object> data, EOEditingContext editingContext) {
		EOEnterpriseObject eo = ERXEOControlUtilities.createAndInsertObject(editingContext, entityName);

		populateEO(eo, data);

		return eo;
	}
}
