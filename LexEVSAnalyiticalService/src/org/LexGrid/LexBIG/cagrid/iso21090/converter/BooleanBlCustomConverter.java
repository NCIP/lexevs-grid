/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import gov.nih.nci.iso21090.BL;

import java.util.List;

public class BooleanBlCustomConverter extends AbstractCustomConverter<Boolean,BL>{

	@Override
	protected BL aToB(Boolean a) {
		BL bl = new BL();
		bl.setValue(a);
		return bl;
	}

	@Override
	protected Boolean bToA(BL b) {
		return b.getValue();
	}

	@Override
	protected Class<?> getAClass() {
		return Boolean.class;
	}

	@Override
	protected Class<?> getBClass() {
		return BL.class;
	}
}
