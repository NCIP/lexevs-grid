package org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.service;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.cagrid.Utils;

/**
 * TODO:I am the service side implementation class. IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class SortImpl extends SortImplBase {

	public SortImpl() throws RemoteException {
		super();
	}

  public java.lang.String getName() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
		try {
			return this.getResourceHome().getAddressedResource().getSort()
					.getName();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public java.lang.String getDescription() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
		try {
			return this.getResourceHome().getAddressedResource().getSort()
					.getDescription();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public java.lang.String getProvider() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
		try {
			return this.getResourceHome().getAddressedResource().getSort()
					.getProvider();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public java.lang.String getVersion() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
		try {
			return this.getResourceHome().getAddressedResource().getSort()
					.getVersion();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

}
