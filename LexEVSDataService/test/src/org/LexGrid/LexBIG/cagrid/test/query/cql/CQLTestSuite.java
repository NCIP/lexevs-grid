package org.LexGrid.LexBIG.cagrid.test.query.cql;

import junit.framework.Test;
import junit.framework.TestSuite;

public class CQLTestSuite {
	
	    public static Test suite() throws Exception
	    {
	        TestSuite mainSuite = new TestSuite("LexEVS Grid Data Service Tests");
	  
	        mainSuite.addTestSuite(CQLCodingScheme.class);
	        mainSuite.addTestSuite(CQLConcept.class);
	        mainSuite.addTestSuite(CQLGroups.class);
	        mainSuite.addTestSuite(CQLPredicates.class);
	        mainSuite.addTestSuite(CQLQueryModifiers.class);
	        return mainSuite;
	    }
}
