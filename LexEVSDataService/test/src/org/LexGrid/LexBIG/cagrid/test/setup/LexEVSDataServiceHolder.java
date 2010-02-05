package org.LexGrid.LexBIG.cagrid.test.setup;

import org.LexGrid.LexBIG.cagrid.dataService.client.LexEVSDataServiceClient;

import gov.nih.nci.cagrid.data.client.DataServiceClient;

public class LexEVSDataServiceHolder {
    private static LexEVSDataServiceHolder sh_;
	private static final String serviceUrl = ServiceTestCase.serviceUrl;
	private LexEVSDataServiceClient service;
	private DataServiceClient standardService;
	
    /**
     * Use this to get an instance of the ServiceHolder. If 'configureForSingleConfig' has not been called,
     * this will run the tests on all configured databases in the testConfig.props file.
     * 
     * @return the EVS query service holder
     */
    public static LexEVSDataServiceHolder instance()
    {
        if (sh_ == null)
        {
            //throw new RuntimeException("ServiceHolder has not been configured");
            configure();
        }
        return sh_;

    }


	/**
	 * Use this to set up the tests for end user enviroment validation. Only runs the tests once, using their
	 * normal config file.
	 * 
	 */
	private static void configure()
	{

		sh_ = new LexEVSDataServiceHolder();

	}
	
	/**
	 * Instantiates a new eVS query service holder.
	 * 
	 */
	private LexEVSDataServiceHolder()
	{
		try{
			service = new LexEVSDataServiceClient(serviceUrl);
			standardService = new DataServiceClient(serviceUrl);
		}
		catch (Exception e)
		{
			System.err.println("Problem initiating Test config");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	/**
	 * Gets the uRL.
	 * 
	 * @return the uRL
	 */
	public static String getURL()
	{
		return serviceUrl;
	}
	
	/**
	 * Gets the app service.
	 * 
	 * @return an instance of the app service
	 */
	public LexEVSDataServiceClient getLexEVSAppService()
	{
		return service;
	}


	public DataServiceClient getStandardService() {
		return standardService;
	}


}
