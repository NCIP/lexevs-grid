package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import gov.nih.nci.iso21090.ST;

public class TextTextCustomConverter extends AbstractCustomConverter<org.LexGrid.commonTypes.Text,org.LexGrid.iso21090.commonTypes.Text>{

	@Override
	protected org.LexGrid.iso21090.commonTypes.Text aToB(org.LexGrid.commonTypes.Text a) {
		ST contentSt = new ST();
		contentSt.setValue(a.getContent());
		
		ST dataTypeSt = new ST();
		dataTypeSt.setValue(a.getDataType());
		
		org.LexGrid.iso21090.commonTypes.Text text = new org.LexGrid.iso21090.commonTypes.Text();
		text.setTextValue(contentSt);
		text.setDataType(dataTypeSt);
		
		return text;
	}

	@Override
	protected org.LexGrid.commonTypes.Text bToA(org.LexGrid.iso21090.commonTypes.Text b) {
		org.LexGrid.commonTypes.Text text = new org.LexGrid.commonTypes.Text();
		text.setContent(b.getTextValue().getValue());
		if(b.getDataType() != null){
			text.setDataType(b.getDataType().getValue());
		}
		
		return text;
	}

	@Override
	protected Class<?> getAClass() {
		return org.LexGrid.commonTypes.Text.class;
	}

	@Override
	protected Class<?> getBClass() {
		return org.LexGrid.iso21090.commonTypes.Text.class;
	}

}
