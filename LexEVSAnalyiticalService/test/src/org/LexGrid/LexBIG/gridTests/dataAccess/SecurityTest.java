package org.LexGrid.LexBIG.gridTests.dataAccess;

import gov.nih.nci.ServiceTestCase;
import gov.nih.nci.evs.security.SecurityToken;
import junit.framework.TestCase;

import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.cagrid.adapters.LexBIGServiceAdapter;
import org.LexGrid.codingSchemes.CodingScheme;

public class SecurityTest extends TestCase {

	public void testConnectToUnsecuredVocab(){
		LexBIGServiceAdapter lbs = null;
		try {
			lbs = new LexBIGServiceAdapter(ServiceTestCase.serviceUrl);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");		
		}

		try {
			lbs.resolveCodingScheme(ServiceTestCase.THES_SCHEME, null);
		} catch (Exception e) {
			e.printStackTrace();
			fail("error resolving NCI Thesaurus");	
		}
	}

	public void testConnectToSecuredVocabWithToken(){
		SecurityToken token = new SecurityToken();
		token.setAccessToken(ServiceTestCase.MEDDRA_TOKEN);

		LexBIGService lbs = null;
		try {
			LexBIGServiceAdapter lbsa = new LexBIGServiceAdapter(ServiceTestCase.serviceUrl);
			lbs = lbsa.setSecurityToken(ServiceTestCase.MEDDRA_SCHEME, token);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail("Error Connecting to Distributed LexBIG");				
		}

		try {
			CodingScheme scheme = lbs.resolveCodingScheme(ServiceTestCase.MEDDRA_SCHEME, null);
			assertTrue(scheme != null);
			assertTrue(scheme.getCodingSchemeName().equals(ServiceTestCase.MEDDRA_SCHEME));
		} catch (Exception e) {
			e.printStackTrace();
			fail("error resoloving MedDRA");	
		}
	}

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
}
