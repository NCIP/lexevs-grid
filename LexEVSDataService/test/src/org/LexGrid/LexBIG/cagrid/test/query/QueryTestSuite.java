/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
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
