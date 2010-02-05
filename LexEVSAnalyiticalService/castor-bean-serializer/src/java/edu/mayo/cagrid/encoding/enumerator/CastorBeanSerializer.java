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

import gov.nih.nci.cagrid.encoding.AxisContentHandler;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.xml.namespace.QName;

import org.apache.axis.Constants;
import org.apache.axis.encoding.SerializationContext;
import org.apache.axis.encoding.Serializer;
import org.apache.axis.wsdl.fromJava.Types;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.springframework.aop.framework.Advised;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;

/**
 * @author <a href="mailto:joshua.phillips@semanticbits.com">Joshua Phillips</a>
 * 
 */
public class CastorBeanSerializer implements Serializer {

	public void serialize(QName qName, Attributes atts, Object value,
			SerializationContext context) throws IOException {
		if (value == null) {
			throw new IOException("object to serialize must not be null");
		}
		AxisContentHandler handler = new AxisContentHandler(context);	
		try {
			 if (value instanceof Advised) {
	              try {
	                    value = ((Advised)value).getTargetSource().getTarget();
	              } catch (Exception e) {
	            	  throw new IOException("Error validating: " + e.getMessage());
	              }
	        }
			Marshaller.marshal(value, handler);
		} catch (MarshalException ex) {
			throw new IOException("Error marshalling: " + ex.getMessage());
		} catch (ValidationException ex) {
			throw new IOException("Error validating: " + ex.getMessage());
		} catch (Exception e) {
			throw new IOException("Error validating: " + e.getMessage());
		}
	}

	public Element writeSchema(Class javaType, Types types) throws Exception {
		return null;
	}

	public String getMechanismType() {
		return Constants.AXIS_SAX;
	}
}
