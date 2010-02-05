/*******************************************************************************
 * Copyright: (c) 2004-2007 Mayo Foundation for Medical Education and 
 * Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 * 
 * Except as contained in the copyright notice above, or as used to identify 
 * MFMER as the author of this software, the trade names, trademarks, service
 * marks, or product names of the copyright holder shall not be used in
 * advertising, promotion or otherwise in connection with this software without
 * prior written authorization of the copyright holder.
 *   
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *   
 *  		http://www.eclipse.org/legal/epl-v10.html
 * 
 *  		
 *******************************************************************************/
/**
 * 
 */
package edu.mayo.cagrid.encoding.enumerator;

import java.io.StringReader;

import javax.xml.namespace.QName;

import org.apache.axis.encoding.DeserializationContext;
import org.apache.axis.encoding.Deserializer;
import org.apache.axis.encoding.DeserializerImpl;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * @author <a href="mailto:joshua.phillips@semanticbits.com">Joshua Phillips</a>
 * 
 */
public class CastorBeanDeserializer extends DeserializerImpl implements
		Deserializer {
	private QName xmlType;
	private Class javaType;

	public CastorBeanDeserializer(Class javaType, QName xmlType) {
		this.xmlType = xmlType;
		this.javaType = javaType;
	}

	public void onEndElement(String namespace, String localName,
			DeserializationContext context) {

		String value = null;
		try {
			value = context.getCurElement().getAsString();
		} catch (Exception ex) {
			throw new RuntimeException(
					"Error getting current element as string: "
							+ ex.getMessage(), ex);
		}
		try {
		
				this.value = Unmarshaller.unmarshal(this.javaType,
					new StringReader(value));
				
		} catch (MarshalException ex) {
			throw new RuntimeException("Error unmarshalling: "
					+ ex.getMessage(), ex);
		} catch (ValidationException ex) {
			throw new RuntimeException("Error validating: " + ex.getMessage(),
					ex);
		}
	}
}
