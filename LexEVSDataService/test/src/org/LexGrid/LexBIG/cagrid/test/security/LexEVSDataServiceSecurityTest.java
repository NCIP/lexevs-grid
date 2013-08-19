/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.test.security;

import gov.nih.nci.cagrid.cqlquery.Attribute;
import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlquery.Object;
import gov.nih.nci.cagrid.cqlquery.Predicate;
import gov.nih.nci.cagrid.data.client.DataServiceClient;
import gov.nih.nci.cagrid.data.utilities.DataServiceHandle;
import gov.nih.nci.cagrid.data.utilities.DataServiceIterator;
import gov.nih.nci.evs.security.SecurityToken;

import java.util.Iterator;

import org.LexGrid.LexBIG.cagrid.dataService.client.LexEVSDataServiceClient;
import org.LexGrid.LexBIG.cagrid.dataService.utils.LexEVSDataServiceHandle;
import org.LexGrid.LexBIG.cagrid.test.setup.ServiceTestCase;
import org.LexGrid.codingSchemes.CodingScheme;

public class LexEVSDataServiceSecurityTest extends ServiceTestCase {
	String testId = "LexEVSDataServiceSecurityTest";
	
	private SecurityToken goodMedraToken;
	private SecurityToken badMedraToken;
	

	@Override
	protected String getTestID() {
		// TODO Auto-generated method stub
		return testId;
	}
	
	public void setUp(){
		goodMedraToken = new SecurityToken();
		goodMedraToken.setAccessToken(ServiceTestCase.MEDDRA_TOKEN);
		
		badMedraToken = new SecurityToken();
		badMedraToken.setAccessToken("BADTOKEN");
	}
	
	public void testConnectToUnsecuredVocabWithGenericClient(){
		DataServiceHandle handle = null;
		try {
			DataServiceClient client = new DataServiceClient(ServiceTestCase.serviceUrl);
			handle = new DataServiceHandle(client);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");		
		}

		try {
			assertTrue(tryToConnectToUnsecuredVocab(handle));
		} catch (Exception e) {
			e.printStackTrace();
			fail("error resolving Coding Scheme");	
		}
	}
	
	public void testConnectToUnsecuredVocabWithLexEVSClient(){
		LexEVSDataServiceHandle handle = null;
		try {
			LexEVSDataServiceClient client = new LexEVSDataServiceClient(ServiceTestCase.serviceUrl);
			handle = new LexEVSDataServiceHandle(client);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");		
		}
		try {
			assertTrue(tryToConnectToUnsecuredVocab(handle));		
		} catch (Exception e) {
			e.printStackTrace();
			fail("error resolving Coding Scheme");	
		}
	}

	public void testConnectToSecuredVocabWithToken(){
		LexEVSDataServiceHandle handle = null;
		try {
			LexEVSDataServiceClient client = new LexEVSDataServiceClient(ServiceTestCase.serviceUrl);
			client = client.registerSecurityToken(ServiceTestCase.MEDDRA_URN, goodMedraToken);
			handle = new LexEVSDataServiceHandle(client);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");		
		}
		try {
			assertTrue(tryToConnectToSecuredVocab(handle));		
		} catch (Exception e) {
			e.printStackTrace();
			fail("error resolving Coding Scheme");	
		}
	}
	
	public void testConnectToSecuredVocabWithoutToken(){
		LexEVSDataServiceHandle handle = null;
		try {
			LexEVSDataServiceClient client = new LexEVSDataServiceClient(ServiceTestCase.serviceUrl);
			client = client.registerSecurityToken(ServiceTestCase.MEDDRA_URN, badMedraToken);
			handle = new LexEVSDataServiceHandle(client);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");		
		}
		try {
			assertFalse(tryToConnectToSecuredVocab(handle));	
		    //If it resolves without the token, fail
			fail("Resolved a Secure Vocab without a Token");
		} catch (Exception e) {
			//This is good - throw a Security Exception	
		}
	}
	
