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
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public interface CodedNodeSetI {

  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList resolveToList(org.LexGrid.LexBIG.DataModel.cagrid.SetResolutionPolicy setResolutionPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToCodes(org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList codeList) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public org.LexGrid.LexBIG.DataModel.cagrid.CodeExistence isCodeInSet(org.LexGrid.LexBIG.DataModel.Core.ConceptReference code) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToMatchingDesignations(org.LexGrid.LexBIG.DataModel.cagrid.MatchCriteria matchCriteria,org.LexGrid.LexBIG.DataModel.enums.SearchDesignationOption searchDesignationOption,org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification extensionIdentification,org.LexGrid.LexBIG.DataModel.cagrid.LanguageIdentification languageIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.client.ResolvedConceptReferencesIteratorClient resolve(org.LexGrid.LexBIG.DataModel.cagrid.SetResolutionPolicy setResolutionPolicy) throws RemoteException, org.apache.axis.types.URI.MalformedURIException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToStatus(org.LexGrid.LexBIG.DataModel.enums.ActiveOption activeOption,org.LexGrid.LexBIG.DataModel.cagrid.Status[] status) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void intersect(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void union(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void difference(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList propertyList,org.LexGrid.LexBIG.DataModel.enums.PropertyType[] propertyType,org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList2,org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList3,org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList nameAndValueList) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToMatchingProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList,org.LexGrid.LexBIG.DataModel.enums.PropertyType[] propertyType,org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList2,org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList3,org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList nameAndValueList,org.LexGrid.LexBIG.DataModel.cagrid.MatchCriteria matchCriteria,org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification extensionIdentification,org.LexGrid.LexBIG.DataModel.cagrid.LanguageIdentification languageIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.lifetime.DestroyResponse destroy(org.oasis.wsrf.lifetime.Destroy params) throws RemoteException ;

  public org.oasis.wsrf.lifetime.SetTerminationTimeResponse setTerminationTime(org.oasis.wsrf.lifetime.SetTerminationTime params) throws RemoteException ;

}
