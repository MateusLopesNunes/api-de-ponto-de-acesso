package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.Locality;
import com.controleDePontoEAcesso.repository.LocalityRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class LocalityService {

	private LocalityRepository localityRepository;
	
	public Locality create(Locality obj) {
		return localityRepository.save(obj);
	}
	
	public List<Locality> findAll() {
		return localityRepository.findAll();
	}
	
	public Locality findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private Locality idExists(Long id) throws NotFoundException {
		return localityRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		localityRepository.deleteById(id);
	}
	
	public Locality update(Long id, Locality obj) throws NotFoundException {
		idExists(id);
		return localityRepository.save(obj);
	}
}
