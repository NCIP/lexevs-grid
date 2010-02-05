/*******************************************************************************
 * Copyright: (c) 2004-2007 Mayo Foundation for Medical Education and 
 * Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 * 
 * Except as contained in the copyright notice above, or as used to identify 
 * MFMER as the author of this software, the trade names, trademarks, service
 * marks, or product names of the copyright holder shall not be used in
 * advertising, promotion or otherwise in connection with this software without
 * prior written authorization of the copyright holder.
 *   
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *   
 *  		http://www.eclipse.org/legal/epl-v10.html
 * 
 *  		
 *******************************************************************************/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.service.globus.resource;

import org.LexGrid.LexBIG.LexBIGService.LexBIGServiceMetadata;
import org.globus.wsrf.ResourceException;

/** 
 * The implementation of this LexBIGServiceMetadataResource type.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class LexBIGServiceMetadataResource extends LexBIGServiceMetadataResourceBase {
	private LexBIGServiceMetadata lbsm;

 	/**
	* This is the callback to destroy this resource. If anything needs to be cleaned up
	* when this resource is destroyed it should be done here.
	*/
    @Override
	public void remove() throws ResourceException {
		this.lbsm = null;
	}
	
	public LexBIGServiceMetadata getLexBIGServiceMetadata() throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
	InvalidServiceContextAccess {
		if(lbsm == null){
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess fault = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess();	
			fault.setFaultString("Cannot Call This Grid Service Directly");
			throw fault;
		}
		return this.lbsm;	
	}

	public void setLexBIGServiceMetadata(LexBIGServiceMetadata lbsm) {
		this.lbsm = lbsm;
	}
	
}
