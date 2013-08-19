/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.security.connection.impl;

import gov.nih.nci.evs.security.SecurityToken;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import junit.framework.TestCase;

import org.LexGrid.LexBIG.caCore.interfaces.LexEVSApplicationService;
import org.LexGrid.LexBIG.caCore.interfaces.LexEVSDistributed;
import org.LexGrid.LexBIG.caCore.security.interfaces.TokenSecurableApplicationService;
import org.LexGrid.LexBIG.cagrid.security.connection.SecureConnectionManager;
import org.LexGrid.LexBIG.cagrid.security.connection.SecureConnectionManagerFactory;
import org.LexGrid.LexBIG.cagrid.security.connection.cache.SecureConnectionCache;
import org.LexGrid.LexBIG.cagrid.security.connection.exceptions.SecureConnectionNotFoundException;
import org.LexGrid.LexBIG.cagrid.security.test.SecurityTestConstants;
import org.apache.axis.MessageContext;
import org.apache.axis.client.AxisClient;
import org.apache.axis.message.MessageElement;
import org.apache.axis.message.MimeHeaders;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.message.addressing.ReferencePropertiesType;
import org.apache.commons.io.FileUtils;

public class SecureConnectionManagerTest extends TestCase {
	
	private static String CON_KEY_PLACEHOLDER = "@@CONNECTION_KEY@@";
	
	public void testGenerics(){
		try {
			SecureConnectionManagerFactory factory = SecureConnectionManagerFactory.getInstance();
			SecureConnectionManager<LexEVSDistributed> conManage = factory.getSecureConnectionManager();	
			assertTrue(conManage != null);

			LexEVSDistributed service = conManage.getApplicationServiceFromCache(buildUnSecureMessageContextAndMessage());
			assertTrue(service instanceof LexEVSDistributed);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error setting up." + e.getMessage());
		}
	}
	
	public void testGenericsAgain(){
		try {
			SecureConnectionManagerFactory factory = SecureConnectionManagerFactory.getInstance();
			SecureConnectionManager<LexEVSApplicationService> conManage = factory.getSecureConnectionManager();	
			assertTrue(conManage != null);
			LexEVSApplicationService service = conManage.getApplicationServiceFromCache(buildUnSecureMessageContextAndMessage());
			assertTrue(service instanceof LexEVSApplicationService);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error setting up." + e.getMessage());
		}
	}
	
	public void testGenericsLastTime(){
		try {
			SecureConnectionManagerFactory factory = SecureConnectionManagerFactory.getInstance();
			SecureConnectionManager<TokenSecurableApplicationService> conManage = factory.getSecureConnectionManager();	
			assertTrue(conManage != null);
			TokenSecurableApplicationService service = conManage.getApplicationServiceFromCache(buildUnSecureMessageContextAndMessage());
			assertTrue(service instanceof TokenSecurableApplicationService);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error setting up." + e.getMessage());
		}
	}
	
	public void testGetConnectionFromCacheNoConnectionKey() throws Exception {
		MessageContext ctx = buildUnSecureMessageContextAndMessage();
        
        SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();
		SecureConnectionManager<LexEVSDistributed> conManage = confactory.getSecureConnectionManager();		
		LexEVSDistributed appSvc = conManage.getApplicationServiceFromCache(ctx);
		
		assertTrue(tryToConnectToNonSecuredVocab(appSvc));
		assertFalse(tryToConnectToSecuredVocab(appSvc));	
	}
	
	/*
	 * Make sure the ConnectionManager throws a SecureConnectionNotFoundException
	 * when asked to get a connection with an invalid key.
	 */
	public void testGetConnectionFromCacheWrongConnectionKey() throws Exception {
		MessageContext ctx = buildMessageContext();
		
		SOAPMessage msg = buildSOAPMessage("WRONG_CONNECTION_KEY");
		
        ctx.setMessage(msg);
        
        SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();
		SecureConnectionManager<LexEVSApplicationService> conManage = confactory.getSecureConnectionManager();	
		
		boolean exceptionThrown = false;
		try {
			LexEVSApplicationService appSvc = conManage.getApplicationServiceFromCache(ctx);
		} catch (SecureConnectionNotFoundException e) {
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);				
	}
	
