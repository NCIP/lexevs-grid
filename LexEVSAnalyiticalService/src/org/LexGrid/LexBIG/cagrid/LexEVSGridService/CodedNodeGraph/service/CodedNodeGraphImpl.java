/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.service;

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
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;
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
			ConceptReference graphFocus = ConvertUtils.convert(graphResolutionPolicy.getGraphFocus(), ConceptReference.class);
			boolean resolveForward = graphResolutionPolicy.getResolveForward().getValue();
			boolean resolveBackward = graphResolutionPolicy.getResolveBackwards().getValue();
			int resolveCodedEntryDepth = graphResolutionPolicy.getResolveCodedEntryDepth().getValue();
			int resolveAssociationDepth = graphResolutionPolicy.getResolveAssociationDepth().getValue();
			LocalNameList propertyNames = ConvertUtils.convert(graphResolutionPolicy.getPropertyNames(), LocalNameList.class);
			PropertyType[] propertyTypes = Utils.convertPropertyType(graphResolutionPolicy.getPropertyTypes());
			SortOptionList sortOptions = ConvertUtils.convert(graphResolutionPolicy.getSortOptions(), SortOptionList.class);
			int maxToReturn = graphResolutionPolicy.getMaximumToReturn().getValue();
	
			org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList
				list = getResourceHome().getAddressedResource().getCodedNodeGraph()
					.resolveAsList(graphFocus, resolveForward, resolveBackward,
							resolveCodedEntryDepth, resolveAssociationDepth,
							propertyNames,
							propertyTypes,
							sortOptions, maxToReturn);
			
			return ConvertUtils.convert(list, org.LexGrid.LexBIG.iso21090.DataModel.Collections.ResolvedConceptReferenceList.class);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList listCodeRelationships(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationshipTypeBasedPolicy relationshipTypeBasedPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
	  ConceptReference sourceCode = ConvertUtils.convert(relationshipTypeBasedPolicy.getSourceConcept(), ConceptReference.class);
	  ConceptReference targetCode = ConvertUtils.convert(relationshipTypeBasedPolicy.getTargetConcept(), ConceptReference.class);
	  boolean directOnly = relationshipTypeBasedPolicy.getDirectOnly().getValue();
	  
	  try {
			return 
				ConvertUtils.convert(getResourceHome().getAddressedResource().getCodedNodeGraph()
					.listCodeRelationships(
							sourceCode, 
							targetCode,
							directOnly), org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList.class);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		} 
	}

  public void restrictToTargetCodeSystem(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			CodedNodeGraph cng = getResourceHome().getAddressedResource().getCodedNodeGraph();
			cng = cng.restrictToTargetCodeSystem(codingSchemeIdentification.getName().getValue());
			this.getResourceHome().getAddressedResource().setCodedNodeGraph(cng);
		} catch (Exception e) {
			Utils.processException(e);
		}
	}

  public void restrictToCodeSystem(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			CodedNodeGraph cng = getResourceHome().getAddressedResource().getCodedNodeGraph();
			cng = cng.restrictToCodeSystem(codingSchemeIdentification.getName().getValue());
			this.getResourceHome().getAddressedResource().setCodedNodeGraph(cng);
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

			CodedNodeGraph cng = getResourceHome().getAddressedResource().getCodedNodeGraph();
			cng = cng.restrictToSourceCodes(cns);
			this.getResourceHome().getAddressedResource().setCodedNodeGraph(cng);
		} catch (Exception e) {
			Utils.processException(e);
		}
	}

  public void restrictToDirectionalNames(org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList directionalNames,org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			CodedNodeGraph cng = 
				getResourceHome().getAddressedResource().getCodedNodeGraph();
			cng = cng.restrictToDirectionalNames(
							ConvertUtils.convert(directionalNames, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList.class),
							ConvertUtils.convert(associationQualifiers, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList.class)
					);
			this.getResourceHome().getAddressedResource().setCodedNodeGraph(cng);
		} catch (Exception e) {
			Utils.processException(e);
		} 
	}

  public void restrictToAssociations(org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList associations,org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			CodedNodeGraph cng = getResourceHome()
					.getAddressedResource()
					.getCodedNodeGraph();
			cng = cng.restrictToAssociations(
							ConvertUtils.convert(associations, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList.class),
							ConvertUtils.convert(associationQualifiers, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList.class));
		
			this.getResourceHome().getAddressedResource().setCodedNodeGraph(cng);
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

			CodedNodeGraph cng = getResourceHome().getAddressedResource().getCodedNodeGraph();
			
			cng = cng.restrictToCodes(cns);
			
			this.getResourceHome().getAddressedResource().setCodedNodeGraph(cng);
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

			CodedNodeGraph resource = getResourceHome().getAddressedResource().getCodedNodeGraph();
			resource = resource.intersect(cng);
			
			this.getResourceHome().getAddressedResource().setCodedNodeGraph(resource);
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

			CodedNodeGraph resource = getResourceHome().getAddressedResource().getCodedNodeGraph();
			resource = resource.union(cng);
			
			this.getResourceHome().getAddressedResource().setCodedNodeGraph(resource);
		} catch (Exception e){
			Utils.processException(e);
		}
	}

  public void restrictToSourceCodeSystem(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			CodedNodeGraph cng = getResourceHome().getAddressedResource().getCodedNodeGraph();
			cng = cng.restrictToSourceCodeSystem(codingSchemeIdentification.getName().getValue());
		
			this.getResourceHome().getAddressedResource().setCodedNodeGraph(cng);
		} catch (Exception e) {
			Utils.processException(e);
		}
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeExistence isCodeInGraph(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference code) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			boolean isInGraph = getResourceHome().getAddressedResource().getCodedNodeGraph()
					.isCodeInGraph(
							ConvertUtils.convert(code, org.LexGrid.LexBIG.DataModel.Core.ConceptReference.class));
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
			
			ConceptReference graphFocus = ConvertUtils.convert(nodeListPolicy.getGraphFocus(), ConceptReference.class);
			boolean resolveForward = nodeListPolicy.getResolveForward().getValue();
			boolean resolveBackward = nodeListPolicy.getResolveBackward().getValue();
			int resolveAssociationDepth = nodeListPolicy.getResolveAssociationDepth().getValue();
			int maxToReturn = nodeListPolicy.getMaximumToReturn().getValue();
		

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
	
	  ConceptReference sourceCode = ConvertUtils.convert(relationshipTypeBasedPolicy.getSourceConcept(), ConceptReference.class);
	  ConceptReference targetCode = ConvertUtils.convert(relationshipTypeBasedPolicy.getTargetConcept(), ConceptReference.class);
	  boolean directOnly = relationshipTypeBasedPolicy.getDirectOnly().getValue();

	  try {
			boolean areRelated = getResourceHome().getAddressedResource().getCodedNodeGraph()
					.areCodesRelated(
							ConvertUtils.convert(nameAndValue, org.LexGrid.LexBIG.DataModel.Core.NameAndValue.class),
							sourceCode, 
							targetCode,
							directOnly);
			 
			 return Utils.wrapCodeRelationship(areRelated);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList listCodeRelationships2(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationshipDistanceBasedPolicy relationshipDistanceBasedPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
	  ConceptReference sourceCode = ConvertUtils.convert(relationshipDistanceBasedPolicy.getSourceConcept(), ConceptReference.class);
	  ConceptReference targetCode = ConvertUtils.convert(relationshipDistanceBasedPolicy.getTargetConcept(), ConceptReference.class);
	  int distance = relationshipDistanceBasedPolicy.getDistance().getValue();
	  
	  try {
			return 
				ConvertUtils.convert(getResourceHome().getAddressedResource().getCodedNodeGraph()
					.listCodeRelationships(
							sourceCode, 
							targetCode,
							distance), org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList.class);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		} 
	}

}
