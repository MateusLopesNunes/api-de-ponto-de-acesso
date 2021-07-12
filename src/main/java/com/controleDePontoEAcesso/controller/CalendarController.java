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

import com.controleDePontoEAcesso.model.Calendar;
import com.controleDePontoEAcesso.model.service.calendarService;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/calendar")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CalendarController {
	
	private calendarService calendarService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Calendar create(@RequestBody Calendar obj) {
		return calendarService.create(obj);
	}
	
	@GetMapping
	public List<Calendar> findAll() {
		return calendarService.findAll();
	}
	
	@GetMapping("/{id}")
	public Calendar findById(@PathVariable Long id) throws NotFoundException {
		return calendarService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Calendar update(@PathVariable Long id, @RequestBody Calendar obj) throws NotFoundException {
		return calendarService.update(id, obj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws NotFoundException {
		calendarService.deleteById(id);
	}
}
