/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
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
