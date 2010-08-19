package org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.service;

import org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.service.globus.resource.ResolvedConceptReferencesIteratorResource;
import  org.LexGrid.LexBIG.cagrid.LexEVSGridService.service.LexEVSGridServiceConfiguration;

import java.rmi.RemoteException;

import javax.naming.InitialContext;
import javax.xml.namespace.QName;

import org.apache.axis.MessageContext;
import org.globus.wsrf.Constants;
import org.globus.wsrf.ResourceContext;
import org.globus.wsrf.ResourceContextException;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceHome;
import org.globus.wsrf.ResourceProperty;
import org.globus.wsrf.ResourcePropertySet;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 *
 * Provides some simple accessors for the Impl.
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public abstract class ResolvedConceptReferencesIteratorImplBase {
	
	public ResolvedConceptReferencesIteratorImplBase() throws RemoteException {
	
	}
	
	public LexEVSGridServiceConfiguration getConfiguration() throws Exception {
		return LexEVSGridServiceConfiguration.getConfiguration();
	}
	
	
	public org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.service.globus.resource.ResolvedConceptReferencesIteratorResourceHome getResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("home");
		return (org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.service.globus.resource.ResolvedConceptReferencesIteratorResourceHome)resource;
	}

	
	
	
	public org.LexGrid.LexBIG.cagrid.LexEVSGridService.service.globus.resource.LexEVSGridServiceResourceHome getLexEVSGridServiceResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("lexEVSGridServiceHome");
		return (org.LexGrid.LexBIG.cagrid.LexEVSGridService.service.globus.resource.LexEVSGridServiceResourceHome)resource;
	}
	
	public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.service.globus.resource.CodedNodeSetResourceHome getCodedNodeSetResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("codedNodeSetHome");
		return (org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.service.globus.resource.CodedNodeSetResourceHome)resource;
	}
	
	public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.service.globus.resource.CodedNodeGraphResourceHome getCodedNodeGraphResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("codedNodeGraphHome");
		return (org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.service.globus.resource.CodedNodeGraphResourceHome)resource;
	}
	
	public org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResourceHome getLexBIGServiceConvenienceMethodsResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("lexBIGServiceConvenienceMethodsHome");
		return (org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResourceHome)resource;
	}
	
	public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service.globus.resource.HistoryServiceResourceHome getHistoryServiceResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("historyServiceHome");
		return (org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service.globus.resource.HistoryServiceResourceHome)resource;
	}
	
	public org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.service.globus.resource.LexBIGServiceMetadataResourceHome getLexBIGServiceMetadataResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("lexBIGServiceMetadataHome");
		return (org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.service.globus.resource.LexBIGServiceMetadataResourceHome)resource;
	}
	
	public org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service.globus.resource.SortResourceHome getSortResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("sortHome");
		return (org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service.globus.resource.SortResourceHome)resource;
	}
	
	public org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.service.globus.resource.FilterResourceHome getFilterResourceHome() throws Exception {
		ResourceHome resource = getResourceHome("filterHome");
		return (org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.service.globus.resource.FilterResourceHome)resource;
	}
	
	
	protected ResourceHome getResourceHome(String resourceKey) throws Exception {
		MessageContext ctx = MessageContext.getCurrentContext();

		ResourceHome resourceHome = null;
		
		String servicePath = ctx.getTargetService();

		String jndiName = Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/" + resourceKey;
		try {
			javax.naming.Context initialContext = new InitialContext();
			resourceHome = (ResourceHome) initialContext.lookup(jndiName);
		} catch (Exception e) {
			throw new Exception("Unable to instantiate resource home. : " + resourceKey, e);
		}

		return resourceHome;
	}


}

