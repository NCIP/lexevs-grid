/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.function.query;

// LexBIG Test ID: T1_FNC_14	TestAttributePresenceMatch

import org.LexGrid.LexBIG.DataModel.Collections.LocalNameList;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.Exceptions.LBParameterException;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet.SearchDesignationOption;
import org.LexGrid.LexBIG.Utility.Constructors;

/**
 * The Class TestAttributePresenceMatch.
 */
public class TestAttributePresenceMatch extends LexBIGServiceTestCase
{
    final static String testID = "testAttributePresenceMatch";

    @Override
    protected String getTestID()
    {
        return testID;
    }

    /**
     * Match attribute.
     * 
     * @param attribute the attribute
     * 
     * @return true, if successful
     * 
     * @throws LBException the LB exception
     */
    public boolean matchAttribute(String attribute) throws LBException
    {
        CodedNodeSet cns = ServiceHolder.instance().getLexBIGService()
                .getCodingSchemeConcepts(THES_SCHEME, Constructors.createCodingSchemeVersionOrTagFromVersion(THES_VERSION));
        cns = cns.restrictToMatchingDesignations("heart", SearchDesignationOption.PREFERRED_ONLY, "contains", null);
        
        LocalNameList lnl = new LocalNameList();
        lnl.addEntry(attribute);

        CodedNodeSet matches = null;
        try
        {
            matches = cns.restrictToProperties(lnl, null);
        }
        catch (LBParameterException e)
        {
            return (false);
        }
        catch (Exception e) {
           // if (e.getCause().getCause().getCause().getClass() == LBParameterException.class) {
           //     return false;
            //}
            e.printStackTrace();
            return (false);
        }

        int count = matches.resolveToList(null, null, null, 100).getResolvedConceptReferenceCount();
        return (count > 0);
    }

    /**
     * Test attribute presence matcha.
     * 
     * @throws LBException the LB exception
     */
    public void testAttributePresenceMatcha() throws LBException
    {
        assertTrue(matchAttribute("DEFINITION"));
    }

    /**
     * Test attribute presence matchb.
     * 
     * @throws LBException the LB exception
     */
    public void testAttributePresenceMatchb() throws LBException
    {
        assertFalse(matchAttribute("defunition"));
    }

}