package br.com.woboleto.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.UnhandledException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import er.extensions.eof.ERXEOControlUtilities;

public class EORequisicao extends _EORequisicao {
	
	final Logger logger = LoggerFactory.getLogger(EORequisicao.class);
	
	@Override
	public void willInsert() {
		super.willInsert();

		Integer resultado = maiorSequencial();

		logger.info("DEPOIS DE VERIFICAR MAX DE REQUISICAO. ID: "+resultado);
		
		if (resultado == null) {
			resultado = 0;
		}

		setSequential(resultado + 1);
		
		try {
			setHash(criarMd5("woboleto"+sequential()));
		} catch (NoSuchAlgorithmException e) {
			logger.error("Erro ao criar o hash",e);
			throw new UnhandledException(e);
		}
	}

	Integer maiorSequencial() {
		logger.info("ANTES DE VERIFICAR MAX DE REQUISICAO");
		return (Integer) ERXEOControlUtilities.aggregateFunctionWithQualifier(
				editingContext(), ENTITY_NAME, SEQUENTIAL_KEY, "MAX", null);
	}

	String criarMd5(String senha) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		return hash.toString(16);
	}
}
