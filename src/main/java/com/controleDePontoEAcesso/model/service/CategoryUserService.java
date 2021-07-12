package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.CategoryUser;
import com.controleDePontoEAcesso.repository.CategoryRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class CategoryUserService {

	private CategoryRepository categoryRepository;
	
	public CategoryUser create(CategoryUser obj) {
		return categoryRepository.save(obj);
	}
	
	public List<CategoryUser> findAll() {
		return categoryRepository.findAll();
	}
	
	public CategoryUser findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private CategoryUser idExists(Long id) throws NotFoundException {
		return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		categoryRepository.deleteById(id);
	}
	
	public CategoryUser update(Long id, CategoryUser obj) throws NotFoundException {
		idExists(id);
		return categoryRepository.save(obj);
	}
}
