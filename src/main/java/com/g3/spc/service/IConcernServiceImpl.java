
package com.g3.spc.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.g3.spc.service.IParentServiceImpl;
import com.g3.spc.entities.Concern;
import com.g3.spc.entities.Parent;
import com.g3.spc.repository.IConcernRepository;

@Service
public class IConcernServiceImpl implements IConcernService {

	@Autowired
	private IConcernRepository concernRepo;
	
	@Autowired
	private IParentService parentservice;
	
	
	
	
	
	public IConcernServiceImpl(IConcernRepository concernRepo) {
		super();
		this.concernRepo = concernRepo;
	}

	@Override
	public Concern addConcern(Concern concern) {
		
		
		int parentId = concern.getpId();
		
		Optional<Parent> p = parentservice.retrieveParentById(parentId);
		concern.setParent(p.get());
		concernRepo.save(concern);
		return concern;
	}

	@Override
	public Concern updateConcern(Concern concern) {
		concernRepo.save(concern);
		return concern;
	}

	@Override
	public List<Concern> retrieveAllConcerns() {
		return concernRepo.findAll();
		
	}

	@Override
	public List<Concern> retrieveAllConcernsByParentId(int parentId) {
		
		return concernRepo.retrieveAllConcernsByParentId(parentId);
	}

	@Override
	public List<Concern> retrieveAllUnResolvedConcerns() {
		
		return concernRepo.retrieveAllUnResolvedConcerns();
	}

	@Override
	public List<Concern> retrieveAllUnResolvedConcernsByParentId(int parentId) {
		
		return concernRepo.retrieveAllUnResolvedConcernsByParentId(parentId);
	}

}
