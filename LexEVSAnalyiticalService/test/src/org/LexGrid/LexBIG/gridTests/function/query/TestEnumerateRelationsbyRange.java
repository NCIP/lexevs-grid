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

// LexBIG Test ID: T1_FNC_09	TestEnumerateRelationsbyRange

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
 * The Class TestEnumerateRelationsbyRange.
 */
public class TestEnumerateRelationsbyRange extends LexBIGServiceTestCase
{
    final static String testID = "testEnumerateRelationsbyRange";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test enumerate relationsby range.
     * 
     * @throws LBException the LB exception
     */
    public void testEnumerateRelationsbyRange() throws LBException
    {
        String rangeCode = "C60138";
        // check if the supplied range is valid

        ConvenienceMethods cm = new ConvenienceMethods(ServiceHolder.instance().getLexBIGService());


        CodedNodeGraph cng = ServiceHolder.instance().getLexBIGService().getNodeGraph(THES_SCHEME, Constructors.createCodingSchemeVersionOrTagFromVersion(THES_VERSION), null);
        cng = cng.restrictToTargetCodes(cm.createCodedNodeSet(new String[]{rangeCode}, THES_LOCAL, null));
          
        assertTrue(cng.isCodeInGraph(Constructors.createConceptReference(rangeCode, THES_SCHEME)).booleanValue());

        // now we have validated that the value supplied is a range. The answer to the test is the graph
        // that is focused on that code (rangeCode)

        // I'll go down two levels for the heck of it.
        cng = ServiceHolder.instance().getLexBIGService().getNodeGraph(THES_SCHEME, Constructors.createCodingSchemeVersionOrTagFromVersion(THES_VERSION), "roles");

        ResolvedConceptReference[] rcr = cng.resolveAsList(Constructors.createConceptReference(rangeCode, THES_SCHEME),
                                                           false, true, -1, 2, null, null, null, 0)
                .getResolvedConceptReference();

        // focus
        assertTrue(rcr.length == 1);
        assertTrue(rcr[0].getConceptCode().equals(rangeCode));

        Association[] a = rcr[0].getTargetOf().getAssociation();

        // one level deep
        assertTrue(a.length == 1);
        assertTrue(a[0].getAssociationName().equals("subClassOf"));

        AssociatedConcept[] ac = a[0].getAssociatedConcepts().getAssociatedConcept();
        assertTrue(contains(ac, "C59722"));
    }

    private boolean contains(Association[] a, String association, String conceptCode)
    {
        boolean found = false;
        for (int i = 0; i < a.length; i++)
        {
        	String name = a[i].getAssociationName();
            if (name.equals(association))
            {
            	if(contains(a[i].getAssociatedConcepts().getAssociatedConcept(), conceptCode))
            	{
                    found = true;
                    break;
            	}
                        
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