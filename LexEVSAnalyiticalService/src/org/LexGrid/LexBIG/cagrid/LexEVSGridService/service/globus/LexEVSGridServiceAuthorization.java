package org.LexGrid.LexBIG.cagrid.LexEVSGridService.service.globus;


import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import javax.security.auth.Subject;
import javax.xml.namespace.QName;
import javax.xml.rpc.handler.MessageContext;

import gov.nih.nci.cagrid.introduce.servicetools.security.AuthorizationExtension;
import org.globus.wsrf.impl.security.authorization.exceptions.AuthorizationException;
import org.globus.wsrf.impl.security.authorization.exceptions.CloseException;
import org.globus.wsrf.impl.security.authorization.exceptions.InitializeException;
import org.globus.wsrf.impl.security.authorization.exceptions.InvalidPolicyException;
import org.globus.wsrf.security.authorization.PDP;
import org.globus.wsrf.security.authorization.PDPConfig;
import org.globus.wsrf.config.ContainerConfig;
import org.w3c.dom.Node;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This is a PDP for use with the globus authorization callout.
 * This class will have a authorize method for each method on this grid service.
 * The method is responsibe for making any authorization callouts required to satisfy the 
 * authorization requirements placed on each method call.  Each method will either return
 * apon a successful authorization or will throw an exception apon a failed authorization.
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public class LexEVSGridServiceAuthorization implements PDP {

	public static final String SERVICE_NAMESPACE = "http://LexBIGCaGridServices.cagrid.LexBIG.LexGrid.org/LexBIGCaGridServices";
	
	Map authorizationClassMap = new HashMap();
	
	
	public LexEVSGridServiceAuthorization() {
	}
	
	protected String getServiceNamespace(){
		return SERVICE_NAMESPACE;
	}
	
	public static String getCallerIdentity() {
		String caller = org.globus.wsrf.security.SecurityManager.getManager().getCaller();
		if ((caller == null) || (caller.equals("<anonymous>"))) {
			return null;
		} else {
			return caller;
		}
	}
					
	public void authorizeGetServiceSecurityMetadata(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetSupportedCodingSchemes(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetCodingSchemeConcepts(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeResolveCodingScheme(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetMatchAlgorithms(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetNodeGraph(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetSortAlgorithms(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetGenericExtensions(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetGenericExtension(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetFilterExtensions(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetHistoryService(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetServiceMetadata(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetSortAlgorithm(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetFilter(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeResolveCodingSchemeCopyright(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeSetSecurityToken(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetMultipleResourceProperties(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeGetResourceProperty(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   				
	public void authorizeQueryResourceProperties(Subject peerSubject, MessageContext context, QName operation) throws AuthorizationException {
		
	}
	   
	
	public boolean isPermitted(Subject peerSubject, MessageContext context, QName operation)
		throws AuthorizationException {
		
		if(!operation.getNamespaceURI().equals(getServiceNamespace())){
		  return false;
		}
		if(operation.getLocalPart().equals("getServiceSecurityMetadata")){
			authorizeGetServiceSecurityMetadata(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getSupportedCodingSchemes")){
			authorizeGetSupportedCodingSchemes(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getCodingSchemeConcepts")){
			authorizeGetCodingSchemeConcepts(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("resolveCodingScheme")){
			authorizeResolveCodingScheme(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getMatchAlgorithms")){
			authorizeGetMatchAlgorithms(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getNodeGraph")){
			authorizeGetNodeGraph(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getSortAlgorithms")){
			authorizeGetSortAlgorithms(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getGenericExtensions")){
			authorizeGetGenericExtensions(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getGenericExtension")){
			authorizeGetGenericExtension(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getFilterExtensions")){
			authorizeGetFilterExtensions(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getHistoryService")){
			authorizeGetHistoryService(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getServiceMetadata")){
			authorizeGetServiceMetadata(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getSortAlgorithm")){
			authorizeGetSortAlgorithm(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getFilter")){
			authorizeGetFilter(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("resolveCodingSchemeCopyright")){
			authorizeResolveCodingSchemeCopyright(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("setSecurityToken")){
			authorizeSetSecurityToken(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getMultipleResourceProperties")){
			authorizeGetMultipleResourceProperties(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("getResourceProperty")){
			authorizeGetResourceProperty(peerSubject, context, operation);
			return true;
		} else if(operation.getLocalPart().equals("queryResourceProperties")){
			authorizeQueryResourceProperties(peerSubject, context, operation);
			return true;
		} 		
		return false;
	}
	

	public Node getPolicy(Node query) throws InvalidPolicyException {
		return null;
	}


	public String[] getPolicyNames() {
		return null;
	}


	public Node setPolicy(Node policy) throws InvalidPolicyException {
		return null;
	}


	public void close() throws CloseException {


	}


	public void initialize(PDPConfig config, String name, String id) throws InitializeException {
    	try{
    		String serviceName = (String)config.getProperty(name, "serviceName");
    	    String etcPath = ContainerConfig.getBaseDirectory() + File.separator + (String)config.getProperty(name, "etcDirectoryPath");

    	
    	} catch (Exception e){
        	throw new InitializeException(e.getMessage(),e);
		}
	}
	
	
}