	/*
	 * Test Registering Secure Connection in the cache
	 */
	public void testRegisterSecureConnection() throws Exception {
		MessageContext ctx = buildUnSecureMessageContextAndMessage();
        
        SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();
		SecureConnectionManager<LexEVSApplicationService> conManage = confactory.getSecureConnectionManager();	
		
		//Break into the ConnectionManagerImpl to see what's going on...
		SecureConnectionManagerImpl impl = (SecureConnectionManagerImpl)conManage;
		SecureConnectionCache cache = impl.getConnectionCache();
		//Clear the cache to make sure we star fresh for this test
		cache.clear();
		
		//Pass in a SecurityToken to register the Secure Connection;
		SecurityToken token = new SecurityToken();
		token.setAccessToken(SecurityTestConstants.MEDDRA_TOKEN);
		EndpointReferenceType epr = conManage.processSecurityToken(ctx, SecurityTestConstants.SECURE_VOCAB, token);
		
		assertTrue(epr != null);
		String connectionKey = getConnectionKeyFromEPR(epr);
		assertTrue(connectionKey != null);
		assertTrue(connectionKey != "");
	}
	
	/*
	 * Test Registering Secure Connection in the cache
	 */
	public void testRegisteredSecureConnectionIsInCache() throws Exception {
		MessageContext ctx = buildUnSecureMessageContextAndMessage();
        
        SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();
		SecureConnectionManager<LexEVSApplicationService> conManage = confactory.getSecureConnectionManager();	
		
		//Break into the ConnectionManagerImpl to see what's going on...
		SecureConnectionManagerImpl impl = (SecureConnectionManagerImpl)conManage;
		SecureConnectionCache cache = impl.getConnectionCache();
		//Clear the cache to make sure we star fresh for this test
		cache.clear();
		
		//Pass in a SecurityToken to register the Secure Connection;
		SecurityToken token = new SecurityToken();
		token.setAccessToken(SecurityTestConstants.MEDDRA_TOKEN);
		EndpointReferenceType epr = conManage.processSecurityToken(ctx, SecurityTestConstants.SECURE_VOCAB, token);
		
		assertTrue(epr != null);
		String connectionKey = getConnectionKeyFromEPR(epr);
		assertTrue(connectionKey != null);
		assertTrue(connectionKey != "");
		
		//Cache should contain one (and only one) secure connection
		assertTrue(cache.size() == 1);
		
		//Make sure the cache contains the key we just got back in the EPR
		assertTrue(cache.containsKey(connectionKey));
		
	}
	
	public void testRegisterAndRetrieveSecureConnection() throws Exception {
		MessageContext ctx = buildUnSecureMessageContextAndMessage();
        
        SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();
		SecureConnectionManager<LexEVSApplicationService> conManage = confactory.getSecureConnectionManager();	
		
		//Break into the ConnectionManagerImpl to see what's going on...
		SecureConnectionManagerImpl impl = (SecureConnectionManagerImpl)conManage;
		SecureConnectionCache cache = impl.getConnectionCache();
		//Clear the cache to make sure we star fresh for this test
		cache.clear();
		
		LexEVSApplicationService unsecureSvc = conManage.getApplicationServiceFromCache(ctx);
		//Make sure we can't connect to a secure vocab yet
		assertTrue(this.tryToConnectToNonSecuredVocab(unsecureSvc));
		assertFalse(this.tryToConnectToSecuredVocab(unsecureSvc));
			
		//Cache should still be empty
		assertTrue(cache.size() == 0);
				
		//Pass in a SecurityToken to register the Secure Connection;
		SecurityToken token = new SecurityToken();
		token.setAccessToken(SecurityTestConstants.MEDDRA_TOKEN);
		EndpointReferenceType epr = conManage.processSecurityToken(ctx, SecurityTestConstants.SECURE_VOCAB, token);
		//Get the connection key we got back
		String connnectionKey = getConnectionKeyFromEPR(epr);
					
		//Build a new MessageContext from the EPR (this is simulating a return message coming back
		//to the client. Give it the connection key from the EPR we got back
		MessageContext ctxReturn = buildMessageContext();
		SOAPMessage msgReturn = buildSOAPMessage(connnectionKey);	
		ctxReturn.setMessage(msgReturn);
		
		//Try to retrieve the Connection From the Cache
		LexEVSApplicationService secureSvc = conManage.getApplicationServiceFromCache(ctxReturn);
		
		//Cache should now contain one (and only one) service
		assertTrue(cache.size() == 1);
		
		//Should now be able to connect to a secure vocab
		assertTrue(this.tryToConnectToNonSecuredVocab(secureSvc));
		assertTrue(this.tryToConnectToSecuredVocab(secureSvc));
		
		//Try again with same MessageContext, to make sure it pulls it from the cache and
		//doesn't create a new Connection
		LexEVSApplicationService secureSvcAgain = conManage.getApplicationServiceFromCache(ctxReturn);
		
		//Cache should STILL contain one (and only one) service
		assertTrue(cache.size() == 1);
		
		//Should still be able to connect to a secure vocab
		assertTrue(this.tryToConnectToNonSecuredVocab(secureSvcAgain));
		assertTrue(this.tryToConnectToSecuredVocab(secureSvcAgain));
	}
	
