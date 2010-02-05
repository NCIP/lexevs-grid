package org.LexGrid.LexBIG.cagrid.dataService.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Iterator;

import org.LexGrid.LexBIG.cagrid.dataService.common.LexEVSDataServiceI;

import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlresultset.CQLQueryResults;
import gov.nih.nci.cagrid.data.faults.MalformedQueryExceptionType;
import gov.nih.nci.cagrid.data.faults.QueryProcessingExceptionType;
import gov.nih.nci.cagrid.data.utilities.CQLQueryResultsIterator;
import gov.nih.nci.cagrid.data.utilities.DataServiceIterator;

public class LexEVSDataServiceHandle implements DataServiceIterator {

	private LexEVSDataServiceI service;
	private InputStream wsddStream;
	
	public LexEVSDataServiceHandle(LexEVSDataServiceI dataService) {
		this(dataService, (InputStream) null);
	}
		
	public LexEVSDataServiceHandle(LexEVSDataServiceI dataService, String wsddFilename) 
		throws FileNotFoundException {
		this(dataService, new FileInputStream(wsddFilename));
	}
		
	public LexEVSDataServiceHandle(LexEVSDataServiceI dataService, InputStream wsddStream) {
		this.service = dataService;
		this.wsddStream = wsddStream;
	}
		
	public Iterator query(CQLQuery cqlQuery) 
		throws MalformedQueryExceptionType, QueryProcessingExceptionType, RemoteException {
		CQLQueryResults results = service.query(cqlQuery);
		if (wsddStream == null) {
			return new CQLQueryResultsIterator(results);
		} else {
			return new CQLQueryResultsIterator(results, wsddStream);
		}
	}
}