	public void testConnectWithMultipleClients(){
		LexEVSDataServiceHandle nonSecureHandle = null;
		LexEVSDataServiceHandle secureHandle = null;
		try {
			LexEVSDataServiceClient clientNonSecure = new LexEVSDataServiceClient(ServiceTestCase.serviceUrl);
			nonSecureHandle = new LexEVSDataServiceHandle(clientNonSecure);
			
			LexEVSDataServiceClient clientSecure = new LexEVSDataServiceClient(ServiceTestCase.serviceUrl);
			clientSecure = clientSecure.registerSecurityToken(ServiceTestCase.MEDDRA_URN, goodMedraToken);
			secureHandle = new LexEVSDataServiceHandle(clientSecure);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");		
		}
		try {
			assertTrue(tryToConnectToUnsecuredVocab(nonSecureHandle));			
		} catch (Exception e) {
			fail("Resolved a Secure Vocab without a Token");
		}
		try {
			assertFalse(tryToConnectToSecuredVocab(nonSecureHandle));		   
		} catch (Exception e) {
			//This is good - throw a Security Exception	
		}
		
		try {
			assertTrue(tryToConnectToUnsecuredVocab(secureHandle));			
		} catch (Exception e) {
			fail("Error Resolving Vocab");
		}
		
		try {
			assertTrue(tryToConnectToSecuredVocab(secureHandle));			
		} catch (Exception e) {
			fail("Error Resolving Vocab");
		}
	}

