package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import gov.nih.nci.iso21090.INT;

public class LongToIntCustomConverter extends AbstractCustomConverter<Long,INT>{

	@Override
	protected INT aToB(Long a) {
		INT intObject = new INT();
		intObject.setValue(a.intValue());
		
		return intObject;
	}

	@Override
	protected Long bToA(INT b) {
		return b.getValue().longValue();
		
	}

	@Override
	protected Class<?> getAClass() {
		return Long.class;
	}

	@Override
	protected Class<?> getBClass() {
		return INT.class;
	}
}
