package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.AcessLevel;
import com.controleDePontoEAcesso.repository.AcessLevelRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class AcessLevelService {

	private AcessLevelRepository acessRepository;
	
	public AcessLevel create(AcessLevel obj) {
		return acessRepository.save(obj);
	}
	
	public List<AcessLevel> findAll() {
		return acessRepository.findAll();
	}
	
	public AcessLevel findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private AcessLevel idExists(Long id) throws NotFoundException {
		return acessRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		acessRepository.deleteById(id);
	}
	
	public AcessLevel update(Long id, AcessLevel obj) throws NotFoundException {
		idExists(id);
		return acessRepository.save(obj);
	}
}