	public void testRegisterMultipleSecureConnections() throws Exception {
		MessageContext ctx = buildUnSecureMessageContextAndMessage();
        
        SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();
        SecureConnectionManager<LexEVSApplicationService> conManage = confactory.getSecureConnectionManager();	

        //Break into the ConnectionManagerImpl to see what's going on...
        SecureConnectionManagerImpl impl = (SecureConnectionManagerImpl)conManage;
        SecureConnectionCache cache = impl.getConnectionCache();
        //Clear the cache to make sure we star fresh for this test
        cache.clear();
        
        //Setup SecurityToken
    	SecurityToken token = new SecurityToken();
    	token.setAccessToken(SecurityTestConstants.MEDDRA_TOKEN);

        for(int i=0;i< 10;i++){
        	LexEVSApplicationService unsecureSvc = conManage.getApplicationServiceFromCache(ctx);
       	
        	EndpointReferenceType epr = conManage.processSecurityToken(ctx, SecurityTestConstants.SECURE_VOCAB, token);
        	//Get the connection key we got back
        	String connnectionKey = getConnectionKeyFromEPR(epr);

        	//Build a new MessageContext from the EPR (this is simulating a return message coming back
        	//to the client. Give it the connection key from the EPR we got back
        	MessageContext ctxReturn = buildMessageContext();
        	SOAPMessage msgReturn = buildSOAPMessage(connnectionKey);	
        	ctxReturn.setMessage(msgReturn);

        	//Try to retrieve the Connection From the Cache
        	LexEVSApplicationService secureSvc = conManage.getApplicationServiceFromCache(ctxReturn);
        }
        
        //All these connections should be cached
        assertTrue(cache.size() == 10);
	}
	
	public void testRegisterMultipleSecureConnectionsOneGoodOneBad() throws Exception {
		MessageContext ctx = buildUnSecureMessageContextAndMessage();
        
        SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();
        SecureConnectionManager<LexEVSApplicationService> conManage = confactory.getSecureConnectionManager();	

        //Break into the ConnectionManagerImpl to see what's going on...
        SecureConnectionManagerImpl impl = (SecureConnectionManagerImpl)conManage;
        SecureConnectionCache cache = impl.getConnectionCache();
        //Clear the cache to make sure we star fresh for this test
        cache.clear();
        
        //Setup a Good SecurityToken
    	SecurityToken tokenGood = new SecurityToken();
    	tokenGood.setAccessToken(SecurityTestConstants.MEDDRA_TOKEN);
    	
    	//Setup a Bad SecurityToken
    	SecurityToken tokenBad = new SecurityToken();
    	tokenBad.setAccessToken("BADTOKEN");

    	/*
    	 * Build the Good connection
    	 */
        EndpointReferenceType eprGood = conManage.processSecurityToken(ctx, SecurityTestConstants.SECURE_VOCAB, tokenGood);
        //Get the connection key we got back
        String connnectionKeyGood = getConnectionKeyFromEPR(eprGood);

        //Build a new MessageContext from the EPR (this is simulating a return message coming back
        //to the client. Give it the connection key from the EPR we got back
        MessageContext ctxReturnGood = buildMessageContext();
        SOAPMessage msgReturnGood = buildSOAPMessage(connnectionKeyGood);	
        ctxReturnGood.setMessage(msgReturnGood);
        
        /*
    	 * Build the Bad connection
    	 */
        EndpointReferenceType eprBad = conManage.processSecurityToken(ctx, SecurityTestConstants.SECURE_VOCAB, tokenBad);
        //Get the connection key we got back
        String connnectionKeyBad = getConnectionKeyFromEPR(eprBad);

        //Build a new MessageContext from the EPR (this is simulating a return message coming back
        //to the client. Give it the connection key from the EPR we got back
        MessageContext ctxReturnBad = buildMessageContext();
        SOAPMessage msgReturnBad = buildSOAPMessage(connnectionKeyBad);	
        ctxReturnBad.setMessage(msgReturnBad);
        
        //Make sure they both get registered in the cache
        assertTrue(cache.size() == 2);
             
        /*
         * Try them out
         */
        //Request the Good Service
        LexEVSApplicationService goodAppSvc = conManage.getApplicationServiceFromCache(ctxReturnGood);
        //Should be able to connect to a secure vocab
		assertTrue(this.tryToConnectToNonSecuredVocab(goodAppSvc));
		assertTrue(this.tryToConnectToSecuredVocab(goodAppSvc));

		//Request the Bad Service
        LexEVSApplicationService badAppSvc = conManage.getApplicationServiceFromCache(ctxReturnBad);
        //Should NOT be able to connect to a secure vocab
		assertTrue(this.tryToConnectToNonSecuredVocab(badAppSvc));
		assertFalse(this.tryToConnectToSecuredVocab(badAppSvc));
	}
	
