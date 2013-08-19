/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.service;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;

/**
 * TODO:I am the service side implementation class. IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class LexBIGServiceMetadataImpl extends LexBIGServiceMetadataImplBase {

	public LexBIGServiceMetadataImpl() throws RemoteException {
		super();
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.AbsoluteCodingSchemeVersionReferenceList listCodingSchemes() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return 
			ConvertUtils.convert(
			getResourceHome().getAddressedResource()
					.getLexBIGServiceMetadata().listCodingSchemes(),
					org.LexGrid.LexBIG.iso21090.DataModel.Collections.AbsoluteCodingSchemeVersionReferenceList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public void restrictToCodingScheme(org.LexGrid.LexBIG.iso21090.DataModel.Core.AbsoluteCodingSchemeVersionReference acsvr) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			LexBIGServiceMetadata lbsmd = getResourceHome()
					.getAddressedResource().getLexBIGServiceMetadata();
			LexBIGServiceMetadata lbsmdRestricted = lbsmd
					.restrictToCodingScheme(
							ConvertUtils.convert(acsvr,org.LexGrid.LexBIG.DataModel.Core.AbsoluteCodingSchemeVersionReference.class));
			getResourceHome().getAddressedResource().setLexBIGServiceMetadata(
					lbsmdRestricted);
		 } catch (Exception e) {
				Utils.processException(e);
		 }
	}

  public void restrictToProperties(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.PropertyIdentification[] propertyIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			LexBIGServiceMetadata lbsmd = getResourceHome()
					.getAddressedResource().getLexBIGServiceMetadata();
			LexBIGServiceMetadata lbsmdRestricted = lbsmd
					.restrictToProperties(Utils.propertyIdentificationToStringArray(propertyIdentification));
			getResourceHome().getAddressedResource().setLexBIGServiceMetadata(
					lbsmdRestricted);
		 } catch (Exception e) {
				Utils.processException(e);
		 }
	}

  public void restrictToPropertyParents(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.PropertyIdentification[] propertyIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			LexBIGServiceMetadata lbsmd = getResourceHome()
					.getAddressedResource().getLexBIGServiceMetadata();
			LexBIGServiceMetadata lbsmdRestricted = lbsmd
					.restrictToPropertyParents(Utils.propertyIdentificationToStringArray(propertyIdentification));
			getResourceHome().getAddressedResource().setLexBIGServiceMetadata(
					lbsmdRestricted);
		 } catch (Exception e) {
				Utils.processException(e);
		 }
	}

  public void restrictToValue(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.MatchCriteria matchCriteria,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ExtensionIdentification extensionIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			LexBIGServiceMetadata lbsmd = getResourceHome()
					.getAddressedResource().getLexBIGServiceMetadata();
			LexBIGServiceMetadata lbsmdRestricted = lbsmd.restrictToValue(
					matchCriteria.getText().getValue(), 
					extensionIdentification.getLexBIGExtensionName().getValue());
			getResourceHome().getAddressedResource().setLexBIGServiceMetadata(
					lbsmdRestricted);
		 } catch (Exception e) {
				Utils.processException(e);
		 }
	}

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.MetadataPropertyList resolve() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return 
				ConvertUtils.convert(
					getResourceHome().getAddressedResource()
							.getLexBIGServiceMetadata().resolve(),
				org.LexGrid.LexBIG.iso21090.DataModel.Collections.MetadataPropertyList.class);
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

}
