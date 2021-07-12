package com.controleDePontoEAcesso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controleDePontoEAcesso.model.Movement;
import com.controleDePontoEAcesso.model.service.MovementService;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/movement")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MovementController {
	
	private MovementService movementService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Movement create(@RequestBody Movement obj) {
		return movementService.create(obj);
	}
	
	@GetMapping
	public List<Movement> findAll() {
		return movementService.findAll();
	}
	
	@GetMapping("/{id}")
	public Movement findById(@PathVariable Long id) throws NotFoundException {
		return movementService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Movement update(@PathVariable Long id, @RequestBody Movement obj) throws NotFoundException {
		return movementService.update(id, obj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		movementService.deleteById(id);
	}
}
