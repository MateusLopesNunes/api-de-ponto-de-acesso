package com.controleDePontoEAcesso.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

	public NotFoundException(Long id) {
		super("Content not found whith id: " + id);
	}
}
