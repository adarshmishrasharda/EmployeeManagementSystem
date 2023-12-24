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
@Table(name = "salary")
@EntityListeners(AuditingEntityListener.class)
public class Salary {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salaryId;
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	
	private double basicSalary;
    private double hra;
	private double da;
	private double otherAllowances;
    private double grossSalary;
    
    @CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	


	public Salary(Long salaryId, Position position, double basicSalary, double hra, double da, double otherAllowances,
			double grossSalary, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.salaryId = salaryId;
		this.position = position;
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.da = da;
		this.otherAllowances = otherAllowances;
		this.grossSalary = grossSalary;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}







	public Long getSalaryId() {
		return salaryId;
	}


	public void setSalaryId(Long salaryId) {
		this.salaryId = salaryId;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public double getBasicSalary() {
		return basicSalary;
	}


	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}


	public double getHra() {
		return hra;
	}


	public void setHra(double hra) {
		this.hra = hra;
	}


	public double getDa() {
		return da;
	}


	public void setDa(double da) {
		this.da = da;
	}


	public double getOtherAllowances() {
		return otherAllowances;
	}


	public void setOtherAllowances(double otherAllowances) {
		this.otherAllowances = otherAllowances;
	}


	public double getGrossSalary() {
		return grossSalary;
	}


	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
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
		return "Salary [salaryId=" + salaryId + ", position=" + position + ", basicSalary=" + basicSalary + ", hra="
				+ hra + ", da=" + da + ", otherAllowances=" + otherAllowances + ", grossSalary=" + grossSalary
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	

}
