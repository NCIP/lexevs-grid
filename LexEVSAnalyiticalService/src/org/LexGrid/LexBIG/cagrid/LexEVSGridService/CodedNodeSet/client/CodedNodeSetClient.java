package org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.client;

import java.io.InputStream;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Stub;
import org.apache.axis.configuration.FileProvider;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

import org.oasis.wsrf.properties.GetResourcePropertyResponse;

import org.globus.gsi.GlobusCredential;

import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.CodedNodeSetPortType;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.service.CodedNodeSetServiceAddressingLocator;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.common.CodedNodeSetI;
import gov.nih.nci.cagrid.introduce.security.client.ServiceSecurityClient;

/**
 * This class is autogenerated, DO NOT EDIT GENERATED GRID SERVICE ACCESS METHODS.
 *
 * This client is generated automatically by Introduce to provide a clean unwrapped API to the
 * service.
 *
 * On construction the class instance will contact the remote service and retrieve it's security
 * metadata description which it will use to configure the Stub specifically for each method call.
 * 
 * @created by Introduce Toolkit version 1.3
 */
public class CodedNodeSetClient extends CodedNodeSetClientBase implements CodedNodeSetI {	

	public CodedNodeSetClient(String url) throws MalformedURIException, RemoteException {
		this(url,null);	
	}

	public CodedNodeSetClient(String url, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(url,proxy);
	}
	
	public CodedNodeSetClient(EndpointReferenceType epr) throws MalformedURIException, RemoteException {
	   	this(epr,null);
	}
	
	public CodedNodeSetClient(EndpointReferenceType epr, GlobusCredential proxy) throws MalformedURIException, RemoteException {
	   	super(epr,proxy);
	}

	public static void usage(){
		System.out.println(CodedNodeSetClient.class.getName() + " -url <service url>");
	}
	
