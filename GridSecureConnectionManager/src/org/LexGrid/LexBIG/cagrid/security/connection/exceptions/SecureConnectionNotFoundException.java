package org.LexGrid.LexBIG.cagrid.security.connection.exceptions;

public class SecureConnectionNotFoundException extends Exception {
	
	public SecureConnectionNotFoundException(String key){
		super("Secure Connection not found for key: " + key +". Either this connection has not been registered with the service," +
				" or it has expired. Please reload any Security Tokens.");
	}
}
