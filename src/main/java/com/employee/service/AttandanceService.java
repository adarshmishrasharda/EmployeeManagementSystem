package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.models.Attendance;



@Service
public interface AttandanceService {
	
	
	public Attendance addAttandence(Attendance attendance);

	public Attendance updateAttandence(Attendance attendance);
	
	public List<Attendance> getAllAttendance();
	
	public Attendance getAttendanceById(Long attendanceId);
	
	public void deleteAttendance(Long attendanceId);

}
