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

import com.controleDePontoEAcesso.model.TypeDate;
import com.controleDePontoEAcesso.model.service.TypeDateService;
import com.controleDePontoEAcesso.model.service.TypeDateService;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/typeDate")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TypeDateController {
	
	private TypeDateService typeDateService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TypeDate create(@RequestBody TypeDate obj) {
		return typeDateService.create(obj);
	}
	
	@GetMapping
	public List<TypeDate> findAll() {
		return typeDateService.findAll();
	}
	
	@GetMapping("/{id}")
	public TypeDate findById(@PathVariable Long id) throws NotFoundException {
		return typeDateService.findById(id);
	}
	
	@PutMapping("/{id}")
	public TypeDate update(@PathVariable Long id, @RequestBody TypeDate obj) throws NotFoundException {
		return typeDateService.update(id, obj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		typeDateService.deleteById(id);
	}
}
