package org.LexGrid.LexBIG.cagrid.test.setup;

import org.LexGrid.LexBIG.cagrid.test.query.QueryTestSuite;
import org.LexGrid.LexBIG.cagrid.test.security.SecurityTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() throws Exception{
		TestSuite suite = new TestSuite("Test LexEVS Data Grid Service");
		//$JUnit-BEGIN$

		suite.addTest(QueryTestSuite.suite());
		suite.addTest(SecurityTestSuite.suite());		
		
		//$JUnit-END$
		return suite;
	}

}
