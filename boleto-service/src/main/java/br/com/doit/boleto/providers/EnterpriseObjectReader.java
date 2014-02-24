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
public class EnterpriseObjectReader<T extends EOEnterpriseObject> implements
		MessageBodyReader<T> {
	private static final List<JsonFormatter<?>> FORMATTERS = new ArrayList<JsonFormatter<?>>();

	static {
		FORMATTERS.add(new EnumJsonFormatter());
		FORMATTERS.add(new NumberJsonFormatter());
		FORMATTERS.add(new DateJsonFormatter());
		FORMATTERS.add(new AnyObjectJsonFormatter());
	}

	private final EOEditingContext editingContext;

	public EnterpriseObjectReader() {
		super();

		editingContext = ERXEC.newEditingContext();
	}

	@Override
	public boolean isReadable(Class<?> clazz, Type type, Annotation[] annotations,
			MediaType mediaType) {
		String tipo = mediaType.getType()+"/"+mediaType.getSubtype();
		return tipo.equals(MediaType.APPLICATION_JSON) && EOEnterpriseObject.class.isAssignableFrom(clazz);
	}

	@Override
	public T readFrom(Class<T> clazz, Type type, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, String> map,
			InputStream input) throws IOException, WebApplicationException {
		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		Map<String, Object> data = mapper.readValue(input, Map.class);

		T eo = ERXEOControlUtilities.createAndInsertObject(editingContext,
				clazz);

		populateEO(eo, data);

		return eo;
	}

	private void populateEO(EOEnterpriseObject eo, Map<String, Object> data) {
		Set<String> keys = data.keySet();

		for (String key : keys) {
			EOEntity entity = EOUtilities.entityForObject(editingContext, eo);

			EOAttribute attribute = entity.attributeNamed(key);

			if (attribute == null) {
				EORelationship relationship = entity.relationshipNamed(key);

				EOEntity destinationEntity = relationship.destinationEntity();

				List<Map<String, Object>> listOfData;

				if (relationship.isToMany()) {
					listOfData = (List<Map<String, Object>>) data.get(key);
				} else {
					listOfData = new ArrayList<Map<String, Object>>(1);

					listOfData.add((Map<String, Object>) data.get(key));
				}

				for (Map<String, Object> relatedData : listOfData) {
					EOEnterpriseObject relatedEO = ERXEOControlUtilities
							.createAndInsertObject(editingContext,
									destinationEntity.name());

					if (relationship.isToMany()) {
						eo.addObjectToBothSidesOfRelationshipWithKey(relatedEO,
								key);
					} else {
						eo.takeValueForKey(relatedEO, key);
					}

					populateEO(relatedEO, relatedData);
				}

				continue;
			}

			String className = attribute.className();

			try {
				Class<?> attributeClass = Class.forName(className);

				for (JsonFormatter<?> formatter : FORMATTERS) {
					if (formatter.canFormat(attributeClass)) {
						Object value = formatter.format(attributeClass,
								data.get(key));

						eo.takeValueForKey(value, key);

						break;
					}
				}
			} catch (ClassNotFoundException exception) {
				exception.printStackTrace();
			}
		}
	}
}
