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

// LexBIG Test ID: T1_FNC_11	TestTraverseGraphviaRoleLinks

import org.LexGrid.LexBIG.DataModel.Core.AssociatedConcept;
import org.LexGrid.LexBIG.DataModel.Core.Association;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.Utility.Constructors;
import org.LexGrid.LexBIG.Utility.ConvenienceMethods;

/**
 * The Class TestTraverseGraphviaRoleLinks.
 */
public class TestTraverseGraphviaRoleLinks extends LexBIGServiceTestCase
{
    final static String testID = "testTraverseGraphviaRoleLinks";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test traverse graphvia role links.
     * 
     * @throws LBException the LB exception
     */
    public void testTraverseGraphviaRoleLinks() throws LBException
    {
        // in LexBig, a role is just an association, so this is traversing associations.

        CodedNodeGraph cng = ServiceHolder.instance().getLexBIGService().getNodeGraph(THES_SCHEME, null, null);
        cng = cng.restrictToAssociations(Constructors.createNameAndValueList(new String[]{"subClassOf"}), null);

        // role "Anatomy_Kind"
        ResolvedConceptReference[] rcr = cng.resolveAsList(Constructors.createConceptReference("C6739", THES_SCHEME),
                                                           false, true, 1, 1, null, null, null, 0)
                .getResolvedConceptReference();
        
        Association[] a = rcr[0].getTargetOf().getAssociation();
        assertTrue(contains(a, "subClassOf", "C45747"));
        assertTrue(contains(a, "subClassOf", "C49179"));
    }

    private boolean contains(Association[] a, String association, String conceptCode)
    {
        boolean found = false;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i].getAssociationName().equals(association)
                    && contains(a[i].getAssociatedConcepts().getAssociatedConcept(), conceptCode))
            {
                found = true;
                break;
            }
        }

        return found;
    }

    private boolean contains(AssociatedConcept[] ac, String conceptCode)
    {
        boolean found = false;
        for (int i = 0; i < ac.length; i++)
        {
            if (ac[i].getConceptCode().equals(conceptCode))
            {
                found = true;
                break;
            }

        }

        return found;
    }

}