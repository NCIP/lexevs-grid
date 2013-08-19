/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_26	TestDescribeSearchTechniques

import org.LexGrid.LexBIG.DataModel.InterfaceElements.ModuleDescription;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;

/**
 * The Class TestDescribeSearchTechniques.
 */
public class TestDescribeSearchTechniques extends LexBIGServiceTestCase
{
    final static String testID = "testDescribeSearchTechniques";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test describe search techniques.
     */
    public void testDescribeSearchTechniques()
    {

        ModuleDescription[] ed = ServiceHolder.instance().getLexBIGService().getMatchAlgorithms()
                .getModuleDescription();

        assertTrue(ed.length > 0);
        assertTrue(ed[0].getName().length() > 0);
        assertTrue(ed[0].getDescription().length() > 0);

    }
}