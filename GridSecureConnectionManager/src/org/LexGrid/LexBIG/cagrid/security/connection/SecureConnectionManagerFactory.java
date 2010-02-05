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
