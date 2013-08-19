/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.service.globus.resource;

import org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods;
import org.globus.wsrf.InvalidResourceKeyException;
import org.globus.wsrf.NoSuchResourceException;
import org.globus.wsrf.ResourceException;
import org.globus.wsrf.ResourceKey;


/** 
 * The implementation of this LexBIGServiceConvenienceMethodsResource type.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class LexBIGServiceConvenienceMethodsResource extends LexBIGServiceConvenienceMethodsResourceBase {
	private LexBIGServiceConvenienceMethods lbscm;
	
    public void remove() throws ResourceException {
		this.lbscm = null;
	}
    
    public LexBIGServiceConvenienceMethods getLexBIGServiceConvenienceMethods() throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
	InvalidServiceContextAccess {
    	if(lbscm == null){
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess fault = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess();	
			fault.setFaultString("Cannot Call This Grid Service Directly");
			throw fault;
		}
		return this.lbscm;	
    }
    public void setLexBIGServiceConvenienceMethods(LexBIGServiceConvenienceMethods lbscm){
    	this.lbscm = lbscm;  	
    }
}
