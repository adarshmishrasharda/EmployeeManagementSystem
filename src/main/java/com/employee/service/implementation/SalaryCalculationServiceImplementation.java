package com.employee.service.implementation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.employee.models.Attendance;
import com.employee.models.Employee;
import com.employee.models.Salary;
import com.employee.models.SalaryCalculation;
import com.employee.repository.AttendanceRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.SalaryCalculationRepository;
import com.employee.repository.SalaryRepository;
import com.employee.service.SalaryCalculationService;


@Service
public class SalaryCalculationServiceImplementation implements SalaryCalculationService{
	
	
	@Autowired
	private SalaryCalculationRepository salaryCalculationRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private SalaryRepository salaryRepository;

	@Override
	public SalaryCalculation addSalaryCalculation(SalaryCalculation salaryCalculation) {
		return this.salaryCalculationRepository.save(salaryCalculation);
	}

	@Override
	public SalaryCalculation updateSalaryCalculation(SalaryCalculation salaryCalculation) {
		return this.salaryCalculationRepository.save(salaryCalculation);
	}

	@Override
	public List<SalaryCalculation> getAllSalaryCalculation() {
		return new ArrayList<SalaryCalculation>(this.salaryCalculationRepository.findAll());
	}

	@Override
	public SalaryCalculation getSalaryCalculationById(Long salaryCalculationId) {
		return this.salaryCalculationRepository.findById(salaryCalculationId).get();
	}

	@Override
	public void deleteSalaryCalculation(Long salaryCalculationId) {
		
		SalaryCalculation salaryCalculation=new SalaryCalculation();
		salaryCalculation.setSalaryCalculationId(salaryCalculationId);
		this.salaryCalculationRepository.delete(salaryCalculation);
	}
	
	
	//@Scheduled(cron = "@monthly")
	public void salaryCalculationEveryMonth() {
	        // Get the current date
	        //LocalDateTime currentDate = LocalDateTime.now();

	        // Check if a salary calculation has already been completed for the current month
//	        boolean isCalculationCompleted = salaryCalculationRepository.existsByCalculationDateAndStatus(currentDate, "Completed");
//
//	        if (!isCalculationCompleted) {
//	            // Insert a new row into the "Salary Calculation" table with the current date and a "Pending" status
//	            SalaryCalculation newCalculation = new SalaryCalculation();
//	            newCalculation.setCalculationDate(currentDate);
//	            newCalculation.setStatus("Pending");
//	            newCalculation.setCreatedAt(LocalDateTime.now());
//	            newCalculation.setUpdatedAt(LocalDateTime.now());
//	            this.salaryCalculationRepository.save(newCalculation);
//
//	            // Retrieve all employee records along with their corresponding attendance records for the previous month
//	            LocalDateTime previousMonth = currentDate.minusMonths(1);
	            List<Employee> employees = employeeRepository.findAll();

	            // Calculate and update salary records for each employee
	            for (Employee employee : employees) {
	                // Retrieve attendance records for the previous month
	            	System.out.println("************"+employee.getEmployeeId().TYPE);
	                List<Attendance> attendanceRecords = attendanceRepository.findByEmployeeId((long) 101);
	                //List<Attendance> attendanceRecords = attendanceRepository.findByEmployee_employeeId(employee.getEmployeeId());

	                System.out.println("employ attendence ####"+attendanceRecords.toString());
	                // Calculate salary using the formulas in the Salary table
	                //BigDecimal calculatedSalary = calculateSalary(employee, attendanceRecords);

	                // Update the salary record for the previous month
	                //Salary salaryRecord = salaryRepository.findByEmployeeAndMonth(employee, previousMonth);
	                //salaryRecord.setBasicSalary(calculatedSalary); // Assuming you have appropriate fields for salary components
	                //salaryRepository.save(salaryRecord);
	            }

	            // Update the "Salary Calculation" record for the current month with a "Completed" status
//	            newCalculation.setStatus("Completed");
//	            salaryCalculationRepository.save(newCalculation);
//	        }
	    }
//
//	    private BigDecimal calculateSalary(Employee employee, List<Attendance> attendanceRecords) {
//	        // Implement your salary calculation logic here
//	        // You may use the provided attendance records and any other relevant information
//	        // to calculate the salary for the employee
//	        // Return the calculated salary as a BigDecimal
//	    }
	
	

	


}
