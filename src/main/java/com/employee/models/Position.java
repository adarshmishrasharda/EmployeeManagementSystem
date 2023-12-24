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
@Table(name = "position")
@EntityListeners(AuditingEntityListener.class)
public class Position {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long positionId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "departmentId")
    private Department department;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "position",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Salary> salaries;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "position",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Employee> employees;

	

    private String positionName;
    
    @CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Position(Long positionId, Department department, List<Salary> salaries, List<Employee> employees,
			String positionName, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.positionId = positionId;
		this.department = department;
		this.salaries = salaries;
		this.employees = employees;
		this.positionName = positionName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}




	public Long getPositionId() {
		return positionId;
	}


	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public List<Salary> getSalaries() {
		return salaries;
	}


	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public String getPositionName() {
		return positionName;
	}


	public void setPositionName(String positionName) {
		this.positionName = positionName;
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
		return "Position [positionId=" + positionId + ", department=" + department + ", salaries=" + salaries
				+ ", employees=" + employees + ", positionName=" + positionName + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	
	
	

	
}
