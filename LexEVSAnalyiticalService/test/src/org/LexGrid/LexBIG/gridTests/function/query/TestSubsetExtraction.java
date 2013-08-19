/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_02	TestSubsetExtraction

import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestSubsetExtraction.
 */
public class TestSubsetExtraction extends LexBIGServiceTestCase
{
    final static String testID = "testSubsetExtraction";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test subset extraction.
     * 
     * @throws LBException the LB exception
     */
    public void testSubsetExtraction() throws LBException
    {

        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService()
                .getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToCodes(Constructors.createConceptReferenceList(new String[]{"C12237", "C12229", "C12230"},
                                                                    THES_SCHEME));

        // this test is really lacking... but here is how you subset. You can serialize however
        // you want from here...
        assertTrue(cns.resolveToList(null, null, null, 0).getResolvedConceptReference().length == 3);

    }

}