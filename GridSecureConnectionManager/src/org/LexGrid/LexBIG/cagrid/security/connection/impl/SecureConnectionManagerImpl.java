/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.security.connection.impl;

import java.io.InputStream;
import java.util.Properties;

import gov.nih.nci.evs.security.SecurityToken;
import gov.nih.nci.system.client.ApplicationServiceProvider;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPHeaderElement;

import org.LexGrid.LexBIG.caCore.security.interfaces.TokenSecurableApplicationService;
import org.LexGrid.LexBIG.cagrid.security.connection.SecureConnectionManager;
import org.LexGrid.LexBIG.cagrid.security.connection.cache.SecureConnectionCache;
import org.LexGrid.LexBIG.cagrid.security.connection.exceptions.SecureConnectionNotFoundException;
import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.components.uuid.UUIDGen;
import org.apache.axis.components.uuid.UUIDGenFactory;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.log4j.Logger;
import org.globus.wsrf.ResourceKey;
import org.globus.wsrf.impl.ResourceContextImpl;
import org.globus.wsrf.impl.SimpleResourceKey;


public class SecureConnectionManagerImpl<T extends TokenSecurableApplicationService> implements SecureConnectionManager<T> {
	private static Logger log = Logger.getLogger(SecureConnectionManagerImpl.class.getName());
	
	private static final UUIDGen UUIDGEN = UUIDGenFactory.getUUIDGen();

	protected SecureConnectionCache<T> connectionCache;
	protected String _service;
	protected T unsecuredConnection;
	
	public SecureConnectionManagerImpl() throws Exception {
		Properties props = new Properties();
		try {
			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("connectionService.props");		
			props.load(inputStream);
			_service = props.getProperty("service");
		} catch (Exception e) {
			log.error("Error Reading Properties File." , e);
			throw new Exception(e);
		}

		try {
			int maxConnections;
			int keepAliveMinutes;
			try {
				maxConnections = Integer.valueOf(props.getProperty("maxConnections"));
				keepAliveMinutes = Integer.valueOf(props.getProperty("keepAliveMinutes"));
			} catch (NumberFormatException e) {
				log.error("Error Reading 'maxConnections' or 'keepAliveMinutes' from Properties file.", e);
				throw new Exception("Error Reading 'maxConnections' or 'keepAliveMinutes' from Properties file.", e);
			}
			connectionCache = new SecureConnectionCache<T>(maxConnections, keepAliveMinutes);
			unsecuredConnection = 
				(T)ApplicationServiceProvider.getApplicationService(_service);
		} catch (Exception e) {
			log.error("Error Creating Unsecured ApplicationService." , e);
			throw new Exception(e);
		}
	}
	
	public SecureConnectionManagerImpl(String service, String url) throws Exception {
		connectionCache = new SecureConnectionCache<T>();
		unsecuredConnection = 
			(T)ApplicationServiceProvider.getApplicationServiceFromUrl(service, url);
	}
	
	protected T getUnSecureConnection(){
		return unsecuredConnection;
	}
	
	protected T getSecureConnection(String key) throws SecureConnectionNotFoundException {
		 return connectionCache.get(key);	 
	}
	
	protected T createSecureConnecton(String key) throws Exception {
		T appSvc = (T)ApplicationServiceProvider.getApplicationService(_service);
		connectionCache.put(key, appSvc);
		return appSvc;		
	}
	
	protected T registerToken(String key, String codingScheme, SecurityToken token) throws Exception {
		T appservice = connectionCache.get(key);
		appservice.registerSecurityToken(codingScheme, token);
		connectionCache.put(key, appservice);
		return appservice;
	}
	protected boolean isServiceCached(String key){
		return connectionCache.containsKey(key);
	}
	
	/**
	   * Return the Key to the Secured Connection. If this EndPointReference isn't
	   * associated with a Secured Connection, create a unique key and return it.
	   * @return String
	   * 		The unique id for the Secure Connection
	   * @throws Exception
	   */
	  protected String getConnectionKey(MessageContext messagectx) throws Exception { 
		  SOAPHeaderElement connectionKey = 
			  getConnectionKeyElementFromHeader(messagectx);
		  if(connectionKey == null){
			  String id = (String)UUIDGEN.nextUUID();
			  return id;
		  } else {
			  return connectionKey.getValue();
		  }
	  }

	  /**
	   * Returns the LexBIGService from the Connection Cache. If there is
	   * no Secure Connection Key associated with this request, return the
	   * unsecured connection.
	   * @return LexBIGService
	   * 		The Secure (or unsecure) LexBIGService Connection
	   * @throws Exception
	   */ 
	  public T getApplicationServiceFromCache(MessageContext messagectx) throws Exception {
		  SOAPHeaderElement connectionKey = 
			  getConnectionKeyElementFromHeader(messagectx);

		  //if there is no Secure Connection Key in this SOAP message, get an 
		  //unsecured connection -- or else return the connection associated
		  //with the Connection Key
		  if(connectionKey == null){
			  T unSecureService = getUnSecureConnection();
			  return unSecureService;
		  } else {
			  String key = connectionKey.getValue();
			  T secureService = getSecureConnection(key);
			  return secureService;	  
		  }
	  }
	 

	  /**
	   * Returns the SOAP Header element from the current SOAP message that contains
	   * the Secure Connection Key. If there is no Secure Connection SOAP Header,
	   * return null.
	   * @return SOAPHeaderElement
	   * 			The Soap Header Element that contains the Secure Connection Key
	   * @throws Exception
	   */
	  protected SOAPHeaderElement getConnectionKeyElementFromHeader(MessageContext messagectx) throws Exception {
		  Message msg = messagectx.getRequestMessage();
		  QName property = SecureConnectionManager.CONNECTION_QNAME;

		  SOAPHeaderElement connectionKey = 
			  ResourceContextImpl.getResourceKeyHeader(msg, property, null);
		  return connectionKey;
	  }
	  
	  public EndpointReferenceType processSecurityToken(MessageContext messagectx,
			  String codingScheme,
			  SecurityToken securityToken) throws Exception {
		  //Get the Secure Connection Key for this current request. If there is no Key, 
		  //create one.
		  String id = getConnectionKey(messagectx);
		  
		  //Check to see if there is a Connection with this id cached.
		  boolean isCached = isServiceCached(id);
		  
		  //If it is cached, add this new security token. If it is not cached, create
		  //it and cache it, then add the security token
		  if(isCached){
			  registerToken(id, codingScheme, securityToken);
		  } else {
			  createSecureConnecton(id);
			  registerToken(id, codingScheme, securityToken);		  
		  }

		  String transportURL = (String) messagectx
		  .getProperty(org.apache.axis.MessageContext.TRANS_URL);

		  EndpointReferenceType epr = null;	  

		  // Create the Secured Connection Key set it
		  QName property = SecureConnectionManager.CONNECTION_QNAME;
		  ResourceKey key = new SimpleResourceKey(property, id);
		  epr = org.globus.wsrf.utils.AddressingUtils
		  .createEndpointReference(transportURL, key);
		  
		  return epr;		  
	  }
	  
	  protected SecureConnectionCache<T> getConnectionCache(){
		  return connectionCache;
	  }
	  
	  protected void setConnectionCache(SecureConnectionCache<T> connectionCache){
		  this.connectionCache = connectionCache;
	  }
	  
	
}
