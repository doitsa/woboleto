package br.com.doit.boleto.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public Date converterData(String data) {
		Date date = null;
		try {
			date = dateFormatter.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
