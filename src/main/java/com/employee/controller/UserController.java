package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.models.User;
import com.employee.service.implementation.UserServiceImplementation;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	
	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	
	
	//creating user
	@PostMapping("/")
	public User createUser(@RequestBody User user) 
	{
		System.out.println("going to save user");
		return this.userServiceImplementation.createUser(user);
		
		
	}
	
	//get user by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username)
	{
		return this.userServiceImplementation.getUser(username);
		
	}
	
	//delet user by id

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userID)
	{
		this.userServiceImplementation.deleteUser(userID);
	}
	
	

}
