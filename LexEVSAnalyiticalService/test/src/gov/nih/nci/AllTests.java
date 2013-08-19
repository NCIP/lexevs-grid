/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package gov.nih.nci;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.LexGrid.LexBIG.gridTests.testUtility.AllTestsLexEVSAnalyticalGridService;

public class AllTests {

	public static Test suite() throws Exception{
		TestSuite suite = new TestSuite("Test for gov.nih.nci");
		//$JUnit-BEGIN$

		suite.addTest(AllTestsLexEVSAnalyticalGridService.suite());
		
		//$JUnit-END$
		return suite;
	}

}
