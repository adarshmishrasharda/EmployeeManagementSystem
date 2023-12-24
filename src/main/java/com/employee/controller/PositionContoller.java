package com.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.employee.models.Position;
import com.employee.service.PositionService;

@RestController
@RequestMapping("/api/positions")
public class PositionContoller {
	
	
	@Autowired
	private PositionService positionService;
	
	//add position
	@PostMapping("/")
	private ResponseEntity<?> addPositions(@RequestBody Position position){
		
		Position position1=this.positionService.addPosition(position);
		
		return ResponseEntity.ok(position1);
		
	}
	
	
	//get position by id
	@GetMapping("/{positionID}")
	public Position getPositionWithId(@PathVariable("positionID") Long positionID)
	{
		 return this.positionService.getPositionById(positionID);
	}
	
	//get all Position
	@GetMapping("/")
	public ResponseEntity<?> getAllPositions(){
		
		return ResponseEntity.ok(this.positionService.getAllPosition());
	}
	
	
	
	//update positions
	@PutMapping("/")
	public Position updatePositions(@RequestBody Position position) {
		
		return this.positionService.updatePosition(position);
		
	}
	
	//delete mapping
	@DeleteMapping("/{positionID}")
	public void deletePositions(@PathVariable("positionID") Long positionID)
	{
		this.positionService.deletePosition(positionID);
		
	}

}
