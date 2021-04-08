/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
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

  public org.LexGrid.LexBIG.iso21090.DataModel.Collections.ResolvedConceptReferenceList resolveToList(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.SetResolutionPolicy setResolutionPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToCodes(org.LexGrid.LexBIG.iso21090.DataModel.Collections.ConceptReferenceList codeList) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeExistence isCodeInSet(org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference code) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToMatchingDesignations(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.MatchCriteria matchCriteria,org.LexGrid.LexBIG.iso21090.DataModel.enums.SearchDesignationOption searchDesignationOption,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ExtensionIdentification extensionIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.LanguageIdentification languageIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.client.ResolvedConceptReferencesIteratorClient resolve(org.LexGrid.LexBIG.iso21090.DataModel.cagrid.SetResolutionPolicy setResolutionPolicy) throws RemoteException, org.apache.axis.types.URI.MalformedURIException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToStatus(org.LexGrid.LexBIG.iso21090.DataModel.enums.ActiveOption activeOption,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.Status[] status) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void intersect(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void union(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void difference(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToProperties(org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList propertyList,org.LexGrid.LexBIG.iso21090.DataModel.enums.PropertyType[] propertyType,org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList localNameList2,org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList localNameList3,org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList nameAndValueList) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public void restrictToMatchingProperties(org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList localNameList,org.LexGrid.LexBIG.iso21090.DataModel.enums.PropertyType[] propertyType,org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList localNameList2,org.LexGrid.LexBIG.iso21090.DataModel.Collections.LocalNameList localNameList3,org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList nameAndValueList,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.MatchCriteria matchCriteria,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ExtensionIdentification extensionIdentification,org.LexGrid.LexBIG.iso21090.DataModel.cagrid.LanguageIdentification languageIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException ;

  public org.oasis.wsrf.lifetime.DestroyResponse destroy(org.oasis.wsrf.lifetime.Destroy params) throws RemoteException ;

  public org.oasis.wsrf.lifetime.SetTerminationTimeResponse setTerminationTime(org.oasis.wsrf.lifetime.SetTerminationTime params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

}