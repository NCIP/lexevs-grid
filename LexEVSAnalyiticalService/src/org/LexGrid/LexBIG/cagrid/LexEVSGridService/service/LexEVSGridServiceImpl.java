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
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.service;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPHeaderElement;

import org.LexGrid.LexBIG.DataModel.InterfaceElements.types.SortContext;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;
import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.caCore.interfaces.LexEVSDistributed;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.security.connection.SecureConnectionManager;
import org.LexGrid.LexBIG.cagrid.security.connection.SecureConnectionManagerFactory;
import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.components.uuid.UUIDGen;
import org.apache.axis.components.uuid.UUIDGenFactory;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.globus.wsrf.ResourceKey;
import org.globus.wsrf.impl.ResourceContextImpl;
import org.globus.wsrf.impl.SimpleResourceKey;

/**
 * TODO:I am the service side implementation class. IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public class LexEVSGridServiceImpl extends LexEVSGridServiceImplBase {
	
	private static final UUIDGen UUIDGEN = UUIDGenFactory.getUUIDGen();
	private SecureConnectionManager<LexEVSDistributed> connectionManager; 

	public LexEVSGridServiceImpl() throws RemoteException {	
		super();
		try {
			SecureConnectionManagerFactory factory = SecureConnectionManagerFactory.getInstance();
			connectionManager = factory.getSecureConnectionManager();
		} catch (Exception e) {
			throw new RemoteException("Error Setting Up Connection Cache: " + e.getMessage(), e);
		}
	}

  public org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeRenderingList getSupportedCodingSchemes() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getLexBIGServiceFromCache()
					.getSupportedCodingSchemes();
		} catch (LBInvocationException e) {
				org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException fault = new 
				org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException();
				fault.addFaultDetailString(e.getMessage());
				throw fault;		
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference getCodingSchemeConcepts(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
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

			LexBIGService lbSvc = getLexBIGServiceFromCache();
			thisResource.setCodedNodeSet(lbSvc.getCodingSchemeConcepts(codingSchemeIdentification.getName(), versionOrTag));

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

  public java.util.Date getLastUpdateTime() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getLexBIGServiceFromCache()
					.getLastUpdateTime();
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.codingSchemes.CodingScheme resolveCodingScheme(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		try {
			return getLexBIGServiceFromCache()
					.resolveCodingScheme(codingSchemeIdentification.getName(), versionOrTag);
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ModuleDescriptionList getMatchAlgorithms() throws RemoteException {
		try {
			return getLexBIGServiceFromCache()
					.getMatchAlgorithms();
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.stubs.types.CodedNodeGraphReference getNodeGraph(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag,org.LexGrid.LexBIG.DataModel.cagrid.RelationContainerIdentification relationContainerIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.service.globus.resource.CodedNodeGraphResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext
				.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME
				+ servicePath + "/" + "codedNodeGraphHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.service.globus.resource.CodedNodeGraphResourceHome) initialContext
					.lookup(homeName);
			resourceKey = home.createResource();

			// Grab the newly created resource
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.service.globus.resource.CodedNodeGraphResource thisResource = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.service.globus.resource.CodedNodeGraphResource) home
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

			LexBIGService lbSvc = getLexBIGServiceFromCache();
			thisResource.setCodedNodeGraph(lbSvc.getNodeGraph(codingSchemeIdentification.getName(), versionOrTag,
					relationContainerIdentification.getContextName()));

			// sample of setting creator only security. This will only allow the
			// caller that created
			// this resource to be able to use it.
			// thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());

			String transportURL = (String) ctx
					.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0, transportURL
					.lastIndexOf('/') + 1);
			transportURL += "CodedNodeGraph";
			epr = org.globus.wsrf.utils.AddressingUtils
					.createEndpointReference(transportURL, resourceKey);
		} catch (Exception e) {
			Utils.processException(e);
		}

		// return the typed EPR
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.stubs.types.CodedNodeGraphReference ref = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.stubs.types.CodedNodeGraphReference();
		ref.setEndpointReference(epr);

		return ref;
	}

  public org.LexGrid.LexBIG.DataModel.Collections.SortDescriptionList getSortAlgorithms(java.lang.String context) throws RemoteException {
		try {
			return getLexBIGServiceFromCache()
					.getSortAlgorithms(SortContext.valueOf(context));
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ExtensionDescriptionList getGenericExtensions() throws RemoteException {
		try {
			return getLexBIGServiceFromCache()
					.getGenericExtensions();
		} catch (Exception e) {
			Utils.processException(e);
			return null;
		}
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.stubs.types.LexBIGServiceConvenienceMethodsReference getGenericExtension(org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification extensionIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext
				.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME
				+ servicePath + "/" + "lexBIGServiceConvenienceMethodsHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResourceHome) initialContext
					.lookup(homeName);
			resourceKey = home.createResource();

			// Grab the newly created resource
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResource thisResource = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource.LexBIGServiceConvenienceMethodsResource) home
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

			LexBIGService lbs = getLexBIGServiceFromCache();

			org.LexGrid.LexBIG.Impl.Extensions.GenericExtensions.LexBIGServiceConvenienceMethodsImpl lbscm = (org.LexGrid.LexBIG.Impl.Extensions.GenericExtensions.LexBIGServiceConvenienceMethodsImpl) lbs
					.getGenericExtension(extensionIdentification.getLexBIGExtensionName());
			lbscm.setLexBIGService(lbs);

			thisResource.setLexBIGServiceConvenienceMethods(lbscm);

			// sample of setting creator only security. This will only allow the
			// caller that created
			// this resource to be able to use it.
			// thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());

			String transportURL = (String) ctx
					.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0, transportURL
					.lastIndexOf('/') + 1);
			transportURL += "LexBIGServiceConvenienceMethods";
			epr = org.globus.wsrf.utils.AddressingUtils
					.createEndpointReference(transportURL, resourceKey);
		} catch (Exception e) {
			Utils.processException(e);
		}

		// return the typed EPR
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.stubs.types.LexBIGServiceConvenienceMethodsReference ref = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.stubs.types.LexBIGServiceConvenienceMethodsReference();
		ref.setEndpointReference(epr);

		return ref;
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ExtensionDescriptionList getFilterExtensions() throws RemoteException {
		try {
			return getLexBIGServiceFromCache()
					.getFilterExtensions();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.types.HistoryServiceReference getHistoryService(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service.globus.resource.HistoryServiceResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext
				.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME
				+ servicePath + "/" + "historyServiceHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service.globus.resource.HistoryServiceResourceHome) initialContext
					.lookup(homeName);
			resourceKey = home.createResource();

			// Grab the newly created resource
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service.globus.resource.HistoryServiceResource thisResource = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service.globus.resource.HistoryServiceResource) home
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

			LexBIGService lbSvc = getLexBIGServiceFromCache();
			thisResource.setHistoryService(lbSvc
					.getHistoryService(codingSchemeIdentification.getName()));

			// sample of setting creator only security. This will only allow the
			// caller that created
			// this resource to be able to use it.
			// thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());

			String transportURL = (String) ctx
					.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0, transportURL
					.lastIndexOf('/') + 1);
			transportURL += "HistoryService";
			epr = org.globus.wsrf.utils.AddressingUtils
					.createEndpointReference(transportURL, resourceKey);
		} catch (Exception e) {
			Utils.processException(e);
		}

		// return the typed EPR
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.types.HistoryServiceReference ref = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.stubs.types.HistoryServiceReference();
		ref.setEndpointReference(epr);

		return ref;
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.stubs.types.LexBIGServiceMetadataReference getServiceMetadata() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.service.globus.resource.LexBIGServiceMetadataResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext
				.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME
				+ servicePath + "/" + "lexBIGServiceMetadataHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.service.globus.resource.LexBIGServiceMetadataResourceHome) initialContext
					.lookup(homeName);
			resourceKey = home.createResource();

			// Grab the newly created resource
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.service.globus.resource.LexBIGServiceMetadataResource thisResource = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.service.globus.resource.LexBIGServiceMetadataResource) home
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

			LexBIGService lbSvc = getLexBIGServiceFromCache();
			thisResource.setLexBIGServiceMetadata(lbSvc.getServiceMetadata());

			// sample of setting creator only security. This will only allow the
			// caller that created
			// this resource to be able to use it.
			// thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());

			String transportURL = (String) ctx
					.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0, transportURL
					.lastIndexOf('/') + 1);
			transportURL += "LexBIGServiceMetadata";
			epr = org.globus.wsrf.utils.AddressingUtils
					.createEndpointReference(transportURL, resourceKey);
		} catch (Exception e) {
			Utils.processException(e);
		}

		// return the typed EPR
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.stubs.types.LexBIGServiceMetadataReference ref = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.stubs.types.LexBIGServiceMetadataReference();
		ref.setEndpointReference(epr);

		return ref;
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.types.SortReference getSortAlgorithm(org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification extensionIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service.globus.resource.SortResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext
				.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME
				+ servicePath + "/" + "sortHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service.globus.resource.SortResourceHome) initialContext
					.lookup(homeName);
			resourceKey = home.createResource();

			// Grab the newly created resource
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service.globus.resource.SortResource thisResource = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service.globus.resource.SortResource) home
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

			LexBIGService lbSvc = getLexBIGServiceFromCache();
			thisResource.setSort(lbSvc.getSortAlgorithm(extensionIdentification.getLexBIGExtensionName()));

			// sample of setting creator only security. This will only allow the
			// caller that created
			// this resource to be able to use it.
			// thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());

			String transportURL = (String) ctx
					.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0, transportURL
					.lastIndexOf('/') + 1);
			transportURL += "Sort";
			epr = org.globus.wsrf.utils.AddressingUtils
					.createEndpointReference(transportURL, resourceKey);
		} catch (Exception e) {
			Utils.processException(e);
		}

		// return the typed EPR
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.types.SortReference ref = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.stubs.types.SortReference();
		ref.setEndpointReference(epr);

		return ref;
	}

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.stubs.types.FilterReference getFilter(org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification extensionIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
		org.apache.axis.message.addressing.EndpointReferenceType epr = new org.apache.axis.message.addressing.EndpointReferenceType();
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.service.globus.resource.FilterResourceHome home = null;
		org.globus.wsrf.ResourceKey resourceKey = null;
		org.apache.axis.MessageContext ctx = org.apache.axis.MessageContext
				.getCurrentContext();
		String servicePath = ctx.getTargetService();
		String homeName = org.globus.wsrf.Constants.JNDI_SERVICES_BASE_NAME
				+ servicePath + "/" + "filterHome";

		try {
			javax.naming.Context initialContext = new javax.naming.InitialContext();
			home = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.service.globus.resource.FilterResourceHome) initialContext
					.lookup(homeName);
			resourceKey = home.createResource();

			// Grab the newly created resource
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.service.globus.resource.FilterResource thisResource = (org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.service.globus.resource.FilterResource) home
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

			LexBIGService lbSvc = getLexBIGServiceFromCache();
			thisResource.setFilter(lbSvc.getFilter(extensionIdentification.getLexBIGExtensionName()));

			// sample of setting creator only security. This will only allow the
			// caller that created
			// this resource to be able to use it.
			// thisResource.setSecurityDescriptor(gov.nih.nci.cagrid.introduce.servicetools.security.SecurityUtils.createCreatorOnlyResourceSecurityDescriptor());

			String transportURL = (String) ctx
					.getProperty(org.apache.axis.MessageContext.TRANS_URL);
			transportURL = transportURL.substring(0, transportURL
					.lastIndexOf('/') + 1);
			transportURL += "Filter";
			epr = org.globus.wsrf.utils.AddressingUtils
					.createEndpointReference(transportURL, resourceKey);
		} catch (Exception e) {
			Utils.processException(e);
		}

		// return the typed EPR
		org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.stubs.types.FilterReference ref = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.stubs.types.FilterReference();
		ref.setEndpointReference(epr);

		return ref;
  }

  public org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeCopyRight resolveCodingSchemeCopyright(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag versionOrTag) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {
	  try {
		  String copyright = getLexBIGServiceFromCache()
		  		.resolveCodingSchemeCopyright(codingSchemeIdentification.getName(), versionOrTag);					
		  return Utils.wrapCodingSchemCopyRight(copyright);
	  } catch (Exception e) {
			Utils.processException(e);
			return null;
	 }
  }

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LexEVSGridServiceReference setSecurityToken(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification codingSchemeIdentification,gov.nih.nci.evs.security.SecurityToken securityToken) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException {  
	  String csName = codingSchemeIdentification.getName();
	  try{
		  EndpointReferenceType eprt =  connectionManager.processSecurityToken(getMessageContext(), csName, securityToken);
		  
		  org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LexEVSGridServiceReference ref = 
			  new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LexEVSGridServiceReference();

		  ref.setEndpointReference(eprt);
		  return ref;
	  } catch (Exception e) {
		  Utils.processException(e);
		  return null;
	  }
  }
  
  /**
   * Returns the LexBIGService from the Connection Cache. If there is
   * no Secure Connection Key associated with this request, return the
   * unsecured connection.
   * @return LexBIGService
   * 		The Secure (or unsecure) LexBIGService Connection
   * @throws Exception
   */  
  private LexEVSDistributed getLexBIGServiceFromCache() throws Exception {
	  MessageContext messagectx = getMessageContext();
	  return connectionManager.getApplicationServiceFromCache(messagectx);
  }
  
  private MessageContext getMessageContext(){
	  return MessageContext
	  .getCurrentContext();
  }
}

