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

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.DataModel.Collections.AssociationList;
import org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeRenderingList;
import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag;
import org.LexGrid.LexBIG.DataModel.InterfaceElements.CodingSchemeRendering;
import org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.CodeState;
import org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeCopyRight;
import org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.ConceptIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.Direction;
import org.LexGrid.LexBIG.DataModel.cagrid.DirectionalAssociationIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.HierarchyIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.HierarchyResolutionPolicy;
import org.LexGrid.LexBIG.DataModel.enums.HierarchyPathResolveOption;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException;


/**
 * Convenience methods to be implemented as a generic extension of the LexBIG
 * API.
 */
public interface LexBIGServiceConvenienceMethodsGrid  {

	/**
	 * Create a CodedNodeSet from a set of concept codes in a coding scheme.
	 * 
	 * @param conceptCodes
	 *            The concept codes for included items.
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @return A CodedNodeSet representing the corresponding coded entries.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	CodedNodeSetGrid createCodeNodeSet(ConceptIdentification[] conceptCodes,
			CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag)
		throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Returns the identifiers for hierarchical relationships available
	 * for navigation within a coding scheme.  These identifiers can be
	 * submitted to the getHierarchyBroader() or getHierarchyNarrower()
	 * methods to navigate corresponding tree structures.
	 * <p>
	 * Possible return values are defined by the LexBIG model (see
	 * http://informatics.mayo.edu/LexGrid/downloads/LexGrid%20Model/
	 * schemas/2008/01/EAwebpublish/index.htm).
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @return
	 *            The array of identifiers; empty if no hierarchies are
	 *            explicitly defined (the ontology is 'flat').
	 *         
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	HierarchyIdentification[] getHierarchyIDs(CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag)
		throws LBException, InvalidServiceContextAccess, RemoteException;
	
	/**
	 * Returns all root nodes for the given hierarchy and
	 * coding scheme.  Each root concept represents the conceptual start
	 * or narrowest point of a tree when visualizing the hierarchy.  
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @param hierarchyIdentification
	 *            Identifies the type of hierarchy being traversed.
	 *            Supported values for the coding scheme are retrievable
	 *            through the getHierarchyIdentifications() method.  If null, roots
	 *            for all registered hierarchies are returned.
	 * @return
	 *            The collection of references to root nodes; empty if the
	 *            given hierarchy is not recognized or is unfulfilled by the
	 *            given coding scheme and version.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	ResolvedConceptReferenceList getHierarchyRoots(CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag,
			HierarchyIdentification hierarchyIdentification)
		throws LBException, InvalidServiceContextAccess, RemoteException;
	
	/**
	 * Returns all root nodes for the given hierarchy as a CodeNodeSet,
	 * which can be further restricted.  Each root
	 * concept represents the conceptual start or narrowest point of a
	 * tree when visualizing the hierarchy.  
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @param hierarchyIdentification
	 *            Identifies the type of hierarchy being traversed.
	 *            Supported values for the coding scheme are retrievable
	 *            through the getHierarchyIdentifications() method.  If null, roots
	 *            for all registered hierarchies are returned.
	 * @return
	 *            The collection of references to root nodes; empty if the
	 *            given hierarchy is not recognized or is unfulfilled by the
	 *            given coding scheme and version.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	CodedNodeSetGrid getHierarchyRootSet(CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag,
			HierarchyIdentification hierarchyIdentification)
		throws LBException, InvalidServiceContextAccess, RemoteException;
	
	/**
	 * Return a representation of associations between a concept and its
	 * immediate decendents.  The resolved association list represents the
	 * next branch of the hierarchy when visualized in a top (root)
	 * to bottom (leaf) representation.
	 * 
	 * @param policy
	 *         Policy for resolving the hierarchy
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @return
	 *            The list of associations and referenced concepts
	 *            representing immediate decendents within the hierarchy;
	 *            empty if no items are found.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	AssociationList getHierarchyLevelNext(HierarchyResolutionPolicy policy, CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return a representation of associations between a concept and its
	 * immediate ancestor(s).  The resolved association list represents the
	 * previous level of the hierarchy when visualized in a top (root)
	 * to bottom (leaf) representation.
	 * 
	 * @param policy
	 *         Policy for resolving the CodedNodeSet
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @return
	 *            The list of associations and referenced concepts
	 *            representing the immediate ancestor(s) within the hierarchy;
	 *            empty if no items are found.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	AssociationList getHierarchyLevelPrev(HierarchyResolutionPolicy policy, CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;
	
	/**
	 * Return a representation of associations between a concept and
	 * hierarchical root node(s).  The resolved association list represents the
	 * path within the hierarchy from traversed from bottom (leaf) to
	 * top (root).
	 * 
	 * @param policy
	 *         Policy for resolving the CodedNodeSet
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @return
	 *            The list of associations and referenced concepts
	 *            representing the path to root node(s) within the hierarchy;
	 *            empty if no items are found.  If not empty, each
	 *            association in the initial list represents a separate path
	 *            to root for the given concept.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	AssociationList getHierarchyPathToRoot(HierarchyResolutionPolicy policy, CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag, HierarchyPathResolveOption pathResolveOption) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return detailed rendering information (including coding scheme summary,
	 * version and status information, reference links, etc) for the given
	 * coding scheme; null if not available.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	CodingSchemeRendering getRenderingDetail(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Indicates if the given code is considered retired or inactive within
	 * context of the provided scheme.
	 * 
	 * @param conceptCode
	 *            The concept code to evaluate.
	 * @param codingScheme
	 *            The local name or URN of the coding scheme to query.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme to query.
	 * @return true if retired; false otherwise
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	CodeState isCodeRetired(ConceptIdentification conceptCode, CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the coding schemes who supported association matching with
	 * AssociationIdentification.  The search is performed only for loaded coding schemes.
	 * 
	 * @param AssociationIdentification
	 * 				Association name to search for. It is case sensitive.
	 * @return
	 * 				List of coding schemes who has supported association matching
	 * 				with the value of AssociationIdentification
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */
	public CodingSchemeRenderingList getCodingSchemesWithSupportedAssociation
	(AssociationIdentification AssociationIdentification) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return all the association forward name and reverse name for the coding scheme.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */	
	public AssociationIdentification[] getAssociationForwardAndReverseNames(CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the forward name for the identified association.
	 * 
	 * @param association
	 *            Primary name of the association.
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */	
	public DirectionalAssociationIdentification getAssociationForwardName(AssociationIdentification association, CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return all the association forward name for the coding scheme.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */	
	public DirectionalAssociationIdentification[] getAssociationForwardNames(CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the reverse name for the identified association.
	 * 
	 * @param association
	 *            Basic (non-directional) name of the association.
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */	
	public DirectionalAssociationIdentification getAssociationReverseName(AssociationIdentification association, CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return all the association reverse name for the coding scheme.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */	
	public DirectionalAssociationIdentification[] getAssociationReverseNames(CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return true if directionalName is the forward name of an association for the coding scheme.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @param directionalName
	 *            The directionalName string           
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */	
	public Direction isForwardName(CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag, AssociationIdentification directionalName) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return true if directionalName is the reverse name of an association for the coding scheme.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @param directionalName
	 *            The directionalName string           
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */	
	public Direction isReverseName(CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag, AssociationIdentification directionalName) throws LBException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the copyright text for the coding scheme.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme.
	 * @param versionOrTag
	 *            The assigned tag/label or absolute version identifier of the
	 *            coding scheme.
	 * @throws LBException, InvalidServiceContextAccess, RemoteException
	 */	
	public CodingSchemeCopyRight getCodingSchemeCopyright(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException;
}