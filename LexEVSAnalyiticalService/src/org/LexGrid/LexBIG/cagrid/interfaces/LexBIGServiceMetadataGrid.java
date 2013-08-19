/*
* Copyright: (c) Mayo Foundation for Medical Education and
* Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
* triple-shield Mayo logo are trademarks and service marks of MFMER.
*
* Distributed under the OSI-approved BSD 3-Clause License.
* See http://ncip.github.com/lexevs-grid/LICENSE.txt for details.
*/
package org.LexGrid.LexBIG.cagrid.interfaces;

import java.io.Serializable;
import java.rmi.RemoteException;

import org.LexGrid.LexBIG.iso21090.DataModel.Collections.AbsoluteCodingSchemeVersionReferenceList;
import org.LexGrid.LexBIG.iso21090.DataModel.Collections.MetadataPropertyList;
import org.LexGrid.LexBIG.iso21090.DataModel.Core.AbsoluteCodingSchemeVersionReference;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.ExtensionIdentification;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.MatchCriteria;
import org.LexGrid.LexBIG.iso21090.DataModel.cagrid.PropertyIdentification;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.InvalidServiceContextAccess;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBInvocationException;
import org.LexGrid.LexBIG.cagrid.LexEVSGridService.stubs.types.LBParameterException;

/**
 * Interface to perform system-wide query over metadata for loaded code systems and providers.
 * @param <LexBIGServiceMetadataImpl>
 */
public interface LexBIGServiceMetadataGrid<LexBIGServiceMetadataImpl> extends Serializable
{
	/**
	 * List the coding schemes that are represented in the metadata index.
	 * 
	 * @throws LBParameterException, InvalidServiceContextAccess, RemoteException
	 */
	public abstract AbsoluteCodingSchemeVersionReferenceList listCodingSchemes() throws LBInvocationException, InvalidServiceContextAccess, RemoteException;
	
    /**
     * Restrict the search to a particular coding scheme.
     * 
     * @param acsvr 
     *      The coding scheme to restrict the search to. You may provide the URN, 
     *      the version, or both.
     * @throws LBParameterException, InvalidServiceContextAccess, RemoteException
     */
    public abstract LexBIGServiceMetadataGrid<?> restrictToCodingScheme(AbsoluteCodingSchemeVersionReference acsvr) throws LBParameterException, InvalidServiceContextAccess, RemoteException;

    /**
     * Restrict the search to a particular property.  Currently, this can be any element or attribute
     * name from the OBO metadata schema.  When we move to the 2006 version of the schema, there will
     * be a method to get the available properties.
     * 
     * @param properties 
     *      The set of properties to restrict the search to.  If you provide multiple properties, 
     *      it is treated as an OR search.
     * @throws LBParameterException, InvalidServiceContextAccess, RemoteException
     */
    public abstract LexBIGServiceMetadataGrid<?> restrictToProperties(PropertyIdentification[] properties) throws LBParameterException, InvalidServiceContextAccess, RemoteException;

    /**
     * Restrict the search by the parents of the metadata elements.
     * The OBO MetaData format is hierarchial - if you wish to restrict your search to properties
     * that are under another property, provide the required property containers here.  
     * 
     * @param propertyParents
     *      The containers to require as parents.  For example, to restrict the search  to 
     *      "contacts" that are under "about" that is under "authority" - provide "authority"
     *      and "about".  
     *      The order of the parents does not matter.  Multiple parents are treated as an AND - 
     *      so the result is required to be under each of the parents going up the parent tree.
     * @throws LBParameterException, InvalidServiceContextAccess, RemoteException
     */
    public abstract LexBIGServiceMetadataGrid<?> restrictToPropertyParents(PropertyIdentification[] propertyParents) throws LBParameterException, InvalidServiceContextAccess, RemoteException;

    /**
     * Restrict the result to the metadata elements that match the supplied string, 
     * using the supplied matching algorithm 
     * 
     * @param matchText
     *          The match text.  Format is determined by the match algorithm.
     * @param matchAlgorithm
     *            Local name of the match algorithm - possible algorithms are
     *            returned in LexBigService.getMatchAlgorithms().
     * @throws LBParameterException
     */
    public abstract LexBIGServiceMetadataGrid<?> restrictToValue(MatchCriteria matchText, ExtensionIdentification matchAlgorithm) throws LBParameterException, InvalidServiceContextAccess, RemoteException;

    /**
     * Apply all of the restrictions, and return the result.
     * 
     * @return
     * @throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException
     */
    public abstract MetadataPropertyList resolve() throws LBParameterException, LBInvocationException, InvalidServiceContextAccess, RemoteException;

}
