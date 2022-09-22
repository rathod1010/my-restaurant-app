package com.cg.model;

public class AuthenticationResponse {
		
	private String jwtToken;
	
	private boolean valid;
	 
	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String jwtToken, boolean valid) {
		super();
		this.jwtToken = jwtToken;
		this.valid = valid;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public boolean getValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
