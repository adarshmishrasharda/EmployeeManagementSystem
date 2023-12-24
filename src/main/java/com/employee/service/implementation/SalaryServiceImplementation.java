package com.employee.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.models.Salary;
import com.employee.repository.SalaryRepository;

import com.employee.service.SalaryService;

@Service
public class SalaryServiceImplementation implements SalaryService {
	
	
	@Autowired
	private SalaryRepository salaryRepository;

	@Override
	public Salary addSalary(Salary salary) {
		return this.salaryRepository.save(salary);
	}

	@Override
	public Salary updateSalary(Salary salary) {
		return this.salaryRepository.save(salary);
	}

	@Override
	public List<Salary> getAllSalary() {
		return new ArrayList<Salary>(this.salaryRepository.findAll());
	}

	@Override
	public Salary getSalaryById(Long salaryId) {
		return this.salaryRepository.findById(salaryId).get();
	}

	@Override
	public void deleteSalary(Long salaryId) {
		
		Salary salary =new Salary();
		salary.setSalaryId(salaryId);
		
		this.salaryRepository.delete(salary);
	
	}
	
	
	
	

}
