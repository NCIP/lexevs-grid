/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_03	TestVersionChanges

import java.net.URI;
import java.net.URISyntaxException;

import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.DataModel.NCIHistory.NCIChangeEvent;
import org.LexGrid.LexBIG.DataModel.NCIHistory.types.ChangeType;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.History.HistoryService;
import org.LexGrid.LexBIG.Utility.Constructors;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;

/**
 * The Class TestVersionChanges.
 */
public class TestVersionChanges extends LexBIGServiceTestCase
{
    final static String testID = "testVersionChanges";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test version changes.
     * 
     * @throws URISyntaxException the URI syntax exception
     * @throws LBException the LB exception
     */
    public void testVersionChanges() throws URISyntaxException, LBException
    {

        HistoryService hs = ServiceHolder.instance().getLexBIGService()
                .getHistoryService(LexBIGServiceTestCase.THES_URN);

        ConceptReference cr = Constructors.createConceptReference("C1884", LexBIGServiceTestCase.THES_URN);
        
        NCIChangeEvent[] nce = hs.getEditActionList(cr, new URI("http://ncicb.nci.nih.gov/xml/owl/EVS/Thesaurus.owl#:03.12a"))
                .getEntry();
        
        assertTrue(nce.length == 1);
        assertTrue(nce[0].getConceptcode().equals("C1884"));
        assertTrue(nce[0].getConceptName().equals(" "));
        assertTrue(nce[0].getReferencecode() == null || nce[0].getReferencecode().equals("null"));
        assertTrue(nce[0].getEditaction().equals(ChangeType.MODIFY));
    }
}