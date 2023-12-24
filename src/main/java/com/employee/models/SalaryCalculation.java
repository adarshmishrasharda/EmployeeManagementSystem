package com.employee.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "salary_calculation")
@EntityListeners(AuditingEntityListener.class)
public class SalaryCalculation {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryCalculationId;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDateTime calculationDate;
    
    private String status;

    @CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public SalaryCalculation() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public SalaryCalculation(Long salaryCalculationId, Employee employee, LocalDateTime calculationDate, String status,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.salaryCalculationId = salaryCalculationId;
		this.employee = employee;
		this.calculationDate = calculationDate;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public Long getSalaryCalculationId() {
		return salaryCalculationId;
	}

	public void setSalaryCalculationId(Long salaryCalculationId) {
		this.salaryCalculationId = salaryCalculationId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LocalDateTime getCalculationDate() {
		return calculationDate;
	}

	public void setCalculationDate(LocalDateTime calculationDate) {
		this.calculationDate = calculationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "SalaryCalculation [salaryCalculationId=" + salaryCalculationId + ", employee=" + employee
				+ ", calculationDate=" + calculationDate + ", status=" + status + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
    
    
    
	
	
}
