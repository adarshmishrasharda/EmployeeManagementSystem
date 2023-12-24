package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.models.Position;

@Service
public interface PositionService {
	
	public Position addPosition(Position position);

	public Position updatePosition(Position position);
	
	public List<Position> getAllPosition();
	
	public Position getPositionById(Long positionId);
	
	public void deletePosition(Long positionId);

}
