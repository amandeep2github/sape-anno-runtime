package com.sapient.tdi.anno.controller;

import java.util.List;

import org.codehaus.jackson.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sapient.tdi.anno.service.DomainService;
import com.sapient.tdi.anno.service.JsonService;

@Controller
public class DomainController {
	
	@Autowired
	private DomainService domainService;
	@Autowired
	private JsonService jsonService;
	@RequestMapping(value="/listDomain", method=RequestMethod.GET)
	public @ResponseBody Object listDomain(@RequestParam String domainClassName) throws IllegalAccessException{
		System.out.println("In Employee controller with Domain Class name "+domainClassName);
		List<?> domainList = domainService.loadDomain(domainClassName);
		ObjectNode on = jsonService.makeObjectNode(domainList);
		System.out.println(on);
		return on;
	}
}
