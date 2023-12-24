package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.employee.models.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	//add employee
	@PostMapping("/")
	private ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		
		Employee employee1= this.employeeService.addEmployee(employee);
		
		return ResponseEntity.ok(employee1);
		
	}
	
	
	//get employee by id
	@GetMapping("/{employeeId}")
	public Employee getEmployeeWithId(@PathVariable("employeeId") Long employeeId)
	{
		 return this.employeeService.getEmployeeById(employeeId);
	}
	
	//get all employee
	@GetMapping("/")
	public ResponseEntity<?> getAllEmployees(){
		
		return ResponseEntity.ok(this.employeeService.getAllEmployee());
	}
	
	
	
	//update employee
	@PutMapping("/")
	public Employee updateEmployees(@RequestBody Employee employee) {
		
		return this.employeeService.updateEmployee(employee);
		
	}
	
	//delete mapping
	@DeleteMapping("/{employeeId}")
	public void deleteEmployees(@PathVariable("employeeId") Long employeeId)
	{
		this.employeeService.deleteEmployee(employeeId);
		
	}

}
