package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.BankHours;
import com.controleDePontoEAcesso.repository.BankHoursRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class BankHoursService {

	private BankHoursRepository bankHoursRepository;
	
	public BankHours create(BankHours obj) {
		return bankHoursRepository.save(obj);
	}
	
	public List<BankHours> findAll() {
		return bankHoursRepository.findAll();
	}
	
	public BankHours findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private BankHours idExists(Long id) throws NotFoundException {
		return bankHoursRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		bankHoursRepository.deleteById(id);
	}
	
	public BankHours update(Long id, BankHours obj) throws NotFoundException {
		idExists(id);
		return bankHoursRepository.save(obj);
	}
}
