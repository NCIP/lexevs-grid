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
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList;
import org.LexGrid.LexBIG.DataModel.cagrid.ConceptIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.HierarchyIdentification;
import org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResource;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResourceHome;

/**
 * TODO:I am the service side implementation class. IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public class LexBIGServiceConvenienceMethodsImpl extends
		LexBIGServiceConvenienceMethodsImplBase {

	public LexBIGServiceConvenienceMethodsImpl() throws RemoteException {
		super();
	}

  public org.LexGrid.LexBIG.DataModel.InterfaceElements.CodingSchemeRendering getRenderingDetail(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			return lbcm.getRenderingDetail(codingSchemeIdentification.getName(), versionOrTag);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeRenderingList getCodingSchemesWithSupportedAssociation(org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification associationIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			return lbcm.getCodingSchemesWithSupportedAssociation(associationIdentification.getRelationshipName());
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.cagrid.HierarchyIdentification[] getHierarchyIDs(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String[] hierIds = lbcm.getHierarchyIDs(codingSchemeIdentification.getName(), versionOrTag);
			return Utils.stringArrayToHierarchyIdentification(hierIds);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.cagrid.CodeState isCodeRetired(org.LexGrid.LexBIG.DataModel.cagrid.ConceptIdentification conceptIdentification,org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			boolean isRetiered = lbcm.isCodeRetired(conceptIdentification.getCode(), codingSchemeIdentification.getName(), versionOrTag);
			return Utils.wrapCodeState(isRetiered);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.cagrid.DirectionalAssociationIdentification getAssociationForwardName(org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification associationIdentification,org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String assocName = lbcm.getAssociationForwardName(associationIdentification.getRelationshipName(),
					codingSchemeIdentification.getName(), versionOrTag);
			return Utils.wrapDirectionalAssociationIdentification(assocName, true);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.cagrid.DirectionalAssociationIdentification[] getAssociationForwardNames(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String[] assocNames = lbcm.getAssociationForwardNames(codingSchemeIdentification.getName(), versionOrTag);
			return Utils.stringArrayToDirectionalAssociationIdentification(assocNames, true);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.cagrid.DirectionalAssociationIdentification getAssociationReverseName(org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification associationIdentification,org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String assocName = lbcm.getAssociationReverseName(associationIdentification.getRelationshipName(),
					codingSchemeIdentification.getName(), versionOrTag);
			return Utils.wrapDirectionalAssociationIdentification(assocName, false);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.cagrid.DirectionalAssociationIdentification[] getAssociationReverseNames(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String[] assocNames = lbcm.getAssociationReverseNames(codingSchemeIdentification.getName(), versionOrTag);
			return Utils.stringArrayToDirectionalAssociationIdentification(assocNames, false);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.cagrid.Direction isForwardName(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification associationIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			boolean isForward = lbcm.isForwardName(codingSchemeIdentification.getName(), versionOrTag,
					associationIdentification.getRelationshipName());
			return Utils.wrapDirection(isForward);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.cagrid.Direction isReverseName(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification associationIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			boolean isReverse = lbcm.isReverseName(codingSchemeIdentification.getName(), versionOrTag,
					associationIdentification.getRelationshipName());
			return Utils.wrapDirection(!isReverse);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.AssociationList getHierarchyLevelNext(org.LexGrid.LexBIG.DataModel.cagrid.HierarchyResolutionPolicy hierarchyResolutionPolicy,org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {	
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			
			NameAndValueList assocQualifiers = hierarchyResolutionPolicy.getAssociationQualifiers();
			HierarchyIdentification hierarchyID = hierarchyResolutionPolicy.getHierarchyId();
			ConceptIdentification conceptCode = hierarchyResolutionPolicy.getConceptCode();
			boolean resolveConcepts = hierarchyResolutionPolicy.getResolveConcepts();
			
			return lbcm.getHierarchyLevelNext(codingSchemeIdentification.getName(), versionOrTag,
					hierarchyID.getIdentifier(), conceptCode.getCode(), resolveConcepts, assocQualifiers);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.AssociationList getHierarchyLevelPrev(org.LexGrid.LexBIG.DataModel.cagrid.HierarchyResolutionPolicy hierarchyResolutionPolicy,org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			
			NameAndValueList assocQualifiers = hierarchyResolutionPolicy.getAssociationQualifiers();
			HierarchyIdentification hierarchyID = hierarchyResolutionPolicy.getHierarchyId();
			ConceptIdentification conceptCode = hierarchyResolutionPolicy.getConceptCode();
			boolean resolveConcepts = hierarchyResolutionPolicy.getResolveConcepts();
			
			return lbcm.getHierarchyLevelPrev(codingSchemeIdentification.getName(), versionOrTag,
					hierarchyID.getIdentifier(), conceptCode.getCode(), resolveConcepts, assocQualifiers);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.AssociationList getHierarchyPathToRoot(org.LexGrid.LexBIG.DataModel.cagrid.HierarchyResolutionPolicy hierarchyResolutionPolicy,org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.DataModel.enums.HierarchyPathResolveOption hierarchyPathResolveOption) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			
			NameAndValueList assocQualifiers = hierarchyResolutionPolicy.getAssociationQualifiers();
			HierarchyIdentification hierarchyID = hierarchyResolutionPolicy.getHierarchyId();
			ConceptIdentification conceptCode = hierarchyResolutionPolicy.getConceptCode();
			boolean resolveConcepts = hierarchyResolutionPolicy.getResolveConcepts();
			
			return lbcm
					.getHierarchyPathToRoot(
							codingSchemeIdentification.getName(),
							versionOrTag,
							hierarchyID.getIdentifier(),
							conceptCode.getCode(),
							resolveConcepts,
							Utils.convertHierarchyPathResolveOption(hierarchyPathResolveOption), assocQualifiers);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList getHierarchyRoots(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.DataModel.cagrid.HierarchyIdentification hierarchyIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			return lbcm.getHierarchyRoots(codingSchemeIdentification.getName(), versionOrTag,
					hierarchyIdentification.getIdentifier());
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference getHierarchyRootSet(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.DataModel.cagrid.HierarchyIdentification hierarchyIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
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
			Calendar cal = new GregorianCalendar();
			cal.add(Calendar.MINUTE, 5);
			thisResource.setTerminationTime(cal);

			LexBIGServiceConvenienceMethodsResourceHome brh = this
					.getResourceHome();
			LexBIGServiceConvenienceMethodsResource lbscmr = brh
					.getAddressedResource();
			LexBIGServiceConvenienceMethods lbscm = lbscmr
					.getLexBIGServiceConvenienceMethods();

			thisResource.setCodedNodeSet(lbscm.getHierarchyRootSet(
					codingSchemeIdentification.getName(), 
					versionOrTag, 
					hierarchyIdentification.getIdentifier()));

			// sample of setting creator only security. This will only allow the
			// caller that created
			// this resource to be able to use it.
			// thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());

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

	private LexBIGServiceConvenienceMethods getLexBIGServiceConvenienceMethods()
			throws Exception {
		LexBIGServiceConvenienceMethods lbcm = getResourceHome()
				.getAddressedResource().getLexBIGServiceConvenienceMethods();
		return lbcm;
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference createCodeNodeSet(org.LexGrid.LexBIG.DataModel.cagrid.ConceptIdentification[] conceptIdentification,org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
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
			Calendar cal = new GregorianCalendar();
			cal.add(Calendar.MINUTE, 5);
			thisResource.setTerminationTime(cal);

			LexBIGServiceConvenienceMethodsResourceHome brh = this
					.getResourceHome();
			LexBIGServiceConvenienceMethodsResource lbscmr = brh
					.getAddressedResource();
			LexBIGServiceConvenienceMethods lbscm = lbscmr
					.getLexBIGServiceConvenienceMethods();

			thisResource.setCodedNodeSet(lbscm.createCodeNodeSet(Utils.conceptIdentificationArrayToString(conceptIdentification),
					codingSchemeIdentification.getName(), versionOrTag));

			// sample of setting creator only security. This will only allow the
			// caller that created
			// this resource to be able to use it.
			// thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());

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

  public org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification[] getAssociationForwardAndReverseNames(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
	  try {
		  String[] assocNames = getLexBIGServiceConvenienceMethods()
		  .getAssociationForwardAndReverseNames(codingSchemeIdentification.getName(),
				  versionOrTag);
		  
		   //TODO: Need to figure out whether to set true or false for the line below.
			return Utils.stringArrayToAssociationIdentification(assocNames);
	  } catch (Exception e) {
			Utils.processException(e);
			return null;
	 }
  }

  public org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeCopyRight getCodingSchemeCopyright(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
	  try {
		  String copyright = getLexBIGServiceConvenienceMethods().getCodingSchemeCopyright(
				  codingSchemeIdentification.getName(), versionOrTag);
		  return Utils.wrapCodingSchemCopyRight(copyright);
	  } catch (Exception e) {
			Utils.processException(e);
			return null;
	 }
  }
  public org.LexGrid.LexBIG.DataModel.Core.Association getAssociationReverseOneLevel(org.LexGrid.LexBIG.DataModel.cagrid.ConceptIdentification conceptIdentification,org.LexGrid.LexBIG.DataModel.cagrid.RelationContainerIdentification relationContainerIdentification,org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification associationIdentification,org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.DataModel.cagrid.ResolveConcepts buildReferencedEntries,org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException {
	  try {
		  String concept = conceptIdentification.getCode();
		  String relationsContainer = relationContainerIdentification.getContextName();
		  String association = associationIdentification.getRelationshipName();
		  String codingScheme = codingSchemeIdentification.getName();
		  Boolean resolve = buildReferencedEntries.getFlag();
		  
		  return getLexBIGServiceConvenienceMethods().getAssociationReverseOneLevel(
				  concept, 
				  relationsContainer, 
				  association, 
				  codingScheme, 
				  versionOrTag, 
				  resolve, 
				  associationQualifiers);
	  } catch (Exception e) {
			Utils.processException(e);
			return null;
	 }
  }

  public org.LexGrid.LexBIG.DataModel.Core.Association getAssociationForwardOneLevel(org.LexGrid.LexBIG.DataModel.cagrid.ConceptIdentification conceptIdentification,org.LexGrid.LexBIG.DataModel.cagrid.RelationContainerIdentification relationContainerIdentification,org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification associationIdentification,org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.DataModel.cagrid.ResolveConcepts buildReferencedEntries,org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException {
	  try {
		  String concept = conceptIdentification.getCode();
		  String relationsContainer = relationContainerIdentification.getContextName();
		  String association = associationIdentification.getRelationshipName();
		  String codingScheme = codingSchemeIdentification.getName();
		  Boolean resolve = buildReferencedEntries.getFlag();
		  
		  return getLexBIGServiceConvenienceMethods().getAssociationForwardOneLevel(
				  concept, 
				  relationsContainer, 
				  association, 
				  codingScheme, 
				  versionOrTag, 
				  resolve, 
				  associationQualifiers);
	  } catch (Exception e) {
			Utils.processException(e);
			return null;
	 }
  }

}
