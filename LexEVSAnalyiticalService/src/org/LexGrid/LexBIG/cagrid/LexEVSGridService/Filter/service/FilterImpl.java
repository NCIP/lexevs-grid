package org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.service;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.cagrid.Utils;

/**
 * TODO:I am the service side implementation class. IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class FilterImpl extends FilterImplBase {

	public FilterImpl() throws RemoteException {
		super();
	}

  public boolean match(org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference ref) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
		try {
			return this.getResourceHome().getAddressedResource().getFilter()
					.match(ref);
		 } catch (Exception e) {
			Utils.processException(e);
			return false;
		 }
	}

  public java.lang.String getName() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
		try {
			return this.getResourceHome().getAddressedResource().getFilter()
					.getName();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public java.lang.String getDescription() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
		try {
			return this.getResourceHome().getAddressedResource().getFilter()
					.getDescription();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public java.lang.String getProvider() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
		try {
			return this.getResourceHome().getAddressedResource().getFilter()
					.getProvider();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public java.lang.String getVersion() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess {
		try {
			return this.getResourceHome().getAddressedResource().getFilter()
					.getVersion();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}
}
