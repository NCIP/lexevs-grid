package org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceMetadata.common;

import javax.xml.namespace.QName;


public interface LexBIGServiceMetadataConstants {
	public static final String SERVICE_NS = "http://LexBIGCaGridServices.cagrid.LexBIG.LexGrid.org/LexBIGCaGridServices/LexBIGServiceMetadata";
	public static final QName RESOURCE_KEY = new QName(SERVICE_NS, "LexBIGServiceMetadataKey");
	public static final QName RESOURCE_PROPERTY_SET = new QName(SERVICE_NS, "LexBIGServiceMetadataResourceProperties");

	//Service level metadata (exposed as resouce properties)
	public static final QName CURRENTTIME = new QName("http://docs.oasis-open.org/wsrf/2004/06/wsrf-WS-ResourceLifetime-1.2-draft-01.xsd", "CurrentTime");
	public static final QName TERMINATIONTIME = new QName("http://docs.oasis-open.org/wsrf/2004/06/wsrf-WS-ResourceLifetime-1.2-draft-01.xsd", "TerminationTime");
	
}
