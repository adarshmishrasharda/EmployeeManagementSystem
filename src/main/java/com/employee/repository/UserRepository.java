package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.employee.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

}
