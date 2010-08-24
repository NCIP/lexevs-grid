/*
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
 * 		http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.LexGrid.LexBIG.cagrid;

import java.net.URISyntaxException;
import java.rmi.RemoteException;

import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.SortOptionList;
import org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.iso21090.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeExistence;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeRelationship;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeState;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeCopyRight;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ConceptIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.Direction;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.DirectionalAssociationIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ExtensionIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.GraphResolutionPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyResolutionPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.LanguageIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.MatchCriteria;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.NodeListPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.PropertyIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationContainerIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationshipDistanceBasedPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationshipTypeBasedPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.SetResolutionPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.Status;
import org.LexGrid.LexBIG.iso21090.DataModel.enums.ActiveOption;
import org.apache.axis.types.URI.MalformedURIException;

/**
 * Utilities class for the LexBIG caGrid Services.
 * @author <A HREF="mailto:peterson.kevin@mayo.edu">Kevin Peterson</A>
 */
public class Utils {
	
	/**
	 * Constructs a String array containing the values of the 
	 * Enumerator array.
	 * 
	 * @param enumerator
	 * 		Enumerator to be converted to a String array.	
	 * @return
	 * 		The String array with values corresponding to the
	 * 		values of the passed in enumerator
	 */
	public static String[] enumArrayToStringArray(Enum[] enumerator){
		if (enumerator == null) {
			return null;
		}
		String[] returnArray = new String[enumerator.length];
		for (int i = 0; i < enumerator.length; i++) {
			returnArray[i] = enumerator[i].toString();			
		}
		return returnArray;		
	}
	
	/**
	 * Constructs a String array containing the values of the 
	 * ConceptIdentification array.
	 * 
	 * @param enumerator
	 * 		Enumerator to be converted to a String array.	
	 * @return
	 * 		The String array with values corresponding to the
	 * 		values of the passed in enumerator
	 */
	public static ConceptIdentification[] stringArrayToConceptIdentification(String[] codes){
		if (codes == null) {
			return null;
		}
		ConceptIdentification[] returnArray = new ConceptIdentification[codes.length];
		for (int i = 0; i < codes.length; i++) {
			ConceptIdentification id = new ConceptIdentification();
			id.setCode(Iso21090Utils.createSt(codes[i]));
			returnArray[i] = id;			
		}
		return returnArray;		
	}
	
	public static HierarchyIdentification[] stringArrayToHierarchyIdentification(String[] ids){
		if (ids == null) {
			return null;
		}
		HierarchyIdentification[] returnArray = new HierarchyIdentification[ids.length];
		for (int i = 0; i < ids.length; i++) {
			HierarchyIdentification id = new HierarchyIdentification();
			id.setIdentifier(Iso21090Utils.createSt(ids[i]));
			returnArray[i] = id;			
		}
		return returnArray;		
	}
	
