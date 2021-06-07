package com.g3.spc.repository;

import java.util.List;

import com.g3.spc.entities.Concern;
import com.g3.spc.entities.Parent;

public interface ICustomConcernRepository {

	public List<Concern> retrieveAllConcernsByParentId(int parentId);
	public List<Concern> retrieveAllUnResolvedConcerns();
	public List<Concern> retrieveAllUnResolvedConcernsByParentId(int parentId);
}
