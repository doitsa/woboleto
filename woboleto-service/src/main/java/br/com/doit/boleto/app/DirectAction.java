// Generated by the Maven Archetype Plug-in
package br.com.doit.boleto.app;

import br.com.doit.boleto.components.Main;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;

import er.extensions.appserver.ERXDirectAction;

public class DirectAction extends ERXDirectAction
{
	public DirectAction(WORequest request)
	{
		super(request);
	}

	@Override
	public WOActionResults defaultAction()
	{
		return pageWithName(Main.class.getName());
	}
}
