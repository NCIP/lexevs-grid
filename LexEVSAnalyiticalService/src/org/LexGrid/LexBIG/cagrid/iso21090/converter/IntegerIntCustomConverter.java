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
