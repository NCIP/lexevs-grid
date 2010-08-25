package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import org.apache.commons.lang.ClassUtils;
import org.dozer.CustomConverter;
import org.dozer.MappingException;

public abstract class AbstractCustomConverter<A,B> implements CustomConverter{

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source, Class<?> destClass, Class<?> sourceClass) {
		if(source == null){return null;}
		//if(destination == null){return null;}

		if(ClassUtils.isAssignable(sourceClass,getAClass())){
			return this.aToB((A) source);
		} if(ClassUtils.isAssignable(sourceClass,getBClass())){
			return this.bToA((B) source);
		} 

		else {
			throw new MappingException("Converter TestCustomConverter used incorrectly. Arguments passed in were:"
					+ destination + " and " + source);
		}

	}
	
	protected abstract B aToB(A a);
	protected abstract A bToA(B b);
	protected abstract Class<?> getAClass();
	protected abstract Class<?> getBClass();
}
