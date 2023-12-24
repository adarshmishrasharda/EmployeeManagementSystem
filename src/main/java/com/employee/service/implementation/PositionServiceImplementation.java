package com.employee.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.models.Position;
import com.employee.repository.PositionRepository;
import com.employee.service.PositionService;


@Service
public class PositionServiceImplementation implements PositionService {
	
	@Autowired
	private PositionRepository positionRepository;

	@Override
	public Position addPosition(Position position) {
		return this.positionRepository.save(position);
	}

	@Override
	public Position updatePosition(Position position) {
		return this.positionRepository.save(position);
	}

	@Override
	public List<Position> getAllPosition() {
		return new ArrayList<Position>(this.positionRepository.findAll());
	}

	@Override
	public Position getPositionById(Long positionId) {
		return this.positionRepository.findById(positionId).get();
	}

	@Override
	public void deletePosition(Long positionId) {
		
		Position position =new Position();
		position.setPositionId(positionId);
		this.positionRepository.delete(position);
	}

}
