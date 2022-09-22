package com.cg.exception;

@SuppressWarnings("serial")
public class UserNameNotExistingException extends RuntimeException {
	
	public UserNameNotExistingException(String msg) {
		super(msg);
	}

}
