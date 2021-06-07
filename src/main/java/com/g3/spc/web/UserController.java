package com.g3.spc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.g3.spc.entities.User;
import com.g3.spc.repository.IUserRepository;
import com.g3.spc.service.IUserServiceImp;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    IUserServiceImp userService;
    
    
    @PostMapping("/user")
    public User addNewUser(@RequestBody   User user) {
    	userService.addNewUser(user);
		
		return user;
	}
    
    @PutMapping("/signIn")
    public User signIn(@RequestBody User user) {
		
    	userService.signIn(user);
		return user;
	}
    
    @PutMapping("/signOut")
    public User signOut(@RequestBody User user) {
		
    	userService.signOut(user);
		return user;
	}
    
}