package br.com.doit.boleto.templates;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.jboleto.JBoletoBean;

import com.webobjects.foundation.NSTimestamp;

/** Wrapper para JBoletoBean com mais informacoes de banco */
public abstract class WOBoletoBean extends JBoletoBean
{

	/** formatador padrao para datas */
	public static final SimpleDateFormat DATA_FORMATTER = new SimpleDateFormat( "dd/MM/yyyy" );

	protected int banco;

	protected NSTimestamp dataCriada;

	protected String email;

	public WOBoletoBean()
	{

		dataCriada = new NSTimestamp();

		setDataDocumento( DATA_FORMATTER.format( dataCriada ) );
		setDataProcessamento( DATA_FORMATTER.format( dataCriada ) );

		setEnderecoSacado( "" );
		setBairroSacado( "" );
		setCidadeSacado( "" );
		setCepSacado( "" );
		setCpfSacado( "" );
		setUfSacado( "" );

	}

	@Override
	public void setEnderecoSacado( String enderecoSacado )
	{
		super.setEnderecoSacado( StringUtils.trimToEmpty( enderecoSacado ) );
	}

	@Override
	public void setBairroSacado( String bairroSacado )
	{
		super.setBairroSacado( StringUtils.trimToEmpty( bairroSacado ) );
	}

	@Override
	public void setCidadeSacado( String cidadeSacado )
	{
		super.setCidadeSacado( StringUtils.trimToEmpty( cidadeSacado ) );
	}

	@Override
	public void setCepSacado( String cepSacado )
	{
		super.setCepSacado( StringUtils.trimToEmpty( cepSacado ) );
	}

	@Override
	public void setCpfSacado( String cpfSacado )
	{
		super.setCpfSacado( StringUtils.trimToEmpty( cpfSacado ) );
	}

	@Override
	public void setUfSacado( String ufSacado )
	{
		super.setUfSacado( StringUtils.trimToEmpty( ufSacado ) );
	}

	public int getBanco()
	{
		return banco;
	}

	public void setBanco( int banco )
	{
		this.banco = banco;
	}

	public void setDataVencimento( NSTimestamp date )
	{

		setDataVencimento( DATA_FORMATTER.format( date ) );

	}

	public NSTimestamp getDataCriada()
	{
		return dataCriada;
	}

	public void setDataCriada( NSTimestamp dataCriada )
	{
		this.dataCriada = dataCriada;
	}

	private boolean isFilled( String campo )
	{
		return campo != null && !campo.equals( "" );
	}

	/** para definir quais dados sao obrigatorios mesmo */
	public boolean validate()
	{

		if( !isFilled( getCedente() ) )
		{
			return false;
		};
		if( !isFilled( getCarteira() ) )
		{
			return false;
		};

		if( !isFilled( getNomeSacado() ) )
		{
			return false;
		};
		// if(!isFilled(getEnderecoSacado())) { return false;};
		// if(!isFilled(getBairroSacado())) { return false;};
		// if(!isFilled(getCidadeSacado())) { return false;};
		// if(!isFilled(getUfSacado())) { return false;};
		// if(!isFilled(getCepSacado())) { return false;};
		// if(!isFilled(getCpfSacado())) { return false;};

		if( !isFilled( getDataVencimento() ) )
		{
			return false;
		};

		if( !isFilled( getAgencia() ) )
		{
			return false;
		};
		if( !isFilled( getContaCorrente() ) )
		{
			return false;
		};
		if( !isFilled( getDvContaCorrente() ) )
		{
			return false;
		};

		if( !isFilled( getNumConvenio() ) )
		{
			return false;
		};
		if( !isFilled( getNossoNumero() ) )
		{
			return false;
		};

		if( !isFilled( getValorBoleto() ) )
		{
			return false;
		};

		return true;

	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	/** formatar nosso numero segundo caracteristica do banco */
	public abstract void setNossoNumeroBanco( String nossoNumero );

}
