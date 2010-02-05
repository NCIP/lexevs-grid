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

// LexBIG Test ID: T1_FNC_26	TestDescribeSearchTechniques

import org.LexGrid.LexBIG.DataModel.InterfaceElements.ModuleDescription;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;

/**
 * The Class TestDescribeSearchTechniques.
 */
public class TestDescribeSearchTechniques extends LexBIGServiceTestCase
{
    final static String testID = "testDescribeSearchTechniques";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Test describe search techniques.
     */
    public void testDescribeSearchTechniques()
    {

        ModuleDescription[] ed = ServiceHolder.instance().getLexBIGService().getMatchAlgorithms()
                .getModuleDescription();

        assertTrue(ed.length > 0);
        assertTrue(ed[0].getName().length() > 0);
        assertTrue(ed[0].getDescription().length() > 0);

    }
}