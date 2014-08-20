package br.com.woboleto.model;

import java.util.Calendar;

import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.woboleto.stella.StellaBoleto;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

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
		Boleto boleto = (Boleto) novoBoleto();

		Datas datas = Datas.novasDatas();

		if(dataDocumento() != null)
		{
			datas.comDocumento(convertDate(dataDocumento()));
		}

		if(dataProcessamento() != null)
		{
			datas.comProcessamento(convertDate(dataProcessamento()));
		}

		if(dataVencimento() != null)
		{
			datas.comVencimento(convertDate(dataVencimento()));
		}

		boleto.comDatas(datas);
		boleto.comBeneficiario(beneficiario().toStellaBeneficiario());
		boleto.comPagador(pagador().toStellaPagador());
		boleto.comDescricoes(stringArrayDe(descricoes()));
		boleto.comInstrucoes(stringArrayDe(instrucoes()));
		boleto.comLocaisDePagamento(stringArrayDe(locaisPagamento()));


		if(aceite() != null)
		{
			boleto.comAceite(aceite());
		}

		if(especieDocumento() != null)
		{
			boleto.comEspecieDocumento(especieDocumento());
		}

		if(numeroDocumento() != null)
		{
			boleto.comNumeroDoDocumento(numeroDocumento());
		}

		if(quantidadeMoeda() != null)
		{
			boleto.comQuantidadeMoeda(quantidadeMoeda());
		}

		if(valor() != null)
		{
			boleto.comValorBoleto(valor());
		}

		if(valorMoeda() != null)
		{
			boleto.comValorMoeda(valorMoeda());
		}

		if(banco() != null)
		{
			boleto.comBanco(banco().toStellaBanco());

			switch (banco()) {
			case ITAU:
				fixBoletoItau(boleto);
				break;

			default:
				break;
			}
		}

		return boleto;
	}

	private void fixBoletoItau(Boleto boleto) {
		Beneficiario beneficiario = boleto.getBeneficiario();
		Banco banco = boleto.getBanco();

		String agencia = beneficiario.getAgenciaFormatada();
		String contaCorrente = banco.getCodigoBeneficiarioFormatado(beneficiario);
		String carteira = banco.getCarteiraFormatado(beneficiario);
		String nossoNumero = banco.getNossoNumeroFormatado(beneficiario);

		String digito = Integer.toString(banco.getGeradorDeDigito().geraDigitoMod10(agencia + contaCorrente + carteira + nossoNumero));

		boleto.comBeneficiario(beneficiario.comDigitoNossoNumero(digito));
	}
	
public String calcularDigitoVerificadorNossoNumero (Beneficiario beneficiario) {
		
		DigitoPara digitoPara = new DigitoPara(leftPadWithZeros(beneficiario.getNossoNumero(), 12));

		
		int digito = Integer.parseInt(digitoPara.comMultiplicadoresDeAte(2,9)
				.mod(11)

		.trocandoPorSeEncontrar("0", 1)
		.trocandoPorSeEncontrar("1", 10)
		.calcula());
		
		if (digito > 1) {		
			digito = 11-digito;
		}
		return String.valueOf(digito);
	}
	
	private Boleto novoBoleto() {
		if (this.isNewObject()) {
			return Boleto.novoBoleto();
		} else {
			StellaBoleto boleto = new StellaBoleto();
			boleto.comCodigoDeBarras(codigoDeBarras());
			boleto.comLinhaDigitavel(linhaDigitavel());
			boleto.comCodigoEspecieMoeda(9);
			return boleto;
		}
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
