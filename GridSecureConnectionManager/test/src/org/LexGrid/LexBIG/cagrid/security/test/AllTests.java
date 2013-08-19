/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
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
