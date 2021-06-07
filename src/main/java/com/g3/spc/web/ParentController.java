package com.g3.spc.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.spc.entities.Parent;
import com.g3.spc.service.IConcernService;
import com.g3.spc.service.IParentService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@Validated
@RestController
@RequestMapping("/api")
@Api(value = "School Parent App")
public class ParentController {

	@Autowired
	private IParentService parent;
	
	@Autowired
	private IConcernService concernService;
	
	
	
	
	public ParentController() {
		System.out.println("------>> SPC Rest Controller Constructor");
	}
	
	@GetMapping("/parenthome")
	public String homeRequest() {
		return "Welcome : School Parent Communication App" + LocalDateTime.now();
	}
	

	@ApiOperation(value = "parent post mapping" , response = Parent.class)
	@PostMapping("/parent")
	public Parent insertParent(@RequestBody @Valid Parent p) {
		parent.addParent(p);
		return p;
	}
	
	@ApiOperation(value = "parent Get mapping to fatch all parents" , response = List.class)
	@GetMapping("/parents")
	public List<Parent> getAllParents() {
		return parent.retrieveAllParent();
		
	}
	
	@GetMapping("/parent/{id}")
	public Optional<Parent> getParentById(@PathVariable int id) {
		return parent.retrieveParentById(id);
		
	}
	

	@PutMapping("/parent")
	public Parent updateParent(@RequestBody @Valid Parent p) {
		parent.updateParent(p);
		return p;
	}
	
	
	@GetMapping("/parent/student/{studentId}")
	public Parent retrieveParentByStudent(@PathVariable long studentId) {
		return parent.retrieveParentByStudent(studentId);
		
	}
	
	
	/*@GetMapping("/parents/class/{classId}")
	public List<Parent> retrieveParentListByClass(@PathVariable  String classId) {
		return parent.retrieveParentListByClass(classId);
		
	}*/
	
	
}