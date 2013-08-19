/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

import org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeRenderingList;
import org.LexGrid.LexBIG.DataModel.InterfaceElements.CodingSchemeRendering;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.Utility.ConvenienceMethods;

//LexBIG Test ID: TEST_FNQRY_CSRNDR_FOR_SUPPASSOC TestCodingSchemesWithSupportedAssociation

/**
 * The Class TestCodingSchemesWithSupportedAssociation.
 */
public class TestCodingSchemesWithSupportedAssociation extends LexBIGServiceTestCase
{
    final static String testID = "testCodingSchemesWithSupportedAssociation";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test coding schemes with supported association.
     * 
     * @throws LBException the LB exception
     */
    public void testCodingSchemesWithSupportedAssociation()
    {
        try {
			ConvenienceMethods cm = new ConvenienceMethods(ServiceHolder.instance().getLexBIGService());
			CodingSchemeRenderingList csrl = cm.getCodingSchemesWithSupportedAssociation("Concept_In_Subset");
			CodingSchemeRendering csr[] = csrl.getCodingSchemeRendering();
			boolean found = false;
			
			for (int i=0; i < csr.length; i++)
			{
				if (csr[i].getCodingSchemeSummary().getLocalName().equals(THES_SCHEME))
					found = true;
			}
			assertTrue(found);
		} catch (LBException e) {
			fail("GForge #15437: Exception Thrown");
		}
    }
}