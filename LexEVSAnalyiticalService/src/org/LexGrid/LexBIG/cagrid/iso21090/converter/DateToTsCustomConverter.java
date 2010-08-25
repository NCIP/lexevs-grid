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
