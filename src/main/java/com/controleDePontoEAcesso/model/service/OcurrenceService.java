package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.Occurrence;
import com.controleDePontoEAcesso.model.Occurrence;
import com.controleDePontoEAcesso.repository.OccurrenceRepository;
import com.controleDePontoEAcesso.repository.OccurrenceRepository;
import com.controleDePontoEAcesso.repository.OccurrenceRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class OcurrenceService {

	private OccurrenceRepository ocurrenceRepository;
	
	public Occurrence create(Occurrence obj) {
		return ocurrenceRepository.save(obj);
	}
	
	public List<Occurrence> findAll() {
		return ocurrenceRepository.findAll();
	}
	
	public Occurrence findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private Occurrence idExists(Long id) throws NotFoundException {
		return ocurrenceRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		ocurrenceRepository.deleteById(id);
	}
	
	public Occurrence update(Long id, Occurrence obj) throws NotFoundException {
		idExists(id);
		return ocurrenceRepository.save(obj);
	}
}
