/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.dataService.queryProcessor;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.LexGrid.LexBIG.caCore.interfaces.LexEVSApplicationService;
import org.LexGrid.LexBIG.cagrid.dataService.queryProcessor.exceptions.SDKQueryException;
import org.LexGrid.LexBIG.cagrid.security.connection.SecureConnectionManager;
import org.LexGrid.LexBIG.cagrid.security.connection.SecureConnectionManagerFactory;

import gov.nih.nci.cagrid.common.Utils;
import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlresultset.CQLQueryResults;
import gov.nih.nci.cagrid.data.InitializationException;
import gov.nih.nci.cagrid.data.MalformedQueryException;
import gov.nih.nci.cagrid.data.QueryProcessingException;
import gov.nih.nci.cagrid.data.cql.CQLQueryProcessor;
import gov.nih.nci.cagrid.data.mapping.Mappings;
import gov.nih.nci.cagrid.data.service.ServiceConfigUtil;
import gov.nih.nci.cagrid.data.utilities.CQLResultsCreationUtil;
import gov.nih.nci.cagrid.data.utilities.ResultsCreationException;

public class LexEVSDataServiceQueryProcessor extends CQLQueryProcessor {

	private SecureConnectionManager<LexEVSApplicationService> manager;
	
	@Override
	public CQLQueryResults processQuery(CQLQuery cqlQuery)
			throws MalformedQueryException, QueryProcessingException {
		String target = cqlQuery.getTarget().getName();
		List results;
		try {
			results = querySDK(cqlQuery);
		} catch (Exception e) {
			throw new QueryProcessingException(e);
		}
		CQLQueryResults queryResults;
		try {
			Mappings mappings = getClassToQnameMappings();
			if(cqlQuery.getQueryModifier() != null && cqlQuery.getQueryModifier().isCountOnly()){
				long count = getCount(results);
				
				queryResults = CQLResultsCreationUtil.createCountResults(count, target);
			} else {
				queryResults = CQLResultsCreationUtil.createObjectResults(results, target, mappings);
			}
		} catch (ResultsCreationException e) {
			throw new QueryProcessingException(e);
		} catch (Exception e) {
			throw new QueryProcessingException(e);
		}
		return queryResults;	
	}
	
	private long getCount(List results) throws QueryProcessingException{
		long count = 0;
		if(results != null && results.size() > 0){
			for(Object result : results){
				count = count + this.getCountFromResult(result);
			}
		}
		
		return count;
	}
	
	private long getCountFromResult(Object result) throws QueryProcessingException{
		try {
			Integer integerCount = (Integer)result;
			return integerCount.longValue();
		} catch (Exception e) {
			throw new QueryProcessingException("Count Query returned wrong result.");
		}
	}

	@Override
	public void initialize(Properties parameters, InputStream wsdd)
			throws InitializationException {
		super.initialize(parameters, wsdd);
		try{
			manager = SecureConnectionManagerFactory.getInstance().getSecureConnectionManager();
		} catch (Exception e){
			throw new InitializationException(e);
		}
	}
	
	protected List querySDK(CQLQuery query) throws SDKQueryException {
		org.apache.axis.MessageContext messagectx = org.apache.axis.MessageContext
		  .getCurrentContext();
		try {
			return manager.getApplicationServiceFromCache(messagectx).query(query);
		} catch (Exception e) {
			throw new SDKQueryException(e);
		}
	}
	
	private Mappings getClassToQnameMappings() throws Exception {
		// get the mapping file name
		String filename = ServiceConfigUtil.getClassToQnameMappingsFile();
		Mappings mappings = (Mappings) Utils.deserializeDocument(filename, Mappings.class);
		return mappings;
	}
}
