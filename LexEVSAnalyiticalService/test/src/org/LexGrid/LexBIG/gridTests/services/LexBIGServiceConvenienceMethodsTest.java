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
	public void testGetAssociationForwardAndReverseNames() throws Exception {
		String[] names = lbscm.getAssociationForwardAndReverseNames(THES_SCHEME, csvt);
		assertTrue(names.length > 0);
		
		assertTrue(ArrayUtils.contains(names, "disjointWith"));
		assertTrue(ArrayUtils.contains(names, "Has_Salt_Form"));
		assertTrue(ArrayUtils.contains(names, "Is_Related_To_Endogenous_Product"));
	}
	public void testGetAssociationForwardName() throws Exception {
		String name = lbscm.getAssociationForwardName("disjointWith", THES_SCHEME, csvt);
		assertTrue(name.equals("disjointWith"));
	
	}
	public void testGetAssociationForwardNames() throws Exception {
		String[] forwardNames = lbscm.getAssociationForwardNames(THES_SCHEME, csvt);
		assertTrue(forwardNames.length > 0);
		
		assertTrue(ArrayUtils.contains(forwardNames, "equivalentClass"));
		assertTrue(ArrayUtils.contains(forwardNames, "subPropertyOf"));
		assertTrue(ArrayUtils.contains(forwardNames, "Has_Salt_Form"));
		assertTrue(ArrayUtils.contains(forwardNames, "Is_Related_To_Endogenous_Product"));
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
	public void testIsForwardName() throws Exception {
		boolean isForwardName = lbscm.isForwardName(THES_SCHEME, csvt, "differentFrom");
		assertTrue(isForwardName);
	}
}