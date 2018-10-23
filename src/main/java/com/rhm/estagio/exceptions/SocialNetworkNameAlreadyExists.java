package com.rhm.estagio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SocialNetworkNameAlreadyExists extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SocialNetworkNameAlreadyExists(String message) {
		super(message);
	}
	
}
