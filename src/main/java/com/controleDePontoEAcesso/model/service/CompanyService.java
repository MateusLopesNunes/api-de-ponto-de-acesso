package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.Company;
import com.controleDePontoEAcesso.repository.CompanyRepository;
import com.controleDePontoEAcesso.repository.CompanyRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class CompanyService {

	private CompanyRepository CompanyRepository;
	
	public Company create(Company obj) {
		return CompanyRepository.save(obj);
	}
	
	public List<Company> findAll() {
		return CompanyRepository.findAll();
	}
	
	public Company findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private Company idExists(Long id) throws NotFoundException {
		return CompanyRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		CompanyRepository.deleteById(id);
	}
	
	public Company update(Long id, Company obj) throws NotFoundException {
		idExists(id);
		return CompanyRepository.save(obj);
	}
}
