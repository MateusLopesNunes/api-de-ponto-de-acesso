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

import com.controleDePontoEAcesso.model.CategoryUser;
import com.controleDePontoEAcesso.model.service.CategoryUserService;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/category")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryUserController {
	
	private CategoryUserService categoryUserService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryUser create(@RequestBody CategoryUser obj) {
		return categoryUserService.create(obj);
	}
	
	@GetMapping
	public List<CategoryUser> findAll() {
		return categoryUserService.findAll();
	}
	
	@GetMapping("/{id}")
	public CategoryUser findById(@PathVariable Long id) throws NotFoundException {
		return categoryUserService.findById(id);
	}
	
	@PutMapping("/{id}")
	public CategoryUser update(@PathVariable Long id, @RequestBody CategoryUser obj) throws NotFoundException {
		return categoryUserService.update(id, obj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		categoryUserService.deleteById(id);
	}
}
