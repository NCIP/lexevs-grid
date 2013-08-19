/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
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
