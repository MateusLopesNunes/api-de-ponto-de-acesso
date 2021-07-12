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

import com.controleDePontoEAcesso.model.Occurrence;
import com.controleDePontoEAcesso.model.service.OcurrenceService;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ocurrence")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OcurrenceController {
	
	private OcurrenceService ocurrence;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Occurrence create(@RequestBody Occurrence obj) {
		return ocurrence.create(obj);
	}
	
	@GetMapping
	public List<Occurrence> findAll() {
		return ocurrence.findAll();
	}
	
	@GetMapping("/{id}")
	public Occurrence findById(@PathVariable Long id) throws NotFoundException {
		return ocurrence.findById(id);
	}
	
	@PutMapping("/{id}")
	public Occurrence update(@PathVariable Long id, @RequestBody Occurrence obj) throws NotFoundException {
		return ocurrence.update(id, obj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		ocurrence.deleteById(id);
	}
}
