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

// LexBIG Test ID: T1_FNC_40	TestRetrieveRelationsforConcept

import org.LexGrid.LexBIG.DataModel.Core.Association;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.Utility.Constructors;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.util.PrintUtility;

// TODO: Auto-generated Javadoc
/**
 * The Class TestRetrieveRelationsforConcept.
 */
public class TestRetrieveRelationsforConcept extends LexBIGServiceTestCase
{
    
    /** The Constant testID. */
    final static String testID = "testRetrieveRelationsforConcept";

    /* (non-Javadoc)
     * @see org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase#getTestID()
     */
    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test retrieve relationsfor concept.
     * 
     * @throws LBException the LB exception
     */
    public void testRetrieveRelationsforConcept() throws LBException
    {

        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService()
                .getCodingSchemeConcepts(THES_SCHEME, Constructors.createCodingSchemeVersionOrTagFromVersion(THES_VERSION));
        cns = cns.restrictToCodes(Constructors.createConceptReferenceList(new String[]{"C12223"}, THES_SCHEME));

        CodedNodeGraph cng = ServiceHolder.instance().getLexBIGService().getNodeGraph(THES_SCHEME, Constructors.createCodingSchemeVersionOrTagFromVersion(THES_VERSION), "roles");

        cng = cng.restrictToSourceCodes(cns);
        cng = cng.restrictToAssociations(Constructors.createNameAndValueList("Anatomic_Structure_Is_Physical_Part_Of"),
                                   null);

        ResolvedConceptReference[] rcr = cng.resolveAsList(Constructors.createConceptReference("C12223", THES_SCHEME),
                                                           true, false, 1, 1,
                                                           Constructors.createLocalNameList("Semantic_Type"), null, null, 0)
                .getResolvedConceptReference();
        
        PrintUtility.print(rcr[0].getEntity());
        
        assertTrue(rcr.length >=1);
        assertTrue(rcr[0].getEntity().getProperty()[0].getPropertyName().equals("Semantic_Type"));
        assertEquals(1,rcr[0].getEntity().getProperty().length);

        Association[] a = rcr[0].getSourceOf().getAssociation();
        assertTrue(a.length == 1);
        assertTrue(a[0].getAssociationName().equals("Anatomic_Structure_Is_Physical_Part_Of"));

    }

}