/*
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
 * 		http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.LexGrid.LexBIG.cagrid.adapters;

import gov.nih.nci.evs.security.SecurityToken;

import java.net.ConnectException;
import java.rmi.RemoteException;
import java.util.Date;

import org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeRenderingList;
import org.LexGrid.LexBIG.DataModel.Collections.ExtensionDescriptionList;
import org.LexGrid.LexBIG.DataModel.Collections.LocalNameList;
import org.LexGrid.LexBIG.DataModel.Collections.ModuleDescriptionList;
import org.LexGrid.LexBIG.DataModel.Collections.SortDescriptionList;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag;
import org.LexGrid.LexBIG.DataModel.InterfaceElements.types.SortContext;
import org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeCopyRight;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;
import org.LexGrid.LexBIG.Extensions.Generic.GenericExtension;
import org.LexGrid.LexBIG.Extensions.Query.Filter;
import org.LexGrid.LexBIG.Extensions.Query.Sort;
import org.LexGrid.LexBIG.History.HistoryService;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.LexBIGService.LexBIGServiceManager;
import org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;
import org.LexGrid.codingSchemes.CodingScheme;
import org.apache.axis.types.URI.MalformedURIException;

/**
 * Adapter class to allow a client to call LexBIG caGrid services as if it was a
 * local service. These calls are forwarded to the appropriate service calls.
 * 
 * @author <A HREF="mailto:peterson.kevin@mayo.edu">Kevin Peterson</A>
 */
/**
 * @author m005256
 *
 */
public class LexBIGServiceAdapter implements LexBIGService {

	private LexBIGServiceGridAdapter lbSvc;

	/**
	 * Entry point for connecting to the LexBIG caGrid Services.
	 * @param url
	 * 		The URL of the LexBIG caGrid Service
	 * @throws LBInvocationException
	 */
	public LexBIGServiceAdapter(String url) throws LBInvocationException {
		try {
			lbSvc = new LexBIGServiceGridAdapter(url);
		} catch (ConnectException e) {
			throw new LBInvocationException("Error Connecting To Grid Service", null);
		} catch (MalformedURIException e) {
			throw new LBInvocationException("Error Connecting To Grid Service", null);
		}
	}
	
