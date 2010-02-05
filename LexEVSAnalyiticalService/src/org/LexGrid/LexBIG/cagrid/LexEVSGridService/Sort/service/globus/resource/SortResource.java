package org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service.globus.resource;

import org.LexGrid.LexBIG.Extensions.Query.Sort;
import org.globus.wsrf.ResourceException;


/** 
 * The implementation of this SortResource type.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class SortResource extends SortResourceBase {
	private Sort sort;

 	/**
	* This is the callback to destroy this resource. If anything needs to be cleaned up
	* when this resource is destroyed it should be done here.
	*/
    @Override
	public void remove() throws ResourceException {
		this.sort = null;
	}
    
	public Sort getSort() throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
	InvalidServiceContextAccess {
		if(sort == null){
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess fault = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess();	
			fault.setFaultString("Cannot Call This Grid Service Directly");
			throw fault;
		}
		return this.sort;	
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}
}
