package org.LexGrid.LexBIG.cagrid.test.query.cql;

import edu.mayo.informatics.lexgrid.convert.directConversions.TextCommon.Concept;
import gov.nih.nci.cagrid.cqlquery.Attribute;
import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlquery.Group;
import gov.nih.nci.cagrid.cqlquery.LogicalOperator;
import gov.nih.nci.cagrid.cqlquery.Object;
import gov.nih.nci.cagrid.cqlquery.Predicate;
import gov.nih.nci.cagrid.data.client.DataServiceClient;
import gov.nih.nci.cagrid.data.utilities.DataServiceHandle;

import java.util.Iterator;

import org.LexGrid.LexBIG.cagrid.test.setup.LexEVSDataServiceHolder;
import org.LexGrid.LexBIG.cagrid.test.setup.ServiceTestCase;
import org.LexGrid.concepts.Entity;

public class CQLGroups extends ServiceTestCase
{
	private final String test_id = "CQLTests";

	@Override
	protected String getTestID() {
		return test_id;
	}

	public void testAndGroup() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Concept");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue(ServiceTestCase.SNOMED_SCHEME);
		at2.setPredicate(Predicate.EQUAL_TO);

		Group group = new Group();
		group.setLogicRelation(LogicalOperator.AND);
		group.setAttribute(new Attribute[]{at1, at2});

		target.setGroup(group);

		query.setTarget(target);
		Iterator results = handle.query(query);

		assertTrue(results.hasNext());
		while (results.hasNext()){
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("149164001"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
	}	

	public void testAndGroupWrongValue() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Concept");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue("WRONG_VALUE_FOR_TESTING");
		at2.setPredicate(Predicate.EQUAL_TO);

		Group group = new Group();
		group.setLogicRelation(LogicalOperator.AND);
		group.setAttribute(new Attribute[]{at1, at2});

		target.setGroup(group);

		query.setTarget(target);
		Iterator results = handle.query(query);

		assertFalse(results.hasNext());
	}	

	public void testOrGroup() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Concept");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue("WRONG_VALUE_FOR_TESTING");
		at2.setPredicate(Predicate.EQUAL_TO);

		Group group = new Group();
		group.setLogicRelation(LogicalOperator.OR);
		group.setAttribute(new Attribute[]{at1, at2});

		target.setGroup(group);

		query.setTarget(target);
		Iterator results = handle.query(query);

		assertTrue(results.hasNext());
		while (results.hasNext()){
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("149164001"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
	}

	public void testOrGroupWrongValue() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Concept");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("WRONG_VALUE_FOR_TESTING");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue("WRONG_VALUE_FOR_TESTING");
		at2.setPredicate(Predicate.EQUAL_TO);

		Group group = new Group();
		group.setLogicRelation(LogicalOperator.OR);
		group.setAttribute(new Attribute[]{at1, at2});

		target.setGroup(group);

		query.setTarget(target);
		Iterator results = handle.query(query);

		assertFalse(results.hasNext());
	}

	public void testNestedAndGroup() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Concept");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue(ServiceTestCase.SNOMED_SCHEME);
		at2.setPredicate(Predicate.EQUAL_TO);

		Group mainGroup = new Group();
		Group nestedGroup1 = new Group();
		nestedGroup1.setLogicRelation(LogicalOperator.AND);
		Group nestedGroup2 = new Group();
		nestedGroup2.setLogicRelation(LogicalOperator.AND);

		nestedGroup1.setAttribute(new Attribute[]{at1});
		nestedGroup2.setAttribute(new Attribute[]{at2});

		mainGroup.setGroup(new Group[]{nestedGroup1, nestedGroup2});
		mainGroup.setLogicRelation(LogicalOperator.AND);

		target.setGroup(mainGroup);

		query.setTarget(target);
		Iterator results = handle.query(query);

		assertTrue(results.hasNext());
		while (results.hasNext()){
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("149164001"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
	}	

	public void testNestedAndGroupWrongValue() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Concept");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue("WRONG_VALUE_FOR_TESTING");
		at2.setPredicate(Predicate.EQUAL_TO);

		Group mainGroup = new Group();
		Group nestedGroup1 = new Group();
		nestedGroup1.setLogicRelation(LogicalOperator.AND);
		Group nestedGroup2 = new Group();
		nestedGroup2.setLogicRelation(LogicalOperator.AND);

		nestedGroup1.setAttribute(new Attribute[]{at1});
		nestedGroup2.setAttribute(new Attribute[]{at2});

		mainGroup.setGroup(new Group[]{nestedGroup1, nestedGroup2});
		mainGroup.setLogicRelation(LogicalOperator.AND);

		target.setGroup(mainGroup);

		query.setTarget(target);

		Iterator results = handle.query(query);
		assertFalse(results.hasNext());

	}	

	public void testNestedOrGroup() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Concept");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("149164001");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue("WRONG_VALUE_FOR_TESTING");
		at2.setPredicate(Predicate.EQUAL_TO);

		Group mainGroup = new Group();
		Group nestedGroup1 = new Group();
		nestedGroup1.setLogicRelation(LogicalOperator.AND);
		Group nestedGroup2 = new Group();
		nestedGroup2.setLogicRelation(LogicalOperator.AND);

		nestedGroup1.setAttribute(new Attribute[]{at1});
		nestedGroup2.setAttribute(new Attribute[]{at2});

		mainGroup.setGroup(new Group[]{nestedGroup1, nestedGroup2});
		mainGroup.setLogicRelation(LogicalOperator.OR);

		target.setGroup(mainGroup);

		query.setTarget(target);
		Iterator results = handle.query(query);

		assertTrue(results.hasNext());
		while (results.hasNext()){
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("149164001"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
	}	

	public void testNestedOrGroupWrongValue() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);

		CQLQuery query = new CQLQuery();	
		Object target = new Object();

		target.setName("org.LexGrid.concepts.Concept");

		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("WRONG_VALUE_FOR_TESTING");
		at1.setPredicate(Predicate.EQUAL_TO);	

		Attribute at2 = new Attribute();
		at2.setName("_entityCodeNamespace");
		at2.setValue("WRONG_VALUE_FOR_TESTING");
		at2.setPredicate(Predicate.EQUAL_TO);

		Group mainGroup = new Group();
		Group nestedGroup1 = new Group();
		nestedGroup1.setLogicRelation(LogicalOperator.AND);
		Group nestedGroup2 = new Group();
		nestedGroup2.setLogicRelation(LogicalOperator.AND);

		nestedGroup1.setAttribute(new Attribute[]{at1});
		nestedGroup2.setAttribute(new Attribute[]{at2});

		mainGroup.setGroup(new Group[]{nestedGroup1, nestedGroup2});
		mainGroup.setLogicRelation(LogicalOperator.OR);

		target.setGroup(mainGroup);

		query.setTarget(target);
		Iterator results = handle.query(query);

		assertFalse(results.hasNext());
	}	

}
