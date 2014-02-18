package br.com.doit.boleto.providers;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.doit.boleto.resource.BoletoResource;

@ApplicationPath("webresources")
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(BoletoResource.class);
        resources.add(EnterpriseObjectReader.class);
        return resources;
    }
}
