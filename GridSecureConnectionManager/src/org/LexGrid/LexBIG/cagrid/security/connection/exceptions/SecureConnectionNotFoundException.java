/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.security.connection.exceptions;

public class SecureConnectionNotFoundException extends Exception {
	
	public SecureConnectionNotFoundException(String key){
		super("Secure Connection not found for key: " + key +". Either this connection has not been registered with the service," +
				" or it has expired. Please reload any Security Tokens.");
	}
}
