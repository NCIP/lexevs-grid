/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_06	TestEnumerateSourceConceptsforRelationandTarget

import org.LexGrid.LexBIG.DataModel.Core.AssociatedConcept;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.Utility.Constructors;
import org.LexGrid.LexBIG.Utility.ConvenienceMethods;

/**
 * The Class TestEnumerateSourceConceptsforRelationandTarget.
 */
public class TestEnumerateSourceConceptsforRelationandTarget extends LexBIGServiceTestCase
{
    final static String testID = "testEnumerateSourceConceptsforRelationandTarget";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test enumerate source conceptsfor relationand target.
     * 
     * @throws LBException the LB exception
     */
    public void testEnumerateSourceConceptsforRelationandTarget() throws LBException
    {

        CodedNodeGraph cng = ServiceHolder.instance().getLexBIGService().getNodeGraph(THES_SCHEME, null, null);

        cng = cng.restrictToAssociations(Constructors.createNameAndValueList("Anatomic_Structure_Has_Location"), null);

        ConvenienceMethods cm = new ConvenienceMethods(ServiceHolder.instance().getLexBIGService());

        cng = cng.restrictToTargetCodes(cm.createCodedNodeSet(new String[]{"C33090"}, THES_SCHEME, null));

        ResolvedConceptReference[] rcr = cng.resolveAsList(Constructors.createConceptReference("C33090", THES_SCHEME),
                                                           false, true, 1, 1, null, null, null, 0)
                .getResolvedConceptReference();
 
    }

}