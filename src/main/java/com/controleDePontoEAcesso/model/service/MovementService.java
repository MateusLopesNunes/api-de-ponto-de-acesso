package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.Movement;
import com.controleDePontoEAcesso.model.Movement;
import com.controleDePontoEAcesso.repository.MovementRepository;
import com.controleDePontoEAcesso.repository.MovementRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class MovementService {

	private MovementRepository movementRepository;
	
	public Movement create(Movement obj) {
		return movementRepository.save(obj);
	}
	
	public List<Movement> findAll() {
		return movementRepository.findAll();
	}
	
	public Movement findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private Movement idExists(Long id) throws NotFoundException {
		return movementRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		movementRepository.deleteById(id);
	}
	
	public Movement update(Long id, Movement obj) throws NotFoundException {
		idExists(id);
		return movementRepository.save(obj);
	}
}
