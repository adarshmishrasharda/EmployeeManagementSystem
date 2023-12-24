package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.models.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long>{

}
