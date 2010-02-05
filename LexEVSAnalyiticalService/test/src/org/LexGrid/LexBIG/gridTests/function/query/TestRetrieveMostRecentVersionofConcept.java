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