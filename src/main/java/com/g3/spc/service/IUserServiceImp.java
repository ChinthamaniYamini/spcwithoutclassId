package com.g3.spc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g3.spc.entities.User;
import com.g3.spc.repository.IUserRepository;

@Service 
public class IUserServiceImp implements IUserService {
	
	@Autowired
	private IUserRepository  userRepo;

	@Override
	@Transactional
	public User addNewUser(User user) {
		userRepo.save(user);
		return user;
	}

	@Override
	public User signIn(User user) {
		List<User> userList = (List<User>) userRepo.findAll();
		
		User u=null;
		
		for (User user2 : userList) {
			if(user2.getUsername().equals(user.getUsername())   && user2.getPassword().equals(user.getPassword()) ) {
				u=user2;
				
				System.out.println("Logged IN");
			}			
		}
		
		return u;
	}

	@Override
	public User signOut(User user) {
		
		System.out.println("Logged Out");
	
		return user;
	}

}
