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
package org.LexGrid.LexBIG.cagrid.adapters;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.DataModel.Collections.AbsoluteCodingSchemeVersionReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.MetadataPropertyList;
import org.LexGrid.LexBIG.DataModel.Core.AbsoluteCodingSchemeVersionReference;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;
import org.LexGrid.LexBIG.Exceptions.LBParameterException;
import org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;

public class LexBIGServiceMetadataAdapter implements LexBIGServiceMetadata {

	private LexBIGServiceMetadataGridAdapter lbsm;

	public LexBIGServiceMetadataAdapter(LexBIGServiceMetadataGridAdapter adapter) throws RemoteException {
		lbsm = adapter;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#listCodingSchemes()
	 */
	public AbsoluteCodingSchemeVersionReferenceList listCodingSchemes()
	throws LBInvocationException {
		try {
			return lbsm.listCodingSchemes();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#resolve()
	 */
	public MetadataPropertyList resolve() throws LBParameterException,
	LBInvocationException {
		try {
			return lbsm.resolve();
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#restrictToCodingScheme(org.LexGrid.LexBIG.DataModel.Core.AbsoluteCodingSchemeVersionReference)
	 */
	public LexBIGServiceMetadata restrictToCodingScheme(
			AbsoluteCodingSchemeVersionReference acsvr)
	throws LBParameterException {
		try {
			lbsm.restrictToCodingScheme(acsvr);
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBParameterException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#restrictToProperties(java.lang.String[])
	 */
	public LexBIGServiceMetadata restrictToProperties(String[] properties)
	throws LBParameterException {
		try {
			lbsm.restrictToProperties(
					Utils.stringArrayToPropertyIdentification(properties));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBParameterException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#restrictToPropertyParents(java.lang.String[])
	 */
	public LexBIGServiceMetadata restrictToPropertyParents(
			String[] propertyParents) throws LBParameterException {
		try {
			lbsm.restrictToPropertyParents(
					Utils.stringArrayToPropertyIdentification(propertyParents));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBParameterException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata#restrictToValue(java.lang.String,
	 *      java.lang.String)
	 */
	public LexBIGServiceMetadata restrictToValue(String matchText,
			String matchAlgorithm) throws LBParameterException {
		try{
			lbsm.restrictToValue(
					Utils.wrapMatchCritia(matchText), 
					Utils.wrapExtensionIdentification(matchAlgorithm));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBParameterException(e.getMessage());
		}
	}
}
