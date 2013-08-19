/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
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
