package com.employee.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.models.Department;
import com.employee.repository.DepartmentRepository;
import com.employee.service.DepartmentService;

@Service
public class DepartmentServiceImplementation implements DepartmentService {
	
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department department) {
		return this.departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return this.departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartment() {
		return new ArrayList<Department>(this.departmentRepository.findAll());
	}

	@Override
	public Department getDepartmentById(Long departmentId) {
		return this.departmentRepository.findById(departmentId).get();
	}

	@Override
	public void deleteDepartment(Long departmentId) {
		
		Department department =new Department();
		
		department.setDepartmentId(departmentId);
		
		this.departmentRepository.delete(department);
		
	}
	
	


}
