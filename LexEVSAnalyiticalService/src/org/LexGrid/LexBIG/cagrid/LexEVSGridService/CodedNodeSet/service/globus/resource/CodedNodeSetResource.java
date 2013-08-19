/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.service.globus.resource;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.globus.wsrf.ResourceException;


/** 
 * The implementation of this CodedNodeSetResource type.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class CodedNodeSetResource extends CodedNodeSetResourceBase {
	
	CodedNodeSet cns;

   	/**
	* This is the callback to destroy this resource. If anything needs to be cleaned up
	* when this resource is destroyed it should be done here.
	*/
    @Override
	public void remove() throws ResourceException {
		this.cns = null;
	}

	public void setCodedNodeSet(CodedNodeSet cns){
		this.cns = cns;
	}

	public CodedNodeSet getCodedNodeSet() throws RemoteException{
		if(cns == null){
			org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess fault = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.
			InvalidServiceContextAccess();	
			fault.setFaultString("Cannot Call This Grid Service Directly");
			throw fault;
		}
		return this.cns;	
	}
}
