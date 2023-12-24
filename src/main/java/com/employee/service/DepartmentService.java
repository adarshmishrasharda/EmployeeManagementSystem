package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.employee.models.Department;


@Service
public interface DepartmentService {
	
	public Department addDepartment(Department department);

	public Department updateDepartment(Department department);
	
	public List<Department> getAllDepartment();
	
	public Department getDepartmentById(Long departmentId);
	
	public void deleteDepartment(Long departmentId);

}
