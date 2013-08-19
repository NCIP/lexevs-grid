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
import java.util.LinkedHashMap;
import java.util.Map;

import org.LexGrid.LexBIG.caCore.security.interfaces.TokenSecurableApplicationService;
import org.LexGrid.LexBIG.cagrid.security.connection.exceptions.SecureConnectionNotFoundException;

public class SecureConnectionCache<T extends TokenSecurableApplicationService> extends LinkedHashMap<String, TimedConnection<T>>{

	 /*
	  * Defaults -- can be overridden by passing these into the constructor
	  */
	 protected int maxEntries = 30;
	 protected  int keepAliveMinutes = 5;
	 
	 public SecureConnectionCache(){
		 super();
	 }
	 
	 public SecureConnectionCache(int max_entries, int keep_alive_minutes){
		 super();
		 maxEntries = max_entries;	
		 keepAliveMinutes = keep_alive_minutes;	
	 }
	 	 
     /* (non-Javadoc)
     * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
     * Overrides to remove oldest entry after MAX_ENTRIES has been reached.
     */
    protected boolean removeEldestEntry(Map.Entry<String, TimedConnection<T>> eldest) {
        return size() >= maxEntries && checkConnectionTimeLimit(eldest.getValue());

     }

    public T get(String key) throws SecureConnectionNotFoundException {
    	boolean keyExists = super.containsKey(key);
    	
    	//At this point we have a message containing a Secure Connection string. We now
    	//look in the cache for that connection. If we DON'T find it, it means that either
    	//the connection key is bad or it has timed-out or expired. Either way, throw an error.
    	if(!keyExists){
    		throw new SecureConnectionNotFoundException(key);
    	}
    	return super.get(key).getAppService();
    }
 
    public void put(String key, T appSvc){
    	TimedConnection<T> connection = new TimedConnection<T>();
		connection.setAppService(appSvc);
    	super.put(key, connection);
    }
    
    /**
     * Checks to see if the TimedConnection is expired or not
     */
    protected boolean checkConnectionTimeLimit(TimedConnection<T> eldest){
    	Calendar creationTime = eldest.getCreationTime(); 	
    	Calendar terminationTime = (Calendar)creationTime.clone();
    	terminationTime.add(Calendar.MINUTE, keepAliveMinutes);  	
    	Calendar currentTime = Calendar.getInstance();
    	boolean isExpired = currentTime.after(terminationTime);
    	return isExpired;
    }

	public int getMaxEntries() {
		return maxEntries;
	}

	public int getKeepAliveMinutes() {
		return keepAliveMinutes;
	}
}
