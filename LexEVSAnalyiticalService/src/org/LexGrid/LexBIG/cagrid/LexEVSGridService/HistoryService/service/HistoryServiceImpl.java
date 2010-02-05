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
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.cagrid.Utils;

/**
 * TODO:I am the service side implementation class. IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class HistoryServiceImpl extends HistoryServiceImplBase {

	public HistoryServiceImpl() throws RemoteException {
		super();
	}

  public org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList getAncestors(org.LexGrid.LexBIG.DataModel.Core.ConceptReference conceptReference) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getAncestors(conceptReference);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.SystemReleaseList getBaselines(java.util.Date releasedAfter,java.util.Date releasedBefore) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getBaselines(releasedAfter, releasedBefore);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeVersionList getConceptChangeVersions(org.LexGrid.LexBIG.DataModel.Core.ConceptReference conceptReference,java.util.Date beginDate,java.util.Date endDate) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getConceptChangeVersions(conceptReference, beginDate,
							endDate);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.versions.CodingSchemeVersion getConceptCreationVersion(org.LexGrid.LexBIG.DataModel.Core.ConceptReference conceptReference) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getConceptCreationVersion(conceptReference);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList getDescendents(org.LexGrid.LexBIG.DataModel.Core.ConceptReference conceptReference) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getDescendants(conceptReference);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.versions.SystemRelease getEarliestBaseline() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getEarliestBaseline();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList getEditActionList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference conceptReference,org.apache.axis.types.URI releaseURN) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getEditActionList(conceptReference,
							Utils.URIConverter(releaseURN));
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList getEditActionList2(org.LexGrid.LexBIG.DataModel.Core.ConceptReference conceptReference,org.LexGrid.versions.CodingSchemeVersion codingSchemeVersion) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getEditActionList(conceptReference, codingSchemeVersion);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList getEditActionList3(org.LexGrid.LexBIG.DataModel.Core.ConceptReference conceptReference,java.util.Date beginDate,java.util.Date endDate) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getEditActionList(conceptReference, beginDate, endDate);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.versions.SystemRelease getLatestBaseline() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getLatestBaseline();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.InterfaceElements.SystemReleaseDetail getSystemRelease(org.apache.axis.types.URI releaseURN) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource().getHistoryService()
					.getSystemRelease(Utils.URIConverter(releaseURN));
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}
}
