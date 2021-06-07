package com.g3.spc.service;

import java.util.List;
import java.util.Optional;

import com.g3.spc.entities.Parent;
import com.g3.spc.entities.Student;

public interface IParentService  {
	public Parent addParent(Parent parent);
	public Parent updateParent(Parent parent);
	//public List<Parent> retrieveParentListByClass(String classId);
	public Parent retrieveParentByStudent(long studentId);
	public Optional<Parent> retrieveParentById(int id);
	public List<Parent> retrieveAllParent();
	
}
