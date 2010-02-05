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
package org.LexGrid.LexBIG.cagrid.interfaces;

import java.io.Serializable;
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
import org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException;

/**
 * A coded node set represents a flat list of coded entries.
 */
public interface CodedNodeSetGrid extends Serializable {

	/**
	 * Return a coded node set that represents the set of concepts in this coded
	 * node set that are not included by the given set of codes.
	 * 
	 * @param codesToRemove
	 *            List of codes to remove from the surrounding set.
	 * @return A new CodedNodeSet containing the difference.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeSetGrid difference(CodedNodeSetGrid codesToRemove)
			throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;

	/**
	 * Return a coded node set that represents the set of concepts that this
	 * node set and the provided node set have in common.
	 * 
	 * @param codes
	 *            Set of codes to intersect.
	 * @return A new CodedNodeSet containing the intersection result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeSetGrid intersect(CodedNodeSetGrid codes)
			throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;

	/**
	 * Return true if the supplied concept reference is contained within the
	 * represented list.
	 * 
	 * @param code
	 *            Coding scheme and concept code to test.
	 * @return CodeExistence
	 * 			  True if the concept is present; otherwise False.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodeExistence isCodeInSet(ConceptReference code)
			throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;

	/**
	 * Resolve an iterator over concepts matching the given criteria.
	 * 
	 * @param policy
	 *         Policy for resolving the CodedNodeSet
	 * @return An iterator over matching concepts.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	ResolvedConceptReferencesIterator resolve(SetResolutionPolicy policy)
			throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;
	
	/**
	 * Resolve the set to a list of concepts sorted by the supplied parameters,
	 * resolving all of the properties named in the list.
	 * 
	 * @param policy
	 *         Policy for resolving the relationship
	 * @return A list of concept references, up to the maximum number specified.
	 *         Note that in the event that a maximum number 'n' is specified and
	 *         exactly 'n' items are resolved, there is currently no flag or
	 *         notification provided to indicate the requested list is fully
	 *         resolved.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	ResolvedConceptReferenceList resolveToList(SetResolutionPolicy policy)
			throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;
	
	/**
	 * Restrict the set to the list of codes in the supplied conceptReference
	 * list
	 * 
	 * @param codeList
	 *            The list of codes to filter on.
	 * @return A new CodedNodeSet containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeSetGrid restrictToCodes(ConceptReferenceList codeList)
			throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;

	/**
	 * Restrict the list to the set of concepts that have designations that
	 * match the supplied string, using the supplied matching algorithm and
	 * language
	 * 
	 * @param matchText
	 *            Filter String - syntax is determined by the match algorithm
	 * @param option
	 *            Indicates the designations to search (one of the enumerated
	 *            type SearchDesignationOption).
	 * @param matchAlgorithm
	 *            Local name of the match algorithm - possible algorithms are
	 *            returned in LexBigService.getMatchAlgorithms().
	 * @param language
	 *            Language of search string. If missing, use the default
	 *            language specified in the context.
	 * @return A new CodedNodeSet containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeSetGrid restrictToMatchingDesignations(MatchCriteria matchText,
			SearchDesignationOption option, ExtensionIdentification matchAlgorithm, LanguageIdentification language)
			throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;

	/**
	 * Remove all elements from the set that do not have one or more properties
	 * that match the given criteria.
	 * <p>
	 * Note that while property name and type are often synchronized, the API
	 * allows for them to be differentiated.  For concepts, there are 5 major
	 * types of properties that can be assigned ('Comments', 'Definitions',
	 * 'Instructions', 'Presentations', and 'Generic' properties which can represent
	 * vocabulary-specific name/value pairings).
	 * <p>
	 * Often the name assigned to a property will match the property type (e.g.
	 * a Presentation named 'textualPresentation' or a Definition named 'definition').
	 * However, names are not fixed (e.g. a Presentation property may be named 'text'
	 * or 'textualPresentation').
	 * <p>
	 * This method allows for query based on property name, type, or both.
	 * However, at least one name or type must be specified.
	 * 
	 * @param propertyNames
	 *            Indicates the local names of properties to match.  To be recognized,
	 *            each provided name must be defined in the coding scheme metadata as
	 *            part of the registered supported properties.  If empty or null,
	 *            all names are evaluated for the specified property types.
	 *            <p>
	 *            Note that the meta-property 'conceptCode' can be specified
	 *            in addition to specific named properties defined by the code
	 *            system.
	 *            <p>
	 *            If 'conceptCode' is specified, the matchAlgorithms 'exactMatch', 
	 *            'contains' and 'luceneQuery' and 'RegExp' are allowed.  Any other request 
	 *            results in 'luceneQuery' being used.<p>
	 * @param propertyTypes
	 *            Indicates whether to match specific property categories, regardless
	 *            of the assigned name.  Any of the enumerated PropertyType values
	 *            can be specified.  If empty or null, properties of all types are
	 *            evaluated.
	 * @param sourceList
	 *            Local names of sources to match; each must be defined in the
	 *            supported sources for the coding scheme. Returned values must
	 *            match at least one of the specified values. A null or empty
	 *            value indicates to match against all available sources.
	 * @param contextList
	 *            Local names of usage contexts to match; each must be defined
	 *            in the supported contexts for the coding scheme. Returned
	 *            values must match at least one of the specified values. A null
	 *            or empty value indicates to match against all available
	 *            contexts.
	 * @param qualifierList
	 *            Name/value pairings of property qualifiers to match. Each name
	 *            must be defined in the supported property qualifiers for the
	 *            coding scheme. Returned values must match at least one of the
	 *            name/value combinations. A null or empty value indicates to
	 *            match against all property qualifiers.
	 * @param matchText
	 *            Property text to match - syntax is determined by the
	 *            algorithm.
	 * @param matchAlgorithm
	 *            Local name of the match algorithm - possible algorithms are
	 *            returned in LexBigService.getMatchAlgorithms().
	 * @param language
	 *            Language of search string. If missing, use the default
	 *            language specified in the context.
	 * @return A new CodedNodeSet containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeSetGrid restrictToMatchingProperties(
			LocalNameList propertyNames, PropertyType[] propertyTypes,
			LocalNameList sourceList, LocalNameList contextList, NameAndValueList qualifierList,
			MatchCriteria matchText, ExtensionIdentification matchAlgorithm, LanguageIdentification language)
			throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;

	/**
	 * Remove all elements from the set that don't have one or more properties
	 * that match the given criteria.
     * <p>
     * Note that while property name and type are often synchronized, the API
     * allows for them to be differentiated.  For concepts, there are 5 major
     * types of properties that can be assigned ('Comments', 'Definitions',
     * 'Instructions', 'Presentations', and 'Generic' properties which can represent
     * vocabulary-specific name/value pairings).
     * <p>
     * Often the name assigned to a property will match the property type (e.g.
     * a Presentation named 'textualPresentation' or a Definition named 'definition').
     * However, names are not fixed (e.g. a Presentation property may be named 'text'
     * or 'textualPresentation').
     * <p>
     * This method allows for query based on property name, type, or both.
     * However, at least one name or type must be specified.
	 * 
	 * @param propertyList
	 *            Local names of properties to use in restriction; each must be
	 *            defined in the supported properties for the coding scheme.
     * @param propertyTypes
     *            Indicates whether to match specific property categories, regardless
     *            of the assigned name.  Any of the enumerated PropertyType values
     *            can be specified.  If empty or null, properties of all types are
     *            evaluated.   
	 * @param sourceList
	 *            Local names of sources to match; each must be defined in the
	 *            supported sources for the coding scheme. Returned values must
	 *            match at least one of the specified values. A null or empty
	 *            value indicates to match against all available sources.
	 * @param contextList
	 *            Local names of usage contexts to match; each must be defined
	 *            in the supported contexts for the coding scheme. Returned
	 *            values must match at least one of the specified values. A null
	 *            or empty value indicates to match against all available
	 *            contexts.
	 * @param qualifierList
	 *            Name/value pairings of property qualifiers to match. Each name
	 *            must be defined in the supported property qualifiers for the
	 *            coding scheme. Returned values must match at least one of the
	 *            name/value combinations. A null or empty value indicates to
	 *            match against all property qualifiers.
	 * @return A new CodedNodeSet containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeSetGrid restrictToProperties(LocalNameList propertyList, PropertyType[] propertyTypes,
			LocalNameList sourceList, LocalNameList contextList,
			NameAndValueList qualifierList) throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;

	/**
	 * Restrict the set to concepts matching the given status criteria.
	 * 
	 * @param activeOption
	 *            Indicates whether to include active concepts, inactive concepts,
	 *            or both in the resolved result set (one of the enumerated type
	 *            ActiveOption).  This is matched against the 'isActive' field for
	 *            CodedEntry instances in the code system.
	 * @param conceptStatus
	 *            Indicates zero or more concept status values to match.  Provided
	 *            values are compared using an exact match algorithm against
	 *            the 'conceptStatus' field for CodedEntry instances in the code
	 *            system.  If null or empty, the restriction is evaluated based only
	 *            on the specified activeOption.
	 * @return A new CodedNodeSet containing the filtered result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeSetGrid restrictToStatus(ActiveOption activeOption, Status[] conceptStatus)
			throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;

	/**
	 * Return the set union of all of the codes in the containing or the
	 * referenced set
	 * 
	 * @param codes
	 *            Codes to add to the union
	 * @return A new CodedNodeSet containing the merged result.
	 * @throws LBInvocationException,LBParameterException,InvalidServiceContextAccess,RemoteException
	 */
	CodedNodeSetGrid union(CodedNodeSetGrid codes) throws LBInvocationException,LBParameterException,InvalidServiceContextAccess, RemoteException;

}