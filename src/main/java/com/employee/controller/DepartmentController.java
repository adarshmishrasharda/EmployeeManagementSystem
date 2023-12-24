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


import com.employee.models.Department;
import com.employee.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	
	@Autowired
	private DepartmentService departmentService;
	
	
	//add Department
	@PostMapping("/")
	private ResponseEntity<?> addDepartments(@RequestBody Department department){
		
		Department department1=this.departmentService.addDepartment(department);
		
		return ResponseEntity.ok(department1);
		
	}
	
	
	//get department by id
	
	@GetMapping("/{departmentId}")
	public Department getDepartmentWithId(@PathVariable("departmentId") Long departmentId)
	{
		 return this.departmentService.getDepartmentById(departmentId);
	}
	
	//get all department
	@GetMapping("/")
	public ResponseEntity<?> getAllDepartments(){
		
		return ResponseEntity.ok(this.departmentService.getAllDepartment());
	}
	
	
	
	//update department
	@PutMapping("/")
	public Department updateDepartments(@RequestBody Department department) {
		
		return this.departmentService.updateDepartment(department);
		
	}
	
	//delete mapping
	@DeleteMapping("/{departmentId}")
	public void deleteDepartments(@PathVariable("departmentId") Long departmentId)
	{
		this.departmentService.deleteDepartment(departmentId);
		
	}

}
