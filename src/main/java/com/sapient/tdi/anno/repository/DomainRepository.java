package com.sapient.tdi.anno.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository("domainRepository")
public class DomainRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<?> loadDomain(Class<?> cls){
		String query = "select t from "+cls.getSimpleName()+" t";
		System.out.println(query);
		Query q = entityManager.createQuery(query);
		
		return q.getResultList();
	}
	

}
