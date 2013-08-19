/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.iso21090.converter;

public class EntityDescriptionToEntityDescriptionCustomConverter extends AbstractCustomConverter<org.LexGrid.commonTypes.EntityDescription,org.LexGrid.iso21090.commonTypes.EntityDescription>{

	@Override
	protected org.LexGrid.iso21090.commonTypes.EntityDescription aToB(org.LexGrid.commonTypes.EntityDescription a) {
		
		org.LexGrid.iso21090.commonTypes.EntityDescription entityDescription = new org.LexGrid.iso21090.commonTypes.EntityDescription();
		entityDescription.setValue(a.getContent());

		return entityDescription;
	}

	@Override
	protected org.LexGrid.commonTypes.EntityDescription bToA(org.LexGrid.iso21090.commonTypes.EntityDescription b) {
		org.LexGrid.commonTypes.EntityDescription entityDescription = new org.LexGrid.commonTypes.EntityDescription();
		entityDescription.setContent(b.getValue());
		
		return entityDescription;
	}

	@Override
	protected Class<?> getAClass() {
		return org.LexGrid.commonTypes.EntityDescription.class;
	}

	@Override
	protected Class<?> getBClass() {
		return org.LexGrid.iso21090.commonTypes.EntityDescription.class;
	}
}
