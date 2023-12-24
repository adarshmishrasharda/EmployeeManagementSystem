package com.employee.service.implementation;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.models.Attendance;
import com.employee.repository.AttendanceRepository;
import com.employee.service.AttandanceService;



@Service
public class AttandenceServiceImplementation implements AttandanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;

	@Override
	public Attendance addAttandence(Attendance attendance) {
		return this.attendanceRepository.save(attendance);
	}

	@Override
	public Attendance updateAttandence(Attendance attendance) {
		return this.attendanceRepository.save(attendance);
	}

	@Override
	public List<Attendance> getAllAttendance() {
		
		return new ArrayList<Attendance>(this.attendanceRepository.findAll());
	}

	@Override
	public Attendance getAttendanceById(Long attendanceId) {
		return this.attendanceRepository.findById(attendanceId).get();
	}

	@Override
	public void deleteAttendance(Long attendanceId) {
		
		Attendance attendance=new Attendance();
		attendance.setAttendenceId(attendanceId);
		
		this.attendanceRepository.delete(attendance);
		
	}

}
