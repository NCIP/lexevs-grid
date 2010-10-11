package org.LexGrid.LexBIG.cagrid.test.query.cql;

import gov.nih.nci.cagrid.cqlquery.Attribute;
import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlquery.Object;
import gov.nih.nci.cagrid.cqlquery.Predicate;
import gov.nih.nci.cagrid.data.client.DataServiceClient;
import gov.nih.nci.cagrid.data.utilities.DataServiceHandle;

import java.util.Iterator;

import org.LexGrid.LexBIG.cagrid.test.setup.LexEVSDataServiceHolder;
import org.LexGrid.LexBIG.cagrid.test.setup.ServiceTestCase;
import org.LexGrid.concepts.Entity;

public class CQLPredicates extends ServiceTestCase
{
	private final String test_id = "CQLTests";

	@Override
	protected String getTestID() {
		return test_id;
	}

	public void testEqualToPredicate() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Entity");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	
		target.setAttribute(at1);

		query.setTarget(target);
		Iterator results = handle.query(query);

		assertTrue(results.hasNext());
		while (results.hasNext()){
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("149164001"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
	}	

	public void testLikePredicate() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Entity");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("14916400%");
		at1.setPredicate(Predicate.LIKE);	
		target.setAttribute(at1);

		query.setTarget(target);
		Iterator results = handle.query(query);

		assertTrue(results.hasNext());
		while (results.hasNext()){
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("149164001"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
	}	

}
