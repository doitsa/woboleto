package br.com.doit.boleto.providers;

public class AnyObjectJsonFormatter implements JsonFormatter<Object> {
	@Override
	public boolean canFormat(Class<?> clazz) {
		return true;
	}

	@Override
	public Object format(Class<?> clazz, Object rawValue) {
		return rawValue;
	}

}
