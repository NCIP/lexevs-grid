/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_39	TestRetrieveMostRecentVersionofConcept

import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestRetrieveMostRecentVersionofConcept.
 */
public class TestRetrieveMostRecentVersionofConcept extends LexBIGServiceTestCase
{
    final static String testID = "testRetrieveMostRecentVersionofConcept";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test retrieve most recent versionof concept.
     * 
     * @throws LBException the LB exception
     */
    public void testRetrieveMostRecentVersionofConcept() throws LBException
    {

        // not providing a version number gets you the PRODUCTION (which can be assumed to be the latest
        // good version)

        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService()
                .getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToCodes(Constructors.createConceptReferenceList(new String[]{"C12223"}, THES_SCHEME));

        assertTrue(cns.resolveToList(null, null, null, 0).getResolvedConceptReference().length == 1);

    }
}