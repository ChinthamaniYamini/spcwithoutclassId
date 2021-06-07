package com.g3.spc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;


import com.g3.spc.entities.Parent;
import com.g3.spc.entities.Student;

public class IParentCustomRepositoryImpl implements IParentCustomRepository{

	@Autowired
	EntityManager entityManager;
	
	
/*	@Override
	public List<Parent> retrieveParentListByClass(String classId) {
	
		Query q = entityManager.createQuery("from Parent p where  p.parentId  IN (select s.parent.parentId from Student s where s.currentClass =: classId)");
		q.setParameter("classId", classId );
		return q.getResultList();
		
	}*/

	@Override
	public Parent retrieveParentByStudent(long studentId) {
		
		Query q = entityManager.createQuery("from Parent where student_id=:studentId");
		q.setParameter("studentId",studentId);
		return  (Parent) q.getSingleResult();
		
	}

}
