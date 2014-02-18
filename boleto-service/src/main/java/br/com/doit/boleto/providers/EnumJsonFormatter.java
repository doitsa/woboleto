package br.com.doit.boleto.providers;

public class EnumJsonFormatter implements JsonFormatter<Enum<?>> {
	@Override
	public boolean canFormat(Class<?> clazz) {
		return Enum.class.isAssignableFrom(clazz);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  Enum<?> format(Class<?> clazz, Object rawValue) {
		return Enum.valueOf((Class<Enum>) clazz, rawValue.toString());
	}
}