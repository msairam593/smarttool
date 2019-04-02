package com.apalya.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.apalya.controller.PlateformController;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SmartApalyaUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PlateformController.class);

	public static String toJsonString(Object obj) throws Exception {

		String responce = null;
		ObjectMapper mapper = new ObjectMapper();
		responce = mapper.writeValueAsString(obj);
		return responce;

	}

	

}
