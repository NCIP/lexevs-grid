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

package gov.nih.nci;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import junit.framework.TestCase;


/**
 * The Class ServiceTestCase.
 */
abstract public class ServiceTestCase extends TestCase{
	
	/** The sys prop. */
	private static Properties sysProp = System.getProperties();
//	private static final String DEFAULT_SAX_DRIVER_CLASS ="org.apache.xerces.parsers.SAXParser";
//	private static SchemaInfo info = readConfig();
//	readConfig();
	
	
	/** The Constant testList. */
    public final static Vector<SchemaInfo> testList = new Vector<SchemaInfo>();
	
	/** The dom. */
	private static Document dom;

	/** The properties. */
	private static Properties properties = loadProperties();


	/** The Constant serviceUrl. */
	public final static String serviceUrl = properties.getProperty("serviceUrl");

	
	/** The Constant THES_SCHEME. */
	public final static String THES_SCHEME =  properties.getProperty("THES_SCHEME"); //NCI_Thesaurus";
	
	/** The Constant THES_URN. */
	public final static String THES_URN = properties.getProperty("THES_URN"); //"urn:oid:2.16.840.1.113883.3.26.1.1";
	
	/** The Constant THES_LOCAL. */
	public final static String THES_LOCAL = properties.getProperty("THES_LOCAL"); //"NCI Thesaurus";
	
	/** The Constant THES_LOCAL_NSDI. */
	public final static String THES_LOCAL_NSDI = properties.getProperty("THES_LOCAL_NSDI"); //"40010";
	
	/** The Constant THES_TAG. */
	public final static String THES_TAG = properties.getProperty("THES_TAG"); //"PRODUCTION";
	
	/** The Constant THES_VERSION. */
	public final static String THES_VERSION = properties.getProperty("THES_VERSION"); 
	
	/** The Constant THES_METADATA_VERSION. */
	public final static String THES_METADATA_VERSION = properties.getProperty("THES_METADATA_VERSION");
	
	/** The Constant META_SCHEME. */
	public final static String META_SCHEME = properties.getProperty("META_SCHEME"); //"NCI MetaThesaurus";
	
	/** The Constant META_SCHEME. */
	public final static String META_TOKEN = properties.getProperty("META_TOKEN");
	
	/** The Constant META_URN. */
	public final static String META_URN = properties.getProperty("META_URN"); //"urn:oid:2.16.840.1.113883.3.26.1.2";
	
	/** The Constant META_VERSION. */
	public final static String META_VERSION = properties.getProperty("META_VERSION");
	
	/** The Constant MGED_SCHEME. */
	public final static String MGED_SCHEME = properties.getProperty("MGED_SCHEME"); //"The MGED Ontology";

	/** The Constant ZEBRAFISH_SCHEME. */
	public final static String ZEBRAFISH_SCHEME = properties.getProperty("ZEBRAFISH_SCHEME"); //"Zebrafish";

	/** The Constant ZEBRAFISH_VERSION. */
	public final static String ZEBRAFISH_VERSION = properties.getProperty("ZEBRAFISH_VERSION"); //"1";

	/** The Constant SNOMED_SCHEME. */
	public final static String SNOMED_SCHEME = properties.getProperty("SNOMED_SCHEME"); //"SNOMED Clinical Terms";

	/** The Constant SNOMED_VERSION. */
	public final static String SNOMED_VERSION = properties.getProperty("SNOMED_VERSION"); 

	/** The Constant GO_SCHEME. */
	public final static String GO_SCHEME = properties.getProperty("GO_SCHEME"); //"Gene Ontology";

	/** The Constant GO_VERSION. */
	public final static String GO_VERSION = properties.getProperty("GO_VERSION");

	/** The Constant MEDDRA_SCHEME. */
	public final static String MEDDRA_SCHEME = properties.getProperty("MEDDRA_SCHEME"); //"MedDRA";

	/** The Constant MEDDRA_URN. */
	public final static String MEDDRA_URN = properties.getProperty("MEDDRA_URN"); //"MedDRA URN";
	
	/** The Constant MEDDRA_VERSION. */
	public final static String MEDDRA_VERSION = properties.getProperty("MEDDRA_VERSION"); 

	/** The Constant MEDDRA_TOKEN. */
	public final static String MEDDRA_TOKEN = properties.getProperty("MEDDRA_TOKEN");

	//The following are all source names in Meta
	/** The Constant meddraMeta. */
	public final static String meddraMeta = properties.getProperty("meddraMeta"); //"MDR";

	/** The Constant loincMeta. */
	public final static String loincMeta = properties.getProperty("loincMeta"); //"LNC";

	/** The Constant ncitMeta. */
	public final static String ncitMeta = properties.getProperty("ncitMeta"); //"NCI";

	/** The Constant nciMetaVersion. */
	public final static String nciMetaVersion = properties.getProperty("nciMetaVersion"); 

