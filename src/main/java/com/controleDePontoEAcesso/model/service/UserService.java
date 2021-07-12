package com.controleDePontoEAcesso.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controleDePontoEAcesso.model.User;
import com.controleDePontoEAcesso.repository.UserRepository;
import com.controleDePontoEAcesso.util.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor =  @__(@Autowired))
public class UserService {

	private UserRepository userRepository;
	
	public User create(User obj) {
		return userRepository.save(obj);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) throws NotFoundException {
		return idExists(id);
	}

	private User idExists(Long id) throws NotFoundException {
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public void deleteById(Long id) throws NotFoundException {
		idExists(id);
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User obj) throws NotFoundException {
		idExists(id);
		return userRepository.save(obj);
	}
}
