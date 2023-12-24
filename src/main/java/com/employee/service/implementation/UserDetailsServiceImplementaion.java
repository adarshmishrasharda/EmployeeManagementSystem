package com.employee.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.employee.models.User;
import com.employee.repository.UserRepository;

@Service
public class UserDetailsServiceImplementaion implements UserDetailsService {
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user=this.userRepository.findByUsername(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("No user found with this user name");
		}
		
		return user;
	}

}
