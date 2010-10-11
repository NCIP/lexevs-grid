package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import org.LexGrid.commonTypes.Text;

public class TextToStringCustomConverter extends AbstractCustomConverter<Text,String>{

	@Override
	protected String aToB(Text a) {
		return a.getContent();
	}

	@Override
	protected Text bToA(String b) {
		Text text = new Text();
		text.setContent(b);
		
		return text;
		
	}

	@Override
	protected Class<?> getAClass() {
		return Text.class;
	}

	@Override
	protected Class<?> getBClass() {
		return String.class;
	}

}
