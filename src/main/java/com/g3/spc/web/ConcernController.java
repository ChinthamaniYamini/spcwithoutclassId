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


import com.g3.spc.entities.Concern;
import com.g3.spc.entities.Parent;
import com.g3.spc.entities.Student;
import com.g3.spc.entities.User;
import com.g3.spc.service.IConcernService;
import com.g3.spc.service.IParentService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@Validated
@RestController
@RequestMapping("/api")
@Api(value = "School Parent App")
public class ConcernController {

	@Autowired
	private IParentService parent;
	
	@Autowired
	private IConcernService concernService;
	
	
	
	
	public ConcernController() {
		System.out.println("------>> SPC Rest Controller Constructor");
	}
	
	@GetMapping("/concernhome")
	public String homeRequest() {
		return "Welcome : School Parent Communication App" + LocalDateTime.now();
	}
	

	

	@ApiOperation(value = "Concern post mapping" , response = Concern.class)
	@PostMapping("/concern")
	public Concern insertConcern(@RequestBody @Valid Concern c) {
		concernService.addConcern(c);
		return c;
		
	}
	
	@ApiOperation(value = "Concerns Get mapping to fatch all concerns" , response = List.class)
	@GetMapping("/concerns")
	public List<Concern> getAllConcerns() {
		return concernService.retrieveAllConcerns();
		
	}
	
	
	@GetMapping("/concerns/{parentId}")
   public List<Concern> retrieveAllConcernsByParentId(@PathVariable int parentId) {
		
		return concernService.retrieveAllConcernsByParentId(parentId);
	}
	
	
	@GetMapping("/concernsUnresolved")
   public List<Concern> retrieveAllUnResolvedConcerns() {
		
		return concernService.retrieveAllUnResolvedConcerns();
	}
	
	
	@GetMapping("/concernsUnresolved/{parentId}")
	public List<Concern> retrieveAllUnResolvedConcernsByParentId(@PathVariable int parentId) {
		
		return concernService.retrieveAllUnResolvedConcernsByParentId(parentId);
	}
	

	
	
	


}