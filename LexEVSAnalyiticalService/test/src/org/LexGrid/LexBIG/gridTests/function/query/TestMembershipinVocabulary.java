/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_24	TestMembershipinVocabulary

import org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestMembershipinVocabulary.
 */
public class TestMembershipinVocabulary extends LexBIGServiceTestCase
{
    final static String testID = "testMembershipinVocabulary";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test membershipin vocabulary.
     * 
     * @throws LBException the LB exception
     */
    public void testMembershipinVocabulary() throws LBException
    {
    	CodedNodeSet cns = ServiceHolder.instance().getLexBIGService()
    	.getCodingSchemeConcepts(THES_SCHEME, null);

    	ConceptReference cr = new ConceptReference();
    	cr.setCodingSchemeName(THES_SCHEME);
    	cr.setConceptCode("C12366");

    	ConceptReferenceList crl = new ConceptReferenceList();
    	crl.addConceptReference(cr);

    	cns = cns.restrictToCodes(crl);

    	assertTrue(cns.isCodeInSet(Constructors.createConceptReference("C12366", THES_SCHEME)).booleanValue());
    	assertFalse(cns.isCodeInSet(Constructors.createConceptReference("fred", THES_SCHEME)).booleanValue());
    }
}