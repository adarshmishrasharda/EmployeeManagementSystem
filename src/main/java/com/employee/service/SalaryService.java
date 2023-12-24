package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.models.Salary;

@Service
public interface SalaryService {
	
	public Salary addSalary(Salary salary);

	public Salary updateSalary(Salary salary);
	
	public List<Salary> getAllSalary();
	
	public Salary getSalaryById(Long salaryId);
	
	public void deleteSalary(Long salaryId);

}
