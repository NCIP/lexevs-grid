/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.security.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SecurityTestConstants {

	private static Properties props = loadProps();
	
	//Secure Vocab
	public static String SECURE_VOCAB = props.getProperty("SECURE_VOCAB");
	
	//Unsecure Vocab
	public static String UNSECURE_VOCAB = props.getProperty("UNSECURE_VOCAB");
	
	//MedDRA Token
	public static String MEDDRA_TOKEN = props.getProperty("MEDDRA_TOKEN");

	private static Properties loadProps(){
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(System.getProperty("test.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return props;
	}
}