	public void testRegisterOverMaxConnections() throws Exception {
		int maxConnections = 5;
		int keepAliveMinutes = 1;

		MessageContext ctx = buildUnSecureMessageContextAndMessage();

		SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();

		//Cast to the Impl - for testing -- don't do this other than for testing purposes!!!!
		//This breaks the generic stuff, so we'll have to cast.
		SecureConnectionManagerImpl conManage = (SecureConnectionManagerImpl)confactory.getSecureConnectionManager();	

		//Give it a connection cache with a max of 5 connections
		SecureConnectionCache cache = new SecureConnectionCache(maxConnections, keepAliveMinutes);
		//Clear the cache to make sure we star fresh for this test
		cache.clear();

		conManage.setConnectionCache(cache);

		//Make sure things are set right
		assertTrue(conManage.getConnectionCache().getMaxEntries() == maxConnections);
		assertTrue(conManage.getConnectionCache().getKeepAliveMinutes() == keepAliveMinutes);

		//Setup SecurityToken
		SecurityToken token = new SecurityToken();
		token.setAccessToken(SecurityTestConstants.MEDDRA_TOKEN);

		//keep track of the order the connections are registered
		HashMap<Integer, String> connectionKeyOrder = new HashMap<Integer, String>();

		for(int i=0;i< 10;i++){       
			EndpointReferenceType epr = conManage.processSecurityToken(ctx, SecurityTestConstants.SECURE_VOCAB, token);
			//Get the connection key we got back
			String connnectionKey = getConnectionKeyFromEPR(epr);

			//put this on the map to keep track of order
			connectionKeyOrder.put(i, connnectionKey);	
		}

		//All these connections should be cached, because it hasn't been a minute.
		assertTrue(cache.size() == 10);

		//Wait one minute to let the connections expire
		long oneMinute = 60000;
		Thread.sleep(oneMinute);

		//All these connections should still be cached, because nobody has tried to register another one.
		assertTrue(cache.size() == 10);    

		//Register another one, and see if it gets rid of the oldest connection
		EndpointReferenceType eprAfterTimeOut = conManage.processSecurityToken(ctx, SecurityTestConstants.SECURE_VOCAB, token);
		String connnectionKey = getConnectionKeyFromEPR(eprAfterTimeOut);

		//put this on the map to keep track of order
		connectionKeyOrder.put(10, connnectionKey);	

		//There still should be 10 cached, but the oldest (the one at the '1' position) should be gone
		assertTrue(cache.size() == 10);

		//Simulate a request for the Expired Connection
		MessageContext ctxReturnExpired = buildMessageContext();
		SOAPMessage msgReturnExpired = buildSOAPMessage(connectionKeyOrder.get(0));	
		ctxReturnExpired.setMessage(msgReturnExpired);

		//Try to retrieve a secure connection that has expired. Should throw a SecureConnectionNotFoundException
		boolean exceptionThrown = false;
		try {
			conManage.getApplicationServiceFromCache(ctxReturnExpired);
		} catch (SecureConnectionNotFoundException e) {
			exceptionThrown = true;
		}
		assertTrue(exceptionThrown);

		//Just to make sure, retrieve the connection we just added
		MessageContext ctxAdded = buildMessageContext();
		SOAPMessage msgAdded = buildSOAPMessage(connectionKeyOrder.get(10));	
		ctxAdded.setMessage(msgAdded);

		LexEVSApplicationService addedSvc = (LexEVSApplicationService)conManage.getApplicationServiceFromCache(ctxAdded);
	
		//Should be able to connect to a secure vocab
		assertTrue(this.tryToConnectToNonSecuredVocab(addedSvc));
		assertTrue(this.tryToConnectToSecuredVocab(addedSvc));
	}
	
