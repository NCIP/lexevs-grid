/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.adapters;

import java.rmi.RemoteException;
import java.util.List;

import org.LexGrid.LexBIG.LexBIGService.CodedNodeGraph;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.client.CodedNodeGraphClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeGraph.stubs.types.CodedNodeGraphReference;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.client.CodedNodeSetClient;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.CodedNodeSet.stubs.types.CodedNodeSetReference;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException;
import org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid;
import org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.ConceptReferenceList;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.NameAndValueList;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.iso21090.DataModel.Core.ConceptReference;
import org.LexGrid.LexBIG.iso21090.DataModel.Core.NameAndValue;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeExistence;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodeRelationship;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.CodingSchemeIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.GraphResolutionPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.NodeListPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationshipDistanceBasedPolicy;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.RelationshipTypeBasedPolicy;
import org.apache.axis.message.addressing.EndpointReferenceType;
import org.apache.axis.types.URI.MalformedURIException;

/**
 * @author m005256
 *
 */
public class CodedNodeGraphGridAdapter implements CodedNodeGraphGrid {

	private CodedNodeGraphClient cng;
	
	public CodedNodeGraphGridAdapter(CodedNodeGraphClient client) throws MalformedURIException, RemoteException {
		cng = client;
	}
	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#areCodesRelated(org.LexGrid.LexBIG.DataModel.cagrid.RelationshipTypeBasedPolicy, org.LexGrid.LexBIG.DataModel.Core.NameAndValue)
	 */
	public CodeRelationship areCodesRelated(RelationshipTypeBasedPolicy policy, NameAndValue nameAndValue)
			throws LBInvocationException, LBParameterException, RemoteException {
			return cng.areCodesRelated(policy, nameAndValue);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#intersect(org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid)
	 */
	public CodedNodeGraphGrid intersect(CodedNodeGraphGrid graph)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			CodedNodeGraphGridAdapter cnga = (CodedNodeGraphGridAdapter) graph;
			CodedNodeGraphReference cngr = new CodedNodeGraphReference(cnga
					.getEndpointReference());
			cng.intersect(cngr);
		return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#isCodeInGraph(org.LexGrid.LexBIG.DataModel.Core.ConceptReference)
	 */
	public CodeExistence isCodeInGraph(ConceptReference code)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			return cng.isCodeInGraph(code);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#listCodeRelationships(org.LexGrid.LexBIG.DataModel.cagrid.RelationshipTypeBasedPolicy)
	 */
	public List<String> listCodeRelationships(RelationshipTypeBasedPolicy policy)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#resolveAsList(org.LexGrid.LexBIG.DataModel.cagrid.GraphResolutionPolicy)
	 */
	public ResolvedConceptReferenceList resolveAsList(GraphResolutionPolicy policy)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			return cng.resolveAsList(policy);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#restrictToAssociations(org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList)
	 */
	public CodedNodeGraphGrid restrictToAssociations(NameAndValueList association,
			NameAndValueList associationQualifiers)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			cng.restrictToAssociations(association, associationQualifiers);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#restrictToCodeSystem(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification)
	 */
	public CodedNodeGraphGrid restrictToCodeSystem(CodingSchemeIdentification codingScheme)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			cng.restrictToCodeSystem(codingScheme);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#restrictToCodes(org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid)
	 */
	public CodedNodeGraphGrid restrictToCodes(CodedNodeSetGrid codes)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			CodedNodeSetGridAdapter cnsga = (CodedNodeSetGridAdapter) codes;
			CodedNodeSetReference cnsr = new CodedNodeSetReference(cnsga
					.getEndpointReference());
			cng.restrictToCodes(cnsr);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#restrictToDirectionalNames(org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList, org.LexGrid.LexBIG.DataModel.Collections.NameAndValueList)
	 */
	public CodedNodeGraphGrid restrictToDirectionalNames(
			NameAndValueList directionalNames,
			NameAndValueList associationQualifiers)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			cng.restrictToDirectionalNames(directionalNames, associationQualifiers);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#restrictToSourceCodeSystem(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification)
	 */
	public CodedNodeGraphGrid restrictToSourceCodeSystem(
			CodingSchemeIdentification codingScheme) throws LBInvocationException,
			LBParameterException,InvalidServiceContextAccess, RemoteException {
				cng.restrictToSourceCodeSystem(codingScheme);
				return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#restrictToSourceCodes(org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid)
	 */
	public CodedNodeGraphGrid restrictToSourceCodes(CodedNodeSetGrid codes)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			CodedNodeSetGridAdapter cnsa = (CodedNodeSetGridAdapter) codes;
			CodedNodeSetReference cnsr = new CodedNodeSetReference(cnsa
					.getEndpointReference());
			cng.restrictToSourceCodes(cnsr);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#restrictToTargetCodeSystem(org.LexGrid.LexBIG.DataModel.cagrid.CodingSchemeIdentification)
	 */
	public CodedNodeGraphGrid restrictToTargetCodeSystem(
			CodingSchemeIdentification codingScheme) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException {
			cng.restrictToTargetCodeSystem(codingScheme);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#restrictToTargetCodes(org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeSetGrid)
	 */
	public CodedNodeGraphGrid restrictToTargetCodes(CodedNodeSetGrid codes)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			CodedNodeSetGridAdapter cnsga = (CodedNodeSetGridAdapter) codes;
			CodedNodeSetReference cnsr = new CodedNodeSetReference(cnsga
					.getEndpointReference());
			cng.restrictToTargetCodes(cnsr);
			return this;
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#toNodeList(org.LexGrid.LexBIG.DataModel.cagrid.NodeListPolicy)
	 */
	public CodedNodeSetGrid toNodeList(NodeListPolicy policy) throws LBInvocationException,
			LBParameterException, InvalidServiceContextAccess, RemoteException {
			CodedNodeSetClient client;
			try {
				client = cng.toNodeList(policy);
			} catch (MalformedURIException e) {
				throw new RemoteException(e.getMessage(), e);
			}
			return new CodedNodeSetGridAdapter(client);
	}

	/* (non-Javadoc)
	 * @see org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid#union(org.LexGrid.LexBIG.cagrid.interfaces.CodedNodeGraphGrid)
	 */
	public CodedNodeGraphGrid union(CodedNodeGraphGrid graph)
			throws LBInvocationException, LBParameterException, InvalidServiceContextAccess, RemoteException {
			CodedNodeGraphGridAdapter cnga = (CodedNodeGraphGridAdapter) graph;
			CodedNodeGraphReference cngr = new CodedNodeGraphReference(cnga
					.getEndpointReference());
			cng.union(cngr);
			return this;
	}

	public CodedNodeGraph getCodedNodeGraphInterface() throws Exception {
		return new CodedNodeGraphAdapter(this);
	}
	
	public EndpointReferenceType getEndpointReference(){
		return cng.getEndpointReference();
	}
	@Override
	public ConceptReferenceList listCodeRelationships(
			RelationshipDistanceBasedPolicy policy)
			throws LBInvocationException, LBParameterException,
			InvalidServiceContextAccess, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
