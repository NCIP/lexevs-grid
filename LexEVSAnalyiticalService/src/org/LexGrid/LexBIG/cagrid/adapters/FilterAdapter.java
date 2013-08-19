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

import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.Extensions.Query.Filter;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.Filter.client.FilterClient;
import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;

public class FilterAdapter implements Filter {

	private FilterClient filter;
	
	public FilterAdapter(FilterClient client) throws RemoteException {
		filter = client;
	}
	
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.Extensions.Extendable#getDescription()
	 */
	public String getDescription() {
		try {
			return filter.getDescription();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.Extensions.Extendable#getName()
	 */
	public String getName() {
		try {
			return filter.getName();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.Extensions.Extendable#getProvider()
	 */
	public String getProvider() {
		try {
			return filter.getProvider();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.Extensions.Extendable#getVersion()
	 */
	public String getVersion() {
		try {
			return filter.getVersion();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.Extensions.Query.Filter#match(org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference)
	 */
	public boolean match(ResolvedConceptReference ref) {
		try {
			return filter.match(ConvertUtils.convert(ref, org.LexGrid.LexBIG.iso21090.DataModel.Core.ResolvedConceptReference.class));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
