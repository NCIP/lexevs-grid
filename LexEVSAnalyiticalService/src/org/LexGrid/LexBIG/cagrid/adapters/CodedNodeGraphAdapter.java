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
import java.util.List;

import org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.LocalNameList;
import org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList;
import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Collections.SortOptionList;
import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.DataModel.Core.NameAndValue;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeRelationship;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.GraphResolutionPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.NodeListPolicy;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;
import org.LexGrid.LexBIG.Exceptions.LBParameterException;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;
import org.apache.axis.message.addressing.EndpointReferenceType;

public class CodedNodeGraphAdapter implements CodedNodeGraph {

	private CodedNodeGraphGridAdapter cng;

	public CodedNodeGraphAdapter(CodedNodeGraphGridAdapter adapter) throws RemoteException {
		cng = adapter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#areCodesRelated(org.LexGrid.LexBIG.DataModel.Core.NameAndValue,
	 *      org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      org.LexGrid.LexBIG.DataModel.Core.ConceptReference, boolean)
	 */
	public Boolean areCodesRelated(NameAndValue arg0, ConceptReference sourceConcept,
			ConceptReference targetConcept, boolean directOnly) throws LBInvocationException,
			LBParameterException {
		CodeRelationship relationship;
		try {
			relationship = cng.areCodesRelated(Utils.buildRelationshipTypeBasedPolicy(
					ConvertUtils.convert(sourceConcept, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
					ConvertUtils.convert(targetConcept, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
					directOnly),
					ConvertUtils.convert(arg0, org.LexGrid.LexBIG.iso21090.DataModel.Core.NameAndValue.class));
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
		return relationship.getIsCodeRelated().getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#intersect(org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph)
	 */
	public CodedNodeGraph intersect(CodedNodeGraph arg0)
	throws LBInvocationException, LBParameterException {
		try {
			CodedNodeGraphAdapter cnga = (CodedNodeGraphAdapter) arg0;
			CodedNodeGraphGrid cnsga = cnga.getCodedNodeGraphGridInterface();
			cng.intersect(cnsga);
			return this;
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#isCodeInGraph(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public Boolean isCodeInGraph(ConceptReference arg0)
	throws LBInvocationException, LBParameterException {
		try {
			return cng.isCodeInGraph(
					ConvertUtils.convert(arg0, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class)).getIsPresent().getValue();
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#listCodeRelationships(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      org.LexGrid.LexBIG.DataModel.Core.ConceptReference, boolean)
	 */
	public List<String> listCodeRelationships(ConceptReference sourceConcept,
			ConceptReference targetConcept, boolean directOnly) throws LBInvocationException,
			LBParameterException {
		try {
			return cng.listCodeRelationships(Utils.buildRelationshipTypeBasedPolicy(
					ConvertUtils.convert(sourceConcept, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
					ConvertUtils.convert(targetConcept, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
					directOnly));
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#listCodeRelationships(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      org.LexGrid.LexBIG.DataModel.Core.ConceptReference, int)
	 */
	public List<String> listCodeRelationships(ConceptReference sourceConcept,
			ConceptReference targetConcept, int distance) throws LBInvocationException,
			LBParameterException {
		try {
			cng.listCodeRelationships(Utils.buildRelationshipDistanceBasedPolicy(
					ConvertUtils.convert(sourceConcept, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
					ConvertUtils.convert(targetConcept, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
					distance));
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#resolveAsList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      boolean, boolean, int, int,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[],
	 *      org.LexGrid.LexBIG.DataModel.Collections.SortOptionList, int)
	 */
	public ResolvedConceptReferenceList resolveAsList(
			ConceptReference graphFocus, boolean resolveForward, boolean resolveBackward,
			int resolveCodedEntryDepth, int resolveAssociationDepth,
			LocalNameList propertyNames, PropertyType[] propertyTypes,
			SortOptionList sortOptions, LocalNameList filterOptions, int maxToReturn)
	throws LBInvocationException, LBParameterException {
		return this.resolveAsList(graphFocus, resolveForward, resolveBackward, resolveCodedEntryDepth, resolveAssociationDepth,
				propertyNames, propertyTypes, sortOptions, filterOptions, maxToReturn, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#resolveAsList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      boolean, boolean, int, int,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[],
	 *      org.LexGrid.LexBIG.DataModel.Collections.SortOptionList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, int,
	 *      boolean)
	 */
	public ResolvedConceptReferenceList resolveAsList(ConceptReference graphFocus,
			boolean resolveForward, boolean resolveBackward, int resolveCodedEntryDepth, int resolveAssociationDepth, LocalNameList propertyNames,
			PropertyType[] propertyTypes, SortOptionList sortOptions, LocalNameList filterOptions,
			int maxToReturn, boolean keepLastAssociationLevelUnresolved) throws LBInvocationException,
			LBParameterException {

		GraphResolutionPolicy policy = Utils.buildGraphResolutionPolicy(graphFocus, resolveForward, resolveBackward, resolveCodedEntryDepth, 
				resolveAssociationDepth, propertyNames, propertyTypes, sortOptions, filterOptions, 
				maxToReturn, keepLastAssociationLevelUnresolved);
		try {
			return ConvertUtils.convert(cng.resolveAsList(policy), org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList.class);
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#resolveAsList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      boolean, boolean, int, int,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList,
	 *      org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[],
	 *      org.LexGrid.LexBIG.DataModel.Collections.SortOptionList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.LocalNameList, int)
	 */
	public ResolvedConceptReferenceList resolveAsList(ConceptReference graphFocus, boolean resolveForward, boolean resolveBackward,
			int resolveCodedEntryDepth, int resolveAssociationDepth,
			LocalNameList propertyNames, PropertyType[] propertyTypes,
			SortOptionList sortOptions, int maxToReturn) throws LBInvocationException, LBParameterException {
		return this.resolveAsList(graphFocus, resolveForward, resolveBackward, resolveCodedEntryDepth, resolveAssociationDepth,
				propertyNames, propertyTypes, sortOptions, null, maxToReturn, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#restrictToAssociations(org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList)
	 */
	public CodedNodeGraph restrictToAssociations(NameAndValueList arg0,
			NameAndValueList arg1) throws LBInvocationException,
			LBParameterException {
		try{
			cng.restrictToAssociations(
					ConvertUtils.convert(arg0, org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList.class),
					ConvertUtils.convert(arg1, org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList.class));
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#restrictToCodes(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet)
	 */
	public CodedNodeGraph restrictToCodes(CodedNodeSet codes)
	throws LBInvocationException, LBParameterException {
		CodedNodeSetAdapter cnsa = (CodedNodeSetAdapter) codes;
		try{
			cng.restrictToCodes(cnsa.getCodedNodeSetGridInterface());
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#restrictToCodeSystem(java.lang.String)
	 */
	public CodedNodeGraph restrictToCodeSystem(String codingScheme)
	throws LBInvocationException, LBParameterException {
		try{	
			cng.restrictToCodeSystem(Utils.wrapCodingSchemeIdentifier(codingScheme));
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#restrictToDirectionalNames(org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList,
	 *      org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList)
	 */
	public CodedNodeGraph restrictToDirectionalNames(NameAndValueList arg0,
			NameAndValueList arg1) throws LBInvocationException,
			LBParameterException {
		try{	
			cng.restrictToDirectionalNames(
					ConvertUtils.convert(arg0, org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList.class), 
					ConvertUtils.convert(arg1, org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList.class));
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#restrictToSourceCodes(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet)
	 */
	public CodedNodeGraph restrictToSourceCodes(CodedNodeSet codes)
	throws LBInvocationException, LBParameterException {
		CodedNodeSetAdapter cnsa = (CodedNodeSetAdapter) codes;
		try{
			cng.restrictToSourceCodes(cnsa.getCodedNodeSetGridInterface());
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#restrictToSourceCodeSystem(java.lang.String)
	 */
	public CodedNodeGraph restrictToSourceCodeSystem(String codingScheme)
	throws LBInvocationException, LBParameterException {
		try{	
			cng.restrictToSourceCodeSystem(Utils.wrapCodingSchemeIdentifier(codingScheme));
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#restrictToTargetCodes(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet)
	 */
	public CodedNodeGraph restrictToTargetCodes(CodedNodeSet arg0)
	throws LBInvocationException, LBParameterException {
		CodedNodeSetAdapter cnsa = (CodedNodeSetAdapter) arg0;
		try{
			cng.restrictToTargetCodes(cnsa.getCodedNodeSetGridInterface());
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#restrictToTargetCodeSystem(java.lang.String)
	 */
	public CodedNodeGraph restrictToTargetCodeSystem(String codingScheme)
	throws LBInvocationException, LBParameterException {
		try{	
			cng.restrictToTargetCodeSystem(Utils.wrapCodingSchemeIdentifier(codingScheme));
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
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#toNodeList(org.LexGrid.LexBIG.DataModel.Core.ConceptReference,
	 *      boolean, boolean, int, int)
	 */
	public CodedNodeSet toNodeList(ConceptReference graphFocus,
			boolean resolveForward, boolean resolveBackward,
			int resolveAssociationDepth, int maxToReturn) throws LBInvocationException,
			LBParameterException {

		NodeListPolicy policy = Utils.buildNodeListPolicy(
				graphFocus, 
				resolveForward, 
				resolveBackward, resolveAssociationDepth, maxToReturn);
		try{
			CodedNodeSetGridAdapter adapter = (CodedNodeSetGridAdapter)cng.toNodeList(policy);
			return adapter.getCodedNodeSetInterface();
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
			throw new LBParameterException(e.getMessage());
		} catch (InvalidServiceContextAccess e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (RemoteException e) {
			throw new LBInvocationException(e.getMessage(), null);
		} catch (Exception e) {
			throw new LBInvocationException(e.getMessage(), null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph#union(org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph)
	 */
	public CodedNodeGraph union(CodedNodeGraph graph)
	throws LBInvocationException, LBParameterException {
		try {
			CodedNodeGraphAdapter cnga = (CodedNodeGraphAdapter) graph;
			CodedNodeGraphGrid cngg = cnga.getCodedNodeGraphGridInterface();
			cng.union(cngg);
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

	@Override
	public CodedNodeGraph restrictToAnonymous(Boolean arg0)
			throws LBInvocationException, LBParameterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CodedNodeGraph restrictToEntityTypes(LocalNameList arg0)
			throws LBInvocationException, LBParameterException {
		// TODO Auto-generated method stub
		return null;
	}
	

	public CodedNodeGraphGrid getCodedNodeGraphGridInterface(){
		return cng;
	}

	public EndpointReferenceType getEndpointReference(){
		return cng.getEndpointReference();
	}
}
