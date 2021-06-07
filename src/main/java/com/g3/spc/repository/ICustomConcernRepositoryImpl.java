package com.g3.spc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.g3.spc.entities.Concern;

public class ICustomConcernRepositoryImpl implements ICustomConcernRepository{

	
	@Autowired
	EntityManager entityManager;
	
	
	@Override
	public List<Concern> retrieveAllConcernsByParentId(int parentId) {

		Query q = entityManager.createQuery("select concern from Parent as par where par.parentId =: b");
		q.setParameter("b", parentId);
		return q.getResultList();
		
	}


	@Override
	public List<Concern> retrieveAllUnResolvedConcerns() {

		Query q = entityManager.createQuery("from Concern where resolved=0");
		//q.setParameter("value", 0 );
		return q.getResultList();
		
		
	}


	@Override
	public List<Concern> retrieveAllUnResolvedConcernsByParentId(int parentId) {
		List<Concern> listConcerns= retrieveAllUnResolvedConcerns();
		
		List<Concern> list2=new ArrayList<>();
		for (Concern concern : listConcerns) {
			if(parentId == concern.getpId()) {
				list2.add(concern);
			}
			
		}
		
		return list2;
		
		
	}

}
