/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.adapters;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.iso21090.DataModel.Collections.AbsoluteCodingSchemeVersionReferenceList;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.MetadataPropertyList;
import org.LexGrid.LexBIG.iso21090.DataModel.Core.AbsoluteCodingSchemeVersionReference;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ExtensionIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.MatchCriteria;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.PropertyIdentification;
import org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.client.LexBIGServiceMetadataClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException;
import org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceMetadataGrid;

public class LexBIGServiceMetadataGridAdapter implements
		LexBIGServiceMetadataGrid {

private LexBIGServiceMetadataClient lbsm;
	
	public LexBIGServiceMetadataGridAdapter(LexBIGServiceMetadataClient client) throws RemoteException {
		lbsm = client;
	}
	
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceMetadataGrid#listCodingSchemes()
	 */
	public AbsoluteCodingSchemeVersionReferenceList listCodingSchemes()
			throws LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return lbsm.listCodingSchemes();
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceMetadataGrid#resolve()
	 */
	public MetadataPropertyList resolve() throws LBParameterException,
			LBInvocationException, InvalidServiceContextAccess, RemoteException {
			return lbsm.resolve();
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceMetadataGrid#restrictToCodingScheme(org.LexGrid.LexBIG.DataModel.Core.AbsoluteCodingSchemeVersionReference)
	 */
	public LexBIGServiceMetadataGrid restrictToCodingScheme(
			AbsoluteCodingSchemeVersionReference acsvr)
			throws LBParameterException, InvalidServiceContextAccess, RemoteException {
			lbsm.restrictToCodingScheme(acsvr);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceMetadataGrid#restrictToValue(org.LexGrid.LexBIG.DataModel.cagrid.MatchCriteria, org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification)
	 */
	public LexBIGServiceMetadataGrid restrictToValue(MatchCriteria matchText,
			ExtensionIdentification matchAlgorithm) throws LBParameterException, InvalidServiceContextAccess, RemoteException {
			lbsm.restrictToValue(matchText, matchAlgorithm);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceMetadataGrid#restrictToProperties(org.LexGrid.LexBIG.DataModel.cagrid.PropertyIdentification[])
	 */
	public LexBIGServiceMetadataGrid restrictToProperties(
			PropertyIdentification[] properties) throws LBParameterException, InvalidServiceContextAccess, RemoteException {
			lbsm.restrictToProperties(properties);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceMetadataGrid#restrictToPropertyParents(org.LexGrid.LexBIG.DataModel.cagrid.PropertyIdentification[])
	 */
	public LexBIGServiceMetadataGrid restrictToPropertyParents(
			PropertyIdentification[] propertyParents)
			throws LBParameterException, InvalidServiceContextAccess, RemoteException {
			lbsm.restrictToPropertyParents(propertyParents);
			return this;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public LexBIGServiceMetadata getLexBIGServiceMetadataInterface() throws Exception {
		return new LexBIGServiceMetadataAdapter(this);
	}
	
}
