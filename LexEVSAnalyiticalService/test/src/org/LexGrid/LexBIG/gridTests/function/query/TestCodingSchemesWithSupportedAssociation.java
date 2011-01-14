/*
 * Copyright: (c) 2004-2006 Mayo Foundation for Medical Education and
 * Research (MFMER).  All rights reserved.  MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 *
 * Except as contained in the copyright notice above, the trade names, 
 * trademarks, service marks, or product names of the copyright holder shall
 * not be used in advertising, promotion or otherwise in connection with
 * this Software without prior written authorization of the copyright holder.
 * 
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * 
 * 		http://www.eclipse.org/legal/epl-v10.html
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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