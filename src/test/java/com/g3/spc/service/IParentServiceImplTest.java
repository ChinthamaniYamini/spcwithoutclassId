package com.g3.spc.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.g3.spc.entities.Concern;
import com.g3.spc.entities.ConcernParty;
import com.g3.spc.entities.ConcernType;
import com.g3.spc.entities.Parent;
import com.g3.spc.repository.IParentRepository;

@SpringBootTest
public class IParentServiceImplTest {

	IParentRepository parentRepo;
	
	private static IParentServiceImpl parentService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
	    parentRepo = mock(IParentRepository.class); 
		parentService = new  IParentServiceImpl(parentRepo); 	
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	@Test
	@Disabled
	@DisplayName("Testing save Parent")
	void testingSaveParent() {
		Concern c1= new Concern(101, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,false);
		Concern c2= new Concern(102, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,true);
		Concern c3= new Concern(103, ConcernType.MESS  ,"not good food",ConcernParty.CATERER,false);
		Concern c4= new Concern(103, ConcernType.MESS  ,"not good food",ConcernParty.CATERER,true);
		
		List<Concern> concernList =  Arrays.asList(c1,c2,c3,c4);
		
		Parent input =new Parent(1,"Mahesh","mahesh@gmail.com","9398850901",concernList);
		
		Parent output  =new Parent(1,"Mahesh","mahesh@gmail.com","9398850901",concernList);
		
		when(parentRepo.save(input)).thenReturn(output);
		parentService.addParent(input);
		verify(parentRepo).save(input);
		assertEquals(input,output);
		
	}
	
	@Test
	@Disabled
	@DisplayName("Testing All Parents")
	void testingRetrieveAllParent () {
		Concern c1= new Concern(101, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,false);
		Concern c2= new Concern(102, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,true);
		Concern c3= new Concern(103, ConcernType.MESS  ,"not good food",ConcernParty.CATERER,false);
		Concern c4= new Concern(103, ConcernType.MESS  ,"not good food",ConcernParty.CATERER,true);
		
		List<Concern> concernList1 =  Arrays.asList(c1,c2);
		List<Concern> concernList2 =  Arrays.asList(c3,c4);
		
		Parent p1 =new Parent(1,"Mahesh","mahesh@gmail.com","9398850901",concernList1);
		
		Parent p2 =new Parent(2,"Ramana","ramana@gmail.com","9398850901",concernList2);
		
		List<Parent> parentList =  Arrays.asList(p1,p2);
		
		
when(parentRepo.findAll()).thenReturn(parentList);
		
		List<Parent> actualParentList = parentService.retrieveAllParent();
		verify(parentRepo).findAll();
		assertIterableEquals(parentList,actualParentList);
		
	}
	
	
	@Test
	@Disabled
	@DisplayName("Testing Update Parent")
	void testingUpdateParent() {
		
		Concern c1= new Concern(101, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,false);
		Concern c2= new Concern(102, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,true);
		Concern c3= new Concern(103, ConcernType.MESS  ,"not good food",ConcernParty.CATERER,false);
		Concern c4= new Concern(103, ConcernType.MESS  ,"not good food",ConcernParty.CATERER,true);
		
		List<Concern> concernList =  Arrays.asList(c1,c2,c3,c4);
		
		Parent input =new Parent(1,"Mahesh","mahesh@gmail.com","9398850901",concernList);
		
		Parent output  =new Parent(1,"Mahesh","mahesh@gmail.com","9398850901",concernList);
		
		when(parentRepo.save(input)).thenReturn(output);
		parentService.updateParent(output);
		assertEquals(input,output);
	}
	
	@Test
	@DisplayName("Testing Get Parent By Id")
	void testGetParentById()  {
		int input = 1;
		Parent parent = mock(Parent.class);
		Optional<Parent> optional = Optional.of(parent);
		
		
		when(parentRepo.findById(input)).thenReturn(optional);
		parentService.retrieveParentById(input);
		verify(parentRepo).findById(input);
	}
	
	
	
	
	
}
