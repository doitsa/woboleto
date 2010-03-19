package br.com.doit.pontofrio.boleto.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class DateConverter implements Converter
{
	private static final DateFormat FORMATTER = new SimpleDateFormat( "dd/MM/yyyy" );

	public DateConverter()
	{
		super();
	}

	public boolean canConvert( final Class clazz )
	{
		return Date.class.isAssignableFrom( clazz );
	}

	public void marshal( final Object value, final HierarchicalStreamWriter writer, final MarshallingContext context )
	{
		Date date = (Date) value;

		writer.setValue( FORMATTER.format( date ) );
	}

	public Object unmarshal( final HierarchicalStreamReader reader, final UnmarshallingContext context )
	{
		try
		{
			return FORMATTER.parse( reader.getValue() );
		}
		catch( ParseException exception )
		{
			throw new ConversionException( exception );
		}
	}
}
