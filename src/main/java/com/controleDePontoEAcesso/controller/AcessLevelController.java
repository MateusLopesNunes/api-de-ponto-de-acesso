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

import com.controleDePontoEAcesso.model.AcessLevel;
import com.controleDePontoEAcesso.model.service.AcessLevelService;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/acessLevel")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AcessLevelController {
	
	private AcessLevelService acessLevelService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AcessLevel create(@RequestBody AcessLevel obj) {
		return acessLevelService.create(obj);
	}
	
	@GetMapping
	public List<AcessLevel> findAll() {
		return acessLevelService.findAll();
	}
	
	@GetMapping("/{id}")
	public AcessLevel findById(@PathVariable Long id) throws NotFoundException {
		return acessLevelService.findById(id);
	}
	
	@PutMapping("/{id}")
	public AcessLevel update(@PathVariable Long id, @RequestBody AcessLevel obj) throws NotFoundException {
		return acessLevelService.update(id, obj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		acessLevelService.deleteById(id);
	}
}
