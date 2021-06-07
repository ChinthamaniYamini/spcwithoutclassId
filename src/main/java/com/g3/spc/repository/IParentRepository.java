package com.g3.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g3.spc.entities.Parent;

public interface IParentRepository extends JpaRepository<Parent,Integer>,IParentCustomRepository{
//	public Parent addParent(Parent parent);
//	public Parent updateParent(Parent parent);
//	public List<Parent> retrieveParentListByClass(ClassId classId);
//	public Parent retrieveParentByStudent(Student student);
//	public Parent retrieveParentById(int id);
//	
}
