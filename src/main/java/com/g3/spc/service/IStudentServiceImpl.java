package com.g3.spc.service;

/*
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.g3.spc.entities.Student;
import com.g3.spc.repository.IStudentRepository;

@Service
public class IStudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentRepository studentRepo;
	

	@Override
	@Transactional
	public Student addStudent(Student student) {
		studentRepo.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		long id=student.getUserId();
		Student s = studentRepo.findById((int) id).get();
		s.setAddress(student.getAddress());
		s.setAttendance(student.getAttendance());
		s.setClassDiary(student.getClassDiary());
		s.setCurrentClass(student.getCurrentClass());
		s.setDateOfBirth(student.getDateOfBirth());
		s.setEmailId(student.getEmailId());
		s.setFee(student.getFee());
		s.setMobileNumber(student.getMobileNumber());
		s.setName(student.getName());
		s.setSubjects(student.getSubjects());
		s.setUserId(student.getUserId());
		return studentRepo.save(s);
	}

	@Override
	public Student deleteStudent(Student student) {
		studentRepo.delete(student);;
		return student;
	}

	@Override
	public List<Student> retrieveAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student retrieveStudentById(int id) {
		Student s = studentRepo.findById((int) id).get();
		return s;
	}
	
	

}*/