/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_35	TestRetrieveConceptandAttributesbyPreferredName

import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestRetrieveConceptandAttributesbyPreferredName.
 */
public class TestRetrieveConceptandAttributesbyPreferredName extends LexBIGServiceTestCase
{
    final static String testID = "testRetrieveConceptandAttributesbyPreferredName";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test retrieve conceptand attributesby preferred name.
     * 
     * @throws LBException the LB exception
     */
    public void testRetrieveConceptandAttributesbyPreferredName() throws LBException
    {

        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService()
                .getCodingSchemeConcepts(THES_SCHEME, null);
        cns = cns.restrictToMatchingDesignations("Vallecula", SearchDesignationOption.PREFERRED_ONLY, "exactMatch", null);

        ResolvedConceptReference[] rcr = cns.resolveToList(null, Constructors.createLocalNameList("Semantic_Type"), null, 0)
                .getResolvedConceptReference();

        assertTrue(rcr.length == 1);
        assertTrue(rcr[0].getConceptCode().equals("C12237"));
        assertTrue(rcr[0].getReferencedEntry().getPropertyCount() == 1);
        assertTrue(rcr[0].getReferencedEntry().getProperty()[0].getPropertyName().equals("Semantic_Type"));

    }

}