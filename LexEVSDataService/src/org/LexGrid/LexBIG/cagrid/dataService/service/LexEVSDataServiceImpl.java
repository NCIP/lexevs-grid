package org.LexGrid.LexBIG.cagrid.dataService.service;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.caCore.interfaces.LexEVSApplicationService;
import org.LexGrid.LexBIG.cagrid.dataService.stubs.types.LexEVSDataServiceReference;
import org.LexGrid.LexBIG.cagrid.security.connection.SecureConnectionManager;
import org.LexGrid.LexBIG.cagrid.security.connection.SecureConnectionManagerFactory;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.log4j.Logger;

/** 
 * TODO:I am the service side implementation class.  IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class LexEVSDataServiceImpl extends LexEVSDataServiceImplBase {

	private static Logger log = Logger.getLogger(LexEVSDataServiceImpl.class.getName());
	 
	private SecureConnectionManager<LexEVSApplicationService> manager;
	
	public LexEVSDataServiceImpl() throws RemoteException {
		super();
		try {
			manager = SecureConnectionManagerFactory.getInstance().getSecureConnectionManager();
		} catch (Exception e) {
			log.error("Error connecting to LexEVS Data Service.", e);
			throw new RemoteException(e.getMessage());
		}		
	}
	
  public org.LexGrid.LexBIG.cagrid.dataService.stubs.types.LexEVSDataServiceReference registerSecurityToken(java.lang.String codingSchemeUri,gov.nih.nci.evs.security.SecurityToken securityToken) throws RemoteException {
	  org.apache.axis.MessageContext messagectx = org.apache.axis.MessageContext
	  .getCurrentContext();
	  LexEVSDataServiceReference ref = new LexEVSDataServiceReference();
	  
	try {
		EndpointReferenceType epr = manager.processSecurityToken(messagectx, codingSchemeUri, securityToken);
		ref.setEndpointReference(epr);
		return ref;
	} catch (Exception e) {
		throw new RemoteException(e.getMessage());
	}
  }
}

