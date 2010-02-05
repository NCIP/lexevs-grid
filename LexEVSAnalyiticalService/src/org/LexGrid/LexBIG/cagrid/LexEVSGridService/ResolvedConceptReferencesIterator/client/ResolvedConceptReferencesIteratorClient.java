/*******************************************************************************
 * Copyright: (c) 2004-2007 Mayo Foundation for Medical Education and 
 * Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 * 
 * Except as contained in the copyright notice above, or as used to identify 
 * MFMER as the author of this software, the trade names, trademarks, service
 * marks, or product names of the copyright holder shall not be used in
 * advertising, promotion or otherwise in connection with this software without
 * prior written authorization of the copyright holder.
 *   
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *   
 *  		http://www.eclipse.org/legal/epl-v10.html
 * 
 *  		
 *******************************************************************************/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.client;

import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

import java.io.InputStream;
import java.rmi.RemoteException;

import org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.common.ResolvedConceptReferencesIteratorI;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.ResolvedConceptReferencesIteratorPortType;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.service.ResolvedConceptReferencesIteratorServiceAddressingLocator;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;
import org.globus.gsi.GlobusCredential;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS
 * METHODS.
 * 
 * This client is generated automatically by Introduce to provide a clean
 * unwrapped API to the service.
 * 
 * On construction the class instance will contact the remote service and
 * retrieve it's security metadata description which it will use to configure
 * the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.1
 */
public class ResolvedConceptReferencesIteratorClient extends
		ServiceSecurityClient implements ResolvedConceptReferencesIteratorI {
	protected ResolvedConceptReferencesIteratorPortType portType;
	private Object portTypeMutex;

	public ResolvedConceptReferencesIteratorClient(String url)
			throws MalformedURIException, RemoteException {
		this(url, null);
	}

	public ResolvedConceptReferencesIteratorClient(String url,
			GlobusCredential proxy) throws MalformedURIException,
			RemoteException {
		super(url, proxy);
		initialize();
	}

	public ResolvedConceptReferencesIteratorClient(EndpointReferenceType epr)
			throws MalformedURIException, RemoteException {
		this(epr, null);
	}

	public ResolvedConceptReferencesIteratorClient(EndpointReferenceType epr,
			GlobusCredential proxy) throws MalformedURIException,
			RemoteException {
		super(epr, proxy);
		initialize();
	}

	private void initialize() throws RemoteException {
		this.portTypeMutex = new Object();
		this.portType = createPortType();
	}

	private ResolvedConceptReferencesIteratorPortType createPortType()
			throws RemoteException {

		ResolvedConceptReferencesIteratorServiceAddressingLocator locator = new ResolvedConceptReferencesIteratorServiceAddressingLocator();
		// attempt to load our context sensitive wsdd file
		InputStream resourceAsStream = getClass().getResourceAsStream(
				"client-config.wsdd");
		if (resourceAsStream != null) {
			// we found it, so tell axis to configure an engine to use it
			EngineConfiguration engineConfig = new FileProvider(
					resourceAsStream);
			// set the engine of the locator
			locator.setEngine(new AxisClient(engineConfig));
		}
		ResolvedConceptReferencesIteratorPortType port = null;
		try {
			port = locator
					.getResolvedConceptReferencesIteratorPortTypePort(getEndpointReference());
		} catch (Exception e) {
			throw new RemoteException("Unable to locate portType:"
					+ e.getMessage(), e);
		}

		return port;
	}

	public static void usage() {
		System.out.println(ResolvedConceptReferencesIteratorClient.class
				.getName()
				+ " -url <service url>");
	}

	public static void main(String[] args) {
		System.out.println("Running the Grid Service Client");
		try {
			if (!(args.length < 2)) {
				if (args[0].equals("-url")) {
					ResolvedConceptReferencesIteratorClient client = new ResolvedConceptReferencesIteratorClient(
							args[1]);
					// place client calls here if you want to use this main as a
					// test....
				} else {
					usage();
					System.exit(1);
				}
			} else {
				usage();
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

  public org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference next() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"next");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.NextRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.NextRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.NextResponse boxedResult = portType.next(params);
    return boxedResult.getResolvedConceptReference();
    }
  }

  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList nextInt(int maxToReturn) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"nextInt");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.NextIntRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.NextIntRequest();
    params.setMaxToReturn(maxToReturn);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.NextIntResponse boxedResult = portType.nextInt(params);
    return boxedResult.getResolvedConceptReferenceList();
    }
  }

  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList get(int start,int end) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"get");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.GetRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.GetRequest();
    params.setStart(start);
    params.setEnd(end);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.GetResponse boxedResult = portType.get(params);
    return boxedResult.getResolvedConceptReferenceList();
    }
  }

  public void scroll(int maxToReturn) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"scroll");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.ScrollRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.ScrollRequest();
    params.setMaxToReturn(maxToReturn);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.ScrollResponse boxedResult = portType.scroll(params);
    }
  }

  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList getNext() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getNext");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.GetNextRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.GetNextRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.GetNextResponse boxedResult = portType.getNext(params);
    return boxedResult.getResolvedConceptReferenceList();
    }
  }

  public boolean hasNext() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"hasNext");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.HasNextRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.HasNextRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.HasNextResponse boxedResult = portType.hasNext(params);
    return boxedResult.isResponse();
    }
  }

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getMultipleResourceProperties");
    return portType.getMultipleResourceProperties(params);
    }
  }

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getResourceProperty");
    return portType.getResourceProperty(params);
    }
  }

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"queryResourceProperties");
    return portType.queryResourceProperties(params);
    }
  }

  public int numberRemaining() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"numberRemaining");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.NumberRemainingRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.NumberRemainingRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.NumberRemainingResponse boxedResult = portType.numberRemaining(params);
    return boxedResult.getResponse();
    }
  }

  public org.oasis.wsrf.lifetime.DestroyResponse destroy(org.oasis.wsrf.lifetime.Destroy params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"destroy");
    return portType.destroy(params);
    }
  }

  public org.oasis.wsrf.lifetime.SetTerminationTimeResponse setTerminationTime(org.oasis.wsrf.lifetime.SetTerminationTime params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"setTerminationTime");
    return portType.setTerminationTime(params);
    }
  }

}