	public void testRegisterAndRetrieveMultipleConnectionsWithDifferentTokens() throws Exception {	
		MessageContext ctx = buildUnSecureMessageContextAndMessage();

		SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();
		SecureConnectionManager<LexEVSApplicationService> conManage = confactory.getSecureConnectionManager();	

		//Break into the ConnectionManagerImpl to see what's going on...
		SecureConnectionManagerImpl impl = (SecureConnectionManagerImpl)conManage;
		SecureConnectionCache cache = impl.getConnectionCache();
		//Clear the cache to make sure we star fresh for this test
		cache.clear();

		//keep track of the order the connections are registered
		HashMap<Integer, String> connectionKeyOrder = new HashMap<Integer, String>();

		for(int i=0;i< 10;i++){ 
			//Even numbers get valid tokens, odds do not
			SecurityToken token = null;
			if (i  % 2 == 0){
				token = new SecurityToken();	
				token.setAccessToken(SecurityTestConstants.MEDDRA_TOKEN);
			} else {
				token = new SecurityToken();	
				token.setAccessToken("INVALID_TOKEN");
			}		

			EndpointReferenceType epr = conManage.processSecurityToken(ctx, SecurityTestConstants.SECURE_VOCAB, token);
			//Get the connection key we got back
			String connnectionKey = getConnectionKeyFromEPR(epr);
	
			//put this on the map to keep track of order
			connectionKeyOrder.put(i, connnectionKey);	
		}
		
		//Now Retrieve and check them
		for(int i=0;i< 10;i++){ 
			MessageContext ctxCheck = buildMessageContext();
			SOAPMessage msgCheck = buildSOAPMessage(connectionKeyOrder.get(i));	
			ctxCheck.setMessage(msgCheck);

			LexEVSApplicationService svc = conManage.getApplicationServiceFromCache(ctxCheck);
			
			//Try them
			boolean unsecureCheck = this.tryToConnectToNonSecuredVocab(svc);
			boolean secureCheck = this.tryToConnectToSecuredVocab(svc);
			
			//Unsecured Vocab should always work
			assertTrue(unsecureCheck);
			
			//Even ones (the ones with good tokens) should resolve secure vocabs
			if (i  % 2 == 0){
				assertTrue(secureCheck);
			} else {
				assertFalse(secureCheck);
			}
		}
	}

