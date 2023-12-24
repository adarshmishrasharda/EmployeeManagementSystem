package com.employee.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.models.User;
import com.employee.repository.UserRepository;
import com.employee.service.UserService;


@Service
public class UserServiceImplementation implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user)  {
		return this.userRepository.save(user);
		
	}

	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);

	}

	@Override
	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);		
	}

}
