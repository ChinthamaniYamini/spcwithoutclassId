package com.g3.spc.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.spc.entities.Parent;
import com.g3.spc.entities.Student;
import com.g3.spc.repository.IParentRepository;



@Service
public class IParentServiceImpl implements IParentService{
	
	@Autowired
	private IParentRepository parentRepo;

	public IParentServiceImpl(IParentRepository parentRepo) {
		super();
		this.parentRepo = parentRepo;
	}

	@Override
	@Transactional
	public Parent addParent(Parent parent) {
		parentRepo.save(parent);
		return parent;
	}

	@Override
	public Parent updateParent(Parent parent) {
		parentRepo.save(parent);
		return parent;
	}

	/*@Override
	public List<Parent> retrieveParentListByClass(String classId) {
		return parentRepo.retrieveParentListByClass(classId);
		
	}*/

	

	@Override
	public Optional<Parent> retrieveParentById(int id) {
		return parentRepo.findById(id);
		
	}

	@Override
	public List<Parent> retrieveAllParent() {
		
		return  parentRepo.findAll();
	}

	@Override
	public Parent retrieveParentByStudent(long studentId) {
		return parentRepo.retrieveParentByStudent(studentId);
		
	}

	

}