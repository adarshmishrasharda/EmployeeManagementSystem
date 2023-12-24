package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.models.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

}
