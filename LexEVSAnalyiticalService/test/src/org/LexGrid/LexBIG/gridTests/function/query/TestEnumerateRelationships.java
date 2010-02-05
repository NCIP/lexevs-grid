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

// LexBIG Test ID: T1_FNC_31	TestEnumerateRelationships

import org.LexGrid.LexBIG.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.Utility.ConvenienceMethods;

/**
 * The Class TestEnumerateRelationships.
 */
public class TestEnumerateRelationships extends LexBIGServiceTestCase
{
    final static String testID = "testEnumerateRelationships";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /*
     * Example of listCodeRelationships
     */
    /**
     * Test enumerate relationships.
     * 
     * @throws LBException the LB exception
     */
    public void testEnumerateRelationships() throws LBException
    {
        CodedNodeGraph cng = ServiceHolder.instance().getLexBIGService().getNodeGraph(GO_SCHEME, null, null);

        ConceptReference ref4 = ConvenienceMethods.createConceptReference("GO:0015489", GO_SCHEME);
        
        ConceptReference ref5 = ConvenienceMethods.createConceptReference("GO:0015203", GO_SCHEME);

        ConceptReference[] cr = cng.listCodeRelationships(ref4, ref5, true).getConceptReference();

        assertTrue("1",contains(cr, new String[] {"is_a"}));       
    }

    private boolean contains(ConceptReference[] cr, String[] associations)
    {
        if (cr.length != associations.length)
        {
            return false;
        }
        for (int i = 0; i < cr.length; i++)
        {
            boolean found = false;
            for (int j = 0; j < associations.length; j++)
            {
                if (cr[i].getConceptCode().equals(associations[j]))
                {
                    found = true;
                    break;
                }
            }
            if (!found)
            {
                return false;
            }
        }
        return true;
    }
}