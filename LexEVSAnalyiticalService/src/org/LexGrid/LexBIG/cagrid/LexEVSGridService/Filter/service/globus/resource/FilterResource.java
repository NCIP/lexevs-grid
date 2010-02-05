package org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.service.globus.resource;

import org.LexGrid.LexBIG.Extensions.Query.Filter;
import org.globus.wsrf.ResourceException;

/** 
 * The implementation of this FilterResource type.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class FilterResource extends FilterResourceBase {
	private Filter filter;

 	/**
	* This is the callback to destroy this resource. If anything needs to be cleaned up
	* when this resource is destroyed it should be done here.
	*/
    @Override
	public void remove() throws ResourceException {
		this.filter = null;
	}
    
	public Filter getFilter() throws org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
	InvalidServiceContextAccess {
		if(filter == null){
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess fault = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess();	
			fault.setFaultString("Cannot Call This Grid Service Directly");
			throw fault;
		}
		return this.filter;	
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	
	
}
