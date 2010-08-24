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
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ConceptIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyIdentification;
import org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResource;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResourceHome;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;

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

  public org.LexGrid.LexBIG.iso21090.DataModel.InterfaceElements.CodingSchemeRendering getRenderingDetail(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			return ConvertUtils.convert(
					lbcm.getRenderingDetail(
						codingSchemeIdentification.getName().getValue(), 
						ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class)),
					org.LexGrid.LexBIG.iso21090.DataModel.InterfaceElements.CodingSchemeRendering.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.CodingSchemeRenderingList getCodingSchemesWithSupportedAssociation(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification associationIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			return ConvertUtils.convert(
					lbcm.getCodingSchemesWithSupportedAssociation(
					associationIdentification.getRelationshipName().getValue()),
					org.LexGrid.LexBIG.iso21090.DataModel.Collections.CodingSchemeRenderingList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyIdentification[] getHierarchyIDs(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String[] hierIds = lbcm.getHierarchyIDs(
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class));
			return Utils.stringArrayToHierarchyIdentification(hierIds);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeState isCodeRetired(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ConceptIdentification conceptIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			boolean isRetiered = lbcm.isCodeRetired(
					conceptIdentification.getCode().getValue(), 
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class));
			return Utils.wrapCodeState(isRetiered);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.DirectionalAssociationIdentification getAssociationForwardName(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification associationIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String assocName = lbcm.getAssociationForwardName(
					associationIdentification.getRelationshipName().getValue(),
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class));
			return Utils.wrapDirectionalAssociationIdentification(assocName, true);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.DirectionalAssociationIdentification[] getAssociationForwardNames(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String[] assocNames = lbcm.getAssociationForwardNames(
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class));
			return Utils.stringArrayToDirectionalAssociationIdentification(assocNames, true);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.DirectionalAssociationIdentification getAssociationReverseName(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification associationIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String assocName = lbcm.getAssociationReverseName(
					associationIdentification.getRelationshipName().getValue(),
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class));
			return Utils.wrapDirectionalAssociationIdentification(assocName, false);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.DirectionalAssociationIdentification[] getAssociationReverseNames(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			String[] assocNames = lbcm.getAssociationReverseNames(
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class));
			return Utils.stringArrayToDirectionalAssociationIdentification(assocNames, false);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.Direction isForwardName(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification associationIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			boolean isForward = lbcm.isForwardName(
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class),
					associationIdentification.getRelationshipName().getValue());
			return Utils.wrapDirection(isForward);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.Direction isReverseName(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification associationIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			boolean isReverse = lbcm.isReverseName(
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class),
					associationIdentification.getRelationshipName().getValue());
			return Utils.wrapDirection(!isReverse);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.AssociationList getHierarchyLevelNext(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyResolutionPolicy hierarchyResolutionPolicy,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {	
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			
			NameAndValueList assocQualifiers = ConvertUtils.convert(hierarchyResolutionPolicy.getAssociationQualifiers(), NameAndValueList.class);
			HierarchyIdentification hierarchyID = hierarchyResolutionPolicy.getHierarchyId();
			ConceptIdentification conceptCode = hierarchyResolutionPolicy.getConceptCode();
			boolean resolveConcepts = hierarchyResolutionPolicy.getResolveConcepts().getValue();
			
			return 
				ConvertUtils.convert(lbcm.getHierarchyLevelNext(
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class),
					hierarchyID.getIdentifier().getValue(), 
					conceptCode.getCode().getValue(), 
					resolveConcepts, 
					assocQualifiers), org.LexGrid.LexBIG.iso21090.DataModel.Collections.AssociationList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.AssociationList getHierarchyLevelPrev(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyResolutionPolicy hierarchyResolutionPolicy,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			
			NameAndValueList assocQualifiers = ConvertUtils.convert(hierarchyResolutionPolicy.getAssociationQualifiers(), NameAndValueList.class);
			HierarchyIdentification hierarchyID = hierarchyResolutionPolicy.getHierarchyId();
			ConceptIdentification conceptCode = hierarchyResolutionPolicy.getConceptCode();
			boolean resolveConcepts = hierarchyResolutionPolicy.getResolveConcepts().getValue();
			
			return 
				ConvertUtils.convert(lbcm.getHierarchyLevelPrev(
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class),
					hierarchyID.getIdentifier().getValue(), 
					conceptCode.getCode().getValue(), 
					resolveConcepts, 
					assocQualifiers), org.LexGrid.LexBIG.iso21090.DataModel.Collections.AssociationList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.AssociationList getHierarchyPathToRoot(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyResolutionPolicy hierarchyResolutionPolicy,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.iso21090.DataModel.enums.HierarchyPathResolveOption hierarchyPathResolveOption) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			
			NameAndValueList assocQualifiers = ConvertUtils.convert(hierarchyResolutionPolicy.getAssociationQualifiers(), NameAndValueList.class);
			HierarchyIdentification hierarchyID = hierarchyResolutionPolicy.getHierarchyId();
			ConceptIdentification conceptCode = hierarchyResolutionPolicy.getConceptCode();
			boolean resolveConcepts = hierarchyResolutionPolicy.getResolveConcepts().getValue();
			
			return ConvertUtils.convert(
					lbcm
					.getHierarchyPathToRoot(
							codingSchemeIdentification.getName().getValue(),
							ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class),
							hierarchyID.getIdentifier().getValue(),
							conceptCode.getCode().getValue(),
							resolveConcepts,
							Utils.convertHierarchyPathResolveOption(hierarchyPathResolveOption), assocQualifiers), 
					org.LexGrid.LexBIG.iso21090.DataModel.Collections.AssociationList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.ResolvedConceptReferenceList getHierarchyRoots(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyIdentification hierarchyIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			LexBIGServiceConvenienceMethods lbcm = getLexBIGServiceConvenienceMethods();
			return ConvertUtils.convert(
					lbcm.getHierarchyRoots(
						codingSchemeIdentification.getName().getValue(), 
						ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class),
						hierarchyIdentification.getIdentifier().getValue()),
					org.LexGrid.LexBIG.iso21090.DataModel.Collections.ResolvedConceptReferenceList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference getHierarchyRootSet(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyIdentification hierarchyIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
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
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class),
					hierarchyIdentification.getIdentifier().getValue()));

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

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference createCodeNodeSet(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ConceptIdentification[] conceptIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
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

			thisResource.setCodedNodeSet(lbscm.createCodeNodeSet(
					Utils.conceptIdentificationArrayToString(conceptIdentification),
					codingSchemeIdentification.getName().getValue(), 
					ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class)));

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

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification[] getAssociationForwardAndReverseNames(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
	  try {
		  String[] assocNames = getLexBIGServiceConvenienceMethods()
		  .getAssociationForwardAndReverseNames(
				  codingSchemeIdentification.getName().getValue(),
				  ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class));
		  
		   //TODO: Need to figure out whether to set true or false for the line below.
			return Utils.stringArrayToAssociationIdentification(assocNames);
	  } catch (Exception e) {
			Utils.processException(e);
			return null;
	 }
  }

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeCopyRight getCodingSchemeCopyright(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
	  try {
		  String copyright = getLexBIGServiceConvenienceMethods().getCodingSchemeCopyright(
				  codingSchemeIdentification.getName().getValue(), 
				  ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class));
		  return Utils.wrapCodingSchemCopyRight(copyright);
	  } catch (Exception e) {
			Utils.processException(e);
			return null;
	 }
  }
  public org.LexGrid.LexBIG.iso21090.DataModel.Core.Association getAssociationReverseOneLevel(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ConceptIdentification conceptIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationContainerIdentification relationContainerIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification associationIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ResolveConcepts buildReferencedEntries,org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException {
	  try {
		  String concept = conceptIdentification.getCode().getValue();
		  String relationsContainer = relationContainerIdentification.getContextName().getValue();
		  String association = associationIdentification.getRelationshipName().getValue();
		  String codingScheme = codingSchemeIdentification.getName().getValue();
		  Boolean resolve = buildReferencedEntries.getFlag().getValue();
		  
		  return ConvertUtils.convert(getLexBIGServiceConvenienceMethods().getAssociationReverseOneLevel(
				  concept, 
				  relationsContainer, 
				  association, 
				  codingScheme, 
				  ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class), 
				  resolve, 
				  ConvertUtils.convert(associationQualifiers, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList.class)),
				  org.LexGrid.LexBIG.iso21090.DataModel.Core.Association.class);
	  } catch (Exception e) {
			Utils.processException(e);
			return null;
	 }
  }

  public org.LexGrid.LexBIG.iso21090.DataModel.Core.Association getAssociationForwardOneLevel(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ConceptIdentification conceptIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationContainerIdentification relationContainerIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification associationIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ResolveConcepts buildReferencedEntries,org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList associationQualifiers) throws RemoteException {
	  try {
		  String concept = conceptIdentification.getCode().getValue();
		  String relationsContainer = relationContainerIdentification.getContextName().getValue();
		  String association = associationIdentification.getRelationshipName().getValue();
		  String codingScheme = codingSchemeIdentification.getName().getValue();
		  Boolean resolve = buildReferencedEntries.getFlag().getValue();
		  
		  return ConvertUtils.convert(getLexBIGServiceConvenienceMethods().getAssociationForwardOneLevel(
				  concept, 
				  relationsContainer, 
				  association, 
				  codingScheme, 
				  ConvertUtils.convert(versionOrTag, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag.class), 
				  resolve, 
				  ConvertUtils.convert(associationQualifiers, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList.class)),
				  org.LexGrid.LexBIG.iso21090.DataModel.Core.Association.class);
	  } catch (Exception e) {
			Utils.processException(e);
			return null;
	 }
  }

}
