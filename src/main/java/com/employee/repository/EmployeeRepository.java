package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
