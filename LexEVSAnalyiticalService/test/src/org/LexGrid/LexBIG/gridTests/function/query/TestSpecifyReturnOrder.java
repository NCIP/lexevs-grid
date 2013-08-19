/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_22	TestSpecifyReturnOrder

import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestSpecifyReturnOrder.
 */
public class TestSpecifyReturnOrder extends LexBIGServiceTestCase
{
    final static String testID = "testSpecifyReturnOrder";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test specify return order.
     * 
     * @throws LBException the LB exception
     */
    public void testSpecifyReturnOrder() throws LBException
    {
    	CodedNodeSet cns = ServiceHolder.instance().getLexBIGService().getCodingSchemeConcepts(THES_SCHEME, null);
    	cns = cns.restrictToMatchingDesignations("Pect", SearchDesignationOption.ALL, "startsWith", null);
    	ResolvedConceptReference[] rcr = cns.resolveToList(Constructors.createSortOptionList(new String[] {"code"}, new Boolean[] {null}), null, null, -1)
    	.getResolvedConceptReference();

    	assertTrue("2",rcr[0].getConceptCode().equals("C21031"));
    	assertTrue("3",rcr[1].getConceptCode().equals("C25611"));
    	assertTrue("4",rcr[2].getConceptCode().equals("C33284"));

    	rcr = cns.resolveToList(Constructors.createSortOptionList(new String[] {"entityDescription"}, new Boolean[] {null}), null, null, -1)
    	.getResolvedConceptReference();
    	assertTrue("5",rcr[0].getConceptCode().equals("C34107"));
    	assertTrue("6",rcr[1].getConceptCode().equals("C82601"));
    	assertTrue("7",rcr[2].getConceptCode().equals("C63647"));

    	//reverse sort 1.
    	rcr = cns.resolveToList(Constructors.createSortOptionList(new String[]{"code"}, new Boolean[]{new Boolean(false)}), null, null, -1)
    	.getResolvedConceptReference();

    	assertTrue("9",rcr[0].getConceptCode().equals("C84042"));
    	assertTrue("10",rcr[1].getConceptCode().equals("C82601"));
    	assertTrue("11",rcr[2].getConceptCode().equals("C63647"));
    }
}