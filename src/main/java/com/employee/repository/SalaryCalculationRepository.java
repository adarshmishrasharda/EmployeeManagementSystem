package com.employee.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.models.SalaryCalculation;

public interface SalaryCalculationRepository extends JpaRepository<SalaryCalculation, Long> {

	boolean existsByCalculationDateAndStatus(LocalDateTime currentDate, String string);

}
