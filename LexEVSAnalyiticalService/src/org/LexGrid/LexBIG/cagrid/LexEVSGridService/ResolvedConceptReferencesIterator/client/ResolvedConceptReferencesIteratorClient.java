package org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.ResolvedConceptReferencesIteratorPortType;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.stubs.service.ResolvedConceptReferencesIteratorServiceAddressingLocator;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.common.ResolvedConceptReferencesIteratorI;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.3
 */
public class ResolvedConceptReferencesIteratorClient extends ResolvedConceptReferencesIteratorClientBase implements ResolvedConceptReferencesIteratorI {	

	public ResolvedConceptReferencesIteratorClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public ResolvedConceptReferencesIteratorClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	}
	
	public ResolvedConceptReferencesIteratorClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public ResolvedConceptReferencesIteratorClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
	}

	public static void usage(){
		System.out.println(ResolvedConceptReferencesIteratorClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  ResolvedConceptReferencesIteratorClient client = new ResolvedConceptReferencesIteratorClient(args[1]);
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

}
