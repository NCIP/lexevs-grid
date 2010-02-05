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