	/** The Constant snomedMeta. */
	public final static String snomedMeta = properties.getProperty("snomedMeta"); //"SNOMEDCT";

	/** The Constant meshMeta. */
	public final static String meshMeta = properties.getProperty("meshMeta"); //"MSH";

    /** The Constant NCIT_CONCODE. */
    public final static String NCIT_CONCODE = properties.getProperty("NCIT_CONCODE"); // Concept code from NCI Thesaurus
    
    /** The Constant SNOMED_CONCODE. */
    public final static String SNOMED_CONCODE = properties.getProperty("SNOMED_CONCODE"); // Concept code from SNOMED
    
    /** The Constant GO_CONCODE. */
    public final static String GO_CONCODE = properties.getProperty("GO_CONCODE"); // Concept code from GO
    
    /** The Constant MEDDRA_CONCODE. */
    public final static String MEDDRA_CONCODE = properties.getProperty("MEDDRA_CONCODE"); // Concept code from MEDDRA
    
    /** The Constant NDF_CONCODE. */
    public final static String NDF_CONCODE = properties.getProperty("NDF_CONCODE"); // Concept code from NDF
    
    /** The Constant MGED_CONCODE. */
    public final static String MGED_CONCODE = properties.getProperty("MGED_CONCODE"); // Concept code from MGED
    
    /** The Constant UMLS_CONCODE. */
    public final static String UMLS_CONCODE = properties.getProperty("UMLS_CONCODE"); // Concept code from UMLS
    
    /** The Constant ZF_CONCODE. */
    public final static String ZF_CONCODE = properties.getProperty("ZF_CONCODE"); // Concept code from ZEBRAFISH

    /** The Constant DomainConceptCode. */
    public final static String DOMAIN_CONCEPT_CODE = properties.getProperty("DOMAIN_CONCEPT_CODE"); // NCIt concept code
    
    /** The Constant ZF_CONCODE. */
    public final static String DOMAIN_CUI = properties.getProperty("DOMAIN_CUI"); //  cui for domain object testing

    
	/**
	 * To be implemented by each descendant testcase.
	 * 
	 * @return String
	 */
	abstract protected String getTestID();


	/**
	 * Load properties.
	 * 
	 * @return the properties
	 */
	private static Properties loadProperties(){

		try{
			String propertyFile = sysProp.getProperty("test.property");
			
			//For running single tests in Eclipse
			if(propertyFile == null){
				propertyFile = "test/resources/Test.properties";
			}
			
			Properties lproperties = new Properties();
			if(propertyFile != null && propertyFile.length() > 0){
				FileInputStream fis = new FileInputStream(new File(propertyFile));
				lproperties.load(fis);				
			}

			//cycle through to see if it throws any errors.
			for(Iterator i = lproperties.keySet().iterator(); i.hasNext();){
				String key = (String)i.next();
				String value  = lproperties.getProperty(key);
			}
			return lproperties;}
		catch (Exception e){
			System.out.println("Error reading properties file");
			e.printStackTrace();
			return null;
		}
	} 

	/**
	 * Parses the xml file.
	 * 
	 * @param filename the filename
	 */
	private static void parseXMLFile(String filename)
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try{
			DocumentBuilder db = dbf.newDocumentBuilder();

			dom=db.parse(filename);

		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * Load objects.
	 */
	private static void loadObjects()
	{
		Element docEle = dom.getDocumentElement();

		NodeList nl = docEle.getElementsByTagName("test");
		if (nl != null && nl.getLength()>0){
			for (int i=0; i<nl.getLength();i++){
				Element el =(Element)nl.item(i);
				SchemaInfo linfo = getTest(el);
				testList.add(linfo);
			}
		}
	}

	/**
	 * Gets the test.
	 * 
	 * @param testEl the Element
	 * 
	 * @return the SchemaInfo object
	 */
	private static SchemaInfo getTest(Element testEl){
		String name = getTextValue(testEl,"name");
		String codingScheme = getTextValue(testEl, "codingScheme");
		String conceptCode = getTextValue(testEl, "conceptCode");
		String propertyToSearch = getTextValue(testEl, "propertyToSearch");
		String searchTerm = getTextValue(testEl, "searchTerm");

		SchemaInfo linfo = new SchemaInfo();
		linfo.setName(name);
		linfo.setCodingScheme(codingScheme);
		linfo.setConceptCode(conceptCode);
		linfo.setPropertyToSearch(propertyToSearch);
		linfo.setSearchTerm(searchTerm);
		return linfo;
	}

	/**
	 * Gets the text value.
	 * 
	 * @param ele the ele
	 * @param tagName the tag name
	 * 
	 * @return the text value
	 */
	private static String getTextValue(Element ele, String tagName){
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if (nl!=null && nl.getLength()>0){
			Element el = (Element)nl.item(0);
			textVal=el.getFirstChild().getNodeValue();
		}
		return textVal;
	}


}
