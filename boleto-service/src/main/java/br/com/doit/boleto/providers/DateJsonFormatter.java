package br.com.doit.boleto.providers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.webobjects.foundation.NSTimestamp;

public class DateJsonFormatter implements JsonFormatter<NSTimestamp> {

	@Override
	public boolean canFormat(Class<?> clazz) {
		return NSTimestamp.class.isAssignableFrom(clazz);
	}

	@Override
	public NSTimestamp format(Class<?> clazz, Object rawValue) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date = null;
		try {
			date = dateFormatter.parse(rawValue.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return new NSTimestamp(date);
	}

}
