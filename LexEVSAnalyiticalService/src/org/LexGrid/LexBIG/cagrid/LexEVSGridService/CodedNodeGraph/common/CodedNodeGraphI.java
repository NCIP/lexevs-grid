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
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public interface CodedNodeGraphI {

  /**
   * Resolve all of the coded nodes in the list, sorting by the supplied property (if any), resolving the supplied properties, resolving coded entries to the supplied depth and resolving associations to the supplied   * depth.
   *
   * @param graphResolutionPolicy
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList resolveAsList(org.LexGrid.LexBIG.DataModel.cagrid.GraphResolutionPolicy graphResolutionPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Return a list of all of the associations in the graph that have the supplied source and target concepts or, if directOnly is false, all associations whose transitive closure has the supplied associations.
   *
   * @param relationshipTypeBasedPolicy
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList listCodeRelationships(org.LexGrid.LexBIG.DataModel.cagrid.RelationshipTypeBasedPolicy relationshipTypeBasedPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Restrict the graph to concept codes (source and target) that originate from the supplied code system. Note: edges defined by other code systems will still be resolved if associated with both source and target nodes for the restricted code system.
   *
   * @param codingSchemeIdentification
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void restrictToSourceCodeSystem(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Restrict the graph to edges that have concepts derived from the supplied code system as a target.
   *
   * @param codingSchemeIdentification
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void restrictToTargetCodeSystem(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Restrict the graph to concept codes (source and target) that originate from the supplied code system. Note: edges defined by other code systems will still be resolved if associated with both source and target nodes for the restricted code system.
   *
   * @param codingSchemeIdentification
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void restrictToCodeSystem(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Restrict the graph to associations that have one of the codes in the supplied list as target codes.
   *
   * @param codes
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void restrictToTargetCodes(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Restrict the graph to associations that have one of the codes in the supplied list as source codes.
   *
   * @param codes
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void restrictToSourceCodes(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Restrict the graph to the nodes that participate as a source or target of an association whose directional name matches the one provided and, if supplied,    * the named association qualifiers.   * A directional name is considered to be either the forward or reverse label     * registered to an association defined by the ontology.  Forward and reverse names     * are optionally assigned to each association.  For example, an association 'lineage' may have a forward name 'ancestorOf' and reverse name 'descendentOf'.
   *
   * @param directionalNames
   * @param associationQualifiers
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void restrictToDirectionalNames(org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList directionalNames,org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Restrict the graph to the nodes that participate as a source or target of the named association and, if supplied, the named association qualifiers.
   *
   * @param associations
   * @param associationQualifiers
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void restrictToAssociations(org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList associations,org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Return a graph that contains only the codes that are present in the supplied list, and all edges that still have a source and target code remaining.
   *
   * @param codes
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void restrictToCodes(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   *  Return the set of concepts and associations that are present in both graphs.
   *
   * @param graph
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void intersect(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.stubs.types.CodedNodeGraphReference graph) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   *  Return the union of the two graphs. Union, in this context, means that the resulting graph contains the unique set of coded entries (String independent) that are present in one or both of the graphs, and the unique combination of edges (associations) present in one or both of the graphs.
   *
   * @param graph
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public void union(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.stubs.types.CodedNodeGraphReference graph) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Determine whether the supplied concept code is in the graph.
   *
   * @param code
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public org.LexGrid.LexBIG.DataModel.cagrid.CodeExistence isCodeInGraph(org.LexGrid.LexBIG.DataModel.Core.ConceptReference code) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Transform the graph into a simple of list of concept codes, removing all association information.
   *
   * @param nodeListPolicy
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.client.CodedNodeSetClient toNodeList(org.LexGrid.LexBIG.DataModel.cagrid.NodeListPolicy nodeListPolicy) throws RemoteException, org.apache.axis.types.URI.MalformedURIException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Determine whether there is an directed edge (or transitive closure of an edge) from the source code to the target code in this graph. The last parameter determines whether only direct associations are considered or  whether the transitive closure of the edge is used.
   *
   * @param relationshipTypeBasedPolicy
   * @param nameAndValue
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public org.LexGrid.LexBIG.DataModel.cagrid.CodeRelationship areCodesRelated(org.LexGrid.LexBIG.DataModel.cagrid.RelationshipTypeBasedPolicy relationshipTypeBasedPolicy,org.LexGrid.LexBIG.DataModel.Core.NameAndValue nameAndValue) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  /**
   * Return a list of all of the associations in the graph that have the supplied source and target concepts based on distance between them. Distance (or the No. of edges) for a direct association between a source and target codes is 1. Values if distance should be equal or greater than 1, otherwise exception is thrown. Resulting list is not based on associations source & target have, but on distance only.
   *
   * @param relationshipDistanceBasedPolicy
   * @throws InvalidServiceContextAccess
   *	
   * @throws LBInvocationException
   *	
   * @throws LBParameterException
   *	
   */
  public org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList listCodeRelationships2(org.LexGrid.LexBIG.DataModel.cagrid.RelationshipDistanceBasedPolicy relationshipDistanceBasedPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.lifetime.DestroyResponse destroy(org.oasis.wsrf.lifetime.Destroy params) throws RemoteException ;

  public org.oasis.wsrf.lifetime.SetTerminationTimeResponse setTerminationTime(org.oasis.wsrf.lifetime.SetTerminationTime params) throws RemoteException ;

}

