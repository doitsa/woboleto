package br.com.doit.boleto.providers;

import java.math.BigDecimal;

public class BigDecimalJsonFormatter implements JsonFormatter<BigDecimal> {
	@Override
	public boolean canFormat(Class<?> clazz) {
		return BigDecimal.class.isAssignableFrom(clazz);
	}

	@Override
	public BigDecimal format(Class<?> clazz, Object rawValue) {
		return new BigDecimal(rawValue.toString());
	}

}
