package org.LexGrid.LexBIG.cagrid.LexEVSGridService.service.globus;


import java.rmi.RemoteException;
import javax.security.auth.Subject;
import javax.xml.namespace.QName;
import javax.xml.rpc.handler.MessageContext;

import org.globus.wsrf.impl.security.authorization.exceptions.AuthorizationException;
import org.globus.wsrf.impl.security.authorization.exceptions.CloseException;
import org.globus.wsrf.impl.security.authorization.exceptions.InitializeException;
import org.globus.wsrf.impl.security.authorization.exceptions.InvalidPolicyException;
import org.globus.wsrf.security.authorization.PDP;
import org.globus.wsrf.security.authorization.PDPConfig;
import org.w3c.dom.Node;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * This is a PDP for use with the globus authorization callout.
 * This class will have a authorize<methodName> method for each method on this grid service.
 * The method is responsibe for making any authorization callouts required to satisfy the 
 * authorization requirements placed on each method call.  Each method will either return
 * apon a successful authorization or will throw an exception apon a failed authorization.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class LexEVSGridServiceAuthorization implements PDP {

	public static final String SERVICE_NAMESPACE = "http://LexBIGCaGridServices.cagrid.LexBIG.LexGrid.org/LexBIGCaGridServices";
	
	
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
					
	public static void authorizeGetServiceSecurityMetadata() throws RemoteException {
		
		
	}
					
	public static void authorizeGetSupportedCodingSchemes() throws RemoteException {
		
		
	}
					
	public static void authorizeGetCodingSchemeConcepts() throws RemoteException {
		
		
	}
					
	public static void authorizeGetLastUpdateTime() throws RemoteException {
		
		
	}
					
	public static void authorizeResolveCodingScheme() throws RemoteException {
		
		
	}
					
	public static void authorizeGetMatchAlgorithms() throws RemoteException {
		
		
	}
					
	public static void authorizeGetNodeGraph() throws RemoteException {
		
		
	}
					
	public static void authorizeGetSortAlgorithms() throws RemoteException {
		
		
	}
					
	public static void authorizeGetGenericExtensions() throws RemoteException {
		
		
	}
					
	public static void authorizeGetGenericExtension() throws RemoteException {
		
		
	}
					
	public static void authorizeGetMultipleResourceProperties() throws RemoteException {
		
		
	}
					
	public static void authorizeGetResourceProperty() throws RemoteException {
		
		
	}
					
	public static void authorizeQueryResourceProperties() throws RemoteException {
		
		
	}
					
	public static void authorizeGetFilterExtensions() throws RemoteException {
		
		
	}
					
	public static void authorizeGetHistoryService() throws RemoteException {
		
		
	}
					
	public static void authorizeGetServiceMetadata() throws RemoteException {
		
		
	}
					
	public static void authorizeGetSortAlgorithm() throws RemoteException {
		
		
	}
					
	public static void authorizeGetFilter() throws RemoteException {
		
		
	}
					
	public static void authorizeResolveCodingSchemeCopyright() throws RemoteException {
		
		
	}
					
	public static void authorizeSetSecurityToken() throws RemoteException {
		
		
	}
	
	
	public boolean isPermitted(Subject peerSubject, MessageContext context, QName operation)
		throws AuthorizationException {
		
		if(!operation.getNamespaceURI().equals(getServiceNamespace())){
		  return false;
		}
		if(operation.getLocalPart().equals("getServiceSecurityMetadata")){
			try{
				authorizeGetServiceSecurityMetadata();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getSupportedCodingSchemes")){
			try{
				authorizeGetSupportedCodingSchemes();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getCodingSchemeConcepts")){
			try{
				authorizeGetCodingSchemeConcepts();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getLastUpdateTime")){
			try{
				authorizeGetLastUpdateTime();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("resolveCodingScheme")){
			try{
				authorizeResolveCodingScheme();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getMatchAlgorithms")){
			try{
				authorizeGetMatchAlgorithms();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getNodeGraph")){
			try{
				authorizeGetNodeGraph();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getSortAlgorithms")){
			try{
				authorizeGetSortAlgorithms();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getGenericExtensions")){
			try{
				authorizeGetGenericExtensions();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getGenericExtension")){
			try{
				authorizeGetGenericExtension();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getMultipleResourceProperties")){
			try{
				authorizeGetMultipleResourceProperties();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getResourceProperty")){
			try{
				authorizeGetResourceProperty();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("queryResourceProperties")){
			try{
				authorizeQueryResourceProperties();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getFilterExtensions")){
			try{
				authorizeGetFilterExtensions();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getHistoryService")){
			try{
				authorizeGetHistoryService();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getServiceMetadata")){
			try{
				authorizeGetServiceMetadata();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getSortAlgorithm")){
			try{
				authorizeGetSortAlgorithm();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("getFilter")){
			try{
				authorizeGetFilter();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("resolveCodingSchemeCopyright")){
			try{
				authorizeResolveCodingSchemeCopyright();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
		} else if(operation.getLocalPart().equals("setSecurityToken")){
			try{
				authorizeSetSecurityToken();
				return true;
			} catch (Exception e){
				e.printStackTrace();
				return false;
			}
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

	}
	
	
}
