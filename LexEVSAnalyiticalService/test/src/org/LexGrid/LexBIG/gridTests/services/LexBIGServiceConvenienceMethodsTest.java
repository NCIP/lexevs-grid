/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests.services;

import java.util.Arrays;

import org.LexGrid.LexBIG.DataModel.Collections.AssociationList;
import org.LexGrid.LexBIG.DataModel.Collections.CodingSchemeRenderingList;
import org.LexGrid.LexBIG.DataModel.Collections.ResolvedConceptReferenceList;
import org.LexGrid.LexBIG.DataModel.Core.Association;
import org.LexGrid.LexBIG.DataModel.Core.CodingSchemeVersionOrTag;
import org.LexGrid.LexBIG.DataModel.Core.ResolvedConceptReference;
import org.LexGrid.LexBIG.DataModel.InterfaceElements.CodingSchemeRendering;
import org.LexGrid.LexBIG.Exceptions.LBException;
import org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods;
import org.LexGrid.LexBIG.Extensions.Generic.LexBIGServiceConvenienceMethods.HierarchyPathResolveOption;
import org.LexGrid.LexBIG.LexBIGService.CodedNodeSet;
import org.LexGrid.LexBIG.LexBIGService.LexBIGService;
import org.LexGrid.LexBIG.gridTests.LexBIGServiceTestCase;
import org.LexGrid.LexBIG.gridTests.testUtility.ServiceHolder;
import org.apache.commons.lang.ArrayUtils;

public class LexBIGServiceConvenienceMethodsTest extends LexBIGServiceTestCase {
	LexBIGService lbs;
	LexBIGServiceConvenienceMethods lbscm;
	CodingSchemeVersionOrTag csvt;
	CodingSchemeVersionOrTag csvt1;
	
	@Override
	protected String getTestID() {
		return this.getClass().getName();
	}
	
	public void setUp(){
		lbs = ServiceHolder.instance().getLexBIGService();

		try {
			lbscm = (LexBIGServiceConvenienceMethods)lbs.getGenericExtension("LexBIGServiceConvenienceMethods");
			lbscm.setLexBIGService(lbs);
		} catch (LBException e) {
			e.printStackTrace();
			fail();
		}
		
		csvt = new CodingSchemeVersionOrTag();
		csvt1 = new CodingSchemeVersionOrTag();
		csvt.setVersion(LexBIGServiceTestCase.THES_VERSION);
		csvt1.setVersion(LexBIGServiceTestCase.GO_VERSION);
	}
	public void testConnect(){
		assertNotNull(lbs);	
	}

	public void testCreateCodeNodeSet() throws Exception {
		String[] codes = {"C53276", "C12907"};
		CodedNodeSet cns = lbscm.createCodeNodeSet(codes, THES_SCHEME, csvt);
		ResolvedConceptReferenceList rcrl = cns.resolveToList(null, null, null, -1);
		ResolvedConceptReference[] rcr = rcrl.getResolvedConceptReference();
		assertTrue(rcr.length == 2);
		
		for (int i = 0; i < rcr.length; i++) {
			assertTrue(rcr[i].getConceptCode().equals("C53276") || rcr[i].getConceptCode().equals("C12907"));
		}
	}

	public void testGetAssociationForwardName() throws Exception {
		String name = lbscm.getAssociationForwardName("disjointWith", THES_SCHEME, csvt);
		assertTrue(name.equals("disjointWith"));
	
	}

	public void testGetHierarchyIDs() throws Exception {
		String[] ids = lbscm.getHierarchyIDs(THES_SCHEME, csvt);
		assertTrue(ids.length == 1);
		assertTrue(ids[0].equals("is_a"));
	}
	public void testGetHierarchyLevelNext() throws Exception {
		AssociationList al = lbscm.getHierarchyLevelNext(THES_SCHEME, csvt, "is_a", "C64489", false, null);
		Association[] assocs = al.getAssociation();	
		assertTrue(assocs.length == 1);
	}
	public void testGetHierarchyLevelPrev() throws Exception {
		AssociationList al = lbscm.getHierarchyLevelPrev(THES_SCHEME, csvt, "is_a", "C64489", false, null);
		Association[] assocs = al.getAssociation();
		assertTrue(assocs.length == 1);	
	}
	public void testGetHierarchyPathToRoot() throws Exception {
		AssociationList al = lbscm.getHierarchyPathToRoot(THES_SCHEME, null, null, "C12907", false, HierarchyPathResolveOption.ALL , null);
		Association[] assocs = al.getAssociation();
		
		assertTrue(assocs.length == 1);
		assertTrue(assocs[0].getAssociationName().equals("subClassOf"));
	}

	public void testGetRenderingDetail() throws Exception {
		CodingSchemeRendering csr = lbscm.getRenderingDetail(THES_SCHEME, csvt);
		assertTrue(csr.getCodingSchemeSummary().getCodingSchemeURI().equals(THES_URN));
	}                                                                       
	public void testIsCodeRetired() throws Exception {
		boolean isRetired = lbscm.isCodeRetired("C10906", THES_SCHEME, csvt);
		assertTrue(isRetired);
	
	}

}