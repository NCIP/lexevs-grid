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

// LexBIG Test ID: T1_FNC_07	TestDAGWalking

import org.LexGrid.LexBIG.DataModel.Core.AssociatedConcept;
import org.LexGrid.LexBIG.DataModel.Core.Association;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestDAGWalking.
 */
public class TestDAGWalking extends LexBIGServiceTestCase
{
    final static String testID = "testDAGWalking";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test dag walking.
     * 
     * @throws LBException the LB exception
     */
    public void testDAGWalking() throws LBException
    {
    	CodedNodeGraph cng = ServiceHolder.instance().getLexBIGService().getNodeGraph(THES_SCHEME, Constructors.createCodingSchemeVersionOrTagFromVersion(THES_VERSION), null);
    	cng = cng.restrictToAssociations(Constructors.createNameAndValueList(new String[]{"subClassOf"}), null);

    	ResolvedConceptReference[] rcr = cng.resolveAsList(Constructors.createConceptReference("C12366", THES_SCHEME),
    			true, true, 1, 1, null, null, null, 500)
    			.getResolvedConceptReference();

    	// check for some source (down) codes that I know should be there.
    	assertTrue(rcr.length == 1);
    	assertTrue(rcr[0].getConceptCode().equals("C12366"));

    	Association[] a = rcr[0].getSourceOf().getAssociation();

    	assertTrue(contains(a, "subClassOf", "C34076"));

    	// check for some target (up) codes that I know should be there
    	a = rcr[0].getTargetOf().getAssociation();

    	assertTrue(contains(a, "subClassOf", "C33287"));
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