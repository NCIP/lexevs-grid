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
import java.util.Comparator;

import org.LexGrid.LexBIG.Exceptions.LBParameterException;
import org.LexGrid.LexBIG.Extensions.Query.Sort;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.Sort.client.SortClient;

public class SortAdapter implements Sort{

private SortClient sort;
	
	public SortAdapter(SortClient client) throws RemoteException {
		sort = client;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Extensions.Extendable#getDescription()
	 */
	public String getDescription() {
		try {
			return sort.getDescription();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Extensions.Extendable#getName()
	 */
	public String getName() {
		try {
			return sort.getName();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Extensions.Extendable#getProvider()
	 */
	public String getProvider() {
		try {
			return sort.getProvider();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.LexGrid.LexBIG.Extensions.Extendable#getVersion()
	 */
	public String getVersion() {
		try {
			return sort.getVersion();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	public <T> Comparator<T> getComparatorForSearchClass(Class<T> arg0)
			throws LBParameterException {
		throw new RuntimeException("This is not a valid Grid Service Call");
	}

	public boolean isSortValidForClass(Class<?> arg0) {
		throw new RuntimeException("This is not a valid Grid Service Call");
	}
}
