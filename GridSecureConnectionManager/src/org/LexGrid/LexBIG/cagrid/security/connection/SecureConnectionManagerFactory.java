/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.security.connection;

import org.LexGrid.LexBIG.caCore.security.interfaces.TokenSecurableApplicationService;
import org.LexGrid.LexBIG.cagrid.security.connection.impl.SecureConnectionManagerImpl;

public class SecureConnectionManagerFactory {

	protected static SecureConnectionManagerFactory instance;
	
	protected SecureConnectionManager managerInstance;
	
	public static SecureConnectionManagerFactory getInstance() throws Exception {
		if(instance == null) {
			instance = new SecureConnectionManagerFactory();
		}
		return instance;
	}
	
	public <T extends TokenSecurableApplicationService> SecureConnectionManager<T> getSecureConnectionManager() throws Exception {
		if(managerInstance == null){
			managerInstance = new SecureConnectionManagerImpl<T>();
		}
		return managerInstance;
	}
}
