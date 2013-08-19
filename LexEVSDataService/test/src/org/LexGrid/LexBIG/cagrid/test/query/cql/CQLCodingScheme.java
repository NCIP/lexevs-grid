/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.test.query.cql;

import gov.nih.nci.cagrid.cqlquery.Attribute;
import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlquery.Group;
import gov.nih.nci.cagrid.cqlquery.LogicalOperator;
import gov.nih.nci.cagrid.cqlquery.Predicate;
import gov.nih.nci.cagrid.data.client.DataServiceClient;
import gov.nih.nci.cagrid.data.utilities.DataServiceHandle;

import java.util.Iterator;

import gov.nih.nci.cagrid.cqlquery.Object;

import org.LexGrid.LexBIG.cagrid.test.setup.LexEVSDataServiceHolder;
import org.LexGrid.LexBIG.cagrid.test.setup.ServiceTestCase;
import org.LexGrid.codingSchemes.CodingScheme;

public class CQLCodingScheme extends ServiceTestCase
{
	private final String test_id = "CQLTests";
	
	@Override
	protected String getTestID() {
		return test_id;
	}
	
	public void testGetCodingSchemes() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();
		
		target.setName("org.LexGrid.codingSchemes.CodingScheme");
		
		query.setTarget(target);
		Iterator itr = handle.query(query);
		
		assertTrue(itr != null);
		assertTrue(itr.hasNext());
	}
	
	public void testGetCodingSchemeByNameAndVersion() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();
		
		target.setName("org.LexGrid.codingSchemes.CodingScheme");
		Attribute at1 = new Attribute();
		at1.setName("_codingSchemeName");
		at1.setValue(ServiceTestCase.SNOMED_SCHEME);
		at1.setPredicate(Predicate.EQUAL_TO);
		
		Attribute at2 = new Attribute();
		at2.setName("_representsVersion");
		at2.setValue(ServiceTestCase.SNOMED_VERSION);
		at2.setPredicate(Predicate.EQUAL_TO);
		
		Group group = new Group();
		group.setLogicRelation(LogicalOperator.AND);
		group.setAttribute(new Attribute[]{at1, at2});
		
		target.setGroup(group);
			
		query.setTarget(target);
		Iterator itr = handle.query(query);
		
		assertTrue(itr != null);
		assertTrue(itr.hasNext());
		
		while(itr.hasNext()){
			CodingScheme cs = (CodingScheme)itr.next();
			assertTrue(cs.getCodingSchemeName().equals(ServiceTestCase.SNOMED_SCHEME));
			assertTrue(cs.getRepresentsVersion().equals(ServiceTestCase.SNOMED_VERSION));
		}		
	}
}
