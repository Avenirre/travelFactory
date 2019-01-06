package com.travelfactory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class NoSuchRecordExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSuchRecordExistsException() {
		super("Such a record doesn't exist!");
	}
}
