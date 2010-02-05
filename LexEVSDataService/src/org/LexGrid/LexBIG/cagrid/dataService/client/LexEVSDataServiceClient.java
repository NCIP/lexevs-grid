package org.LexGrid.LexBIG.cagrid.dataService.client;

import java.io.FileReader;
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

import org.LexGrid.LexBIG.cagrid.dataService.stubs.LexEVSDataServicePortType;
import org.LexGrid.LexBIG.cagrid.dataService.stubs.service.LexEVSDataServiceAddressingLocator;
import org.LexGrid.LexBIG.cagrid.dataService.common.LexEVSDataServiceI;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlresultset.CQLQueryResults;
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
 * @created by Introduce Toolkit version 1.2
 */
public class LexEVSDataServiceClient extends LexEVSDataServiceClientBase implements LexEVSDataServiceI {	

	public LexEVSDataServiceClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public LexEVSDataServiceClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	}
	
	public LexEVSDataServiceClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public LexEVSDataServiceClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
	}

	public static void usage(){
		System.out.println(LexEVSDataServiceClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
		System.out.println("Running the Grid Service Client");
		try{
			if(!(args.length < 2)){
				if(args[0].equals("-url")){
					LexEVSDataServiceClient client = new LexEVSDataServiceClient(args[1]);

					CQLQuery query = (CQLQuery)Utils.deserializeObject(new FileReader("queries/testQueries"), CQLQuery.class);

					CQLQueryResults results = client.query(query);
					System.out.println(results.toString());
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

  public gov.nih.nci.cagrid.cqlresultset.CQLQueryResults query(gov.nih.nci.cagrid.cqlquery.CQLQuery cqlQuery) throws RemoteException, gov.nih.nci.cagrid.data.faults.QueryProcessingExceptionType, gov.nih.nci.cagrid.data.faults.MalformedQueryExceptionType {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"query");
    gov.nih.nci.cagrid.data.QueryRequest params = new gov.nih.nci.cagrid.data.QueryRequest();
    gov.nih.nci.cagrid.data.QueryRequestCqlQuery cqlQueryContainer = new gov.nih.nci.cagrid.data.QueryRequestCqlQuery();
    cqlQueryContainer.setCQLQuery(cqlQuery);
    params.setCqlQuery(cqlQueryContainer);
    gov.nih.nci.cagrid.data.QueryResponse boxedResult = portType.query(params);
    return boxedResult.getCQLQueryResultCollection();
    }
  }

  public org.LexGrid.LexBIG.cagrid.dataService.client.LexEVSDataServiceClient registerSecurityToken(java.lang.String codingSchemeURN,gov.nih.nci.evs.security.SecurityToken securityToken) throws RemoteException, org.apache.axis.types.URI.MalformedURIException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"registerSecurityToken");
    org.LexGrid.LexBIG.cagrid.dataService.stubs.RegisterSecurityTokenRequest params = new org.LexGrid.LexBIG.cagrid.dataService.stubs.RegisterSecurityTokenRequest();
    params.setCodingSchemeURN(codingSchemeURN);
    org.LexGrid.LexBIG.cagrid.dataService.stubs.RegisterSecurityTokenRequestSecurityToken securityTokenContainer = new org.LexGrid.LexBIG.cagrid.dataService.stubs.RegisterSecurityTokenRequestSecurityToken();
    securityTokenContainer.setSecurityToken(securityToken);
    params.setSecurityToken(securityTokenContainer);
    org.LexGrid.LexBIG.cagrid.dataService.stubs.RegisterSecurityTokenResponse boxedResult = portType.registerSecurityToken(params);
    EndpointReferenceType ref = boxedResult.getLexEVSDataServiceReference().getEndpointReference();
    return new org.LexGrid.LexBIG.cagrid.dataService.client.LexEVSDataServiceClient(ref);
    }
  }

}
