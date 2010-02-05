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
