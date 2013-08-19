/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.gridTests;


import gov.nih.nci.ServiceTestCase;


/**
 * Base text fixture for LexBIGService initialization and result logging
 * <p>
 * This program assumes the sample content or a full version of the
 * NCI_Thesaurus been loaded using the admin tools.
 */
abstract public class LexBIGServiceTestCase extends ServiceTestCase {
	/**
	 * To be implemented by each descendant testcase.
	 * 
	 * @return String
	 */
	abstract protected String getTestID();

}