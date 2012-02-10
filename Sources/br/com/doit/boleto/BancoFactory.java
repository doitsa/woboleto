package br.com.doit.boleto;

import org.apache.log4j.Logger;
import org.jboleto.Banco;
import org.jboleto.JBoleto;
import org.jboleto.bancos.BancoBrasil;
import org.jboleto.bancos.BancoReal;
import org.jboleto.bancos.Bradesco;
import org.jboleto.bancos.CaixaEconomica;
import org.jboleto.bancos.Hsbc;
import org.jboleto.bancos.Itau;
import org.jboleto.bancos.NossaCaixa;
import org.jboleto.bancos.Santander;
import org.jboleto.bancos.Unibanco;

import br.com.doit.boleto.templates.BancoDoBrasilBoleto;
import br.com.doit.boleto.templates.BancoRealBoleto;
import br.com.doit.boleto.templates.BradescoBoleto;
import br.com.doit.boleto.templates.CaixaEconomicaBoleto;
import br.com.doit.boleto.templates.HSBCBoleto;
import br.com.doit.boleto.templates.ItauBoleto;
import br.com.doit.boleto.templates.NossaCaixaBoleto;
import br.com.doit.boleto.templates.SantanderBoleto;
import br.com.doit.boleto.templates.UnibancoBoleto;
import br.com.doit.boleto.templates.WOBoletoBean;

/** retornar os bancos que sao implementados na framework*/
public class BancoFactory {

	private static final Logger LOGGER = Logger.getLogger(BancoFactory.class);

	public static Banco createBanco(WOBoletoBean woBoletoBean)
			throws IllegalArgumentException {

		switch (woBoletoBean.getBanco()) {
		case JBoleto.BANCO_DO_BRASIL:

			return new BancoBrasil(woBoletoBean);

		case JBoleto.BANCO_REAL:

			return new BancoReal(woBoletoBean);

		case JBoleto.BRADESCO:

			return new Bradesco(woBoletoBean);

		case JBoleto.CAIXA_ECONOMICA:

			return new CaixaEconomica(woBoletoBean);

		case JBoleto.HSBC:

			return new Hsbc(woBoletoBean);

		case JBoleto.ITAU:

			return new Itau(woBoletoBean);

		case JBoleto.NOSSACAIXA:

			return new NossaCaixa(woBoletoBean);

		case JBoleto.SANTANDER:

			return new Santander(woBoletoBean);

		case JBoleto.UNIBANCO:

			return new Unibanco(woBoletoBean);

		default:

			LOGGER.error("banco desconhecido: " + woBoletoBean.getBanco());

			throw new IllegalArgumentException(
					"N\u00e3o \u00e9 poss\u00edvel gerar um boleto para o banco com c\u00f3digo "
							+ woBoletoBean.getBanco() + ".");
		}

	}

	public static WOBoletoBean createBoletoTemplate(int banco)
			throws IllegalArgumentException {

		switch (banco) {
		case JBoleto.BANCO_DO_BRASIL:

			return new BancoDoBrasilBoleto();

		case JBoleto.BANCO_REAL:

			return new BancoRealBoleto();

		case JBoleto.BRADESCO:

			return new BradescoBoleto();

		case JBoleto.CAIXA_ECONOMICA:

			return new CaixaEconomicaBoleto();

		case JBoleto.HSBC:

			return new HSBCBoleto();

		case JBoleto.ITAU:

			return new ItauBoleto();

		case JBoleto.NOSSACAIXA:

			return new NossaCaixaBoleto();

		case JBoleto.SANTANDER:

			return new SantanderBoleto();

		case JBoleto.UNIBANCO:

			return new UnibancoBoleto();

		default:

			LOGGER.error("Banco desconhecido: " + banco);

			throw new IllegalArgumentException(
					"N\u00e3o \u00e9 poss\u00edvel gerar um boleto para o banco com c\u00f3digo "
							+ banco + ".");
		}

	}
}
