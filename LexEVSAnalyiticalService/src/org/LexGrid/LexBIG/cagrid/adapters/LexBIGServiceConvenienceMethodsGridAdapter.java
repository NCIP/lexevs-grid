/*******************************************************************************
 * Copyright: (c) 2004-2007 Mayo Foundation for Medical Education and 
 * Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 * 
 * Except as contained in the copyright notice above, or as used to identify 
 * MFMER as the author of this software, the trade names, trademarks, service
 * marks, or product names of the copyright holder shall not be used in
 * advertising, promotion or otherwise in connection with this software without
 * prior written authorization of the copyright holder.
 *   
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *   
 *  		http://www.eclipse.org/legal/epl-v10.html
 * 
 *  		
 *******************************************************************************/
package org.LexGrid.LexBIG.cagrid.adapters;

import java.rmi.RemoteException;

import org.LexGrid.LexBIG.iso21090.DataModel.Collections.AssociationList;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.CodingSchemeRenderingList;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.iso21090.DataModel.Core.CodingSchemeVersionOrTag;
import org.LexGrid.LexBIG.iso21090.DataModel.InterfaceElements.CodingSchemeRendering;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.AssociationIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeState;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeCopyRight;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ConceptIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.Direction;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.DirectionalAssociationIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.HierarchyResolutionPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.enums.HierarchyPathResolveOption;
import org.LexGrid.LexBIG.Extensions.Generic.GenericExtension;
import org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.client.CodedNodeSetClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.LexBIGServiceConvenienceMethods.client.LexBIGServiceConvenienceMethodsClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBException;
import org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid;
import org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid;
import org.apache.axis.types.URI.MalformedURIException;

