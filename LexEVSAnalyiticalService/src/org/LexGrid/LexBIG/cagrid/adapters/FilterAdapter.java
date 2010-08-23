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