	public void testRegisterOneConnectionWithMultipleTokens() throws Exception {
		MessageContext ctx = buildUnSecureMessageContextAndMessage();

		SecureConnectionManagerFactory confactory = SecureConnectionManagerFactory.getInstance();

		//Cast to the Impl - for testing -- don't do this other than for testing purposes!!!!
		//This breaks the generic stuff, so we'll have to cast.
		SecureConnectionManagerImpl conManage = (SecureConnectionManagerImpl)confactory.getSecureConnectionManager();	

		SecureConnectionCache cache = conManage.connectionCache;
		//Clear the cache to make sure we star fresh for this test
		cache.clear();

		//Setup SecurityToken
		SecurityToken token = new SecurityToken();
		token.setAccessToken(SecurityTestConstants.MEDDRA_TOKEN);

		//Register another one token for a bogus Vocab
		EndpointReferenceType eprFirstToken = conManage.processSecurityToken(ctx, "BOGUS_VOCAB", token);
		String connnectionKeyFirstToken = getConnectionKeyFromEPR(eprFirstToken);

		//There should be 1 cached
		assertTrue(cache.size() == 1);

		//Simulate a request for the Connection
		MessageContext ctxReturnFirstToken = buildMessageContext();	
		SOAPMessage msgReturnFirstToken = buildSOAPMessage(connnectionKeyFirstToken);	
		ctxReturnFirstToken.setMessage(msgReturnFirstToken);

		LexEVSApplicationService appSvc = (LexEVSApplicationService)conManage.getApplicationServiceFromCache(ctxReturnFirstToken);
		
		//Shouldn't be able to resolve with the bogus token
		assertTrue(this.tryToConnectToNonSecuredVocab(appSvc));
		assertFalse(this.tryToConnectToSecuredVocab(appSvc));
			
		//Simulate another request to set a Valid Vocab token
		EndpointReferenceType eprSecondToken = conManage.processSecurityToken(ctxReturnFirstToken, SecurityTestConstants.SECURE_VOCAB, token);
		String connnectionKeySecondToken = getConnectionKeyFromEPR(eprSecondToken);
		
		//Simulate a request for the Connection
		MessageContext ctxReturnSecondToken = buildMessageContext();	
		SOAPMessage msgReturnSecondToken = buildSOAPMessage(connnectionKeySecondToken);	
		ctxReturnSecondToken.setMessage(msgReturnSecondToken);

		//The connection keys should be reused
		assertTrue(connnectionKeyFirstToken.equals(connnectionKeySecondToken));
		
		//Get the service using the 2nd Token epr
		LexEVSApplicationService appSvcSecondToken = (LexEVSApplicationService)conManage.getApplicationServiceFromCache(ctxReturnSecondToken);
		
		//There should still be only 1 cached
		assertTrue(cache.size() == 1);
		
		//This should use the second token and resolve
		assertTrue(this.tryToConnectToNonSecuredVocab(appSvcSecondToken));
		assertTrue(this.tryToConnectToSecuredVocab(appSvcSecondToken));	
	}
	
	private boolean tryToConnectToNonSecuredVocab(LexEVSDistributed svc){
		try {
			svc.resolveCodingScheme(SecurityTestConstants.UNSECURE_VOCAB, null);
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean tryToConnectToSecuredVocab(LexEVSDistributed svc){
		try {
			svc.resolveCodingScheme(SecurityTestConstants.SECURE_VOCAB, null);
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private SOAPMessage buildSOAPMessage() throws Exception{
		String file = System.getProperty("test.soapMessages") + "/testSOAP.txt";
		MimeHeaders mimeheaders = new MimeHeaders();

        mimeheaders.addHeader("Content-Type", "text/xml");
        InputStream instream = new FileInputStream(file);
        MessageFactory factory =
                MessageFactory.newInstance();
        SOAPMessage msg =
                factory.createMessage(mimeheaders, instream);
        
        return msg;
	}
	
	private SOAPMessage buildSOAPMessage(String connectionKey) throws Exception{
		String fileName = System.getProperty("test.soapMessages") + "/testSOAP_Secure.txt";
		File file = new File(fileName);
		MimeHeaders mimeheaders = new MimeHeaders();

		String soapString = FileUtils.readFileToString(file);
		
		soapString = soapString.replaceAll(CON_KEY_PLACEHOLDER, connectionKey);
		
		byte bytes[] = soapString.getBytes();
		InputStream instream = new ByteArrayInputStream(bytes); 
        
        mimeheaders.addHeader("Content-Type", "text/xml");
       
        MessageFactory factory =
                MessageFactory.newInstance();
        SOAPMessage msg =
                factory.createMessage(mimeheaders, instream);
        
        return msg;
	}
	
	private MessageContext buildMessageContext(){
		MessageContext ctx = new MessageContext(new AxisClient());
		ctx.setProperty(org.apache.axis.MessageContext.TRANS_URL, "http://my.testing.url.edu");
		return ctx;
	}
	
	private String getConnectionKeyFromEPR(EndpointReferenceType epr){
		ReferencePropertiesType rpt = epr.getProperties();
		MessageElement me = rpt.get(SecureConnectionManager.CONNECTION_QNAME);
		return me.getValue();
	}
	
	private MessageContext buildUnSecureMessageContextAndMessage() throws Exception {
		MessageContext ctx = buildMessageContext();
		ctx.setMessage(buildSOAPMessage());
		return ctx;
	}
	
}
