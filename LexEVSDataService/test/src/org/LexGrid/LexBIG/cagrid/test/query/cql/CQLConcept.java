package org.LexGrid.LexBIG.cagrid.test.query.cql;

import gov.nih.nci.cagrid.cqlquery.Association;
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

public class CQLConcept extends ServiceTestCase
{
	private final String test_id = "CQLTests";
	
	@Override
	protected String getTestID() {
		return test_id;
	}
	
	public void testGetConceptByIdAndCodingSchemeNamespace() throws Exception {
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
		group.setLogicRelation(LogicalOperator.AND);
		group.setAttribute(new Attribute[]{at1, at2});
		
		target.setGroup(group);
				
		query.setTarget(target);
		Iterator results = handle.query(query);
		
		boolean foundResults = false;
		while (results.hasNext()){
			foundResults = true;
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("149164001"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
		assertTrue(foundResults);
	}	
	
	public void testGetEntityByIdAndCodingSchemeNamespaceWildCard() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();
				
		target.setName("org.LexGrid.concepts.Entity");
		
		Attribute at1 = new Attribute();
		at1.setName("_entityCode");
		at1.setValue("10000500%");
		at1.setPredicate(Predicate.LIKE);	
		
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
		
		boolean foundResults = false;
		while (results.hasNext()){
			foundResults = true;
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().startsWith("10000500"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
		assertTrue(foundResults);
	}	
	
	public void testGetEntityByEntityDescriptionAndCodingSchemeNamespace() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();
				
		target.setName("org.LexGrid.concepts.Entity");
	
		Attribute at = new Attribute();
		at.setName("_entityCodeNamespace");
		at.setValue(ServiceTestCase.SNOMED_SCHEME);
		at.setPredicate(Predicate.EQUAL_TO);
		
		target.setAttribute(at);
		
		Association assoc = new Association();
		assoc.setRoleName("_entityDescription");
		
		Attribute entityDes = new Attribute();
		entityDes.setName("_content");
		entityDes.setValue("Boxing");
		entityDes.setPredicate(Predicate.EQUAL_TO);
		
		assoc.setAttribute(entityDes);	
		target.setAssociation(assoc);
		
		query.setTarget(target);
		Iterator results = handle.query(query);
		
		boolean foundResults = false;
		while (results.hasNext()){
			foundResults = true;
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().startsWith("29506000"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
		assertTrue(foundResults);
	}	
	
	public void testGetEntityByEntityDescriptionAndCodingSchemeNamespaceWildCard() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();
				
		target.setName("org.LexGrid.concepts.Entity");
	
		Attribute at = new Attribute();
		at.setName("_entityCodeNamespace");
		at.setValue(ServiceTestCase.SNOMED_SCHEME);
		at.setPredicate(Predicate.EQUAL_TO);
		
		target.setAttribute(at);
		
		Association assoc = new Association();
		assoc.setRoleName("_entityDescription");
		
		Attribute entityDes = new Attribute();
		entityDes.setName("_content");
		entityDes.setValue("Boxing r%g");
		entityDes.setPredicate(Predicate.LIKE);
		
		assoc.setAttribute(entityDes);	
		target.setAssociation(assoc);
		
		query.setTarget(target);
		Iterator results = handle.query(query);
		
		boolean foundResults = false;
		while (results.hasNext()){
			foundResults = true;
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("285079000"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
		assertTrue(foundResults);
	}	
	
	public void testGetEntityByPresentationAndCodingSchemeNamespace() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();
				
		target.setName("org.LexGrid.concepts.Entity");
	
		Attribute at = new Attribute();
		at.setName("_entityCodeNamespace");
		at.setValue(ServiceTestCase.SNOMED_SCHEME);
		at.setPredicate(Predicate.EQUAL_TO);
	
		target.setAttribute(at);
		
		Association presAssoc = new Association();
		presAssoc.setRoleName("_presentationList");
		
		Association textAssoc = new Association();
		textAssoc.setRoleName("_value");
		
		Attribute content = new Attribute();
		content.setName("_content");	
		content.setValue("Boxing ring");
		content.setPredicate(Predicate.EQUAL_TO);
		
		textAssoc.setAttribute(content);
		presAssoc.setAssociation(textAssoc);
		
		target.setAssociation(presAssoc);
		
		query.setTarget(target);
		Iterator results = handle.query(query);
		
		boolean foundResults = false;
		while (results.hasNext()){
			foundResults = true;
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("285079000"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
		assertTrue(foundResults);
	}	
	
	public void testGetEntityByPresentationAndNameSpaceWildCard() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();
				
		target.setName("org.LexGrid.concepts.Entity");
		
		Attribute at = new Attribute();
		at.setName("_entityCodeNamespace");
		at.setValue("SN%");
		at.setPredicate(Predicate.LIKE);
		
		target.setAttribute(at);
		
		Association presAssoc = new Association();
		presAssoc.setRoleName("_presentationList");
		
		Association textAssoc = new Association();
		textAssoc.setRoleName("_value");
		
		Attribute content = new Attribute();
		content.setName("_content");	
		content.setValue("Boxing ring");
		content.setPredicate(Predicate.EQUAL_TO);
		
		textAssoc.setAttribute(content);
		presAssoc.setAssociation(textAssoc);
		
		target.setAssociation(presAssoc);
		
		query.setTarget(target);
		Iterator results = handle.query(query);
		
		boolean foundResults = false;
		while (results.hasNext()){
			foundResults = true;
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityDescription().getContent().equals("Boxing ring"));
		}
		assertTrue(foundResults);
	}	
	
	
	
	public void testGetEntityByPresentationAndCodingSchemeNamespaceWildCard() throws Exception {
		DataServiceClient svc = LexEVSDataServiceHolder.instance().getStandardService();
		DataServiceHandle handle = new DataServiceHandle(svc);
		
		CQLQuery query = new CQLQuery();	
		Object target = new Object();
				
		target.setName("org.LexGrid.concepts.Entity");
	
		Attribute at = new Attribute();
		at.setName("_entityCodeNamespace");
		at.setValue(ServiceTestCase.SNOMED_SCHEME);
		at.setPredicate(Predicate.EQUAL_TO);
	
		target.setAttribute(at);
		
		Association presAssoc = new Association();
		presAssoc.setRoleName("_presentationList");
		
		Association textAssoc = new Association();
		textAssoc.setRoleName("_value");
		
		Attribute content = new Attribute();
		content.setName("_content");	
		content.setValue("Boxing r%g");
		content.setPredicate(Predicate.LIKE);
		
		textAssoc.setAttribute(content);
		presAssoc.setAssociation(textAssoc);
		
		target.setAssociation(presAssoc);
		
		query.setTarget(target);
		Iterator results = handle.query(query);
		
		boolean foundResults = false;
		while (results.hasNext()){
			foundResults = true;
			Entity concept = (Entity)results.next();
			assertTrue(concept.getEntityCode().equals("285079000"));
			assertTrue(concept.getEntityCodeNamespace().equals(ServiceTestCase.SNOMED_SCHEME));
		}
		assertTrue(foundResults);
	}	
}
