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

import com.controleDePontoEAcesso.model.Company;
import com.controleDePontoEAcesso.model.service.CompanyService;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/company")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CompanyController {
	
	private CompanyService companyService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Company create(@RequestBody Company obj) {
		return companyService.create(obj);
	}
	
	@GetMapping
	public List<Company> findAll() {
		return companyService.findAll();
	}
	
	@GetMapping("/{id}")
	public Company findById(@PathVariable Long id) throws NotFoundException {
		return companyService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Company update(@PathVariable Long id, @RequestBody Company obj) throws NotFoundException {
		return companyService.update(id, obj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		companyService.deleteById(id);
	}
}
