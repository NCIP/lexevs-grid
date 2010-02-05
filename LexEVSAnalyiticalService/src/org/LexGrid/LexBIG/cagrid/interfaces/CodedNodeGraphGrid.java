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
import java.rmi.RemoteException;

import org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList;
import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.DataModel.Core.NameAndValue;
import org.LexGrid.LexBIG.DataModel.cagrid.CodeExistence;
import org.LexGrid.LexBIG.DataModel.cagrid.CodeRelationship;
import org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.GraphResolutionPolicy;
import org.LexGrid.LexBIG.DataModel.cagrid.NodeListPolicy;
import org.LexGrid.LexBIG.DataModel.cagrid.RelationshipDistanceBasedPolicy;
import org.LexGrid.LexBIG.DataModel.cagrid.RelationshipTypeBasedPolicy;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException;

/**
 * A virtual graph where the edges represent associations and the nodes
 * represent concept codes. A CodedNodeGraph describes a graph that can be
 * combined with other graphs, queried or resolved into an actual graph
 * rendering.
 */
public interface CodedNodeGraphGrid extends Serializable {

	/**
	 * Determine whether there is an directed edge (or transitive closure of an
	 * edge) from the source code to the target code in this graph. The last
	 * parameter determines whether only direct associations are considered or
	 * whether the transitive closure of the edge is used.
	 * 
	 * @param policy
	 *            Policy for resolving the relationship
	 * @param association
	 *            Identifies the association to be tested. The name and value
	 *            will be compared against the local name and URN of supported
	 *            associations for participating coding schemes.
	
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodeRelationship areCodesRelated(RelationshipTypeBasedPolicy policy,
			NameAndValue association) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the set of concepts and associations that are present in both
	 * graphs.
	 * 
	 * @param graph
	 *            Identifies the CodedNodeGraph to be intersected with.
	 * @return A new CodedNodeGraph containing the intersection result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid intersect(CodedNodeGraphGrid graph)
	throws LBInvocationException,
	LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Determine whether the supplied concept code is in the graph.
	 * 
	 * @param code
	 *            Identifies the coding scheme and concept code to test.
	 * @return CodeExistence
	 * 			  True if the concept is present; otherwise False.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodeExistence isCodeInGraph(ConceptReference code)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return a list of all of the associations in the graph that have the
	 * supplied source and target concepts or, if directOnly is false, all
	 * associations whose transitive closure has the supplied associations.
	 * 
	 * @param policy
	 *            Policy for resolving the relationship
	 * @return The list of concept references for matching associations.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	ConceptReferenceList listCodeRelationships(
			RelationshipTypeBasedPolicy policy) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException;
	


	/**
	 * Return a list of all of the associations in the graph that have the
	 * supplied source and target concepts based on distance between them.
	 * Distance (or the No. of edges) for a direct association between a 
	 * source and target codes is 1. Values if distance should be equal or 
	 * greater than 1, otherwise exception is thrown. Resulting list is not
	 * based on associations source & target have, but on distance only.
	 * 
	 * @param policy
	 *            Policy for resolving the relationship
	 * @return The list of concept references for matching associations.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	ConceptReferenceList listCodeRelationships(
			RelationshipDistanceBasedPolicy policy) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Resolve all of the coded nodes in the list, sorting by the supplied
	 * property (if any), resolving the supplied properties, resolving coded
	 * entries to the supplied depth and resolving associations to the supplied
	 * depth.
	 * 
	 * @param policy
	 *            Policy for resolving the relationship
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	ResolvedConceptReferenceList resolveAsList(
			GraphResolutionPolicy policy)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;
	
	/**
	 * Restrict the graph to the nodes that participate as a source or target of
	 * the named association and, if supplied, the named association qualifiers.
	 * 
	 * @param association
	 *            List of associations used to restrict the graph.  The name and
	 *            value for each item in the list will be compared against the
	 *            local name and URN of supported associations for participating
	 *            coding schemes.
	 * @param associationQualifiers
	 *            If supplied, restriction only applies to associations that are
	 *            qualified by one or more of the supplied qualifiers.  The name
	 *            and value for each item in the list will be compared against
	 *            the local name and URN of supported association qualifiers for
	 *            participating coding schemes.
	 * @return A new CodedNodeGraph containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid restrictToAssociations(
			NameAndValueList association,
			NameAndValueList associationQualifiers)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;


	/**
	 * Restrict the graph to the nodes that participate as a source or target of
	 * an association whose directional name matches the one provided and, if supplied, 
	 * the named association qualifiers.
	 * A directional name is considered to be either the forward or reverse label
	 * registered to an association defined by the ontology.  Forward and reverse names
	 * are optionally assigned to each association.  For example, an association
	 * 'lineage' may have a forward name 'ancestorOf' and reverse name
	 * 'descendentOf'.
	 * 
	 * @param directionalNames
	 *            List of directionalNames used to restrict the graph.  
	 *            A directional name is compared against the forward and reverse
	 *            names for defined associations.  If a given name matches more
	 *            than one forward or reverse label, all corresponding
	 *            associations are included in the restriction.
	 * @param associationQualifiers
	 *            If supplied, restriction only applies to associations that are
	 *            qualified by one or more of the supplied qualifiers.  The name
	 *            and value for each item in the list will be compared against
	 *            the local name and URN of supported association qualifiers for
	 *            participating coding schemes.
	 * @return A new CodedNodeGraph containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid restrictToDirectionalNames(
			NameAndValueList directionalNames,
			NameAndValueList associationQualifiers)
	throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;	
	
	/**
	 * Return a graph that contains only the codes that are present in the
	 * supplied list, and all edges that still have a source and target code
	 * remaining.
	 * 
	 * @param codes
	 *            Codes to filter on.
	 * @return A new CodedNodeGraph containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid restrictToCodes(CodedNodeSetGrid codes)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Restrict the graph to concept codes (source and target) that originate
	 * from the supplied code system. Note: edges defined by other code systems
	 * will still be resolved if associated with both source and target nodes
	 * for the restricted code system.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme to filter on.
	 * @return A new CodedNodeGraph containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid restrictToCodeSystem(CodingSchemeIdentification codingScheme)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Restrict the graph to associations that have one of the codes in the
	 * supplied list as source codes.
	 * 
	 * @param codes
	 *            Codes to filter on.
	 * @return A new CodedNodeGraph containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid restrictToSourceCodes(CodedNodeSetGrid codes)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Restrict the graph to edges that have concepts derived from the supplied
	 * code system as a source.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme to filter on.
	 * @return A new CodedNodeGraph containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid restrictToSourceCodeSystem(CodingSchemeIdentification codingScheme)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Restrict the graph to associations that have one of the codes in the
	 * supplied list as target codes.
	 * 
	 * @param codes
	 *            Codes to filter on.
	 * @return A new CodedNodeGraph containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid restrictToTargetCodes(CodedNodeSetGrid codes)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Restrict the graph to edges that have concepts derived from the supplied
	 * code system as a target.
	 * 
	 * @param codingScheme
	 *            The local name or URN of the coding scheme to filter on.
	 * @return A new CodedNodeGraph containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid restrictToTargetCodeSystem(CodingSchemeIdentification codingScheme)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Transform the graph into a simple of list of concept codes, removing all
	 * association information.
	 * 
	 * @param policy
	 *            Policy for resolving the relationship
	 * @throws LBInvocationException,LBParameterException
	 */
	CodedNodeSetGrid toNodeList(NodeListPolicy policy)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the union of the two graphs. Union, in this context, means that
	 * the resulting graph contains the unique set of coded entries (String
	 * independent) that are present in one or both of the graphs, and the
	 * unique combination of edges (associations) present in one or both of the
	 * graphs.
	 * 
	 * @param graph
	 *            Identifies the CodedNodeGraph to merge with.
	 * @return A new CodedNodeGraph containing the merged result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeGraphGrid union(CodedNodeGraphGrid graph)
			throws LBInvocationException,LBParameterException, InvalidServiceContextAccess, RemoteException;

}