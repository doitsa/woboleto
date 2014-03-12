package br.com.doit.boleto.providers;

public interface JsonFormatter<T> {
	boolean canFormat(Class<?> clazz);

	T format(Class<?> clazz, Object rawValue);
}