	/**
	 * Constructs a String array containing the values of the 
	 * HierarchyIdentification array.
	 * 
	 * @param ids
	 * 		HierarchyIdentification array to be converted to a String array.	
	 * @return
	 * 		The String array with values corresponding to the
	 * 		values of the passed in array.
	 */
	public static String[] hierarchyIdentificationToStringArray(HierarchyIdentification[] ids){
		if (ids == null) {
			return null;
		}
		String[] returnArray = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			returnArray[i] = ids[i].getIdentifier().getValue();			
		}
		return returnArray;		
	}
	
	public static String[] propertyIdentificationToStringArray(PropertyIdentification[] ids){
		if (ids == null) {
			return null;
		}
		String[] returnArray = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			returnArray[i] = ids[i].getName().getValue();			
		}
		return returnArray;		
	}
	
	/**
	 * Constructs a String array containing the values of the 
	 * DirectionalAssociationIdentification array.
	 * 
	 * @param ids
	 * 		DirectionalAssociationIdentification array to be converted to a String array.	
	 * @return
	 * 		The String array with values corresponding to the
	 * 		values of the passed in array.
	 */
	public static String[] directionalAssociationIdentificationToStringArray(DirectionalAssociationIdentification[] assocs){
		if (assocs == null) {
			return null;
		}
		String[] returnArray = new String[assocs.length];
		for (int i = 0; i < assocs.length; i++) {
			returnArray[i] = assocs[i].getRelationshipName().getValue();			
		}
		return returnArray;		
	}
	
	/**
	 * Constructs a String array containing the values of the 
	 * AssociationIdentification array.
	 * 
	 * @param ids
	 * 		DirectionalAssociationIdentification array to be converted to a String array.	
	 * @return
	 * 		The String array with values corresponding to the
	 * 		values of the passed in array.
	 */
	public static String[] associationIdentificationToStringArray(AssociationIdentification[] assocs){
		if (assocs == null) {
			return null;
		}
		String[] returnArray = new String[assocs.length];
		for (int i = 0; i < assocs.length; i++) {
			returnArray[i] = assocs[i].getRelationshipName().getValue();			
		}
		return returnArray;		
	}
	
	/**
	 * Constructs an array of PropertyType objects based on values in a String array.
	 * @param stringArray
	 * 		The array containing the values of the PropertyType enum.
	 * @return
	 * 		The constructed PropertyType enum array.
	 */
	public static org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[] convertPropertyType(org.LexGrid.LexBIG.DataModel.enums.PropertyType[] inputArray){
		if (inputArray == null) {
			return null;
		}
		org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[] returnArray = new org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			returnArray[i] = org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType.valueOf(inputArray[i].getPropertyTypeOption());
		}
		return returnArray;
	}
	
	/**
	 * Constructs an array of PropertyType objects based on values in a String array.
	 * @param stringArray
	 * 		The array containing the values of the PropertyType enum.
	 * @return
	 * 		The constructed PropertyType enum array.
	 */
	public static org.LexGrid.LexBIG.iso21090.DataModel.enums.PropertyType[] convertPropertyType(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[] inputArray){
		if (inputArray == null) {
			org.LexGrid.LexBIG.iso21090.DataModel.enums.PropertyType[] emptyArray = new org.LexGrid.LexBIG.iso21090.DataModel.enums.PropertyType[0];
			return emptyArray;
		}
		org.LexGrid.LexBIG.iso21090.DataModel.enums.PropertyType[] returnArray = new org.LexGrid.LexBIG.iso21090.DataModel.enums.PropertyType[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			org.LexGrid.LexBIG.iso21090.DataModel.enums.PropertyType prop = new org.LexGrid.LexBIG.iso21090.DataModel.enums.PropertyType();
			prop.setPropertyTypeOption(inputArray[i].toString());
			returnArray[i] = prop;
		}
		return returnArray;
	}
	
	
	/**
	 * Constructs an array of ActiveOption objects based on values in a String array.
	 * @param stringArray
	 * 		The array containing the values of the ActiveOption enum.
	 * @return
	 * 		The constructed ActiveOption enum array.
	 */
	public static ActiveOption[] stringArrayToActiveOption(String[] stringArray){
		if (stringArray == null) {
			return null;
		}
		ActiveOption[] returnArray = new ActiveOption[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			ActiveOption ao = new ActiveOption();
			ao.setActiveOptionName(returnArray.toString());
			returnArray[i] = ao;
		}
		return returnArray;
	}
	
	/**
	 * Constructs an array of Status objects based on values in a String array.
	 * @param stringArray
	 * 		The array containing the values of the Status.
	 * @return
	 * 		The constructed Status array.
	 */
	public static Status[] stringArrayToStatus(String[] stringArray){
		if (stringArray == null) {
			return null;
		}
		Status[] returnArray = new Status[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			Status status = new Status();
			status.setValue(Iso21090Utils.createSt(stringArray[i]));
			returnArray[i] = status;
		}
		return returnArray;
	}
	
	public static String[] statusArrayToString(Status[] statusArray){
		if (statusArray == null) {
			return null;
		}
		String[] returnArray = new String[statusArray.length];
		for (int i = 0; i < statusArray.length; i++) {
			returnArray[i] = statusArray[i].getValue().getValue();
		}
		return returnArray;
	}
	
	/**
	 * Constructs an array of PropertyIdentification objects based on values in a String array.
	 * @param stringArray
	 * 		The array containing the values of the Status.
	 * @return
	 * 		The constructed PropertyIdentification array.
	 */
	public static PropertyIdentification[] stringArrayToPropertyIdentification(String[] stringArray){
		if (stringArray == null) {
			return null;
		}
		PropertyIdentification[] returnArray = new PropertyIdentification[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			PropertyIdentification propId = new PropertyIdentification();
			propId.setName(Iso21090Utils.createSt(stringArray[i]));
			returnArray[i] = propId;
		}
		return returnArray;
	} 
	
	
	public static DirectionalAssociationIdentification[] stringArrayToDirectionalAssociationIdentification(String[] stringArray, boolean isForward){
		if (stringArray == null) {
			return null;
		}
		DirectionalAssociationIdentification[] returnArray = new DirectionalAssociationIdentification[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			DirectionalAssociationIdentification assoc = new DirectionalAssociationIdentification();
			assoc.setRelationshipName(Iso21090Utils.createSt(stringArray[i]));
			assoc.setIsForward(Iso21090Utils.createBl(isForward));
			returnArray[i] = assoc;
		}
		return returnArray;
	} 
	
	public static AssociationIdentification[] stringArrayToAssociationIdentification(String[] stringArray){
		if (stringArray == null) {
			return null;
		}
		AssociationIdentification[] returnArray = new AssociationIdentification[stringArray.length];
		for (int i = 0; i < stringArray.length; i++) {
			AssociationIdentification assoc = new AssociationIdentification();
			assoc.setRelationshipName(Iso21090Utils.createSt(stringArray[i]));
			returnArray[i] = assoc;
		}
		return returnArray;
	} 
	
	/**
	 * Because caGrid services cannot pass a ResolvedConceptReference, this method
	 * builds a ConceptReference out of a ResolvedConceptReference
	 * @param ref
	 * 		The ConceptReference to check
	 * @return
	 * 		If the passed in ConceptReference is actually a ResolvedConceptReference
	 * 		object, it will return a ConceptReference based on it. If the object passed
	 * 		in is a ConceptReference, simply return it.
	 */
	public static org.LexGrid.LexBIG.DataModel.Core.ConceptReference checkIfConceptReferencsIsResolved(org.LexGrid.LexBIG.DataModel.Core.ConceptReference ref){
		  if(ref instanceof org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference){
			  org.LexGrid.LexBIG.DataModel.Core.ConceptReference sourceCodeReference = new org.LexGrid.LexBIG.DataModel.Core.ConceptReference();
			  sourceCodeReference.setCodingSchemeName(ref.getCodingSchemeName());
			  sourceCodeReference.setConceptCode(ref.getConceptCode());			  
			  ref = sourceCodeReference;
		  }	  
		  return ref;
	}	
	
	public static ConceptReference checkIfConceptReferencsIsResolved(ConceptReference ref){
		  if(ref instanceof ResolvedConceptReference){
			  ConceptReference sourceCodeReference = new ConceptReference();
			  sourceCodeReference.setCodingSchemeName(ref.getCodingSchemeName());
			  sourceCodeReference.setConceptCode(ref.getConceptCode());			  
			  ref = sourceCodeReference;
		  }	  
		  return ref;
	}	
	
	/**
	 * Transfroms a java.net.URI to an org.apache.axis.types.URI
	 * @param uri
	 * 		The URI to be transformed
	 * @return
	 * 		The new URI.
	 * @throws MalformedURIException
	 */
	public static org.apache.axis.types.URI URIConverter(java.net.URI uri) throws MalformedURIException{
		org.apache.axis.types.URI urn = new org.apache.axis.types.URI(uri.toString());
		return urn;
	}
	
	/**
	 * Transfroms a org.apache.axis.types.URI to an java.net.URI
	 * @param uri
	 * 		The URI to be transformed
	 * @return
	 * 		The new URI.
	 * @throws MalformedURIException
	 */
	public static java.net.URI URIConverter(org.apache.axis.types.URI uri) throws MalformedURIException{
		java.net.URI urn;
		try {
			urn = new java.net.URI(uri.toString());
		} catch (URISyntaxException e) {
			throw new MalformedURIException(e.getMessage());
		}
		return urn;
	}
	
	public static HierarchyResolutionPolicy buildHierarchyResolutionPolicy(
			String hierarchyID, 
			String conceptCode, 
			boolean resolveConcepts, 
			org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList associationQualifiers){
		HierarchyResolutionPolicy policy = new HierarchyResolutionPolicy();
		policy.setHierarchyId(Utils.wrapHierarchyIdentificationIdentification(hierarchyID));
		policy.setConceptCode(Utils.wrapConceptIdentification(conceptCode));
		policy.setResolveConcepts(Iso21090Utils.createBl(resolveConcepts));
		policy.setAssociationQualifiers(
				ConvertUtils.convert(associationQualifiers, org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList.class));	
		return policy;
	}
	
	public static RelationshipTypeBasedPolicy buildRelationshipTypeBasedPolicy(ConceptReference sourceConcept, 
			ConceptReference targetConcept, boolean directOnly){
		RelationshipTypeBasedPolicy policy = new RelationshipTypeBasedPolicy();
		policy.setSourceConcept(Utils.checkIfConceptReferencsIsResolved(sourceConcept));
		policy.setTargetConcept(Utils.checkIfConceptReferencsIsResolved(targetConcept));
		policy.setDirectOnly(Iso21090Utils.createBl(directOnly));
		return policy;
	}
	
	public static RelationshipDistanceBasedPolicy buildRelationshipDistanceBasedPolicy(ConceptReference sourceConcept, 
			ConceptReference targetConcept, int distance){
		RelationshipDistanceBasedPolicy policy = new RelationshipDistanceBasedPolicy();
		policy.setSourceConcept(Utils.checkIfConceptReferencsIsResolved(sourceConcept));
		policy.setTargetConcept(Utils.checkIfConceptReferencsIsResolved(targetConcept));
		policy.setDistance(Iso21090Utils.createInt(distance));
		return policy;
	}
	
	public static GraphResolutionPolicy buildGraphResolutionPolicy(org.LexGrid.LexBIG.DataModel.Core.ConceptReference graphFocus, 
			boolean resolveForward,
			boolean resolveBackward, 
			int resolveCodedEntryDepth, 
			int resolveAssociationDepth,
			org.LexGrid.LexBIG.DataModel.Collections.LocalNameList propertyNames,
			org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[] propertyTypes,
			org.LexGrid.LexBIG.DataModel.Collections.SortOptionList sortOptions, 
			org.LexGrid.LexBIG.DataModel.Collections.LocalNameList filterOptions, 
			int maxToReturn, 
			boolean keepLastAssociationLevelUnresolved){
		return buildGraphResolutionPolicy(
				ConvertUtils.convert(graphFocus, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
				resolveForward,
				resolveBackward,
				resolveCodedEntryDepth,
				resolveAssociationDepth,
				ConvertUtils.convert(propertyNames, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class),
				propertyTypes,
				ConvertUtils.convert(sortOptions, org.LexGrid.LexBIG.iso21090.DataModel.Collections.SortOptionList.class),
				ConvertUtils.convert(filterOptions, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class),
				maxToReturn,
				keepLastAssociationLevelUnresolved);
	}
	
	public static GraphResolutionPolicy buildGraphResolutionPolicy(
			ConceptReference graphFocus, 
			boolean resolveForward,
			boolean resolveBackward, 
			int resolveCodedEntryDepth, 
			int resolveAssociationDepth,
			LocalNameList propertyNames, 
			org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[] propertyTypes,
			SortOptionList sortOptions, 
			LocalNameList filterOptions, 
			int maxToReturn, 
			boolean keepLastAssociationLevelUnresolved){
		GraphResolutionPolicy policy = new GraphResolutionPolicy();
		policy.setGraphFocus(Utils.checkIfConceptReferencsIsResolved(graphFocus));
		policy.setResolveForward(Iso21090Utils.createBl(resolveForward));
		policy.setResolveBackwards(Iso21090Utils.createBl(resolveBackward));
		policy.setResolveCodedEntryDepth(Iso21090Utils.createInt(resolveCodedEntryDepth));
		policy.setResolveAssociationDepth(Iso21090Utils.createInt(resolveAssociationDepth));
		policy.setPropertyNames(propertyNames);
		policy.setPropertyTypes(Utils.convertPropertyType(propertyTypes));
		policy.setSortOptions(sortOptions);
		policy.setFilterOptions(filterOptions);
		policy.setMaximumToReturn(Iso21090Utils.createInt(maxToReturn));
		policy.setKeeptLastAssociationUnresolved(Iso21090Utils.createBl(keepLastAssociationLevelUnresolved));	
		return policy;
	}
	
	public static SetResolutionPolicy buildSetResolutionPolicy(
			org.LexGrid.LexBIG.DataModel.Collections.SortOptionList sortOptions,
			org.LexGrid.LexBIG.DataModel.Collections.LocalNameList filterOptions, 
			org.LexGrid.LexBIG.DataModel.Collections.LocalNameList propertyNames,
			org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.PropertyType[] propertyTypes, 
			boolean resolveConcepts, int maxToReturn){
		SetResolutionPolicy policy = new SetResolutionPolicy();
		policy.setSortOptions(ConvertUtils.convert(sortOptions, org.LexGrid.LexBIG.iso21090.DataModel.Collections.SortOptionList.class));
		policy.setFilterOptions(ConvertUtils.convert(filterOptions, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class));
		policy.setPropertyNames(ConvertUtils.convert(propertyNames, org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList.class));
		policy.setPropertyTypes(Utils.convertPropertyType(propertyTypes));
		policy.setResolveConcepts(Iso21090Utils.createBl(resolveConcepts));
		policy.setMaximumToReturn(Iso21090Utils.createInt(maxToReturn));
		return policy;
	}
	
	public static NodeListPolicy buildNodeListPolicy(
			org.LexGrid.LexBIG.DataModel.Core.ConceptReference graphFocus,
			boolean resolveForward, 
			boolean resolveBackward,
			int resolveAssociationDepth, 
			int maxToReturn){
		return buildNodeListPolicy(
				ConvertUtils.convert(graphFocus, org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference.class),
				resolveForward, 
				resolveBackward,
				resolveAssociationDepth, 
				maxToReturn);
	}
	
	public static NodeListPolicy buildNodeListPolicy(ConceptReference graphFocus,
			boolean resolveForward, boolean resolveBackward,
			int resolveAssociationDepth, int maxToReturn){
		NodeListPolicy policy = new NodeListPolicy();
		policy.setGraphFocus(graphFocus);
		policy.setResolveForward(Iso21090Utils.createBl(resolveForward));
		policy.setResolveBackward(Iso21090Utils.createBl(resolveBackward));
		policy.setResolveAssociationDepth(Iso21090Utils.createInt(resolveAssociationDepth));
		policy.setMaximumToReturn(Iso21090Utils.createInt(maxToReturn));
		return policy;
	}
	
	public static CodingSchemeIdentification wrapCodingSchemeIdentifier(String codingScheme){
		CodingSchemeIdentification cs = new CodingSchemeIdentification();
		cs.setName(Iso21090Utils.createSt(codingScheme));
		return cs;
	}
	
	public static MatchCriteria wrapMatchCritia(String text){
		MatchCriteria criteria = new MatchCriteria();
		criteria.setText(Iso21090Utils.createSt(text));
		return criteria;
	}
	
	public static CodeExistence wrapCodeExistence(boolean isPresent){
		CodeExistence codeExists = new CodeExistence();
		codeExists.setIsPresent(Iso21090Utils.createBl(isPresent));
		return codeExists;
	}
	
	public static ExtensionIdentification wrapExtensionIdentification(String name){
		ExtensionIdentification extension = new ExtensionIdentification();
		extension.setLexBIGExtensionName(Iso21090Utils.createSt(name));
		return extension;
	}
	
	public static HierarchyIdentification wrapHierarchyIdentificationIdentification(String identifier){
		HierarchyIdentification hier = new HierarchyIdentification();
		hier.setIdentifier(Iso21090Utils.createSt(identifier));
		return hier;
	}
	
	public static LanguageIdentification wrapLanguageIdentification(String name){
		LanguageIdentification language = new LanguageIdentification();
		language.setIdentifier(Iso21090Utils.createSt(name));
		return language;
	}
	
	public static CodeRelationship wrapCodeRelationship(boolean areRelated){
		CodeRelationship rel = new CodeRelationship();
		rel.setIsCodeRelated(Iso21090Utils.createBl(areRelated));
		return rel;
	}
	
	public static CodeState wrapCodeState(boolean isActive){
		CodeState codeState = new CodeState();
		codeState.setIsActive(Iso21090Utils.createBl(isActive));
		return codeState;
	}
	
	public static Direction wrapDirection(boolean isForward){
		Direction direction = new Direction();
		direction.setIsForward(Iso21090Utils.createBl(isForward));
		return direction;
	}
	
	public static DirectionalAssociationIdentification wrapDirectionalAssociationIdentification(String id, boolean isForward){
		DirectionalAssociationIdentification assoc = new DirectionalAssociationIdentification();
		assoc.setRelationshipName(Iso21090Utils.createSt(id));
		assoc.setIsForward(Iso21090Utils.createBl(isForward));
		return assoc;
	}
	
	
	public static ConceptIdentification wrapConceptIdentification(String code){
		ConceptIdentification concept = new ConceptIdentification();
		concept.setCode(Iso21090Utils.createSt(code));
		return concept;
	}
	
	public static RelationContainerIdentification wrapRelationContainerIdentification(String name){
		RelationContainerIdentification container = new RelationContainerIdentification();
		container.setContextName(Iso21090Utils.createSt(name));
		return container;
	}
	
	public static CodingSchemeCopyRight wrapCodingSchemCopyRight(String text){
		CodingSchemeCopyRight copyright = new CodingSchemeCopyRight();
		copyright.setCopyrightTextOrURL(Iso21090Utils.createSt(text));
		return copyright;
	}
	
	public static AssociationIdentification wrapAssociationIdentification(String name){
		AssociationIdentification assoc = new AssociationIdentification();
		assoc.setRelationshipName(Iso21090Utils.createSt(name));
		return assoc;
	}
	
	public static org.LexGrid.LexBIG.iso21090.DataModel.enums.SearchDesignationOption convertSearchDesignationOption(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption option){
		if(option == null){
			return new org.LexGrid.LexBIG.iso21090.DataModel.enums.SearchDesignationOption();
		}
		org.LexGrid.LexBIG.iso21090.DataModel.enums.SearchDesignationOption returnOption = new org.LexGrid.LexBIG.iso21090.DataModel.enums.SearchDesignationOption();
		returnOption.setSearchDesignationOptionName(option.toString());
		return returnOption;
	}
	
	public static org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption convertSearchDesignationOption(org.LexGrid.LexBIG.DataModel.enums.SearchDesignationOption option){
		if(option.getSearchDesignationOptionName() == null){
			return null;
		}
		return org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption.
			valueOf(option.getSearchDesignationOptionName());
	}
	
	public static org.LexGrid.LexBIG.iso21090.DataModel.enums.ActiveOption convertActiveOption(org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.ActiveOption option){
		if(option == null){
			return new org.LexGrid.LexBIG.iso21090.DataModel.enums.ActiveOption();
		}
		org.LexGrid.LexBIG.iso21090.DataModel.enums.ActiveOption returnOption = new org.LexGrid.LexBIG.iso21090.DataModel.enums.ActiveOption();
		returnOption.setActiveOptionName(option.toString());
		return returnOption;
	}
	
	public static org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.ActiveOption convertActiveOption(org.LexGrid.LexBIG.DataModel.enums.ActiveOption option){
		if(option.getActiveOptionName() == null){
			return null;
		}
		return org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.ActiveOption.valueOf(option.getActiveOptionName());
	}
	
	public static org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.ActiveOption convertActiveOption(org.LexGrid.LexBIG.iso21090.DataModel.enums.ActiveOption option){
		if(option.getActiveOptionName() == null){
			return null;
		}
		return org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.ActiveOption.valueOf(option.getActiveOptionName());
	}
	
	public static org.LexGrid.LexBIG.iso21090.DataModel.enums.HierarchyPathResolveOption convertHierarchyPathResolveOption(org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods.HierarchyPathResolveOption option){
		if(option == null){
			return new org.LexGrid.LexBIG.iso21090.DataModel.enums.HierarchyPathResolveOption();
		}
		org.LexGrid.LexBIG.iso21090.DataModel.enums.HierarchyPathResolveOption returnOption = new org.LexGrid.LexBIG.iso21090.DataModel.enums.HierarchyPathResolveOption();
		returnOption.setPathToRootResovleOption(option.toString());
		return returnOption;
	}
	
	public static org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods.HierarchyPathResolveOption convertHierarchyPathResolveOption(org.LexGrid.LexBIG.iso21090.DataModel.enums.HierarchyPathResolveOption option){
		if(option.getPathToRootResovleOption() == null){
			return null;
		}
		return org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods.HierarchyPathResolveOption.valueOf(option.getPathToRootResovleOption());
	}
	
	public static String[] conceptIdentificationArrayToString(ConceptIdentification[] codeArray){
		if (codeArray == null) {
			return null;
		}
		String[] returnArray = new String[codeArray.length];
		for (int i = 0; i < codeArray.length; i++) {
			returnArray[i] = codeArray[i].getCode().getValue();
		}
		return returnArray;
	}
	
	
	/**
	 * LexEVS Grid Service is a layer over Distributed LexBIG, which itself is a layer
	 * over LexBIG. Often, Exceptions are rethrown or wrappered by the various layers,
	 * making them hard to understand by the time they reach the Grid Service layer.
	 * This method attempts to unwrap some of these Exceptions to find the real cause
	 * of the problem. After it receives an Exception, it cycles through the causes and
	 * attempts to locate the actual buried cause. It then creates a Grid Exception
	 * to correspond to that, and rethrows this new Exception.
	 * 
	 * @param e
	 * 		The Exception to process
	 * @throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException
	 * @throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException
	 * @throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException
	 * @throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException
	 * @throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess
	 * @throws RemoteException
	 */
	public static void processException(Exception e) throws 
	org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException,
	org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException,
	org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException,
	org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException,
	org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess,
	RemoteException
	{
		Throwable ex = (Throwable)e;
		while(ex != null){
			if(ex instanceof org.LexGrid.LexBIG.Exceptions.LBParameterException){						
				org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException exception =
					new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException();	
				exception.setFaultString(ex.getMessage());
				throw exception;
			} else if(ex instanceof org.LexGrid.LexBIG.Exceptions.LBException){
				org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException exception =
					new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException();	
				exception.setFaultString(ex.getMessage());
				throw exception;
			} else if(ex instanceof org.LexGrid.LexBIG.Exceptions.LBInvocationException){
				org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException exception =
					new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException();	
				exception.setFaultString(ex.getMessage());
				throw exception;						
			} else if(ex instanceof org.LexGrid.LexBIG.Exceptions.LBResourceUnavailableException){
				org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException exception =
					new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException();	
				exception.setFaultString(ex.getMessage());
				throw exception;						
			} else if(ex instanceof org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess){
				org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess exception =
					new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess();	
				exception.setFaultString(ex.getMessage());
				throw exception;							
			} else if(ex instanceof java.lang.IllegalArgumentException){
				RemoteException exception = new RemoteException("Illegal Argument Exception Thrown by Distributed LexBIG -- "
						+ "This could be caused by attempting to access a secured vocabulary without passing the proper Security"
						+ "Token. " + ex.getMessage(), ex);
				throw exception;							
			} else if(ex instanceof java.lang.SecurityException){
				RemoteException exception = new RemoteException("Security Error: " + ex.getMessage(), ex);
				throw exception;							
			}
			ex = ex.getCause();
		}
		throw new RemoteException("Unexpected Error: " + e.getMessage(), e);	
	}
	/*
	public static void processException_LBException(Exception e) throws
	org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException,
	RemoteException
	{
		Throwable ex = (Throwable)e;
		while(ex != null){
			if(ex instanceof org.LexGrid.LexBIG.Exceptions.LBException){
				org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException exception =
					new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException();	
				exception.setFaultString(ex.getMessage());
				throw exception;
			}
			ex = ex.getCause();
		}
		throw new RemoteException("Unexpected Error: " + e.getMessage(), e);	
	}
	
	public static void processException_LBInvocationException(Exception e) throws
	org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException,
	RemoteException
	{
		Throwable ex = (Throwable)e;
		while(ex != null){
			if(ex instanceof org.LexGrid.LexBIG.Exceptions.LBException){
				org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException exception =
					new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException();	
				exception.setFaultString(ex.getMessage());
				throw exception;
			}
			ex = ex.getCause();
		}
		throw new RemoteException("Unexpected Error: " + e.getMessage(), e);	
	}
	*/
}
