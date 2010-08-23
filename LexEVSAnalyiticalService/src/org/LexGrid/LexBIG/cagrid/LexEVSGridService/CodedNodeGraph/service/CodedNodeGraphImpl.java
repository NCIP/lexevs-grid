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
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.service;

import gov.nih.nci.iso21090.St;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.namespace.QName;

import org.LexGrid.LexBIG.DataModel.Collections.LocalNameList;
import org.LexGrid.LexBIG.DataModel.Collections.SortOptionList;
import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.common.CodedNodeGraphConstants;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.service.globus.resource.CodedNodeGraphResource;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.common.CodedNodeSetConstants;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.service.globus.resource.CodedNodeSetResource;
import org.apache.axis.message.MessageElement;
import org.globus.wsrf.ResourceKey;
import org.globus.wsrf.impl.SimpleResourceKey;

/**
 * TODO:I am the service side implementation class. IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public class CodedNodeGraphImpl extends CodedNodeGraphImplBase {

	public CodedNodeGraphImpl() throws RemoteException {
		super();
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.ResolvedConceptReferenceList resolveAsList(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.GraphResolutionPolicy graphResolutionPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			ConceptReference graphFocus = graphResolutionPolicy.getGraphFocus();
			boolean resolveForward = graphResolutionPolicy.getResolveForward();
			boolean resolveBackward = graphResolutionPolicy.getResolveBackwards();
			int resolveCodedEntryDepth = graphResolutionPolicy.getResolveCodedEntryDepth();
			int resolveAssociationDepth = graphResolutionPolicy.getResolveAssociationDepth();
			LocalNameList propertyNames = graphResolutionPolicy.getPropertyNames();
			PropertyType[] propertyTypes = Utils.convertPropertyType(graphResolutionPolicy.getPropertyTypes());
			SortOptionList sortOptions = graphResolutionPolicy.getSortOptions();
			int maxToReturn = graphResolutionPolicy.getMaximumToReturn();
			
			St st = new St();
			
			return getResourceHome().getAddressedResource().getCodedNodeGraph()
					.resolveAsList(graphFocus, resolveForward, resolveBackward,
							resolveCodedEntryDepth, resolveAssociationDepth,
							propertyNames,
							propertyTypes,
							sortOptions, maxToReturn);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList listCodeRelationships(org.LexGrid.LexBIG.DataModel.cagrid.RelationshipTypeBasedPolicy relationshipTypeBasedPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
	  ConceptReference sourceCode = relationshipTypeBasedPolicy.getSourceConcept();
	  ConceptReference targetCode = relationshipTypeBasedPolicy.getTargetConcept();
	  boolean directOnly = relationshipTypeBasedPolicy.getDirectOnly();
	  
	  throw new UnsupportedOperationException();
	  /*
	  try {
			return getResourceHome().getAddressedResource().getCodedNodeGraph()
					.listCodeRelationships(sourceCode, targetCode, directOnly);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		} 
		*/
	}

  public void restrictToTargetCodeSystem(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			getResourceHome().getAddressedResource().getCodedNodeGraph()
					.restrictToTargetCodeSystem(codingSchemeIdentification.getName());
		} catch (Exception e) {
			Utils.processException(e);
		}
	}

  public void restrictToCodeSystem(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			getResourceHome().getAddressedResource().getCodedNodeGraph()
					.restrictToCodeSystem(codingSchemeIdentification.getName());
		} catch (Exception e) {
			Utils.processException(e);
		} 
	}

  public void restrictToTargetCodes(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			QName name = CodedNodeSetConstants.RESOURCE_KEY;

			MessageElement returnedValue = codes.getEndpointReference()
					.getProperties().get(name);
			String value = returnedValue.getValue();

			ResourceKey newKey = new SimpleResourceKey(name, value);
			CodedNodeSetResource cnsr = this.getCodedNodeSetResourceHome()
					.getResource((newKey));
			CodedNodeSet cns = cnsr.getCodedNodeSet();

			getResourceHome().getAddressedResource().getCodedNodeGraph()
					.restrictToTargetCodes(cns);
		} catch (Exception e) {
			Utils.processException(e);
		}
	}

  public void restrictToSourceCodes(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			QName name = CodedNodeSetConstants.RESOURCE_KEY;

			MessageElement returnedValue = codes.getEndpointReference()
					.getProperties().get(name);
			String value = returnedValue.getValue();

			ResourceKey newKey = new SimpleResourceKey(name, value);
			CodedNodeSetResource cnsr = this.getCodedNodeSetResourceHome()
					.getResource((newKey));
			CodedNodeSet cns = cnsr.getCodedNodeSet();

			getResourceHome().getAddressedResource().getCodedNodeGraph()
					.restrictToSourceCodes(cns);
		} catch (Exception e) {
			Utils.processException(e);
		}
	}

  public void restrictToDirectionalNames(org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList directionalNames,org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			getResourceHome().getAddressedResource().getCodedNodeGraph()
					.restrictToDirectionalNames(directionalNames,
							associationQualifiers);
		} catch (Exception e) {
			Utils.processException(e);
		} 
	}

  public void restrictToAssociations(org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList associations,org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			getResourceHome()
					.getAddressedResource()
					.getCodedNodeGraph()
					.restrictToAssociations(associations, associationQualifiers);
		} catch (Exception e) {
			Utils.processException(e);
		}
	}

  public void restrictToCodes(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			QName name = CodedNodeSetConstants.RESOURCE_KEY;

			MessageElement returnedValue = codes.getEndpointReference()
					.getProperties().get(name);
			String value = returnedValue.getValue();

			ResourceKey newKey = new SimpleResourceKey(name, value);
			CodedNodeSetResource cnsr = this.getCodedNodeSetResourceHome()
					.getResource((newKey));
			CodedNodeSet cns = cnsr.getCodedNodeSet();

			getResourceHome().getAddressedResource().getCodedNodeGraph()
					.restrictToCodes(cns);
		} catch (Exception e) {
			Utils.processException(e);
		} 
	}

  public void intersect(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.stubs.types.CodedNodeGraphReference graph) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			QName name = CodedNodeGraphConstants.RESOURCE_KEY;

			MessageElement returnedValue = graph.getEndpointReference()
					.getProperties().get(name);
			String value = returnedValue.getValue();

			ResourceKey newKey = new SimpleResourceKey(name, value);
			CodedNodeGraphResource cngr = this.getResourceHome().getResource(
					(newKey));
			CodedNodeGraph cng = cngr.getCodedNodeGraph();

			getResourceHome().getAddressedResource().getCodedNodeGraph()
					.intersect(cng);
		} catch (Exception e){
			Utils.processException(e);
		}
	}

  public void union(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.stubs.types.CodedNodeGraphReference graph) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			QName name = CodedNodeGraphConstants.RESOURCE_KEY;

			MessageElement returnedValue = graph.getEndpointReference()
					.getProperties().get(name);
			String value = returnedValue.getValue();

			ResourceKey newKey = new SimpleResourceKey(name, value);
			CodedNodeGraphResource cngr = this.getResourceHome().getResource(
					(newKey));
			CodedNodeGraph cng = cngr.getCodedNodeGraph();

			getResourceHome().getAddressedResource().getCodedNodeGraph().union(
					cng);
		} catch (Exception e){
			Utils.processException(e);
		}
	}

  public void restrictToSourceCodeSystem(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			getResourceHome().getAddressedResource().getCodedNodeGraph()
					.restrictToSourceCodeSystem(codingSchemeIdentification.getName());
		} catch (Exception e) {
			Utils.processException(e);
		}
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeExistence isCodeInGraph(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference code) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			boolean isInGraph = getResourceHome().getAddressedResource().getCodedNodeGraph()
					.isCodeInGraph(code);
			 return Utils.wrapCodeExistence(isInGraph);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference toNodeList(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.NodeListPolicy nodeListPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.service.globus.resource.CodedNodeSetResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext
				.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME
				+ servicePath + "/" + "codedNodeSetHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.service.globus.resource.CodedNodeSetResourceHome) initialContext
					.lookup(homeName);
			resourceKey = home.createResource();

			// Grab the newly created resource
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.service.globus.resource.CodedNodeSetResource thisResource = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.service.globus.resource.CodedNodeSetResource) home
					.find(resourceKey);

			// This is where the creator of this resource type can set whatever
			// needs
			// to be set on the resource so that it can function appropriatly
			// for instance
			// if you want the resouce to only have the query string then there
			// is where you would
			// give it the query string.
			
			ConceptReference graphFocus = nodeListPolicy.getGraphFocus();
			boolean resolveForward = nodeListPolicy.getResolveForward();
			boolean resolveBackward = nodeListPolicy.getResolveBackward();
			int resolveAssociationDepth = nodeListPolicy.getResolveAssociationDepth();
			int maxToReturn = nodeListPolicy.getMaximumToReturn();
		

			CodedNodeSet cns = getResourceHome().getAddressedResource()
					.getCodedNodeGraph().toNodeList(graphFocus, resolveForward,
							resolveBackward, resolveAssociationDepth,
							maxToReturn);
			thisResource.setCodedNodeSet(cns);
			// sample of setting creator only security. This will only allow the
			// caller that created
			// this resource to be able to use it.
			// thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());
			Calendar cal = new GregorianCalendar();
			cal.add(Calendar.MINUTE, 5);
			thisResource.setTerminationTime(cal);

			String transportURL = (String) ctx
					.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0, transportURL
					.lastIndexOf('/') + 1);
			transportURL += "CodedNodeSet";
			epr = org.globus.wsrf.utils.AddressingUtils
					.createEndpointReference(transportURL, resourceKey);
		} catch (Exception e) {
			Utils.processException(e);
		}

		// return the typed EPR
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference ref = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference();
		ref.setEndpointReference(epr);

		return ref;
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeRelationship areCodesRelated(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationshipTypeBasedPolicy relationshipTypeBasedPolicy,org.LexGrid.LexBIG.iso21090.DataModel.Core.NameAndValue nameAndValue) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
	
	  ConceptReference sourceCode = relationshipTypeBasedPolicy.getSourceConcept();
	  ConceptReference targetCode =relationshipTypeBasedPolicy.getTargetConcept();
	  boolean directOnly = relationshipTypeBasedPolicy.getDirectOnly();

	  try {
			boolean areRelated = getResourceHome().getAddressedResource().getCodedNodeGraph()
					.areCodesRelated(nameAndValue, sourceCode, targetCode,
							directOnly);
			 
			 return Utils.wrapCodeRelationship(areRelated);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList listCodeRelationships2(org.LexGrid.LexBIG.DataModel.cagrid.RelationshipDistanceBasedPolicy relationshipDistanceBasedPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
	  ConceptReference sourceCode = relationshipDistanceBasedPolicy.getSourceConcept();
	  ConceptReference targetCode = relationshipDistanceBasedPolicy.getTargetConcept();
	  int distance = relationshipDistanceBasedPolicy.getDistance();
	 
	  
	  throw new UnsupportedOperationException();
	  /*
	  try {
			return getResourceHome().getAddressedResource().getCodedNodeGraph()
					.listCodeRelationships(sourceCode, targetCode, distance);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
		*/
	}

}
