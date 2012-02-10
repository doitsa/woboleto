package br.com.doit.boleto.test.basic;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.BeforeClass;
import org.wounittest.EOFTest;

import com.webobjects.eoaccess.EOModelGroup;


public class AbstractBoletoTest extends EOFTest {
	@BeforeClass
	public static void loadModel() throws MalformedURLException {
		System.setProperty("er.extensions.ERXRaiseOnMissingEditingContextDelegate", "false");

		if (EOModelGroup.defaultGroup().modelNamed("boleto") == null) {
			URL url = new File("Resources/boleto.eomodeld").toURL();

			EOModelGroup.defaultGroup().addModelWithPathURL(url);
		}
	}
}
