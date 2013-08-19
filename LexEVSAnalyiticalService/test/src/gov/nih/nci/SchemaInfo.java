/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package gov.nih.nci;

// TODO: Auto-generated Javadoc
/**
 * The Class SchemaInfo.
 */
public class SchemaInfo {
	
	/** The name of the test. */
	private String name;
    
    /** The coding scheme. */
    private String codingScheme;
    
    /** The search term. */
    private String searchTerm;
    
    /** The concept code. */
    private String conceptCode;
    
    /** The property to search. */
    private String propertyToSearch;
    


	/**
	 * Gets the concept code.
	 * 
	 * @return the concept code
	 */
	public String getConceptCode() {
		return conceptCode;
	}

	/**
	 * Sets the concept code.
	 * 
	 * @param conceptCode the new concept code
	 */
	public void setConceptCode(String conceptCode) {
		this.conceptCode = conceptCode;
	}

	/**
	 * Gets the property to search.
	 * 
	 * @return the property to search
	 */
	public String getPropertyToSearch() {
		return propertyToSearch;
	}

	/**
	 * Sets the property to search.
	 * 
	 * @param propertyToSearch the new property to search
	 */
	public void setPropertyToSearch(String propertyToSearch) {
		this.propertyToSearch = propertyToSearch;
	}

	/**
	 * Gets the search term.
	 * 
	 * @return the search term
	 */
	public String getSearchTerm() {
		return searchTerm;
	}

	/**
	 * Sets the search term.
	 * 
	 * @param searchTerm the new search term
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	/**
	 * Gets the coding scheme.
	 * 
	 * @return the coding scheme
	 */
	public String getCodingScheme() {
		return codingScheme;
	}
	
    /**
     * Sets the coding scheme.
     * 
     * @param inCodingScheme the new coding scheme
     */
    public void setCodingScheme(String inCodingScheme){
    	this.codingScheme= inCodingScheme;
    }
    
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
    
	public String toString() {
		return this.name;
	}
}
