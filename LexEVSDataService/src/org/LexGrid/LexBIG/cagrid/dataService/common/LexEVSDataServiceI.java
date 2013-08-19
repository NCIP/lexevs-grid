/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.dataService.common;

import java.rmi.RemoteException;

/** 
 * This class is autogenerated, DO NOT EDIT.
 * 
 * This interface represents the API which is accessable on the grid service from the client. 
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public interface LexEVSDataServiceI {

  /**
   * The standard caGrid Data Service query method.
   *
   * @param cqlQuery
   *	The CQL query to be executed against the data source.
   * @return The result of executing the CQL query against the data source.
   * @throws QueryProcessingException
   *	Thrown when an error occurs in processing a CQL query
   * @throws MalformedQueryException
   *	Thrown when a query is found to be improperly formed
   */
  public gov.nih.nci.cagrid.cqlresultset.CQLQueryResults query(gov.nih.nci.cagrid.cqlquery.CQLQuery cqlQuery) throws RemoteException, gov.nih.nci.cagrid.data.faults.QueryProcessingExceptionType, gov.nih.nci.cagrid.data.faults.MalformedQueryExceptionType ;

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException ;

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException ;

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException ;

  /**
   * codingSchemeUri
   *
   * @param string
   * @param securityToken
   */
  public org.LexGrid.LexBIG.cagrid.dataService.client.LexEVSDataServiceClient registerSecurityToken(java.lang.String string,gov.nih.nci.evs.security.SecurityToken securityToken) throws RemoteException, org.apache.axis.types.URI.MalformedURIException ;

}

