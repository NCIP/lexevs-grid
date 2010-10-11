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

// LexBIG Test ID: T1_FNC_23	TestforCurrentOrObsoleteConcept

import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.ActiveOption;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestforCurrentOrObsoleteConcept.
 */
public class TestforCurrentOrObsoleteConcept extends LexBIGServiceTestCase
{
    final static String testID = "testforCurrentOrObsoleteConcept";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Testfor current or obsolete concepta.
     * 
     * @throws LBException the LB exception
     */
    

    /**
     * Testfor current or obsolete conceptb.
     * 
     * @throws LBException the LB exception
     */
    public void testforCurrentOrObsoleteConceptb() throws LBException
    {

        //same as above, but this time, using the new methods (that aren't deprecated)
        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToStatus(ActiveOption.ACTIVE_ONLY, null);
        cns = cns.restrictToCodes(Constructors.createConceptReferenceList(new String[]{"C38389"}, THES_SCHEME));
        ResolvedConceptReference[] rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();

        assertTrue("1",rcr.length == 0);

        cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToStatus(ActiveOption.ALL, null);
        cns = cns.restrictToCodes(Constructors.createConceptReferenceList(new String[]{"C38389"}, THES_SCHEME));
        rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();

        assertTrue("2",rcr.length == 1);
        
        //same test again - no status restriction 
        cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToCodes(Constructors.createConceptReferenceList(new String[]{"C38389"}, THES_SCHEME));
        rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();

        assertTrue("3",rcr.length == 1);

        //add a status restriction
        cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToMatchingDesignations("Sex Not Known", SearchDesignationOption.ALL, "exactMatch", null);
        cns = cns.restrictToStatus(ActiveOption.INACTIVE_ONLY, null);
        rcr = cns.resolveToList(null, null, null, 0).getResolvedConceptReference();
        assertTrue("4",rcr.length == 1);

        assertFalse("6",rcr[0].getReferencedEntry().getIsActive().booleanValue());
    }
}