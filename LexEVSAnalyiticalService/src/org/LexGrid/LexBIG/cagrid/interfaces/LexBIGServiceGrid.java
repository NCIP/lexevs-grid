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

import gov.nih.nci.evs.security.SecurityToken;

import java.io.Serializable;
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
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.codingSchemes.CodingScheme;

/**
 * This interface represents the core interface to a LexBIG service.
 */
public interface LexBIGServiceGrid extends Serializable {

	/**
	 * Returns the set of all (or all active) concepts in the specified coding
	 * scheme.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme to query.
	 * @throws LBException, RemoteException
	 */
	CodedNodeSetGrid getCodingSchemeConcepts(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag)
			throws LBException, RemoteException;

	/**
	 * Returns an instance of the filter extension registered with the given name.
	 * 
	 * @param name
	 *            The extension name; not null.
	 * @return org.LexGrid.LexBIG.Extensions.Query.Filter
	 * @throws RemoteException
	 */
	Filter getFilter(ExtensionIdentification name) throws RemoteException;

	/**
	 * Returns a description of all registered extensions used to provide
	 * additional filtering of query results.
	 * 
	 * @return The list containing the description of extensions registered for
	 *         this category. Each description identifies a class of item implementing
	 *         org.LexGrid.LexBIG.Extensions.Query.Filter and providing a public
	 *         parameterless constructor.
	 * @throws RemoteException
	 */
	ExtensionDescriptionList getFilterExtensions() throws RemoteException;

	/**
	 * Returns an instance of the application-specific extension registered with
	 * the given name.
	 * 
	 * @param name
	 *            The extension name; not null.
	 * @return org.LexGrid.LexBIG.Extensions.Generic.GenericExtension
	 * @throws LBException
	 */
	GenericExtension getGenericExtension(ExtensionIdentification name) throws LBException, RemoteException;

	/**
	 * Returns a description of all registered extensions used to implement
	 * application-specific behavior that is centrally accessible from a
	 * LexBIGService.
	 * <p>
	 * Note that only generic extensions (base class GenericExtension) will
	 * be listed here. All other classes are retrievable at the appropriate
	 * interface point (filter, sort, etc).
	 * 
	 * @return The list containing the description of extensions registered for
	 *         this category. Each description identifies a class of item implementing
	 *         org.LexGrid.LexBIG.Extensions.Generic.GenericExtension and
	 *         providing a public parameterless constructor.
	 * @throws LBException, RemoteException
	 */
	ExtensionDescriptionList getGenericExtensions() throws RemoteException;

	/**
	 * Resolve a reference to the history api servicing the given coding scheme.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @return org.LexGrid.LexBIG.History.HistoryService
	 * @throws LBException, RemoteException
	 */
	HistoryServiceGrid getHistoryService(CodingSchemeIdentification codingScheme)
			throws LBException, RemoteException;

	/**
	 * Return the last time that the content of this service was changed; null
	 * if no changes have occurred. Tag assignments do not count as service
	 * changes for this purpose.
	 * 
	 * @return java.util.Date
	 * @throws LBInvocationException, RemoteException
	 */
	Date getLastUpdateTime() throws LBInvocationException, RemoteException;

	/**
	 * Returns the full description of all supported match algorithms.
	 * @throws RemoteException
	 */
	ModuleDescriptionList getMatchAlgorithms() throws RemoteException;

	/**
	 * Returns the node graph as represented in the particular relationship set
	 * in the coding scheme.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme to query.
	 * @param relationsName
	 *            The name of the relations container to reference when generating
	 *            the graph. If omitted, all native relation containers for the code
	 *            system will be queried.  Note: a 'native' container contains a
	 *            set of associations defined by the coding scheme curators.
	 * @throws LBException, RemoteException
	 */
	CodedNodeGraphGrid getNodeGraph(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag, RelationContainerIdentification relationsName)
			throws LBException, RemoteException;

	/**
	 * Return an interface to perform system-wide query over
	 * metadata for loaded code systems and providers.
	 * 
	 * @throws LBException, RemoteException
	 */
	LexBIGServiceMetadataGrid<?> getServiceMetadata()
			throws LBException, RemoteException;

	/**
	 * Returns an instance of the sort extension registered with the given name.
	 * 
	 * @param name
	 *            The extension name; not null.
	 * @return org.LexGrid.LexBIG.Extensions.Query.Sort
	 * @throws LBException, RemoteException
	 */
	Sort getSortAlgorithm(ExtensionIdentification name) throws LBException, RemoteException;

	/**
	 * Returns a description of all registered extensions used to provide
	 * additional sorting of query results in the given context.
	 * <p>
	 * Note: The returned list will include any 'built-in' sort algorithms in
	 * addition to extensions externally packaged and registered to the service.
	 * 
	 * @param context
	 *            A context defined by the SortContext class, or null to
	 *            indicate that all registered algorithms are to be returned.
	 * @return The list containing the description of extensions registered for
	 *         this category. Each description identifies a class of item implementing
	 *         org.LexGrid.LexBIG.Extensions.Query.Sort and providing a public
	 *         parameterless constructor.
	 * @throws RemoteException
	 */
	SortDescriptionList getSortAlgorithms(SortContext context) throws RemoteException;

	/**
	 * Return a list of coding schemes and versions that are supported by this
	 * service, along with their status.
	 * 
	 * @throws LBInvocationException, RemoteException
	 */
	CodingSchemeRenderingList getSupportedCodingSchemes()
			throws LBInvocationException, RemoteException;

	/**
	 * Return detailed coding scheme information given a specific tag or version
	 * identifier.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            scheme to resolve.
	 * @throws LBException, RemoteException
	 */
	CodingScheme resolveCodingScheme(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, RemoteException;
	/**
	 * Return coding scheme copyright given a specific tag or version
	 * identifier.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            scheme to resolve.
	 * @throws LBException, RemoteException
	 */
	
	CodingSchemeCopyRight resolveCodingSchemeCopyright(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, RemoteException;
	
	/**
	 * Registers a Security Token for a coding scheme
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param token
	 *            The assigned security token.
	 *            
	 * @throws LBException, RemoteException
	 */
	
	LexBIGServiceGrid setSecurityToken(CodingSchemeIdentification codingScheme, SecurityToken token)
	throws LBException, RemoteException;
}