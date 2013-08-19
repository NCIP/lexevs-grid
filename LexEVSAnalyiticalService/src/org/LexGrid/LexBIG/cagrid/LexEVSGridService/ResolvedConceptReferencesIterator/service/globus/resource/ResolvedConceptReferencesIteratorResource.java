/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.service.globus.resource;

import org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator;
import org.globus.wsrf.ResourceException;


/** 
 * The implementation of this ResolvedConceptReferencesIteratorResource type.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class ResolvedConceptReferencesIteratorResource extends ResolvedConceptReferencesIteratorResourceBase {

   	/**
	* This is the callback to destroy this resource. If anything needs to be cleaned up
	* when this resource is destroyed it should be done here.
	*/

	private ResolvedConceptReferencesIterator rcri;
	
    public void remove() throws ResourceException {
		this.rcri = null;
	}
    
    public ResolvedConceptReferencesIterator getResolvedConceptReferencesIterator() throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
	InvalidServiceContextAccess {
    	if(rcri == null){
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess fault = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess();	
			fault.setFaultString("Cannot Call This Grid Service Directly");
			throw fault;
		}
		return this.rcri;	
    }
    
    public void setResolvedConceptReferencesIterator(ResolvedConceptReferencesIterator rcri){
    	this.rcri = rcri;
    }
}
