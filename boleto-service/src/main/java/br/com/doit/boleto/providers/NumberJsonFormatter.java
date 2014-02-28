package br.com.doit.boleto.providers;

import java.math.BigDecimal;

public class NumberJsonFormatter implements JsonFormatter<Number> {

	@Override
	public boolean canFormat(Class<?> clazz) {
		return Number.class.isAssignableFrom(clazz);
	}

	@Override
	public Number format(Class<?> clazz, Object rawValue) {
		if (rawValue != null) {
			if (Integer.class.isAssignableFrom(clazz)) {
				System.out.println(rawValue.toString());
				return new Integer(rawValue.toString());
			} else if (BigDecimal.class.isAssignableFrom(clazz)) {
				return new BigDecimal(rawValue.toString());
			} else {
				return new Long(rawValue.toString());
			}
		} else {
			return 0;
		}
	}
}
