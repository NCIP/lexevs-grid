package org.LexGrid.LexBIG.cagrid.dataService.common;

import javax.xml.namespace.QName;


public interface LexEVSDataServiceConstants {
	public static final String SERVICE_NS = "http://dataService.cagrid.LexBIG.LexGrid.org/LexEVSDataService";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "LexEVSDataServiceKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "LexEVSDataServiceResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName SERVICEMETADATA = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata", "ServiceMetadata");
	public static final QName DOMAINMODEL = new QName("gme://caGrid.caBIG/1.0/gov.nih.nci.cagrid.metadata.dataservice", "DomainModel");
	
}
