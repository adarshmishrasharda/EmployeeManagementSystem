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
@Table(name = "attendance")
@EntityListeners(AuditingEntityListener.class)
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendenceId;
	
	

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	
	
	private LocalDateTime inTime;
	
	private LocalDateTime outTime;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	
	
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Attendance(Long attendenceId, Employee employee, LocalDateTime inTime, LocalDateTime outTime, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.attendenceId = attendenceId;
		this.employee = employee;
		this.inTime = inTime;
		this.outTime = outTime;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public Long getAttendenceId() {
		return attendenceId;
	}



	public void setAttendenceId(Long attendenceId) {
		this.attendenceId = attendenceId;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public LocalDateTime getInTime() {
		return inTime;
	}



	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}



	public LocalDateTime getOutTime() {
		return outTime;
	}



	public void setOutTime(LocalDateTime outTime) {
		this.outTime = outTime;
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
		return "Attendance [attendenceId=" + attendenceId + ", employee=" + employee + ", inTime=" + inTime
				+ ", outTime=" + outTime + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	
	


	


	



	
	
	
	
	

}
