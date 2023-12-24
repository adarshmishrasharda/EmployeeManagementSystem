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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "department")
@EntityListeners(AuditingEntityListener.class)
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId ;
    private String departmentName;
    
    @JsonIgnore
    @OneToMany(mappedBy = "department",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Position> positions;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Employee> employees;

    @CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
	private LocalDateTime updatedAt;
    
    
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	public Department(Long departmentId, String departmentName, List<Position> positions, List<Employee> employees,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.positions = positions;
		this.employees = employees;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}






	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", positions="
				+ positions + ", employees=" + employees + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	
	
	

}
