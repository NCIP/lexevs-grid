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
package org.LexGrid.LexBIG.cagrid.interfaces;

import java.io.Serializable;
import java.net.URI;
import java.rmi.RemoteException;
import java.util.Date;

import org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeVersionList;
import org.LexGrid.LexBIG.DataModel.Collections.NCIChangeEventList;
import org.LexGrid.LexBIG.DataModel.Collections.SystemReleaseList;
import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.DataModel.InterfaceElements.SystemReleaseDetail;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException;
import org.LexGrid.versions.CodingSchemeVersion;
import org.LexGrid.versions.SystemRelease;

/**
 * The history service returns information about the change history of a coding
 * scheme.
 * 
 * @created 09-Feb-2006 10:45:53 PM
 * @author solbrigcvs
 * @version 1.0
 */
public interface HistoryServiceGrid extends Serializable {
    
    public static final String metaURN = "urn:oid:2.16.840.1.113883.3.26.1.2";

	/**
	 * Return the list of change events identifying the immediate ancestors
	 * of the given concept reference.
	 * 
	 * @param conceptReference ConceptReference
	 * @return NCIChangeEventList
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	public NCIChangeEventList getAncestors(ConceptReference conceptReference)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return a list of baselines supported by this service that were released
	 * on or after the first supplied date and were released on or before the
	 * second date. Returned baselines are arranged in sequential order, from
	 * earliest to latest.
	 * 
	 * @param releasedAfter
	 *            If present, only return baselines released on or after the
	 *            supplied date.
	 * @param releasedBefore
	 *            If present, only return baselines that were released before
	 *            the specified date
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	public SystemReleaseList getBaselines(Date releasedAfter, Date releasedBefore)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return a list of all of the coding scheme versions in which the supplied
	 * concept changed between the two supplied times (inclusive).
	 * 
	 * @param conceptReference
	 *            The concept to pull the versions out of
	 * @param beginDate
	 *            Begin date (inclusive) to check for version changes. If
	 *            omitted, go to earliest recorded date
	 * @param endDate
	 *            Last date to check for changes in (inclusive). If omitted
	 *            include all dates past and including beginDate
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	public CodingSchemeVersionList getConceptChangeVersions(ConceptReference conceptReference,
			Date beginDate, Date endDate) throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the coding scheme version in which the supplied concept was
	 * created.
	 * 
	 * @param conceptReference ConceptReference
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	public CodingSchemeVersion getConceptCreationVersion(ConceptReference conceptReference)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the list of change events identifying the immediate descendants
	 * of the given concept reference.
	 * 
	 * @param conceptReference ConceptReference
	 * @return NCIChangeEventList
	 * @throws LBParameterException,LBInvocationException
	 */
	public NCIChangeEventList getDescendants(ConceptReference conceptReference) throws LBParameterException,
			LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the earliest baseline version in the list
	 * @throws LBInvocationException,InvalidServiceContextAccess,RemoteException
	 */
	public SystemRelease getEarliestBaseline() throws LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the list of available NCI-defined change events for the given
	 * concept and coding scheme version.
	 * 
	 * @param conceptReference
	 *            Optional concept to get the action list for. If omitted, all
	 *            events for the given change set (represented by a coding
	 *            scheme version) are returned.
	 * @param codingSchemeVersion
	 *            Version to get the action list for
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	public NCIChangeEventList getEditActionList(ConceptReference conceptReference,
			CodingSchemeVersion codingSchemeVersion) throws LBParameterException,
			LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the list of available NCI-defined change events for the given
	 * concept and date range.
	 * 
	 * @param conceptReference
	 *            Optional concept to get the action list for. If omitted, all
	 *            events for the given date range are returned.
	 * @param beginDate
	 *            Begin date (inclusive) to check for version changes. If
	 *            omitted, go to earliest recorded date.
	 * @param endDate
	 *            Last date to check for changes in (inclusive). If omitted
	 *            include all dates past and including beginDate.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	public NCIChangeEventList getEditActionList(ConceptReference conceptReference,
			Date beginDate, Date endDate) throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the list of NCI-defined change events for the given concept and
	 * release; empty if not applicable.
	 * 
	 * @param conceptReference
	 *            Optional concept to get the action list for. If omitted the
	 *            actions for all registered concepts for the specified system
	 *            release are returned.
	 * @param releaseURN
	 *            URN of the system release to retrieve the action list for.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	public NCIChangeEventList getEditActionList(ConceptReference conceptReference,
			URI releaseURN) throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Get the latest baseline in the list.
	 */
	public SystemRelease getLatestBaseline() throws LBInvocationException, LBInvocationException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return detailed information about the particular system release.
	 * 
	 * @param releaseURN
	 *            The URN of the system release to retrieve.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	public SystemReleaseDetail getSystemRelease(URI releaseURN)
			throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException;

}