package br.com.woboleto.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import er.extensions.eof.ERXEOControlUtilities;

public class EORequisicao extends _EORequisicao {
	@Override
	public void willInsert() {
		super.willInsert();

		Integer resultado = maiorSequencial();

		if (resultado == null) {
			resultado = 0;
		}

		setSequential(resultado + 1);
		
		try {
			setHash(criarMd5("woboleto"+sequential()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	Integer maiorSequencial() {
		return (Integer) ERXEOControlUtilities.aggregateFunctionWithQualifier(
				editingContext(), ENTITY_NAME, SEQUENTIAL_KEY, "MAX", null);
	}

	String criarMd5(String senha) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		return hash.toString(16);
	}
}
