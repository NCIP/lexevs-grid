/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.testUtility;

import gov.nih.nci.ServiceTestCase;
import gov.nih.nci.evs.security.SecurityToken;

import java.io.File;
import java.util.Properties;

import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.cagrid.Iso21090Utils;
import org.LexGrid.LexBIG.cagrid.adapters.LexBIGServiceGridAdapter;
import org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceGrid;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification;

/**
 * Singleton class for getting a LexBIGService for the JUnit test cases.
 * 
 * @author <A HREF="mailto:armbrust.daniel@mayo.edu">Dan Armbrust</A>
 * @version subversion $Revision: 1.7 $ checked in on $Date: 2007/12/15 00:07:44 $
 */
public class ServiceHolder 
{
    private static final String serviceUrl = LexBIGServiceTestCase.serviceUrl;
    
    private static Properties[]                configs_;
    private static int                         currentConfig_ = 0;
//    private static ArrayList<TestServerConfig> serverConfigs;
    private static ServiceHolder               sh_;
    private File                               testConfigFolder_;
    private boolean                            singleConfigMode_ = true;

    private LexBIGService                      lbsi_;

    /**
     * Use this to get an instance of the ServiceHolder. If 'configureForSingleConfig' has not been called,
     * this will run the tests on all configured databases in the testConfig.props file.
     * 
     * @return the service holder
     */
    public static ServiceHolder instance()
    {
        if (sh_ == null)
        {
            //throw new RuntimeException("ServiceHolder has not been configured");
            sh_ = new ServiceHolder();
        }
        return sh_;

    }

    private ServiceHolder()
    {
    	try{
    		
    		LexBIGServiceGrid lbs = null;
    		try {
    			lbs = new LexBIGServiceGridAdapter(ServiceTestCase.serviceUrl);
    		} catch (Exception e1) {
    			e1.printStackTrace();				
    		}

    		CodingSchemeIdentification csMeta = new CodingSchemeIdentification();
    		csMeta.setName(Iso21090Utils.createSt(ServiceTestCase.META_SCHEME));
    		
    		CodingSchemeIdentification csMedra = new CodingSchemeIdentification();
    		csMedra.setName(Iso21090Utils.createSt(ServiceTestCase.MEDDRA_SCHEME));
    		
    		CodingSchemeIdentification csMedraURN = new CodingSchemeIdentification();
    		csMedraURN.setName(Iso21090Utils.createSt(ServiceTestCase.MEDDRA_URN));

    		SecurityToken metaToken = new SecurityToken();
    		metaToken.setAccessToken(ServiceTestCase.META_TOKEN);
    		
    		SecurityToken medraToken = new SecurityToken();
    		medraToken.setAccessToken(ServiceTestCase.MEDDRA_TOKEN);
    		
    		lbs = lbs.setSecurityToken(csMeta, metaToken);
			lbs = lbs.setSecurityToken(csMedra, medraToken);
			lbs = lbs.setSecurityToken(csMedraURN, medraToken);

    		LexBIGServiceGridAdapter lbsg = (LexBIGServiceGridAdapter)lbs;      
    		lbsi_ = lbsg.getLexBIGServiceInterface();
    	}
    	catch (Exception e)
    	{
    		System.err.println("Problem reading Test config file");
    		e.printStackTrace();
    		System.exit(-1);
    	}
    }

    /**
     * Gets the lex big service.
     * 
     * @return the lex big service
     */
    public LexBIGService getLexBIGService()
    {
        return lbsi_;
    }

    /**
     * Gets the single config mode.
     * 
     * @return the single config mode
     */
    public boolean getSingleConfigMode()
    {
        return singleConfigMode_;
    }
    
    /**
     * Gets the uRL.
     * 
     * @return the uRL
     */
    public static String getURL()
    {
    	return serviceUrl;
    }
}