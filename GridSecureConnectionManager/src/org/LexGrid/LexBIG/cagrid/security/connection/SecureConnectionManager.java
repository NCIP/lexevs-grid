package org.LexGrid.LexBIG.cagrid.security.connection;

import gov.nih.nci.evs.security.SecurityToken;

import javax.xml.namespace.QName;

import org.LexGrid.LexBIG.caCore.security.interfaces.TokenSecurableApplicationService;
import org.apache.axis.MessageContext;
import org.apache.axis.message.addressing.EndpointReferenceType;

public interface SecureConnectionManager<T extends TokenSecurableApplicationService> {
	
	public static QName CONNECTION_QNAME = new QName("http://LexBIGCaGridServices.cagrid.LexBIG.LexGrid.org/LexBIGCaGridServices", "SecureDLBConnectionKey");
	
	public EndpointReferenceType processSecurityToken(MessageContext messagectx,
			  String codingScheme,
			  SecurityToken securityToken) throws Exception;
	
	public T getApplicationServiceFromCache(MessageContext messagectx) throws Exception;
}
