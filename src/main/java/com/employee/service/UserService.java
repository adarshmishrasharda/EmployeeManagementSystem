package com.employee.service;


import org.springframework.stereotype.Service;

import com.employee.models.User;





@Service
public interface UserService {
	
	
	//create user
	public User createUser(User user);

	//get user by username
	public User getUser(String username);
	
	//detele user by id
	public void deleteUser(Long id);
	
	

}
