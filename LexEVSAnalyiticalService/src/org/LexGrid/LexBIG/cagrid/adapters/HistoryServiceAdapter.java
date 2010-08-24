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

import org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeVersionList;
import org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList;
import org.LexGrid.LexBIG.DataModel.Collections.SystemReleaseList;
import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.DataModel.InterfaceElements.SystemReleaseDetail;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;
import org.LexGrid.LexBIG.Exceptions.LBParameterException;
import org.LexGrid.LexBIG.History.HistoryService;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;
import org.LexGrid.versions.CodingSchemeVersion;
import org.LexGrid.versions.SystemRelease;

public class HistoryServiceAdapter implements HistoryService {

	private HistoryServiceGridAdapter history;

	public HistoryServiceAdapter(HistoryServiceGridAdapter adapter) throws RemoteException {
		history = adapter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getAncestors(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public NCIChangeEventList getAncestors(ConceptReference conceptReference)
	throws LBParameterException, LBInvocationException {
		try {
			return 
			ConvertUtils.convert(
			history.getAncestors(
					ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class)),
					org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList.class);	
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getBaselines(java.util.Date,
	 *      java.util.Date)
	 */
	public SystemReleaseList getBaselines(Date releasedAfter,
			Date releasedBefore) throws LBParameterException,
			LBInvocationException {
		try{
			return 
				ConvertUtils.convert(
			history.getBaselines(
					releasedAfter, 
					releasedBefore),
			org.LexGrid.LexBIG.DataModel.Collections.SystemReleaseList.class);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getConceptChangeVersions(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      java.util.Date, java.util.Date)
	 */
	public CodingSchemeVersionList getConceptChangeVersions(
			ConceptReference conceptReference, Date beginDate, Date endDate)
	throws LBParameterException, LBInvocationException {
		try {
			return 
				ConvertUtils.convert(
			history.getConceptChangeVersions(
					ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
					beginDate,
					endDate),
					org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeVersionList.class);	
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getConceptCreationVersion(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public CodingSchemeVersion getConceptCreationVersion(
			ConceptReference conceptReference) throws LBParameterException,
			LBInvocationException {
		try {
			return 
			ConvertUtils.convert(
					history.getConceptCreationVersion(
							ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class)),
							org.LexGrid.versions.CodingSchemeVersion.class);			
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getDescendants(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public NCIChangeEventList getDescendants(ConceptReference conceptReference)
	throws LBParameterException, LBInvocationException {
		try {
			return 
			ConvertUtils.convert(
			history.getDescendants(
					ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class)),
					org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList.class);	
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getEarliestBaseline()
	 */
	public SystemRelease getEarliestBaseline() throws LBInvocationException {
		try{
			return 
				ConvertUtils.convert(
						history.getEarliestBaseline(),
						org.LexGrid.versions.SystemRelease.class);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getEditActionList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      org.LexGrid.codingSchemes.CodingSchemeVersion)
	 */
	public NCIChangeEventList getEditActionList(
			ConceptReference conceptReference,
			CodingSchemeVersion codingSchemeVersion)
	throws LBParameterException, LBInvocationException {
		try{
			return 
				ConvertUtils.convert(
						history.getEditActionList(
								ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
								ConvertUtils.convert(codingSchemeVersion, org.LexGrid.iso21090.versions.CodingSchemeVersion.class)),
								org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList.class);		
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getEditActionList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      java.util.Date, java.util.Date)
	 */
	public NCIChangeEventList getEditActionList(
			ConceptReference conceptReference, Date beginDate, Date endDate)
	throws LBParameterException, LBInvocationException {
		try{
			return 
				ConvertUtils.convert(
						history.getEditActionList(
					ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
					beginDate, 
					endDate),
					org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList.class);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getEditActionList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      java.net.URI)
	 */
	public NCIChangeEventList getEditActionList(
			ConceptReference conceptReference, URI releaseURN)
	throws LBParameterException, LBInvocationException {
		try{
			return 
			ConvertUtils.convert(
					history.getEditActionList(
				ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
				releaseURN),
				org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList.class);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getLatestBaseline()
	 */
	public SystemRelease getLatestBaseline() throws LBInvocationException {
		try{
			return 
				ConvertUtils.convert(
						history.getLatestBaseline(),
				org.LexGrid.versions.SystemRelease.class);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.History.HistoryService#getSystemRelease(java.net.URI)
	 */
	public SystemReleaseDetail getSystemRelease(URI releaseURN)		
	throws LBParameterException, LBInvocationException {
		try{
			return 
			ConvertUtils.convert(
					history.getSystemRelease(releaseURN),
					org.LexGrid.LexBIG.DataModel.InterfaceElements.SystemReleaseDetail.class);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}
}
