package com.g3.spc.repository;

import java.util.List;


import com.g3.spc.entities.Parent;
import com.g3.spc.entities.Student;

public interface IParentCustomRepository {

	//public List<Parent> retrieveParentListByClass(String classId);
	public Parent retrieveParentByStudent(long studentId);
}
