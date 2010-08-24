package org.LexGrid.LexBIG.cagrid;

import gov.nih.nci.iso21090.BL;
import gov.nih.nci.iso21090.INT;
import gov.nih.nci.iso21090.ST;
import gov.nih.nci.iso21090.TS;

import java.util.Date;

import org.LexGrid.LexBIG.cagrid.iso21090.converter.ConvertUtils;
import org.LexGrid.codingSchemes.CodingScheme;
import org.LexGrid.commonTypes.Text;
import org.LexGrid.concepts.Entities;
import org.LexGrid.concepts.Entity;
import org.LexGrid.iso21090.commonTypes.EntityDescription;
import org.LexGrid.iso21090.versions.EntryState;

public class Iso21090Utils {
	
	public static void main(String[] args){
		
		CodingScheme cs = new CodingScheme();
		cs.setEntities(new Entities());
		
		Entity entity = new Entity();
		entity.setIsActive(true);
		cs.getEntities().addEntity(entity);
		
		entity.setEntityCode("123");
		entity.setEntityCodeNamespace("ns");

		org.LexGrid.iso21090.codingSchemes.CodingScheme destObject = ConvertUtils.convert(cs, org.LexGrid.iso21090.codingSchemes.CodingScheme.class);
		
		System.out.println(destObject.getEntities().getEntity(0).getEntityCode().getValue());
		System.out.println(destObject.getEntities().getEntity(0).getEntityCodeNamespace().getValue());
		System.out.println(destObject.getEntities().getEntity(0).getIsActive().getValue());

	}

	public static TS iso21090ToLexEvs(Date date){
		TS ts = new TS();
		ts.setValue(date.toString());
		return ts;
	}
	
	public static EntityDescription iso21090ToLexEvs(org.LexGrid.commonTypes.EntityDescription entityDescription){
		EntityDescription returnEntityDescription = new EntityDescription();
		returnEntityDescription.setContent(entityDescription.getContent());
		return returnEntityDescription;
	}
	
	public static EntryState iso21090ToLexEvs(org.LexGrid.versions.EntryState entryState){
		EntryState returnEntryState = new EntryState();
		//returnEntryState.setChangeType(entryState.getChangeType());
		returnEntryState.setContainingRevision(createSt(entryState.getContainingRevision()));
		returnEntryState.setPrevRevision(createSt(entryState.getPrevRevision()));
		returnEntryState.setRelativeOrder(createInt(entryState.getRelativeOrder()));
		return returnEntryState;
	}
	
	public static INT createInt(Integer i){
		INT returnInt = new INT();
		returnInt.setValue(i);
		return returnInt;
	}
	
	public static INT createInt(Long i){
		return createInt(i.intValue());
	}
	
	public static ST createSt(String str){
		ST returnSt = new ST();
		returnSt.setValue(str);
		return returnSt;
	}

	
	public static ST createSt(Text str){
		return createSt(str.getContent());
	}
	
	public static BL createBl(Boolean bool){
		BL returnBl = new BL();
		returnBl.setValue(bool);
		return returnBl;
	}
	
	public static TS createTs(Date date){
		TS returnTs = new TS();
		returnTs.setValue(date.toString());
		return returnTs;
	}

}
