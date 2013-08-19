/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import gov.nih.nci.iso21090.INT;

public class IntegerIntCustomConverter extends AbstractCustomConverter<Integer,INT> {

	@Override
	protected INT aToB(Integer a) {
		INT in = new INT();
		in.setValue(a);
		return in;
	}

	@Override
	protected Integer bToA(INT b) {
		return b.getValue();
	}

	@Override
	protected Class<?> getAClass() {
		return Integer.class;
	}

	@Override
	protected Class<?> getBClass() {
		return INT.class;
	}

}