	public static void main(String [] args){
	    System.out.println("Running the Grid Service Client");
		try{
		if(!(args.length < 2)){
			if(args[0].equals("-url")){
			  CodedNodeSetClient client = new CodedNodeSetClient(args[1]);
			  // place client calls here if you want to use this main as a
			  // test....
			} else {
				usage();
				System.exit(1);
			}
		} else {
			usage();
			System.exit(1);
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

  public org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList resolveToList(org.LexGrid.LexBIG.DataModel.cagrid.SetResolutionPolicy setResolutionPolicy) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"resolveToList");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveToListRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveToListRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveToListRequestSetResolutionPolicy setResolutionPolicyContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveToListRequestSetResolutionPolicy();
    setResolutionPolicyContainer.setSetResolutionPolicy(setResolutionPolicy);
    params.setSetResolutionPolicy(setResolutionPolicyContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveToListResponse boxedResult = portType.resolveToList(params);
    return boxedResult.getResolvedConceptReferenceList();
    }
  }

  public void restrictToCodes(org.LexGrid.LexBIG.DataModel.Collections.ConceptReferenceList codeList) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"restrictToCodes");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToCodesRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToCodesRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToCodesRequestCodeList codeListContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToCodesRequestCodeList();
    codeListContainer.setConceptReferenceList(codeList);
    params.setCodeList(codeListContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToCodesResponse boxedResult = portType.restrictToCodes(params);
    }
  }

  public org.LexGrid.LexBIG.DataModel.cagrid.CodeExistence isCodeInSet(org.LexGrid.LexBIG.DataModel.Core.ConceptReference code) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"isCodeInSet");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IsCodeInSetRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IsCodeInSetRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IsCodeInSetRequestCode codeContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IsCodeInSetRequestCode();
    codeContainer.setConceptReference(code);
    params.setCode(codeContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IsCodeInSetResponse boxedResult = portType.isCodeInSet(params);
    return boxedResult.getCodeExistence();
    }
  }

  public void restrictToMatchingDesignations(org.LexGrid.LexBIG.DataModel.cagrid.MatchCriteria matchCriteria,org.LexGrid.LexBIG.DataModel.enums.SearchDesignationOption searchDesignationOption,org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification extensionIdentification,org.LexGrid.LexBIG.DataModel.cagrid.LanguageIdentification languageIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"restrictToMatchingDesignations");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequestMatchCriteria matchCriteriaContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequestMatchCriteria();
    matchCriteriaContainer.setMatchCriteria(matchCriteria);
    params.setMatchCriteria(matchCriteriaContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequestSearchDesignationOption searchDesignationOptionContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequestSearchDesignationOption();
    searchDesignationOptionContainer.setSearchDesignationOption(searchDesignationOption);
    params.setSearchDesignationOption(searchDesignationOptionContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequestExtensionIdentification extensionIdentificationContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequestExtensionIdentification();
    extensionIdentificationContainer.setExtensionIdentification(extensionIdentification);
    params.setExtensionIdentification(extensionIdentificationContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequestLanguageIdentification languageIdentificationContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsRequestLanguageIdentification();
    languageIdentificationContainer.setLanguageIdentification(languageIdentification);
    params.setLanguageIdentification(languageIdentificationContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingDesignationsResponse boxedResult = portType.restrictToMatchingDesignations(params);
    }
  }

  public org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.client.ResolvedConceptReferencesIteratorClient resolve(org.LexGrid.LexBIG.DataModel.cagrid.SetResolutionPolicy setResolutionPolicy) throws RemoteException, org.apache.axis.types.URI.MalformedURIException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"resolve");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveRequestSetResolutionPolicy setResolutionPolicyContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveRequestSetResolutionPolicy();
    setResolutionPolicyContainer.setSetResolutionPolicy(setResolutionPolicy);
    params.setSetResolutionPolicy(setResolutionPolicyContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.ResolveResponse boxedResult = portType.resolve(params);
    EndpointReferenceType ref = boxedResult.getResolvedConceptReferencesIteratorReference().getEndpointReference();
    return new org.LexGrid.LexBIG.cagrid.LexEVSGridService.ResolvedConceptReferencesIterator.client.ResolvedConceptReferencesIteratorClient(ref,getProxy());
    }
  }

  public void restrictToStatus(org.LexGrid.LexBIG.DataModel.enums.ActiveOption activeOption,org.LexGrid.LexBIG.DataModel.cagrid.Status[] status) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"restrictToStatus");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToStatusRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToStatusRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToStatusRequestActiveOption activeOptionContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToStatusRequestActiveOption();
    activeOptionContainer.setActiveOption(activeOption);
    params.setActiveOption(activeOptionContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToStatusRequestStatus statusContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToStatusRequestStatus();
    statusContainer.setStatus(status);
    params.setStatus(statusContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToStatusResponse boxedResult = portType.restrictToStatus(params);
    }
  }

  public void intersect(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"intersect");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IntersectRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IntersectRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IntersectRequestCodes codesContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IntersectRequestCodes();
    codesContainer.setCodedNodeSetReference(codes);
    params.setCodes(codesContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.IntersectResponse boxedResult = portType.intersect(params);
    }
  }

  public void union(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"union");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.UnionRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.UnionRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.UnionRequestCodes codesContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.UnionRequestCodes();
    codesContainer.setCodedNodeSetReference(codes);
    params.setCodes(codesContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.UnionResponse boxedResult = portType.union(params);
    }
  }

  public void difference(org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference codes) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"difference");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.DifferenceRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.DifferenceRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.DifferenceRequestCodes codesContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.DifferenceRequestCodes();
    codesContainer.setCodedNodeSetReference(codes);
    params.setCodes(codesContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.DifferenceResponse boxedResult = portType.difference(params);
    }
  }

  public void restrictToProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList propertyList,org.LexGrid.LexBIG.DataModel.enums.PropertyType[] propertyType,org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList2,org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList3,org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList nameAndValueList) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"restrictToProperties");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestPropertyList propertyListContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestPropertyList();
    propertyListContainer.setLocalNameList(propertyList);
    params.setPropertyList(propertyListContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestPropertyType propertyTypeContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestPropertyType();
    propertyTypeContainer.setPropertyType(propertyType);
    params.setPropertyType(propertyTypeContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestLocalNameList2 localNameList2Container = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestLocalNameList2();
    localNameList2Container.setLocalNameList(localNameList2);
    params.setLocalNameList2(localNameList2Container);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestLocalNameList3 localNameList3Container = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestLocalNameList3();
    localNameList3Container.setLocalNameList(localNameList3);
    params.setLocalNameList3(localNameList3Container);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestNameAndValueList nameAndValueListContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesRequestNameAndValueList();
    nameAndValueListContainer.setNameAndValueList(nameAndValueList);
    params.setNameAndValueList(nameAndValueListContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToPropertiesResponse boxedResult = portType.restrictToProperties(params);
    }
  }

  public void restrictToMatchingProperties(org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList,org.LexGrid.LexBIG.DataModel.enums.PropertyType[] propertyType,org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList2,org.LexGrid.LexBIG.DataModel.Collections.LocalNameList localNameList3,org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList nameAndValueList,org.LexGrid.LexBIG.DataModel.cagrid.MatchCriteria matchCriteria,org.LexGrid.LexBIG.DataModel.cagrid.ExtensionIdentification extensionIdentification,org.LexGrid.LexBIG.DataModel.cagrid.LanguageIdentification languageIdentification) throws RemoteException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException, org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"restrictToMatchingProperties");
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequest params = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequest();
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestLocalNameList localNameListContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestLocalNameList();
    localNameListContainer.setLocalNameList(localNameList);
    params.setLocalNameList(localNameListContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestPropertyType propertyTypeContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestPropertyType();
    propertyTypeContainer.setPropertyType(propertyType);
    params.setPropertyType(propertyTypeContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestLocalNameList2 localNameList2Container = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestLocalNameList2();
    localNameList2Container.setLocalNameList(localNameList2);
    params.setLocalNameList2(localNameList2Container);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestLocalNameList3 localNameList3Container = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestLocalNameList3();
    localNameList3Container.setLocalNameList(localNameList3);
    params.setLocalNameList3(localNameList3Container);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestNameAndValueList nameAndValueListContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestNameAndValueList();
    nameAndValueListContainer.setNameAndValueList(nameAndValueList);
    params.setNameAndValueList(nameAndValueListContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestMatchCriteria matchCriteriaContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestMatchCriteria();
    matchCriteriaContainer.setMatchCriteria(matchCriteria);
    params.setMatchCriteria(matchCriteriaContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestExtensionIdentification extensionIdentificationContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestExtensionIdentification();
    extensionIdentificationContainer.setExtensionIdentification(extensionIdentification);
    params.setExtensionIdentification(extensionIdentificationContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestLanguageIdentification languageIdentificationContainer = new org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesRequestLanguageIdentification();
    languageIdentificationContainer.setLanguageIdentification(languageIdentification);
    params.setLanguageIdentification(languageIdentificationContainer);
    org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.RestrictToMatchingPropertiesResponse boxedResult = portType.restrictToMatchingProperties(params);
    }
  }

  public org.oasis.wsrf.lifetime.DestroyResponse destroy(org.oasis.wsrf.lifetime.Destroy params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"destroy");
    return portType.destroy(params);
    }
  }

  public org.oasis.wsrf.lifetime.SetTerminationTimeResponse setTerminationTime(org.oasis.wsrf.lifetime.SetTerminationTime params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"setTerminationTime");
    return portType.setTerminationTime(params);
    }
  }

  public org.oasis.wsrf.properties.GetMultipleResourcePropertiesResponse getMultipleResourceProperties(org.oasis.wsrf.properties.GetMultipleResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getMultipleResourceProperties");
    return portType.getMultipleResourceProperties(params);
    }
  }

  public org.oasis.wsrf.properties.GetResourcePropertyResponse getResourceProperty(javax.xml.namespace.QName params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"getResourceProperty");
    return portType.getResourceProperty(params);
    }
  }

  public org.oasis.wsrf.properties.QueryResourcePropertiesResponse queryResourceProperties(org.oasis.wsrf.properties.QueryResourceProperties_Element params) throws RemoteException {
    synchronized(portTypeMutex){
      configureStubSecurity((Stub)portType,"queryResourceProperties");
    return portType.queryResourceProperties(params);
    }
  }

}
