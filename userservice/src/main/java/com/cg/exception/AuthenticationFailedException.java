package com.cg.exception;

@SuppressWarnings("serial")
public class AuthenticationFailedException extends RuntimeException {

	public AuthenticationFailedException(String msg) {
		super(msg);
	}
}