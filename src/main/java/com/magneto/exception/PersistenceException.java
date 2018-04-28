package com.magneto.exception;

import org.springframework.dao.DataAccessException;

public class PersistenceException extends DataAccessException {

	private static final long serialVersionUID = 8157311830813650929L;

	public PersistenceException(String msg, Throwable cause) {
		super(msg, cause);		
	}
}
