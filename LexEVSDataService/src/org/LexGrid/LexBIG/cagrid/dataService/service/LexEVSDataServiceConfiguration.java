package org.LexGrid.LexBIG.cagrid.dataService.service;

import gov.nih.nci.cagrid.introduce.servicetools.ServiceConfiguration;

import org.globus.wsrf.config.ContainerConfig;
import java.io.File;
import javax.naming.InitialContext;

import org.apache.axis.MessageContext;
import org.globus.wsrf.Constants;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 * 
 * This class holds all service properties which were defined for the service to have
 * access to.
 * 
 * @created by Introduce Toolkit version 1.3
 * 
 */
public class LexEVSDataServiceConfiguration implements ServiceConfiguration {

	public static LexEVSDataServiceConfiguration  configuration = null;
    public String etcDirectoryPath;
    	
	public static LexEVSDataServiceConfiguration getConfiguration() throws Exception {
		if (LexEVSDataServiceConfiguration.configuration != null) {
			return LexEVSDataServiceConfiguration.configuration;
		}
		MessageContext ctx = MessageContext.getCurrentContext();

		String servicePath = ctx.getTargetService();

		String jndiName = Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/serviceconfiguration";
		try {
			javax.naming.Context initialContext = new InitialContext();
			LexEVSDataServiceConfiguration.configuration = (LexEVSDataServiceConfiguration) initialContext.lookup(jndiName);
		} catch (Exception e) {
			throw new Exception("Unable to instantiate service configuration.", e);
		}

		return LexEVSDataServiceConfiguration.configuration;
	}
	

	
	private String queryProcessorClass;
	
	private String serverConfigLocation;
	
	private String dataService_cqlValidatorClass;
	
	private String dataService_domainModelValidatorClass;
	
	private String dataService_validateCqlFlag;
	
	private String dataService_validateDomainModelFlag;
	
	private String dataService_classMappingsFilename;
	
	
    public String getEtcDirectoryPath() {
		return ContainerConfig.getBaseDirectory() + File.separator + etcDirectoryPath;
	}
	
	public void setEtcDirectoryPath(String etcDirectoryPath) {
		this.etcDirectoryPath = etcDirectoryPath;
	}


	
	public String getQueryProcessorClass() {
		return queryProcessorClass;
	}
	
	
	public void setQueryProcessorClass(String queryProcessorClass) {
		this.queryProcessorClass = queryProcessorClass;
	}

	
	public String getServerConfigLocation() {
		return ContainerConfig.getBaseDirectory() + File.separator + serverConfigLocation;
	}
	
	
	public void setServerConfigLocation(String serverConfigLocation) {
		this.serverConfigLocation = serverConfigLocation;
	}

	
	public String getDataService_cqlValidatorClass() {
		return dataService_cqlValidatorClass;
	}
	
	
	public void setDataService_cqlValidatorClass(String dataService_cqlValidatorClass) {
		this.dataService_cqlValidatorClass = dataService_cqlValidatorClass;
	}

	
	public String getDataService_domainModelValidatorClass() {
		return dataService_domainModelValidatorClass;
	}
	
	
	public void setDataService_domainModelValidatorClass(String dataService_domainModelValidatorClass) {
		this.dataService_domainModelValidatorClass = dataService_domainModelValidatorClass;
	}

	
	public String getDataService_validateCqlFlag() {
		return dataService_validateCqlFlag;
	}
	
	
	public void setDataService_validateCqlFlag(String dataService_validateCqlFlag) {
		this.dataService_validateCqlFlag = dataService_validateCqlFlag;
	}

	
	public String getDataService_validateDomainModelFlag() {
		return dataService_validateDomainModelFlag;
	}
	
	
	public void setDataService_validateDomainModelFlag(String dataService_validateDomainModelFlag) {
		this.dataService_validateDomainModelFlag = dataService_validateDomainModelFlag;
	}

	
	public String getDataService_classMappingsFilename() {
		return ContainerConfig.getBaseDirectory() + File.separator + dataService_classMappingsFilename;
	}
	
	
	public void setDataService_classMappingsFilename(String dataService_classMappingsFilename) {
		this.dataService_classMappingsFilename = dataService_classMappingsFilename;
	}

	
}
