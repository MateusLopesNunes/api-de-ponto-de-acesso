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

import com.controleDePontoEAcesso.model.JourneyWork;
import com.controleDePontoEAcesso.model.service.JourneyService;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/journey")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JourneyWorkController {
	
	private JourneyService journeyService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public JourneyWork create(@RequestBody JourneyWork obj) {
		return journeyService.createJourney(obj);
	}
	
	@GetMapping
	public List<JourneyWork> findAll() {
		return journeyService.findAll();
	}
	
	@GetMapping("/{id}")
	public JourneyWork findById(@PathVariable Long id) throws NotFoundException {
		return journeyService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		journeyService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public JourneyWork updateJourney(@PathVariable Long id, @RequestBody JourneyWork obj) throws NotFoundException {
		return journeyService.update(id, obj);
	}
}
