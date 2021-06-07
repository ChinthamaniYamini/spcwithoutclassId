package com.g3.spc.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

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
import com.g3.spc.repository.IConcernRepository;
import com.g3.spc.repository.IParentRepository;

@SpringBootTest
public class IConcernServiceImplTest {
	
	IConcernRepository concernRepo;


	private static IConcernServiceImpl concernService;
	private static AutoCloseable ac;
	
	@BeforeEach
	public void doinit()
	{
	    concernRepo = mock(IConcernRepository.class); 
		concernService = new  IConcernServiceImpl(concernRepo); 	
		ac = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void doAtEnd()throws Exception
	{
		ac.close();
	}
	
	@Test
	@Disabled
	@DisplayName("Testing save Concern")
	void testingSaveConcern() {
		
		Concern input= new Concern(101, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,false);
		
		Concern output= new Concern(101, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,false);
		
		
		when(concernRepo.save(input)).thenReturn(output);
		concernService.addConcern(input);
		verify(concernRepo).save(input);
		assertEquals(input,output);
	}
	
	
	
	@Test
	@Disabled
	@DisplayName("Testing Get All Concerns")
	void testingRetrieveAllConcerns () {
		Concern c1= new Concern(101, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,false);
		Concern c2= new Concern(102, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,true);
		Concern c3= new Concern(103, ConcernType.MESS  ,"not good food",ConcernParty.CATERER,false);
		Concern c4= new Concern(103, ConcernType.MESS  ,"not good food",ConcernParty.CATERER,true);
		
		List<Concern> concernList=  Arrays.asList(c1,c2,c3,c4);	
		
        when(concernRepo.findAll()).thenReturn(concernList);
		
		List<Concern> actualParentList = concernService.retrieveAllConcerns();
		
		
		verify(concernRepo).findAll();
		assertIterableEquals(concernList,actualParentList);
		
	}
	
	
	@Test
	//@Disabled
	@DisplayName("Testing Update Concern")
	void testingUpdateConcern() {
		
		Concern input= new Concern(101, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,false);
		
		Concern output= new Concern(101, ConcernType.PERFORMANCE  ,"not studying",ConcernParty.TEACHER,false);
		
		
		when(concernRepo.save(input)).thenReturn(output);
		concernService.addConcern(input);
		verify(concernRepo).save(input);
		assertEquals(input,output);
	}
	
	
	
	
	
	
	
	
	
	
}
