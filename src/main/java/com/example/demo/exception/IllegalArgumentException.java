package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class IllegalArgumentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;

	public IllegalArgumentException(String message) {
		super(message);
		this.message = message;
	}
}
