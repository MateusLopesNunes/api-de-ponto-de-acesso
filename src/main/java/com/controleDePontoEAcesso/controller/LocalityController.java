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

import com.controleDePontoEAcesso.model.Locality;
import com.controleDePontoEAcesso.model.service.LocalityService;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/locality")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LocalityController {
	
	private LocalityService localityService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Locality create(@RequestBody Locality obj) {
		return localityService.create(obj);
	}
	
	@GetMapping
	public List<Locality> findAll() {
		return localityService.findAll();
	}
	
	@GetMapping("/{id}")
	public Locality findById(@PathVariable Long id) throws NotFoundException {
		return localityService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Locality update(@PathVariable Long id, @RequestBody Locality obj) throws NotFoundException {
		return localityService.update(id, obj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		localityService.deleteById(id);
	}
}
