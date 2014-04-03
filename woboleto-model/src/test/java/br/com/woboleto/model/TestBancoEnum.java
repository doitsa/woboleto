package br.com.woboleto.model;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.bancos.Bradesco;
import br.com.caelum.stella.boleto.bancos.Caixa;
import br.com.caelum.stella.boleto.bancos.Itau;

@RunWith(Parameterized.class)
public class TestBancoEnum {
	@Parameters
	public static List<Object[]> bancos() {
		Object[][] data = new Object[][] {
				{ BancoEnum.BANCO_DO_BRASIL, BancoDoBrasil.class },
				{ BancoEnum.BRADESCO, Bradesco.class },
				{ BancoEnum.CAIXA, Caixa.class },
				{ BancoEnum.ITAU, Itau.class } };

		return Arrays.asList(data);
	}

	private final BancoEnum banco;

	private final Class<? extends Banco> classeBanco;

	public TestBancoEnum(final BancoEnum banco,
			final Class<? extends Banco> classeBanco) {
		this.banco = banco;
		this.classeBanco = classeBanco;
	}

	@Test
	public void converteParaStellaBanco() throws Exception {
		assertThat(banco.toStellaBanco(), instanceOf(classeBanco));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void excecaoSeBancoNaoImplementadoPeloStella() throws Exception {
		BancoEnum.OUTRO.toStellaBanco();
	}
}
