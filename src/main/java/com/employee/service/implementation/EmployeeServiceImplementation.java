package com.employee.service.implementation;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.models.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;



@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employeeID) {
		return this.employeeRepository.save(employeeID);
	}

	@Override
	public Employee updateEmployee(Employee employeeId) {
		return this.employeeRepository.save(employeeId);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return new ArrayList<Employee>(this.employeeRepository.findAll());
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return this.employeeRepository.findById(employeeId).get();
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee employee = new Employee();
		
		employee.setEmployeeId(employeeId);
		
		this.employeeRepository.delete(employee);
		
	}

}
