package org.LexGrid.LexBIG.cagrid.adapters;

import gov.nih.nci.evs.security.SecurityToken;

import java.net.ConnectException;
import java.rmi.RemoteException;
import java.util.Date;

import org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeRenderingList;
import org.LexGrid.LexBIG.DataModel.Collections.ExtensionDescriptionList;
import org.LexGrid.LexBIG.DataModel.Collections.ModuleDescriptionList;
import org.LexGrid.LexBIG.DataModel.Collections.SortDescriptionList;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag;
import org.LexGrid.LexBIG.DataModel.InterfaceElements.types.SortContext;
import org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeCopyRight;
import org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.RelationContainerIdentification;
import org.LexGrid.LexBIG.Extensions.Generic.GenericExtension;
import org.LexGrid.LexBIG.Extensions.Query.Filter;
import org.LexGrid.LexBIG.Extensions.Query.Sort;
import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.client.CodedNodeGraphClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.client.CodedNodeSetClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.client.FilterClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.client.HistoryServiceClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.client.LexBIGServiceConvenienceMethodsClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.client.LexBIGServiceMetadataClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.client.LexEVSGridServiceClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid;
import org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid;
import org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid;
import org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid;
import org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceMetadataGrid;
import org.LexGrid.codingSchemes.CodingScheme;
import org.apache.axis.types.URI.MalformedURIException;

public class LexBIGServiceGridAdapter implements LexBIGServiceGrid {

	private LexEVSGridServiceClient lbSvc;

	/**
	 * Entry point for connecting to the LexBIG caGrid Services.
	 * @param url
	 * 		The URL of the LexBIG caGrid Service
	 * @throws LBInvocationException
	 */
	public LexBIGServiceGridAdapter(String url) throws ConnectException, MalformedURIException {
			//Test the service connection (this isn't done automatically).
			try {
				lbSvc = new LexEVSGridServiceClient(url);
				lbSvc.getLastUpdateTime();
			} catch (RemoteException e) {
				if(e.getCause() instanceof ConnectException){
					throw new ConnectException("Problem Connecting To The Grid Service -- Please Check The URL. " + e.getMessage());
				} else {
					throw new ConnectException("Unexpected Problem Connecting To The Grid Service. " + e.getMessage());
				}
				
			}
	}
	
