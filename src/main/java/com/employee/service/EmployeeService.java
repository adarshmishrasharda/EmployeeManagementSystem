package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.models.Employee;

@Service
public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(Long employeeId);
	
	public void deleteEmployee(Long employeeId);

}
