/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_12	TestRelationshipInquiry

import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestRelationshipInquiry.
 */
public class TestRelationshipInquiry extends LexBIGServiceTestCase
{
    final static String testID = "testRelationshipInquiry";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test relationship inquiry.
     * 
     * @throws LBException the LB exception
     */
    public void testRelationshipInquiry() throws LBException
    {

    	CodedNodeGraph cng = ServiceHolder.instance().getLexBIGService().getNodeGraph(THES_SCHEME, null, "roles");

    	 ConceptReference cr1 = new ConceptReference();
         cr1.setCode("C33231");
         cr1.setCodeNamespace("NCI_Thesaurus");
         cr1.setCodingSchemeName(THES_SCHEME);
         
         ConceptReference cr2 = new ConceptReference();
         cr2.setCode("C33090");
         cr2.setCodeNamespace("NCI_Thesaurus");
         cr2.setCodingSchemeName(THES_SCHEME);
         
         assertTrue(cng.areCodesRelated(Constructors.createNameAndValue("Anatomic_Structure_Has_Location", null),
                                        cr1,
                                        cr2, true).booleanValue());
    }
}