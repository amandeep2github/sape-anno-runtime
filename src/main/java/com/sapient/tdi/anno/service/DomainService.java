package com.sapient.tdi.anno.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.tdi.anno.repository.DomainRepository;

@Service(value="domainService")
public class DomainService {
	@Autowired
	private DomainRepository domainRepository;
	public List<?> loadDomain(String domainClassName){
		Class<?> cls;
		try {
			cls = Class.forName(domainClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
		return domainRepository.loadDomain(cls);
	}
}
