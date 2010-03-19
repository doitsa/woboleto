// Generated by the Maven Archetype Plug-in
package br.com.doit.pontofrio.app;

import br.com.doit.pontofrio.components.Main;

import com.webobjects.appserver.WOSession;
import com.webobjects.foundation.NSLog;

import er.extensions.appserver.ERXApplication;
import er.extensions.foundation.ERXPatcher;
import er.extensions.foundation.ERXProperties;

public class Application extends ERXApplication
{
	public static void main( final String[] argv )
	{
		ERXApplication.main( argv, Application.class );
	}

	public Application()
	{
		super();

		NSLog.out.appendln( "Welcome to " + name() + " !" );

		ERXProperties.setStringForKey( "jdbc:derby:target/boleto;create=true", "dbConnectURLGLOBAL" );
		ERXProperties.setStringForKey( "WOBRDerbyPlugIn", "dbConnectPluginGLOBAL" );
		ERXProperties.setStringForKey( "EOJDBCDerbyPrototypes", "dbEOPrototypesEntityGLOBAL" );
		ERXProperties.setStringForKey( "org.apache.derby.jdbc.EmbeddedDriver", "dbConnectDriverGLOBAL" );
	}

	/**
	 * Determines the WOSession class to instantiate.
	 * 
	 * @see com.webobjects.appserver.WOApplication#_sessionClass()
	 */
	@Override
	protected Class<? extends WOSession> _sessionClass()
	{
		return Session.class;
	}

	/**
	 * Install patches including ensuring that Main is correctly resolved at
	 * runtime.
	 * 
	 * @see er.extensions.appserver.ERXApplication#installPatches()
	 */
	@Override
	public void installPatches()
	{
		super.installPatches();

		ERXPatcher.setClassForName( Main.class, "Main" );
	}
}