	/*
	public void testConnectToSecuredVocabWithoutToken(){
		LexBIGServiceAdapter lbs = null;
		try {
			lbs = new LexBIGServiceAdapter(ServiceTestCase.serviceUrl);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");				
		}

		try {
			CodingScheme scheme = lbs.resolveCodingScheme(ServiceTestCase.MEDDRA_SCHEME, null);
			fail("Secure coding cheme was resolved without a token");
		} catch (Exception e) {
			//This is a good thing -- it should  throw an exception when trying
			//to access a secure coding scheme without a token
		}
	}

	public void testMultipleSessions(){
		//Set up two sessions
		LexBIGService lbs = null;
		LexBIGService lbs2 = null;
		try {
			lbs = new LexBIGServiceAdapter(ServiceTestCase.serviceUrl);
			lbs2 = new LexBIGServiceAdapter(ServiceTestCase.serviceUrl);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");	
		}

		//try the first one (unsecured)
		try {
			CodingScheme scheme = lbs.resolveCodingScheme(ServiceTestCase.MEDDRA_SCHEME, null);
			fail("Secure coding cheme was resolved without a token");
		} catch (Exception e) {
			//This is a good thing -- it should  throw an exception when trying
			//to access a secure coding scheme without a token
		}

		//try the second one (unsecured)
		try {
			CodingScheme scheme = lbs2.resolveCodingScheme(ServiceTestCase.MEDDRA_SCHEME, null);
			fail("Secure coding cheme was resolved without a token");
		} catch (Exception e) {
			//This is a good thing -- it should  throw an exception when trying
			//to access a secure coding scheme without a token
		}

		//try the first one again (secured with token)
		SecurityToken token = new SecurityToken();
		token.setAccessToken(ServiceTestCase.MEDDRA_TOKEN);
		try {
			LexBIGServiceAdapter lbsa = (LexBIGServiceAdapter)lbs;
			lbs = lbsa.setSecurityToken(ServiceTestCase.MEDDRA_SCHEME, token);
			CodingScheme scheme = lbs.resolveCodingScheme(ServiceTestCase.MEDDRA_SCHEME, null);
			assertTrue(scheme != null);
			assertTrue(scheme.getCodingSchemeName().equals(ServiceTestCase.MEDDRA_SCHEME));
		} catch (Exception e) {
			e.printStackTrace();
			fail("error resoloving MedDRA");	
		}

		//try the second one (secured WITHOUT token)
		try {
			CodingScheme scheme = lbs2.resolveCodingScheme(ServiceTestCase.MEDDRA_SCHEME, null);
			fail("Secure coding cheme was resolved without a token");
		} catch (Exception e) {
			//This is a good thing -- it should  throw an exception when trying
			//to access a secure coding scheme without a token
		}	
	}

	public void testConnectTwoSecuredVocabs(){
		LexBIGServiceGrid lbs = null;
		try {
			lbs = new LexBIGServiceGridAdapter(ServiceTestCase.serviceUrl);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");				
		}

		CodingSchemeIdentification csMeta = new CodingSchemeIdentification();
		csMeta.setName(ServiceTestCase.META_SCHEME);
		
		CodingSchemeIdentification csMedra = new CodingSchemeIdentification();
		csMedra.setName(ServiceTestCase.MEDDRA_SCHEME);

		SecurityToken metaToken = new SecurityToken();
		metaToken.setAccessToken(ServiceTestCase.META_TOKEN);
		
		SecurityToken medraToken = new SecurityToken();
		medraToken.setAccessToken(ServiceTestCase.MEDDRA_TOKEN);

		try {
			lbs = lbs.setSecurityToken(csMeta, metaToken);
			lbs = lbs.setSecurityToken(csMedra, medraToken);
		} catch (LBException e) {
			e.printStackTrace();
			fail("error resolving NCI MetaThesaurus");	
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("error resolving NCI MetaThesaurus");	
		}

		try{
			CodingScheme codingScheme = lbs.resolveCodingScheme(csMeta, null);
			assertTrue(codingScheme != null);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("error resolving NCI MetaThesaurus");	
		}

		try{
			CodingScheme codingScheme = lbs.resolveCodingScheme(csMedra, null);
			assertTrue(codingScheme != null);
		}
		catch(Exception e){
			e.printStackTrace();
			fail("error resolving MedDRA");	
			e.printStackTrace();
		}
	}
	
	*/
	
	
	 private boolean tryToConnectToUnsecuredVocab(DataServiceIterator handle) throws Exception {
		 CQLQuery query = new CQLQuery();	
		 Object target = new Object();

		 target.setName("org.LexGrid.codingSchemes.CodingScheme");
		 Attribute at1 = new Attribute();
		 at1.setName("_codingSchemeName");
		 at1.setValue(ServiceTestCase.SNOMED_SCHEME);
		 at1.setPredicate(Predicate.EQUAL_TO);
		 
		 target.setAttribute(at1);
		 query.setTarget(target);
		 
		Iterator itr = handle.query(query);
		
		while(itr.hasNext()){
			CodingScheme cs = (CodingScheme)itr.next();
			if(cs.getCodingSchemeName().equals(ServiceTestCase.SNOMED_SCHEME)){
				return true;
			}
		}
		
		//if it doesn't find it, return false
		return false;
	 }

	 private boolean tryToConnectToSecuredVocab(DataServiceIterator handle) throws Exception {
		 CQLQuery query = new CQLQuery();	
		 Object target = new Object();

		 target.setName("org.LexGrid.codingSchemes.CodingScheme");
		 Attribute at1 = new Attribute();
		 at1.setName("_codingSchemeName");
		 at1.setValue(ServiceTestCase.MEDDRA_SCHEME);
		 at1.setPredicate(Predicate.EQUAL_TO);
		 
		 target.setAttribute(at1);
		 query.setTarget(target);
		 
		 Iterator itr = handle.query(query);
			
			while(itr.hasNext()){
				CodingScheme cs = (CodingScheme)itr.next();
				if(cs.getCodingSchemeName().equals(ServiceTestCase.MEDDRA_SCHEME)){
					return true;
				}
			}
			
			//if it doesn't find it, return false
			return false;

	 }
}

