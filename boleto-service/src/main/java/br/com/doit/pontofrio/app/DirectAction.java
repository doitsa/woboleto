// Generated by the Maven Archetype Plug-in
package br.com.doit.pontofrio.app;

import br.com.doit.pontofrio.components.Main;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WODirectAction;
import er.extensions.appserver.ERXDirectAction;

public class DirectAction extends ERXDirectAction {
	public DirectAction( WORequest request ) {
		super( request );
	}

	public WOActionResults defaultAction() {
		return pageWithName( Main.class.getName() );
	}
}