public class LexBIGServiceConvenienceMethodsGridAdapter implements
		LexBIGServiceConvenienceMethodsGrid, GenericExtension {

private LexBIGServiceConvenienceMethodsClient lbscm;
	
	public LexBIGServiceConvenienceMethodsGridAdapter(LexBIGServiceConvenienceMethodsClient client) throws RemoteException {
		lbscm = client;
	}
	
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#createCodeNodeSet(org.LexGrid.LexBIG.DataModel.cagrid.ConceptIdentification[], org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public CodedNodeSetGrid createCodeNodeSet(ConceptIdentification[] conceptCodes,
			CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag)
			throws LBException, InvalidServiceContextAccess, RemoteException {
			try {
				CodedNodeSetClient client = lbscm.createCodeNodeSet(conceptCodes, codingScheme, versionOrTag);
				CodedNodeSetGridAdapter adapter = new CodedNodeSetGridAdapter(client);
				return adapter;
			} catch (MalformedURIException e) {
				throw new RemoteException(e.getMessage(), e);
			}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getAssociationForwardAndReverseNames(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public AssociationIdentification[] getAssociationForwardAndReverseNames(
			CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag)
			throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getAssociationForwardAndReverseNames(codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getAssociationForwardName(org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification, org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public DirectionalAssociationIdentification getAssociationForwardName(
			AssociationIdentification association, CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getAssociationForwardName(association, codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getAssociationForwardNames(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public DirectionalAssociationIdentification[] getAssociationForwardNames(
			CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag)
			throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getAssociationForwardNames(codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getAssociationReverseName(org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification, org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public DirectionalAssociationIdentification getAssociationReverseName(
			AssociationIdentification association, CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getAssociationReverseName(association, codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getAssociationReverseNames(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public DirectionalAssociationIdentification[] getAssociationReverseNames(
			CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag)
			throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getAssociationReverseNames(codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getCodingSchemesWithSupportedAssociation(org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification)
	 */
	public CodingSchemeRenderingList getCodingSchemesWithSupportedAssociation(
			AssociationIdentification associationName) throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getCodingSchemesWithSupportedAssociation(associationName);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getHierarchyIDs(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public HierarchyIdentification[] getHierarchyIDs(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getHierarchyIDs(codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getHierarchyLevelNext(org.LexGrid.LexBIG.DataModel.cagrid.HierarchyResolutionPolicy, org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public AssociationList getHierarchyLevelNext(HierarchyResolutionPolicy policy, CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getHierarchyLevelNext(policy, codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getHierarchyLevelPrev(org.LexGrid.LexBIG.DataModel.cagrid.HierarchyResolutionPolicy, org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public AssociationList getHierarchyLevelPrev(HierarchyResolutionPolicy policy, CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getHierarchyLevelPrev(policy, codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getHierarchyPathToRoot(org.LexGrid.LexBIG.DataModel.cagrid.HierarchyResolutionPolicy, org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag, org.LexGrid.LexBIG.DataModel.enums.HierarchyPathResolveOption)
	 */
	public AssociationList getHierarchyPathToRoot(
			HierarchyResolutionPolicy policy, CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag, HierarchyPathResolveOption resolveOption) throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getHierarchyPathToRoot(policy, codingScheme, versionOrTag, resolveOption);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getHierarchyRootSet(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag, org.LexGrid.LexBIG.DataModel.cagrid.HierarchyIdentification)
	 */
	public CodedNodeSetGrid getHierarchyRootSet(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag, HierarchyIdentification hierarchyID)
			throws LBException, InvalidServiceContextAccess, RemoteException {
			try {
				CodedNodeSetClient client = lbscm.getHierarchyRootSet(codingScheme, versionOrTag, hierarchyID);
				CodedNodeSetGridAdapter adapter = new CodedNodeSetGridAdapter(client);
				return adapter;
			} catch (MalformedURIException e) {
				throw new RemoteException(e.getMessage(), e);
			}
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getHierarchyRoots(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag, org.LexGrid.LexBIG.DataModel.cagrid.HierarchyIdentification)
	 */
	public ResolvedConceptReferenceList getHierarchyRoots(
			CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag, HierarchyIdentification hierarchyID)
			throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getHierarchyRoots(codingScheme, versionOrTag, hierarchyID);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getRenderingDetail(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public CodingSchemeRendering getRenderingDetail(
			CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag)
			throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.getRenderingDetail(codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#isCodeRetired(org.LexGrid.LexBIG.DataModel.cagrid.ConceptIdentification, org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public CodeState isCodeRetired(ConceptIdentification conceptCode,
			CodingSchemeIdentification codingScheme, CodingSchemeVersionOrTag versionOrTag)
			throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.isCodeRetired(conceptCode, codingScheme, versionOrTag);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#isForwardName(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag, org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification)
	 */
	public Direction isForwardName(
			CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag,
			AssociationIdentification directionalName) throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.isForwardName(codingScheme, versionOrTag, directionalName);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#isReverseName(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag, org.LexGrid.LexBIG.DataModel.cagrid.AssociationIdentification)
	 */
	public Direction isReverseName(
			CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag,
			AssociationIdentification directionalName) throws LBException, InvalidServiceContextAccess, RemoteException {
			return lbscm.isReverseName(codingScheme, versionOrTag, directionalName);
	}
	
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.LexBIGServiceConvenienceMethodsGrid#getCodingSchemeCopyright(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification, org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag)
	 */
	public CodingSchemeCopyRight getCodingSchemeCopyright(CodingSchemeIdentification codingScheme,
			CodingSchemeVersionOrTag versionOrTag) throws LBException, InvalidServiceContextAccess, RemoteException {
				return lbscm.getCodingSchemeCopyright(codingScheme, 
						versionOrTag);
	}

	public String getDescription() {
		throw new RuntimeException("Not a valid Grid Service Call");
	}

	public String getName() {
		throw new RuntimeException("Not a valid Grid Service Call");
	}

	public String getProvider() {
		throw new RuntimeException("Not a valid Grid Service Call");
	}

	public String getVersion() {
		throw new RuntimeException("Not a valid Grid Service Call");
	}

	public LexBIGServiceConvenienceMethods getLexBIGServiceConvenienceMethodsInterface() throws Exception {
		return new LexBIGServiceConvenienceMethodsAdapter(this);
	}

}
