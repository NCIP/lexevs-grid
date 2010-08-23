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
package org.LexGrid.LexBIG.cagrid.adapters;

import java.net.URI;
import java.rmi.RemoteException;
import java.util.Date;

import org.LexGrid.LexBIG.iso21090.DataModel.Collections.CodingSchemeVersionList;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.SystemReleaseList;
import org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.iso21090.DataModel.InterfaceElements.SystemReleaseDetail;
import org.LexGrid.LexBIG.History.HistoryService;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.client.HistoryServiceClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException;
import org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid;
import org.LexGrid.versions.CodingSchemeVersion;
import org.LexGrid.versions.SystemRelease;
import org.apache.axis.types.URI.MalformedURIException;

public class HistoryServiceGridAdapter implements HistoryServiceGrid {

	
private HistoryServiceClient history;
	
	public HistoryServiceGridAdapter(HistoryServiceClient client) throws RemoteException {
		history = client;
	}
	
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getAncestors(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public NCIChangeEventList getAncestors(ConceptReference conceptReference)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return history.getAncestors(conceptReference);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getBaselines(java.util.Date, java.util.Date)
	 */
	public SystemReleaseList getBaselines(Date releasedAfter,
			Date releasedBefore) throws LBParameterException,
			LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return history.getBaselines(releasedAfter, releasedBefore);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getConceptChangeVersions(org.LexGrid.LexBIG.DataModel.Core.ConceptReference, java.util.Date, java.util.Date)
	 */
	public CodingSchemeVersionList getConceptChangeVersions(
			ConceptReference conceptReference, Date beginDate, Date endDate)
			throws LBParameterException, LBInvocationException ,InvalidServiceContextAccess, RemoteException {
			return history.getConceptChangeVersions(conceptReference, beginDate,
					endDate);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getConceptCreationVersion(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public CodingSchemeVersion getConceptCreationVersion(
			ConceptReference conceptReference) throws LBParameterException,
			LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return history.getConceptCreationVersion(conceptReference);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getDescendants(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public NCIChangeEventList getDescendants(ConceptReference conceptReference)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return history.getDescendents(conceptReference);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getEarliestBaseline()
	 */
	public SystemRelease getEarliestBaseline() throws LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return history.getEarliestBaseline();
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getEditActionList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference, org.LexGrid.codingSchemes.CodingSchemeVersion)
	 */
	public NCIChangeEventList getEditActionList(
			ConceptReference conceptReference,
			CodingSchemeVersion codingSchemeVersion)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return history.getEditActionList2(conceptReference, codingSchemeVersion);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getEditActionList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference, java.util.Date, java.util.Date)
	 */
	public NCIChangeEventList getEditActionList(
			ConceptReference conceptReference, Date beginDate, Date endDate)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return history.getEditActionList3(conceptReference, beginDate, endDate);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getEditActionList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference, java.net.URI)
	 */
	public NCIChangeEventList getEditActionList(
			ConceptReference conceptReference, URI releaseURN)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException {
		try{	
			return history.getEditActionList(conceptReference, Utils
					.URIConverter(releaseURN));
		} catch (MalformedURIException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getLatestBaseline()
	 */
	public SystemRelease getLatestBaseline() throws LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return history.getLatestBaseline();
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.HistoryServiceGrid#getSystemRelease(java.net.URI)
	 */
	public SystemReleaseDetail getSystemRelease(URI releaseURN)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException {
			try {
				return history.getSystemRelease(Utils.URIConverter(releaseURN));
			} catch (MalformedURIException e) {
				throw new RemoteException(e.getMessage(), e);
			}
	}

	public HistoryService getHistoryInterface() throws Exception, InvalidServiceContextAccess, RemoteException {
		return new HistoryServiceAdapter(this);
	}
}
