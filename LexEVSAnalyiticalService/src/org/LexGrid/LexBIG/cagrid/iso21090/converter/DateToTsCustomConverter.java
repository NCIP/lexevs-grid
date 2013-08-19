/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import gov.nih.nci.iso21090.TS;

import java.util.Date;

public class DateToTsCustomConverter extends AbstractCustomConverter<Date,TS>{

	@Override
	protected TS aToB(Date a) {
		TS ts = new TS();
		ts.setValue(a.toString());
		return ts;
	}

	@Override
	protected Date bToA(TS b) {
		return new Date();
	}

	@Override
	protected Class<?> getAClass() {
		return Date.class;
	}

	@Override
	protected Class<?> getBClass() {
		return TS.class;
	}
}
