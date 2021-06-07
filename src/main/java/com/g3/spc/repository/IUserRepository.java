package com.g3.spc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import com.g3.spc.entities.User;

public interface IUserRepository extends CrudRepository<User, String>{

}
