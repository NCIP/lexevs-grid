package org.LexGrid.LexBIG.cagrid.iso21090.converter;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;

public class ConvertUtils {

	private static String MAPPING_FILE = "iso21090mappings.xml";

	private static DozerBeanMapper mapper;
	static {
		mapper = new DozerBeanMapper();
		mapper.setMappingFiles(Arrays.asList(MAPPING_FILE));
	}

	public static <T> T convert(Object obj, Class<T> destination){
		if(obj == null){
			return null;
		}

		return mapper.map(obj, destination);

	}	
}
