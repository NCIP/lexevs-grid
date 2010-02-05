package org.LexGrid.LexBIG.cagrid.LexEVSGridService.common;

import javax.xml.namespace.QName;


public interface LexEVSGridServiceConstants {
	public static final String SERVICE_NS = "http://LexBIGCaGridServices.cagrid.LexBIG.LexGrid.org/LexBIGCaGridServices";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "LexEVSGridServiceKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "LexEVSGridServiceResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	
}
