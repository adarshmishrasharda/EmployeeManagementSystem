package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
