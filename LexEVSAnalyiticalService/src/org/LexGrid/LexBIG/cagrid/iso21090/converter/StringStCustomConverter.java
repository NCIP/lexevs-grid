package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import gov.nih.nci.iso21090.ST;

public class StringStCustomConverter extends AbstractCustomConverter<String,ST>{

	@Override
	protected ST aToB(String a) {
		ST st = new ST();
		st.setValue(a);
		return st;
	}

	@Override
	protected String bToA(ST b) {
		return b.getValue();
	}

	@Override
	protected Class<?> getAClass() {
		return String.class;
	}

	@Override
	protected Class<?> getBClass() {
		return ST.class;
	}

}
