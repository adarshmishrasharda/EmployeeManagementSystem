package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.models.Attendance;
import com.employee.models.Employee;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

	//@Query("select u from Attendance u where u.employee= ?1")

	//System.out.println("going to excute query");
	@Query("select u from Attendance u where u.employee.employeeId=:employeeId")
	List<Attendance> findByEmployeeId(@Param("employeeId") Long employeeId);
	
	List<Attendance> findByEmployee_employeeId(Long employId);
	
	//List<Attendance> findByEmployee(Employee employee);

	//List<Attendance> findByEmployeeId(Employee employee);
}