	/**
	 * Entry point for connecting to the LexBIG caGrid Services.
	 * @param adapter
	 * 		The adapter (Grid) of the LexBIG caGrid Service
	 * @throws LBInvocationException
	 */
	public LexBIGServiceAdapter(LexBIGServiceGridAdapter adapter) throws LBInvocationException {
		lbSvc = adapter;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getCodingSchemeConcepts(java.lang.String, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag, boolean)
	 */
	public CodedNodeSet getCodingSchemeConcepts(String codingScheme,
			CodingSchemeVersionOrTag versionOrTag, boolean activeOnly) throws LBException {
			
			try {
				CodedNodeSetGridAdapter adapter = (CodedNodeSetGridAdapter)lbSvc.getCodingSchemeConcepts(Utils.wrapCodingSchemeIdentifier(codingScheme),
						ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag.class));
				return adapter.getCodedNodeSetInterface();
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
				throw new LBException(e.getMessage(), e);
			} catch (RemoteException e) {
				throw new LBException(e.getMessage(), e);
			} catch (Exception e) {
				throw new LBException(e.getMessage(), e);
			}
	}
	
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getCodingSchemeConcepts(java.lang.String, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public CodedNodeSet getCodingSchemeConcepts(String codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException {
		
			try {
				CodedNodeSetGridAdapter adapter = (CodedNodeSetGridAdapter)lbSvc.getCodingSchemeConcepts(
						Utils.wrapCodingSchemeIdentifier(codingScheme), 
						ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag.class));
				return adapter.getCodedNodeSetInterface();
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
				throw new LBException(e.getMessage(), e);
			} catch (RemoteException e) {
				throw new LBException(e.getMessage(), e);
			} catch (Exception e) {
				throw new LBException(e.getMessage(), e);
			}
		
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getFilter(java.lang.String)
	 */
	public Filter getFilter(String name) throws LBException {
			try {
				return lbSvc.getFilter(Utils.wrapExtensionIdentification(name));
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
				throw new LBException(e.getMessage(), e);
			} catch (RemoteException e) {
				throw new LBException(e.getMessage(), e);
			}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getFilterExtensions()
	 */
	public ExtensionDescriptionList getFilterExtensions() {
			return ConvertUtils.convert(lbSvc.getFilterExtensions(), org.LexGrid.LexBIG.DataModel.Collections.ExtensionDescriptionList.class);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getGenericExtension(java.lang.String)
	 */
	public GenericExtension getGenericExtension(String name) throws LBException {
		try {
			LexBIGServiceConvenienceMethodsGridAdapter adapter = 
				(LexBIGServiceConvenienceMethodsGridAdapter)lbSvc.getGenericExtension(Utils.wrapExtensionIdentification(name));
			return adapter.getLexBIGServiceConvenienceMethodsInterface();
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
			throw new LBException(e.getMessage(), e);
		} catch (RemoteException e) {
			throw new LBException(e.getMessage(), e);
		} catch (Exception e) {
			throw new LBException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getGenericExtensions()
	 */
	public ExtensionDescriptionList getGenericExtensions() {	
			try {
				return ConvertUtils.convert(lbSvc.getGenericExtensions(), org.LexGrid.LexBIG.DataModel.Collections.ExtensionDescriptionList.class);
			} catch (RemoteException e) {
				e.printStackTrace();
				return null;
			}		
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getHistoryService(java.lang.String)
	 */
	public HistoryService getHistoryService(String codingScheme) throws LBException {
		try {
			HistoryServiceGridAdapter adapter = 
				(HistoryServiceGridAdapter)lbSvc.getHistoryService(Utils.wrapCodingSchemeIdentifier(codingScheme));
			return adapter.getHistoryInterface();
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
			throw new LBException(e.getMessage(), e);
		} catch (RemoteException e) {
			throw new LBException(e.getMessage(), e);
		} catch (Exception e) {
			throw new LBException(e.getMessage(), e);
		}
		
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getLastUpdateTime()
	 */
	public Date getLastUpdateTime() throws LBInvocationException {
			try {
				return lbSvc.getLastUpdateTime();
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
				throw new LBInvocationException(e.getMessage(), null);
			} catch (RemoteException e) {
				throw new LBInvocationException(e.getMessage(), null);
			}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getMatchAlgorithms()
	 */
	public ModuleDescriptionList getMatchAlgorithms() {
		
			try {
				return ConvertUtils.convert(lbSvc.getMatchAlgorithms(), org.LexGrid.LexBIG.DataModel.Collections.ModuleDescriptionList.class);
			} catch (RemoteException e) {
				e.printStackTrace();
				return null;
			}
		
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getNodeGraph(java.lang.String, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag, java.lang.String)
	 */
	public CodedNodeGraph getNodeGraph(String codingScheme,
			CodingSchemeVersionOrTag versionOrTag, String relationsName) throws LBException {
		
			try {
				CodedNodeGraphGridAdapter adapter = (CodedNodeGraphGridAdapter)lbSvc.getNodeGraph(
						Utils.wrapCodingSchemeIdentifier(codingScheme), versionOrTag, 
						Utils.wrapRelationContainerIdentification(relationsName));
				return adapter.getCodedNodeGraphInterface();
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
				throw new LBException(e.getMessage(), e);
			} catch (RemoteException e) {
				throw new LBException(e.getMessage(), e);
			} catch (Exception e) {
				throw new LBException(e.getMessage(), e);
			}	
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getServiceManager(java.lang.Object)
	 */
	public LexBIGServiceManager getServiceManager(Object credentials)
			throws LBException {
		throw new LBException("Can't Call this via a caGrid Service", null);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getServiceMetadata()
	 */
	public LexBIGServiceMetadata getServiceMetadata() throws LBException {
		try {
			LexBIGServiceMetadataGridAdapter adapter = 
				(LexBIGServiceMetadataGridAdapter)lbSvc.getServiceMetadata();
			return adapter.getLexBIGServiceMetadataInterface();
		} catch (Exception e) {
			throw new LBException("Error Calling 'getServiceMetadata': " + e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getSortAlgorithm(java.lang.String)
	 */
	public Sort getSortAlgorithm(String name) throws LBException {
				try {
					return lbSvc.getSortAlgorithm(Utils.wrapExtensionIdentification(name));
				} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
					throw new LBException(e.getMessage(), e);
				} catch (RemoteException e) {
					throw new LBException(e.getMessage(), e);
				}
	}

	public SortDescriptionList getSortAlgorithms(SortContext context) {
			try {
				return ConvertUtils.convert(
						lbSvc.getSortAlgorithms(
								ConvertUtils.convert(context, org.LexGrid.LexBIG.iso21090.DataModel.InterfaceElements.types.SortContext.class)),
								org.LexGrid.LexBIG.DataModel.Collections.SortDescriptionList.class);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
				e.printStackTrace();
				return null;
				}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#getSupportedCodingSchemes()
	 */
	public CodingSchemeRenderingList getSupportedCodingSchemes() throws LBInvocationException {
			try {
				return ConvertUtils.convert(lbSvc.getSupportedCodingSchemes(), org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeRenderingList.class);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
				throw new LBInvocationException(e.getMessage(), null);
			} catch (RemoteException e) {
				throw new LBInvocationException(e.getMessage(), null);
			}
	}


	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#resolveCodingScheme(java.lang.String, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public CodingScheme resolveCodingScheme(String codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException {
			try {
				return ConvertUtils.convert(lbSvc.resolveCodingScheme(
						
						Utils.wrapCodingSchemeIdentifier(codingScheme), 
						ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag.class)), 
						
						org.LexGrid.codingSchemes.CodingScheme.class);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
				throw new LBException(e.getMessage(), e);
			} catch (RemoteException e) {
				throw new LBException(e.getMessage(), e);
			}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGService#resolveCodingSchemeCopyright(java.lang.String, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public String resolveCodingSchemeCopyright(String codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException {
			try {
				CodingSchemeCopyRight copyright = 
					ConvertUtils.convert(
					lbSvc.resolveCodingSchemeCopyright(
						Utils.wrapCodingSchemeIdentifier(codingScheme), 
						ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag.class)),
					org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeCopyRight.class
					);
						
				return copyright.getCopyrightTextOrURL();
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException e) {
				throw new LBException(e.getMessage(), e);
			} catch (RemoteException e) {
				throw new LBException(e.getMessage(), e);
			}
	}	
	
	public CodedNodeSet getNodeSet(String codingScheme, CodingSchemeVersionOrTag versionOrTag,
			LocalNameList localNameList) throws LBException {
		throw new LBException("Not Implemented as a LexEVS Grid Service.");
	}

	public LexBIGService setSecurityToken(String codingScheme, SecurityToken token) throws LBException {
		try {
			LexBIGServiceGridAdapter adapter = (LexBIGServiceGridAdapter)lbSvc.setSecurityToken(Utils.wrapCodingSchemeIdentifier(codingScheme), token);
			return adapter.getLexBIGServiceInterface();
		} catch (Exception e) {
			throw new LBException("Error Calling 'setSecurityToken': " + e.getMessage(), e);
		}
	}	
}
