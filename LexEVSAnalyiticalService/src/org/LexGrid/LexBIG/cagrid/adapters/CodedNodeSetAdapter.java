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

import org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.LocalNameList;
import org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList;
import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.SortOptionList;
import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeExistence;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.SetResolutionPolicy;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;
import org.LexGrid.LexBIG.Exceptions.LBParameterException;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;
import org.apache.axis.message.addressing.EndpointReferenceType;

public class CodedNodeSetAdapter implements CodedNodeSet {


	private CodedNodeSetGridAdapter cns;

	public CodedNodeSetAdapter(CodedNodeSetGridAdapter adapter) throws RemoteException {
		cns = adapter;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#difference(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet)
	 */
	public CodedNodeSet difference(CodedNodeSet arg0)
	throws LBInvocationException, LBParameterException {
		try {
			CodedNodeSetAdapter cnsa = (CodedNodeSetAdapter) arg0;
			CodedNodeSetGrid cnsga = cnsa.getCodedNodeSetGridInterface();
			cns.difference(cnsga);
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#intersect(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet)
	 */
	public CodedNodeSet intersect(CodedNodeSet arg0)
	throws LBInvocationException, LBParameterException {
		try {
			CodedNodeSetAdapter cnsa = (CodedNodeSetAdapter) arg0;
			CodedNodeSetGrid cnsga = cnsa.getCodedNodeSetGridInterface();
			cns.intersect(cnsga);
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#isCodeInSet(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public Boolean isCodeInSet(ConceptReference code)
	throws LBInvocationException, LBParameterException {
		try {
			CodeExistence codeExits = cns.isCodeInSet(
					Utils.checkIfConceptReferencsIsResolved(
							ConvertUtils.convert(code, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class)));
			return codeExits.getIsPresent().getValue();
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#resolve(org.LexGrid.LexBIG.DataModel.Collections.SortOptionList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[])
	 */
	public ResolvedConceptReferencesIterator resolve(
			SortOptionList sortOptions, LocalNameList filterOptions,
			LocalNameList propertyNames, PropertyType[] propertyTypes)
	throws LBInvocationException, LBParameterException {
		return this.resolve(sortOptions, filterOptions,
				propertyNames, propertyTypes, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#resolve(org.LexGrid.LexBIG.DataModel.Collections.SortOptionList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[])
	 */
	public ResolvedConceptReferencesIterator resolve(SortOptionList sortOptions,
			LocalNameList filterOptions, PropertyType[] propertyTypes)
	throws LBInvocationException, LBParameterException {		
		return this.resolve(sortOptions, filterOptions,
				null, propertyTypes, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#resolveToList(org.LexGrid.LexBIG.DataModel.Collections.SortOptionList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[], int)
	 */
	public ResolvedConceptReferenceList resolveToList(
			SortOptionList sortOptions, LocalNameList propertyNames,
			PropertyType[] propertyTypes, int maxToReturn) throws LBInvocationException, LBParameterException {
		return this.resolveToList(sortOptions, null, propertyNames, propertyTypes, false, maxToReturn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#restrictToCodes(org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList)
	 */
	public CodedNodeSet restrictToCodes(ConceptReferenceList arg0)
	throws LBInvocationException, LBParameterException {
		try {
			cns.restrictToCodes(ConvertUtils.convert(arg0, org.LexGrid.LexBIG.iso21090.DataModel.Collections.ConceptReferenceList.class));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#restrictToMatchingDesignations(java.lang.String,
	 *      boolean, java.lang.String, java.lang.String)
	 */
	public CodedNodeSet restrictToMatchingDesignations(String matchText,
			boolean preferredOnly, String matchAlgorithm, String language)
	throws LBInvocationException, LBParameterException {
		return this.restrictToMatchingDesignations(matchText, SearchDesignationOption.PREFERRED_ONLY,
				matchAlgorithm, language);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#restrictToMatchingDesignations(java.lang.String,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption,
	 *      java.lang.String, java.lang.String)
	 */
	public CodedNodeSet restrictToMatchingDesignations(
			String matchText,
			SearchDesignationOption option, 
			String matchAlgorithm, 
			String language)
	throws LBInvocationException, LBParameterException {
		try {
			cns.restrictToMatchingDesignations(
					Utils.wrapMatchCritia(matchText), 
					Utils.convertSearchDesignationOption(option), 
					Utils.wrapExtensionIdentification(matchAlgorithm), 
					Utils.wrapLanguageIdentification(language));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#restrictToMatchingProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[],
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public CodedNodeSet restrictToMatchingProperties(
			LocalNameList propertyNames, 
			PropertyType[] propertyTypes,
			LocalNameList sourceList, 
			LocalNameList contextList, 
			NameAndValueList qualifierList,
			String matchText, 
			String matchAlgorithm, 
			String language)
	throws LBInvocationException, LBParameterException {
		try {
			cns.restrictToMatchingProperties(
					ConvertUtils.convert(propertyNames, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class),
					Utils.convertPropertyType(propertyTypes), 
					ConvertUtils.convert(sourceList, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class),
					ConvertUtils.convert(contextList, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class),
					ConvertUtils.convert(qualifierList, org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList.class),
					Utils.wrapMatchCritia(matchText),
					Utils.wrapExtensionIdentification(matchAlgorithm), 
					Utils.wrapLanguageIdentification(language));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#restrictToMatchingProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[],
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	public CodedNodeSet restrictToMatchingProperties(
			LocalNameList propertyNames, PropertyType[] propertyTypes,
			String matchText, String matchAlgorithm, String language)
	throws LBInvocationException, LBParameterException {
		return this.restrictToMatchingProperties(propertyNames, propertyTypes, null, null, null, matchText,
				matchAlgorithm, language);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#restrictToProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[],
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList)
	 */
	public CodedNodeSet restrictToProperties(
			LocalNameList propertyList, 
			PropertyType[] propertyTypes,
			LocalNameList sourceList, 
			LocalNameList contextList,
			NameAndValueList qualifierList) throws LBInvocationException,
			LBParameterException {
		try {
			cns.restrictToProperties(
					ConvertUtils.convert(propertyList, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class),
					Utils.convertPropertyType(propertyTypes),
					ConvertUtils.convert(sourceList, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class),
					ConvertUtils.convert(contextList, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class),
					ConvertUtils.convert(qualifierList, org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList.class));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#restrictToProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[])
	 */
	public CodedNodeSet restrictToProperties(
			LocalNameList propertyList, PropertyType[] propertyTypes) throws LBInvocationException,
			LBParameterException {
		return this.restrictToProperties(propertyList, propertyTypes, null, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#restrictToStatus(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.ActiveOption,
	 *      java.lang.String[])
	 */
	public CodedNodeSet restrictToStatus(ActiveOption activeOption, String[] conceptStatus)
	throws LBInvocationException, LBParameterException {
		try {
			cns.restrictToStatus(
					Utils.convertActiveOption(activeOption), 
					Utils.stringArrayToStatus(conceptStatus));
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#union(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet)
	 */
	public CodedNodeSet union(CodedNodeSet arg0) throws LBInvocationException,
	LBParameterException {
		try {
			CodedNodeSetAdapter cnsa = (CodedNodeSetAdapter) arg0;
			CodedNodeSetGrid cnsga = cnsa.getCodedNodeSetGridInterface();
			cns.union(cnsga);
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#resolveToList(org.LexGrid.LexBIG.DataModel.Collections.SortOptionList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[], int)
	 */
	public ResolvedConceptReferenceList resolveToList(
			SortOptionList sortOptions,
			LocalNameList filterOptions, LocalNameList propertyNames,
			PropertyType[] propertyTypes, boolean resolveConcepts, int maxToReturn)
	throws LBInvocationException, LBParameterException {
		SetResolutionPolicy policy = Utils.buildSetResolutionPolicy(
				sortOptions, 
				filterOptions, 
				propertyNames, 
				propertyTypes,
				resolveConcepts, 
				maxToReturn);
		try {
			return ConvertUtils.convert(cns.resolveToList(policy), 
					org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList.class);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#resolve(org.LexGrid.LexBIG.DataModel.Collections.SortOptionList, org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[], boolean)
	 */
	public ResolvedConceptReferencesIterator resolve(
			SortOptionList sortOptions, LocalNameList filterOptions,
			LocalNameList propertyNames, PropertyType[] propertyTypes, boolean resolveConcepts) throws LBInvocationException, LBParameterException {

		SetResolutionPolicy policy = Utils.buildSetResolutionPolicy(sortOptions, filterOptions, propertyNames, 
				propertyTypes, resolveConcepts, 0);
		try {
			ResolvedConceptReferencesIteratorAdapter adapter = (ResolvedConceptReferencesIteratorAdapter)cns.resolve(policy);			
			return adapter;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeSet#resolveToList(org.LexGrid.LexBIG.DataModel.Collections.SortOptionList, org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[], boolean, int)
	 */
	public ResolvedConceptReferenceList resolveToList(SortOptionList sortOptions,
			LocalNameList filterOptions, LocalNameList propertyNames,
			PropertyType[] propertyTypes, int maxToReturn) throws LBInvocationException,
			LBParameterException {
		return this.resolveToList(sortOptions, filterOptions, propertyNames, propertyTypes, false, maxToReturn);
	}
	
	@Override
	public CodedNodeSet restrictToAnonymous(AnonymousOption arg0)
			throws LBInvocationException, LBParameterException {
		// TODO Auto-generated method stub
		return null;
	}

	public CodedNodeSetGrid getCodedNodeSetGridInterface(){
		return cns;
	}

	public EndpointReferenceType getEndpointReference(){
		return cns.getEndpointReference();
	}



}
