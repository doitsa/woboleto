
package br.com.doit.boleto.test.bancos;
import java.util.Vector;

import org.jboleto.JBoletoBean;
import org.jboleto.bancos.BancoBrasil;
import org.jboleto.control.Generator;
import org.jboleto.control.HtmlGenerator;
import org.junit.Assert;
import org.junit.Test;


public class TestBancoBrasil {
    
	@Test
	public void generateHTML() {
		JBoletoBean jBoletoBean = new JBoletoBean();
		
		jBoletoBean.setDataDocumento("31/05/2006");
        jBoletoBean.setDataProcessamento("31/05/2006");      
            
        jBoletoBean.setCedente("KOBI System");  
        jBoletoBean.setCarteira("17");

        jBoletoBean.setNomeSacado("ARCOR");
        jBoletoBean.setEnderecoSacado("Rua Teste");        
        jBoletoBean.setBairroSacado("Barra");
        jBoletoBean.setCidadeSacado("Rio de Janeiro");
        jBoletoBean.setUfSacado("RJ");
        jBoletoBean.setCepSacado("22753-501");
        jBoletoBean.setCpfSacado("0000000000000");
        
        jBoletoBean.setLocalPagamento("ATE O VENCIMENTO, PREFERENCIALMENTE NO BANCO DO BRASIL");
        jBoletoBean.setLocalPagamento2("APOS O VENCIMENTO, SOMENTE NO BANCO DO BRASIL");        
        
        Vector descricoes = new Vector();
        jBoletoBean.setDescricoes(descricoes);
        
        jBoletoBean.setDataVencimento("10/06/2006");
        jBoletoBean.setInstrucao1("APOS O VENCIMENTO COBRAR MULTA DE 2%");
        jBoletoBean.setInstrucao2("APOS O VENCIMENTO COBRAR R$ 0,50 POR DIA DE ATRASO");
        jBoletoBean.setInstrucao3("");
        jBoletoBean.setInstrucao4("");

        jBoletoBean.setAgencia("3415");
        jBoletoBean.setContaCorrente("00543004"); //completar com zeros quando necessario
               
        jBoletoBean.setNumConvenio("1101354");
        jBoletoBean.setNossoNumero("0005963971",10);
        jBoletoBean.setValorBoleto("1.00");
        
        Generator generator = new HtmlGenerator();
        
        generator.addBoleto(jBoletoBean, new BancoBrasil(jBoletoBean));
        
        Assert.assertNotNull(  generator.toString() );
        
        System.out.println( ">>> " +  generator.toString());
            
	}
}
