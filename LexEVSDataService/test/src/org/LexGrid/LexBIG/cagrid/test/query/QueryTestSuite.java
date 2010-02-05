package org.LexGrid.LexBIG.cagrid.test.query;

import org.LexGrid.LexBIG.cagrid.test.query.cql.CQLCodingScheme;
import org.LexGrid.LexBIG.cagrid.test.query.cql.CQLTestSuite;

import junit.framework.Test;
import junit.framework.TestSuite;

public class QueryTestSuite {
    
    /**
     * Suite.
     * 
     * @return the test
     * 
     * @throws Exception the exception
     */
    public static Test suite() throws Exception
    {
        TestSuite mainSuite = new TestSuite("LexEVS caCORE Query Tests");
        mainSuite.addTest(CQLTestSuite.suite());
        return mainSuite;
    }
}
