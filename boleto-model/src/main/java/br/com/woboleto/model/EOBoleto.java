package br.com.woboleto.model;

import java.util.Calendar;

import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;

import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class EOBoleto extends _EOBoleto
{
	public static EOBoleto createEOBoleto(final EOEditingContext editingContext)
	{
		return (EOBoleto) EOUtilities.createAndInsertInstance(editingContext, ENTITY_NAME);
	}

	@Override
	public void awakeFromInsertion(final EOEditingContext editingContext)
	{
		super.awakeFromInsertion(editingContext);

		if(aceite() == null)
		{
			setAceite(Boolean.FALSE);
		}

		if(emissor() == null)
		{
			setEmissorRelationship(EOEmissor.createEOEmissor(editingContext));
		}

		if(sacado() == null)
		{
			setSacadoRelationship(EOSacado.createEOSacado(editingContext));
		}
	}

	private Calendar convertDate(final NSTimestamp date)
	{
		if(date == null)
		{
			return null;
		}

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		return calendar;
	}

	@SuppressWarnings("unchecked")
	private String[] stringArrayDe(final NSArray<? extends AbstractInformacao> informacoes)
	{
		return ((NSArray<String>) informacoes.valueForKeyPath(AbstractInformacao.VALOR_KEY)).toArray(new String[] {});
	}

	public Boleto toStellaBoleto()
	{
		Boleto boleto = Boleto.newBoleto();

		Datas datas = Datas.newDatas();

		if(dataDocumento() != null)
		{
			datas.withDocumento(convertDate(dataDocumento()));
		}

		if(dataProcessamento() != null)
		{
			datas.withProcessamento(convertDate(dataProcessamento()));
		}

		if(dataVencimento() != null)
		{
			datas.withVencimento(convertDate(dataVencimento()));
		}

		boleto.withDatas(datas);
		boleto.withEmissor(emissor().toStellaEmissor());
		boleto.withSacado(sacado().toStellaSacado());
		boleto.withDescricoes(stringArrayDe(descricoes()));
		boleto.withInstrucoes(stringArrayDe(instrucoes()));
		boleto.withLocaisDePagamento(stringArrayDe(locaisPagamento()));

		if(aceite() != null)
		{
			boleto.withAceite(aceite());
		}

		if(especieDocumento() != null)
		{
			boleto.withEspecieDocumento(especieDocumento());
		}

		if(numeroDocumento() != null)
		{
			boleto.withNumeroDoDocumento(numeroDocumento());
		}

		if(quantidadeMoeda() != null)
		{
			boleto.withQuantidadeMoeda(quantidadeMoeda());
		}

		if(valor() != null)
		{
			boleto.withValorBoleto(valor());
		}

		if(valorMoeda() != null)
		{
			boleto.withValorMoeda(valorMoeda());
		}

		if(banco() != null)
		{
			boleto.withBanco(banco().toStellaBanco());
		}

		return boleto;
	}

	@Override
	public void validateForSave() throws ValidationException
	{
		super.validateForSave();

		if(locaisPagamento().size() > 2)
		{
			throw new ValidationException("O boleto pode conter no m\u00e1ximo 2 locais de pagamento");
		}
	}
}
