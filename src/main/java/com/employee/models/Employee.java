package com.employee.models;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Attendance> attendances;
	
	@JsonIgnore
	 @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 private List<SalaryCalculation> salaryCalculations;
	
	private String employeeName;
	private String email;
    private String phoneNumber;
	private String address;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Employee(Long employeeId, Department department, Position position, List<Attendance> attendances,
			List<SalaryCalculation> salaryCalculations, String employeeName, String email, String phoneNumber,
			String address, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.employeeId = employeeId;
		this.department = department;
		this.position = position;
		this.attendances = attendances;
		this.salaryCalculations = salaryCalculations;
		this.employeeName = employeeName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}





	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public List<Attendance> getAttendances() {
		return attendances;
	}


	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}


	public List<SalaryCalculation> getSalaryCalculations() {
		return salaryCalculations;
	}


	public void setSalaryCalculations(List<SalaryCalculation> salaryCalculations) {
		this.salaryCalculations = salaryCalculations;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	




	
	
	
	
	
	

}
