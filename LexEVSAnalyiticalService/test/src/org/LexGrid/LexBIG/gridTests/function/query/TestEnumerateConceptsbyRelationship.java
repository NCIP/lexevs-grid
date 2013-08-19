/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_05	TestEnumerateConceptsbyRelationship

import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestEnumerateConceptsbyRelationship.
 */
public class TestEnumerateConceptsbyRelationship extends LexBIGServiceTestCase
{
    final static String testID = "testEnumerateConceptsbyRelationship";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test enumerate conceptsby relationship.
     * 
     * @throws LBException the LB exception
     */
    public void testEnumerateConceptsbyRelationship() throws LBException
    {

    	CodedNodeGraph cng = ServiceHolder.instance().getLexBIGService().getNodeGraph(THES_SCHEME, Constructors.createCodingSchemeVersionOrTagFromVersion(THES_VERSION), null);
    	cng = cng.restrictToAssociations(Constructors.createNameAndValueList("Concept_In_Subset"), null);
        
        CodedNodeSet cns = cng.toNodeList(Constructors.createConceptReference("C12366", THES_SCHEME),
                true, false, 1, -1);
        ResolvedConceptReferenceList rcrl= cns.resolveToList(null, null, null, -1);
        ResolvedConceptReference[] rcr = rcrl.getResolvedConceptReference();

        assertTrue("Length : " + rcr.length, rcr.length == 5);
    }
}