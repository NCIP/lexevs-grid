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
