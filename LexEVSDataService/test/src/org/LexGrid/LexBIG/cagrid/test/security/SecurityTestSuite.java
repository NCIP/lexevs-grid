package org.LexGrid.LexBIG.cagrid.test.security;

import junit.framework.Test;
import junit.framework.TestSuite;

public class SecurityTestSuite {
	
	    public static Test suite() throws Exception
	    {
	        TestSuite mainSuite = new TestSuite("LexEVS Grid Data Service Security Tests");
	  
	        mainSuite.addTestSuite(LexEVSDataServiceSecurityTest.class);
	        return mainSuite;
	    }
}
