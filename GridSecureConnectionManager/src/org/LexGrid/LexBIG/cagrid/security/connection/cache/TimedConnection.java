/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.security.connection.cache;

import java.util.Calendar;

public class TimedConnection <T>{

	private T appSvc;
	private Calendar creationTime;
	
	public T getAppService() {
		return appSvc;
	}
	
	//Time Doesn't start until the service is set
	public void setAppService(T appSvc) {
		
		this.appSvc = appSvc;
		this.creationTime = Calendar.getInstance();
	}
	public Calendar getCreationTime() {
		return creationTime;
	}	
	
	public void updateTimeStamp(){
		this.creationTime = Calendar.getInstance();
	}
}
