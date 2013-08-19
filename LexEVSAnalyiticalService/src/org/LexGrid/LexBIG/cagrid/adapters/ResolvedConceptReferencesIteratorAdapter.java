/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.adapters;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Exceptions.LBInvocationException;
import org.LexGrid.LexBIG.Exceptions.LBParameterException;
import org.LexGrid.LexBIG.Exceptions.LBResourceUnavailableException;
import org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.client.ResolvedConceptReferencesIteratorClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;

public class ResolvedConceptReferencesIteratorAdapter implements ResolvedConceptReferencesIterator{

private ResolvedConceptReferencesIteratorClient itr;
	
	public ResolvedConceptReferencesIteratorAdapter(ResolvedConceptReferencesIteratorClient client) throws RemoteException {
		itr = client;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator#get(int,
	 *      int)
	 */
	public ResolvedConceptReferenceList get(int arg0, int arg1)
			throws LBResourceUnavailableException, LBInvocationException,
			LBParameterException {
			try {
				return ConvertUtils.convert(itr.get(arg0, arg1), org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList.class);
			} catch (InvalidServiceContextAccess e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
				throw new LBInvocationException(e.getMessage(), null);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException e) {
				throw new LBInvocationException(e.getMessage(), null);
			} catch (RemoteException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			}	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator#getNext()
	 */
	public ResolvedConceptReferenceList getNext() {
		try {
			return ConvertUtils.convert(itr.getNext(), org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator#next()
	 */
	public ResolvedConceptReference next()
			throws LBResourceUnavailableException, LBInvocationException {
			try {
				return ConvertUtils.convert(itr.next(), org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference.class);
			} catch (InvalidServiceContextAccess e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
				throw new LBInvocationException(e.getMessage(), null);
			} catch (RemoteException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator#next(int)
	 */
	public ResolvedConceptReferenceList next(int arg0)
			throws LBResourceUnavailableException, LBInvocationException {
			try {
				return ConvertUtils.convert(itr.nextInt(arg0), org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList.class);
			} catch (InvalidServiceContextAccess e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
				throw new LBInvocationException(e.getMessage(), null);
			} catch (RemoteException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Utility.Iterators.ResolvedConceptReferencesIterator#scroll(int)
	 */
	public ResolvedConceptReferencesIterator scroll(int arg0)
			throws LBResourceUnavailableException, LBInvocationException {
			try {
				itr.scroll(arg0);
				return this;
			} catch (InvalidServiceContextAccess e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException e) {
				throw new LBInvocationException(e.getMessage(), null);
			} catch (RemoteException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Utility.Iterators.EntityListIterator#hasNext()
	 */
	public boolean hasNext() throws LBResourceUnavailableException {
			try {
				return itr.hasNext();
			} catch (InvalidServiceContextAccess e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException e) {
				throw new LBResourceUnavailableException(e.getMessage(), null);
			} catch (RemoteException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Utility.Iterators.EntityListIterator#numberRemaining()
	 */
	public int numberRemaining() throws LBResourceUnavailableException {
			try {
				return itr.numberRemaining();
			} catch (InvalidServiceContextAccess e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBResourceUnavailableException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			} catch (RemoteException e) {
				throw new LBResourceUnavailableException(e.getMessage(), e);
			}
	}

	public void release() throws LBResourceUnavailableException {
		// TODO Auto-generated method stub

	}
}