	/**
	 * Entry point for connecting to the LexBIG caGrid Services.
	 * @param client
	 * 		The Client of the LexBIG caGrid Service
	 */
	public LexBIGServiceGridAdapter(LexEVSGridServiceClient client) throws LBInvocationException {
		lbSvc = client;
	}
	
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#resolveCodingScheme(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public CodingScheme resolveCodingScheme(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException , RemoteException{
			return lbSvc.resolveCodingScheme(codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getCodingSchemeConcepts(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public CodedNodeSetGrid getCodingSchemeConcepts(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, 
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException, RemoteException {
			try {
				CodedNodeSetClient client = lbSvc.getCodingSchemeConcepts(codingScheme, versionOrTag);
				CodedNodeSetGridAdapter adapter = new CodedNodeSetGridAdapter(client);
				return adapter;
			} catch (MalformedURIException e) {
				throw new RemoteException(e.getMessage(), e);
			}	
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getFilter(org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification)
	 */
	public Filter getFilter(ExtensionIdentification name) throws LBException, RemoteException {
			try {
				FilterClient client = lbSvc.getFilter(name);
				FilterAdapter adapter = new FilterAdapter(client);
				return adapter;
			} catch (MalformedURIException e) {
				throw new RemoteException(e.getMessage(), e);
			}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getGenericExtension(org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification)
	 */
	public GenericExtension getGenericExtension(ExtensionIdentification name)
			throws LBException, RemoteException {
			try {
				LexBIGServiceConvenienceMethodsClient client = lbSvc.getGenericExtension(name);
				LexBIGServiceConvenienceMethodsGridAdapter adapter = new LexBIGServiceConvenienceMethodsGridAdapter(client);
				return adapter;
			} catch (MalformedURIException e) {
				throw new RemoteException(e.getMessage(), e);
			}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getHistoryService(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification)
	 */
	public HistoryServiceGrid getHistoryService(CodingSchemeIdentification codingScheme)
			throws LBException, RemoteException {
		try {
			HistoryServiceClient client = lbSvc.getHistoryService(codingScheme);
			HistoryServiceGridAdapter adapter = new HistoryServiceGridAdapter(client);
			return adapter;
		} catch (MalformedURIException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getNodeGraph(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag, org.LexGrid.LexBIG.DataModel.cagrid.RelationContainerIdentification)
	 */
	public CodedNodeGraphGrid getNodeGraph(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag,
			RelationContainerIdentification relationsName) throws LBException, RemoteException {
		try {
			CodedNodeGraphClient client = lbSvc.getNodeGraph(codingScheme, versionOrTag, relationsName);
			CodedNodeGraphGridAdapter adapter = new CodedNodeGraphGridAdapter(client);
			return adapter;
		} catch (MalformedURIException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getSortAlgorithm(org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification)
	 */
	public Sort getSortAlgorithm(ExtensionIdentification name) throws LBException, RemoteException {
		SortAdapter sort;
		try {
			sort = new SortAdapter(lbSvc.getSortAlgorithm(name));
			return sort;
		} catch (MalformedURIException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#resolveCodingSchemeCopyright(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public CodingSchemeCopyRight resolveCodingSchemeCopyright(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, RemoteException {
			return lbSvc.resolveCodingSchemeCopyright(codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getFilterExtensions()
	 */
	public ExtensionDescriptionList getFilterExtensions() {
		try {
			return lbSvc.getFilterExtensions();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getGenericExtensions()
	 */
	public ExtensionDescriptionList getGenericExtensions() throws RemoteException {
			return lbSvc.getGenericExtensions();
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getLastUpdateTime()
	 */
	public Date getLastUpdateTime() throws LBInvocationException, RemoteException {
			return lbSvc.getLastUpdateTime();
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getMatchAlgorithms()
	 */
	public ModuleDescriptionList getMatchAlgorithms() throws RemoteException {
			return lbSvc.getMatchAlgorithms();
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getServiceMetadata()
	 */
	public LexBIGServiceMetadataGrid<?> getServiceMetadata() throws LBException, RemoteException {
		try{	
			LexBIGServiceMetadataClient client = lbSvc.getServiceMetadata();
			LexBIGServiceMetadataGridAdapter adapter = new LexBIGServiceMetadataGridAdapter(client);
			return adapter;
		} catch (MalformedURIException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getSortAlgorithms(org.LexGrid.LexBIG.DataModel.InterfaceElements.types.SortContext)
	 */
	public SortDescriptionList getSortAlgorithms(SortContext context) throws LBException {
		try {
			return lbSvc.getSortAlgorithms(context.toString());
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#getSupportedCodingSchemes()
	 */
	public CodingSchemeRenderingList getSupportedCodingSchemes() 
			throws LBInvocationException, RemoteException {
			CodingSchemeRenderingList csrl = lbSvc.getSupportedCodingSchemes();
			return csrl;
	}
	
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid#setSecurityToken(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, gov.nih.nci.evs.security.SecurityToken)
	 */
	public LexBIGServiceGrid setSecurityToken(CodingSchemeIdentification codingScheme, SecurityToken token) throws LBException, RemoteException{
			try {
				return new LexBIGServiceGridAdapter(lbSvc.setSecurityToken(codingScheme, token));
			} catch (MalformedURIException e) {
				throw new RemoteException(e.getMessage(), e);
			}
	}
	
	public LexBIGService getLexBIGServiceInterface() throws Exception {
		return new LexBIGServiceAdapter(this);
	}
	
}
