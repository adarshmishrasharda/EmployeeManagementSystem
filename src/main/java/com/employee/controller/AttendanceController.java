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

import com.employee.models.Attendance;
import com.employee.service.AttandanceService;
import com.employee.service.implementation.SalaryCalculationServiceImplementation;




@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
	
	@Autowired
	private AttandanceService attandanceService;
	

	
	//add attendance
	@PostMapping("/")
	private ResponseEntity<?> markAttendance(@RequestBody Attendance attendance){
		
		
		SalaryCalculationServiceImplementation sci=new SalaryCalculationServiceImplementation();
		sci.salaryCalculationEveryMonth();
		
		Attendance attendance1=this.attandanceService.addAttandence(attendance);
		
		return ResponseEntity.ok(attendance1);
		
	}
	
	
	//get category
	
	@GetMapping("/{categoryId}")
	public Attendance getAttendanceWithId(@PathVariable("attendanceId") Long attendanceId)
	{
		 return this.attandanceService.getAttendanceById(attendanceId);
	}
	
	//get all attendance
	@GetMapping("/")
	public ResponseEntity<?> getAllAttendances(){
		
		return ResponseEntity.ok(this.attandanceService.getAllAttendance());
	}
	
	
	
	//update attendance
	@PutMapping("/")
	public Attendance updateAttendance(@RequestBody Attendance attendance) {
		
		return this.attandanceService.updateAttandence(attendance);
		
	}
	
	//delete mapping
	@DeleteMapping("/{attendanceId}")
	public void deleteAttendance(@PathVariable("attendanceId") Long attendanceId)
	{
		this.attandanceService.deleteAttendance(attendanceId);
		
	}
	

}
