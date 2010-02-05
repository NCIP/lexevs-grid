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

import org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.LocalNameList;
import org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList;
import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.DataModel.cagrid.CodeExistence;
import org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.LanguageIdentification;
import org.LexGrid.LexBIG.DataModel.cagrid.MatchCriteria;
import org.LexGrid.LexBIG.DataModel.cagrid.SetResolutionPolicy;
import org.LexGrid.LexBIG.DataModel.cagrid.Status;
import org.LexGrid.LexBIG.DataModel.enums.ActiveOption;
import org.LexGrid.LexBIG.DataModel.enums.PropertyType;
import org.LexGrid.LexBIG.DataModel.enums.SearchDesignationOption;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.client.CodedNodeSetClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.client.ResolvedConceptReferencesIteratorClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException;
import org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

public class CodedNodeSetGridAdapter implements CodedNodeSetGrid {

private CodedNodeSetClient cns;
	
	public CodedNodeSetGridAdapter(CodedNodeSetClient client) throws RemoteException {
		cns = client;
	}
	
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#difference(org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid)
	 */
	public CodedNodeSetGrid difference(CodedNodeSetGrid codesToRemove)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			CodedNodeSetGridAdapter cnsa = (CodedNodeSetGridAdapter) codesToRemove;
			CodedNodeSetReference cnsr = new CodedNodeSetReference(cnsa
					.getEndpointReference());
			cns.difference(cnsr);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#intersect(org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid)
	 */
	public CodedNodeSetGrid intersect(CodedNodeSetGrid codes)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			CodedNodeSetGridAdapter cnsa = (CodedNodeSetGridAdapter) codes;
			CodedNodeSetReference cnsr = new CodedNodeSetReference(cnsa
					.getEndpointReference());
			cns.intersect(cnsr);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#isCodeInSet(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public CodeExistence isCodeInSet(ConceptReference code)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			return cns.isCodeInSet(Utils
					.checkIfConceptReferencsIsResolved(code));
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#resolve(org.LexGrid.LexBIG.DataModel.cagrid.SetResolutionPolicy)
	 */
	public ResolvedConceptReferencesIterator resolve(SetResolutionPolicy policy) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException {
			ResolvedConceptReferencesIteratorClient client;
			try {
				client = cns.resolve(policy);
				ResolvedConceptReferencesIteratorAdapter adapter = new ResolvedConceptReferencesIteratorAdapter(client);		
				return adapter;	
			} catch (MalformedURIException e) {
				throw new RemoteException(e.getMessage(), e);
			}
				
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#resolveToList(org.LexGrid.LexBIG.DataModel.cagrid.SetResolutionPolicy)
	 */
	public ResolvedConceptReferenceList resolveToList(SetResolutionPolicy policy) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException {
			return cns.resolveToList(policy);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#restrictToCodes(org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList)
	 */
	public CodedNodeSetGrid restrictToCodes(ConceptReferenceList codeList)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			cns.restrictToCodes(codeList);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#restrictToMatchingDesignations(org.LexGrid.LexBIG.DataModel.cagrid.MatchCriteria, org.LexGrid.LexBIG.DataModel.enums.SearchDesignationOption, org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification, org.LexGrid.LexBIG.DataModel.cagrid.LanguageIdentification)
	 */
	public CodedNodeSetGrid restrictToMatchingDesignations(MatchCriteria matchText,
			SearchDesignationOption option, ExtensionIdentification matchAlgorithm,
			LanguageIdentification language) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException {
			cns.restrictToMatchingDesignations(matchText, option, matchAlgorithm, language);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#restrictToMatchingProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.DataModel.enums.PropertyType[], org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList, org.LexGrid.LexBIG.DataModel.cagrid.MatchCriteria, org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification, org.LexGrid.LexBIG.DataModel.cagrid.LanguageIdentification)
	 */
	public CodedNodeSetGrid restrictToMatchingProperties(
			LocalNameList propertyNames, PropertyType[] propertyTypes,
			LocalNameList sourceList, LocalNameList contextList,
			NameAndValueList qualifierList, MatchCriteria matchText,
			ExtensionIdentification matchAlgorithm, LanguageIdentification language)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			cns.restrictToMatchingProperties(propertyNames, propertyTypes, sourceList, contextList,
					qualifierList, matchText, matchAlgorithm, language);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#restrictToProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.DataModel.enums.PropertyType[], org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList)
	 */
	public CodedNodeSetGrid restrictToProperties(LocalNameList propertyList,
			PropertyType[] propertyTypes, LocalNameList sourceList,
			LocalNameList contextList, NameAndValueList qualifierList)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			cns.restrictToProperties(propertyList, propertyTypes,
					sourceList, contextList, qualifierList);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#restrictToStatus(org.LexGrid.LexBIG.DataModel.enums.ActiveOption, org.LexGrid.LexBIG.DataModel.cagrid.Status[])
	 */
	public CodedNodeSetGrid restrictToStatus(ActiveOption activeOption,
			Status status[]) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException {
			cns.restrictToStatus(activeOption, status);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid#union(org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid)
	 */
	public CodedNodeSetGrid union(CodedNodeSetGrid codes) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException {
			CodedNodeSetGridAdapter cnsa = (CodedNodeSetGridAdapter) codes;
			CodedNodeSetReference cnsr = new CodedNodeSetReference(cnsa
					.getEndpointReference());

			cns.union(cnsr);
		return this;
	}
	
	public CodedNodeSet getCodedNodeSetInterface() throws Exception {
		return new CodedNodeSetAdapter(this);
	}
	
	public EndpointReferenceType getEndpointReference(){
		return cns.getEndpointReference();
	}

}
