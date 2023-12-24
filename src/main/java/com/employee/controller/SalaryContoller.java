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


import com.employee.models.Salary;
import com.employee.service.SalaryService;

@RestController
@RequestMapping("/api/salaries")
public class SalaryContoller {
	
	
	@Autowired
	private SalaryService salaryService;
	
	//add salary
	@PostMapping("/")
	private ResponseEntity<?> addSalaries(@RequestBody Salary salary){
		
		Salary salary1=this.salaryService.addSalary(salary);
		
		return ResponseEntity.ok(salary1);
		
	}
	
	
	//get salary by id
	@GetMapping("/{salaryId}")
	public Salary getSalaryWithId(@PathVariable("salaryId") Long salaryId)
	{
		 return this.salaryService.getSalaryById(salaryId);
	}
	
	//get all salary
	@GetMapping("/")
	public ResponseEntity<?> getAllSalaries(){
		
		return ResponseEntity.ok(this.salaryService.getAllSalary());
	}
	
	
	
	//update salary
	@PutMapping("/")
	public Salary updateSalaries(@RequestBody Salary salary) {
		
		return this.salaryService.updateSalary(salary);
		
	}
	
	//delete mapping
	@DeleteMapping("/{salaryId}")
	public void deleteSalaries(@PathVariable("salaryId") Long salaryId)
	{
		this.salaryService.deleteSalary(salaryId);
		
	}

}
