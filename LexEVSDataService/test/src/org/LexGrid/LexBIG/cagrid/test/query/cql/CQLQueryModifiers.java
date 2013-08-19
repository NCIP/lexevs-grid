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
import gov.nih.nci.cagrid.cqlquery.Object;
import gov.nih.nci.cagrid.cqlquery.Predicate;
import gov.nih.nci.cagrid.cqlquery.QueryModifier;
import gov.nih.nci.cagrid.cqlresultset.CQLCountResult;
import gov.nih.nci.cagrid.cqlresultset.CQLObjectResult;
import gov.nih.nci.cagrid.cqlresultset.CQLQueryResults;
import gov.nih.nci.cagrid.data.client.DataServiceClient;
import gov.nih.nci.cagrid.data.utilities.DataServiceHandle;

import java.util.Iterator;

import org.LexGrid.LexBIG.cagrid.test.setup.LexEVSDataServiceHolder;
import org.LexGrid.LexBIG.cagrid.test.setup.ServiceTestCase;
import org.LexGrid.concepts.Entity;

public class CQLQueryModifiers extends ServiceTestCase
{
	private final String test_id = "CQLTests";

	@Override
	protected String getTestID() {
		return test_id;
	}

	public void testCountOnly() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		
		CQLQuery query = new CQLQuery();	
		
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Entity");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue(ServiceTestCase.SNOMED_SCHEME);
		at2.setPredicate(Predicate.EQUAL_TO);

		Group group = new Group();
		group.setAttribute(new Attribute[]{at1, at2});
		group.setLogicRelation(LogicalOperator.AND);
		
		target.setGroup(group);
		
		QueryModifier modifiers = new QueryModifier();
		modifiers.setCountOnly(true);
		
		query.setTarget(target);
		
		query.setQueryModifier(modifiers);
		
		CQLQueryResults results = svc.query(query);

		CQLCountResult countResult = results.getCountResult();
		
		assertEquals(1,countResult.getCount());
	}	
	
	public void testCountOnlyFalse() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Entity");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue(ServiceTestCase.SNOMED_SCHEME);
		at2.setPredicate(Predicate.EQUAL_TO);

		Group group = new Group();
		group.setAttribute(new Attribute[]{at1, at2});
		group.setLogicRelation(LogicalOperator.AND);
		
		target.setGroup(group);
		
		QueryModifier modifiers = new QueryModifier();
		modifiers.setCountOnly(false);
		
		query.setTarget(target);
		
		query.setQueryModifier(modifiers);
		
		Iterator<Entity> itr = handle.query(query);
		
		assertTrue(itr.hasNext());
		Entity foundConcept = itr.next();
		assertTrue(foundConcept.getEntityCode().equals("149164001"));
		assertFalse(itr.hasNext());	
	}	
	
	public void testAttributes() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Entity");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue(ServiceTestCase.SNOMED_SCHEME);
		at2.setPredicate(Predicate.EQUAL_TO);

		Group group = new Group();
		group.setAttribute(new Attribute[]{at1, at2});
		group.setLogicRelation(LogicalOperator.AND);
		
		target.setGroup(group);
		
		QueryModifier modifiers = new QueryModifier();
		modifiers.setAttributeNames(new String[]{"_entityCode"});
		query.setTarget(target);
		
		query.setQueryModifier(modifiers);
		
		CQLQueryResults results = svc.query(query);
		
		CQLObjectResult[] obj = results.getObjectResult();
		
		assertTrue(obj[0].get_any()[0].getValue().equals("149164001"));
	}	
	
	public void testDistinctAttributes() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Entity");

		//This should return 11 results or so.
		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("14916%");
		at1.setPredicate(Predicate.LIKE);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue(ServiceTestCase.SNOMED_SCHEME);
		at2.setPredicate(Predicate.EQUAL_TO);

		Group group = new Group();
		group.setAttribute(new Attribute[]{at1, at2});
		group.setLogicRelation(LogicalOperator.AND);
		
		target.setGroup(group);
		
		QueryModifier modifiers = new QueryModifier();
		modifiers.setCountOnly(false);
		modifiers.setDistinctAttribute("_entityCodeNamespace");
		query.setTarget(target);
		
		query.setQueryModifier(modifiers);
		
		CQLQueryResults results = svc.query(query);
		
		CQLObjectResult[] obj = results.getObjectResult();
		
		assertTrue(obj[0].get_any()[0].getValue().equals(ServiceTestCase.SNOMED_SCHEME));
	}		
	
	/*
	 * GForge #19406
	 * https://gforge.nci.nih.gov/tracker/?func=detail&aid=19406&group_id=491&atid=1850
	 */
	public void testCountOnlyProperlySerialized() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		
		CQLQuery query = new CQLQuery();	
		
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Entity");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue(ServiceTestCase.SNOMED_SCHEME);
		at2.setPredicate(Predicate.EQUAL_TO);

		Group group = new Group();
		group.setAttribute(new Attribute[]{at1, at2});
		group.setLogicRelation(LogicalOperator.AND);
		
		target.setGroup(group);
		
		QueryModifier modifiers = new QueryModifier();
		modifiers.setCountOnly(true);
		
		query.setTarget(target);
		
		query.setQueryModifier(modifiers);
		
		CQLQueryResults results = svc.query(query);

		CQLCountResult countResult = results.getCountResult();
		
		assertTrue("GForge #19406", countResult != null);
		assertTrue("GForge #19406", countResult.getCount() == 1);
	}
	
	public void testCountOnlyMultipleCodingSchemes() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		
		CQLQuery query = new CQLQuery();	
		
		Object target = new Object();

		target.setName("org.LexGrid.codingSchemes.CodingScheme");

		QueryModifier modifiers = new QueryModifier();
		modifiers.setCountOnly(true);
		
		query.setTarget(target);
		
		query.setQueryModifier(modifiers);
		
		CQLQueryResults results = svc.query(query);

		CQLCountResult countResult = results.getCountResult();

		assertTrue("GForge #19406", countResult.getCount() > 1);
	}
}
