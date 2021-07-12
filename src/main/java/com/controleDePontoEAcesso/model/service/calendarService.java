package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.Calendar;
import com.controleDePontoEAcesso.repository.CalendarRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class calendarService {

	private CalendarRepository calendarRepository;
	
	public Calendar create(Calendar obj) {
		return calendarRepository.save(obj);
	}
	
	public List<Calendar> findAll() {
		return calendarRepository.findAll();
	}
	
	public Calendar findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private Calendar idExists(Long id) throws NotFoundException {
		return calendarRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		calendarRepository.deleteById(id);
	}
	
	public Calendar update(Long id, Calendar obj) throws NotFoundException {
		idExists(id);
		return calendarRepository.save(obj);
	}
}
