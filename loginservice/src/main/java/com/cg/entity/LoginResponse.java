package com.cg.entity;

public class LoginResponse {
	
	private int userId;

	private String name;

	private String email;
	
	private String token;

	public LoginResponse(int userId, String name, String email, String token) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.token = token;
	}
	
	public LoginResponse()
	{
		
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
