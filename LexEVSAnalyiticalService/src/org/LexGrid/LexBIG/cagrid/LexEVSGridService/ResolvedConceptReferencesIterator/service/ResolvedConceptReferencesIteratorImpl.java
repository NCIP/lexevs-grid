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
package org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.service;

import java.lang.reflect.Field;
import java.rmi.RemoteException;

import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;
import org.LexGrid.LexBIG.Exceptions.LBResourceUnavailableException;
import org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator;
import org.LexGrid.LexBIG.cagrid.Utils;
import org.springframework.aop.framework.Advised;

/**
 * TODO:I am the service side implementation class. IMPLEMENT AND DOCUMENT ME
 * 
 * @created by Introduce Toolkit version 1.1
 * 
 */
public class ResolvedConceptReferencesIteratorImpl extends
		ResolvedConceptReferencesIteratorImplBase {

	public ResolvedConceptReferencesIteratorImpl() throws RemoteException {
		super();
	}

  public org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference next() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return getResourceHome().getAddressedResource()
					.getResolvedConceptReferencesIterator().next();
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList nextInt(int maxToReturn) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return unwrap(getResourceHome().getAddressedResource()
					.getResolvedConceptReferencesIterator().next(maxToReturn));
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList get(int start,int end) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
		try {
			return unwrap(getResourceHome().getAddressedResource()
					.getResolvedConceptReferencesIterator().get(start, end));
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList getNext() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			return unwrap(getResourceHome().getAddressedResource()
					.getResolvedConceptReferencesIterator().getNext());
		 } catch (Exception e) {
				Utils.processException(e);
				return null;
		 }
	}

  public void scroll(int maxToReturn) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException {
		try {
			ResolvedConceptReferencesIterator rcri = getResourceHome()
					.getAddressedResource()
					.getResolvedConceptReferencesIterator().scroll(maxToReturn);
			getResourceHome().getAddressedResource()
					.setResolvedConceptReferencesIterator(rcri);
		 } catch (Exception e) {
				Utils.processException(e);
		 }
	}

  public boolean hasNext() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException {
		try {
			return getResourceHome().getAddressedResource()
					.getResolvedConceptReferencesIterator().hasNext();
		 } catch (Exception e) {
				Utils.processException(e);
				return false;
		 }
	}

  public int numberRemaining() throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException {
		try {
			return getResourceHome().getAddressedResource()
					.getResolvedConceptReferencesIterator().numberRemaining();
		 } catch (Exception e) {
				Utils.processException(e);
				return 0;
		 }
	}
  
  private ResolvedConceptReferenceList unwrap(ResolvedConceptReferenceList rcrl) throws Exception {
	  for(int i=0;i<rcrl.getResolvedConceptReference().length;i++){
		  ResolvedConceptReference ref = unwrap(rcrl.getResolvedConceptReference()[i]);
		  rcrl.setResolvedConceptReference(i, ref);
	  }
	  return rcrl;
  }
  
   private <T> T unwrap(T proxy) throws Exception {
	  if(!(proxy instanceof Advised)){
		  return proxy;
	  }
      Object interceptor = null;
      int i = 0;
      while (true) {
          Field field = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_"+i);
          field.setAccessible(true);
          Object value = field.get(proxy);
          if (value.getClass().getName().contains("EqualsInterceptor")) {
              interceptor = value;
              break;
          }
          i++;
      }

      Field field = interceptor.getClass().getDeclaredField("advised");
      field.setAccessible(true);
      Advised advised = (Advised)field.get(interceptor);
      T realObject = (T)advised.getTargetSource().getTarget();
      return realObject;
  }

}
