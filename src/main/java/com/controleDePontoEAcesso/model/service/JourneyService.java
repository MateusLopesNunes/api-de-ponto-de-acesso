package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.JourneyWork;
import com.controleDePontoEAcesso.repository.JourneyRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JourneyService {

	private JourneyRepository journeyRepository;

	/*
	@Autowired
	public JourneyService(JourneyService journeyService) {
		this.journeyService = journeyService;
	}*/
	
	public JourneyWork createJourney(JourneyWork obj) {
		return journeyRepository.save(obj);
	}
	
	public List<JourneyWork> findAll() {
		return journeyRepository.findAll();
	}
	
	public JourneyWork findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		journeyRepository.deleteById(id);
	}
	
	public JourneyWork update(Long id, JourneyWork obj) throws NotFoundException {
		idExists(id);
		return journeyRepository.save(obj);
	}
	
	private JourneyWork idExists(Long id) throws NotFoundException {
		return journeyRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
}
