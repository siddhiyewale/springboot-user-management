package com.example.usermanagement.dto;

public class loginresponse {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "loginresponse [token=" + token + ", getToken()=" + getToken() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public loginresponse(String token) {
		super();
		this.token = token;
	}

	public loginresponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
