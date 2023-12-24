package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.models.SalaryCalculation;



@Service
public interface SalaryCalculationService {
	
	public SalaryCalculation addSalaryCalculation(SalaryCalculation salaryCalculation);

	public SalaryCalculation updateSalaryCalculation(SalaryCalculation salaryCalculation);
	
	public List<SalaryCalculation> getAllSalaryCalculation();
	
	public SalaryCalculation getSalaryCalculationById(Long salaryCalculationId);
	
	public void deleteSalaryCalculation(Long salaryCalculationId);
	
	public void salaryCalculationEveryMonth();

}
