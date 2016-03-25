package com.sapient.tdi.anno.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

public class JsonTry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//JsonNodeFactory jsonFactory = JsonNodeFactory.instance;
		ObjectMapper om = new ObjectMapper();
		ObjectNode on = om.createObjectNode();
		on.put("name", "Employee Data");
		ArrayNode an = om.createArrayNode();
		on.put("data", an);
		ObjectNode dataElement = om.createObjectNode();
		dataElement.put("First Name", "Amandeep");
		dataElement.put("Last Name", "Singh");
		an.add(dataElement);
		System.out.println(on);

	}

}
