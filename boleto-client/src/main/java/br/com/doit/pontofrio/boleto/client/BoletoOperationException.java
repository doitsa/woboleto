package br.com.doit.pontofrio.boleto.client;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class BoletoOperationException extends Exception
{
	public BoletoOperationException()
	{
		super();
	}

	public BoletoOperationException( final String message )
	{
		super( message );
	}

	public BoletoOperationException( final String message, final Throwable cause )
	{
		super( message, cause );
	}

	public BoletoOperationException( final Throwable cause )
	{
		super( cause );
	}
}
