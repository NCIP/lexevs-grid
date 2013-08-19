/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.HistoryService.service;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;

/**
 * TODO:I am the service side implementation class. IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class HistoryServiceImpl extends HistoryServiceImplBase {

	public HistoryServiceImpl() throws RemoteException {
		super();
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList getAncestors(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference conceptReference) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return 
				ConvertUtils.convert(
						getResourceHome().getAddressedResource().getHistoryService()
							.getAncestors(
									ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.DataModel.Core.ConceptReference.class)),
				org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.SystemReleaseList getBaselines(java.util.Date releasedAfter,java.util.Date releasedBefore) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return 
			ConvertUtils.convert(
				getResourceHome().getAddressedResource().getHistoryService()
						.getBaselines(releasedAfter, releasedBefore),
				org.LexGrid.LexBIG.iso21090.DataModel.Collections.SystemReleaseList.class);	
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.CodingSchemeVersionList getConceptChangeVersions(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference conceptReference,java.util.Date beginDate,java.util.Date endDate) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return 
			ConvertUtils.convert(
				getResourceHome().getAddressedResource().getHistoryService()
					.getConceptChangeVersions(
							ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.DataModel.Core.ConceptReference.class),
							beginDate,
							endDate),
			org.LexGrid.LexBIG.iso21090.DataModel.Collections.CodingSchemeVersionList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.iso21090.versions.CodingSchemeVersion getConceptCreationVersion(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference conceptReference) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return
			ConvertUtils.convert(
					getResourceHome().getAddressedResource().getHistoryService()
						.getConceptCreationVersion(
							ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.DataModel.Core.ConceptReference.class)),
			org.LexGrid.iso21090.versions.CodingSchemeVersion.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList getDescendents(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference conceptReference) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return
			ConvertUtils.convert(
					getResourceHome().getAddressedResource().getHistoryService()
						.getDescendants(
							ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.DataModel.Core.ConceptReference.class)),
						org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList.class);	
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.iso21090.versions.SystemRelease getEarliestBaseline() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return ConvertUtils.convert(
					getResourceHome().getAddressedResource().getHistoryService().getEarliestBaseline(),
					org.LexGrid.iso21090.versions.SystemRelease.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList getEditActionList(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference conceptReference,org.apache.axis.types.URI releaseURN) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return 
				ConvertUtils.convert(
						getResourceHome().getAddressedResource().getHistoryService()
							.getEditActionList(
									ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.DataModel.Core.ConceptReference.class),
									Utils.URIConverter(releaseURN)),
				org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList getEditActionList2(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference conceptReference,org.LexGrid.iso21090.versions.CodingSchemeVersion codingSchemeVersion) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return 
				ConvertUtils.convert(
					getResourceHome().getAddressedResource().getHistoryService()
						.getEditActionList(
								ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.DataModel.Core.ConceptReference.class), 
								ConvertUtils.convert(codingSchemeVersion, org.LexGrid.versions.CodingSchemeVersion.class)),
				org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList getEditActionList3(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference conceptReference,java.util.Date beginDate,java.util.Date endDate) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return ConvertUtils.convert(
					getResourceHome().getAddressedResource().getHistoryService()
					.getEditActionList(
							ConvertUtils.convert(conceptReference, org.LexGrid.LexBIG.DataModel.Core.ConceptReference.class), 
							beginDate, 
							endDate),
							org.LexGrid.LexBIG.iso21090.DataModel.Collections.NCIChangeEventList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.iso21090.versions.SystemRelease getLatestBaseline() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return ConvertUtils.convert(
					getResourceHome().getAddressedResource().getHistoryService().getLatestBaseline(),
					org.LexGrid.iso21090.versions.SystemRelease.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.InterfaceElements.SystemReleaseDetail getSystemRelease(org.apache.axis.types.URI releaseURN) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return ConvertUtils.convert(
					getResourceHome().getAddressedResource().getHistoryService()
					.getSystemRelease(Utils.URIConverter(releaseURN)),
							org.LexGrid.LexBIG.iso21090.DataModel.InterfaceElements.SystemReleaseDetail.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}
}
