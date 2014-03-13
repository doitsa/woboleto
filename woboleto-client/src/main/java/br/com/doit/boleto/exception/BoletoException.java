package br.com.doit.boleto.exception;

public class BoletoException extends RuntimeException {

	public BoletoException() {
		super();
	}

	public BoletoException(String message) {
		super(message);
	}

	public BoletoException(String message, Throwable cause) {
		super(message, cause);
	}

	public BoletoException(Throwable cause) {
		super(cause);
	}

}
