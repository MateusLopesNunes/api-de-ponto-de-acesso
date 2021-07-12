package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.TypeDate;
import com.controleDePontoEAcesso.repository.TypeDateRepository;
import com.controleDePontoEAcesso.repository.TypeDateRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class TypeDateService {

	private TypeDateRepository typeDateRepository;
	
	public TypeDate create(TypeDate obj) {
		return typeDateRepository.save(obj);
	}
	
	public List<TypeDate> findAll() {
		return typeDateRepository.findAll();
	}
	
	public TypeDate findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private TypeDate idExists(Long id) throws NotFoundException {
		return typeDateRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		typeDateRepository.deleteById(id);
	}
	
	public TypeDate update(Long id, TypeDate obj) throws NotFoundException {
		idExists(id);
		return typeDateRepository.save(obj);
	}
}
