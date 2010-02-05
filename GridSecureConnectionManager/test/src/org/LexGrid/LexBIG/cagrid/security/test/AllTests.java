package org.LexGrid.LexBIG.cagrid.security.test;

import org.LexGrid.LexBIG.cagrid.security.connection.impl.SecureConnectionManagerTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() throws Exception{
		TestSuite suite = new TestSuite("Test for caGrid Connection Security");
		//$JUnit-BEGIN$

		suite.addTestSuite(SecureConnectionManagerTest.class);
		
		//$JUnit-END$
		return suite;
	}

}
