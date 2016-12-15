package com.whoayoo.requestReceiver.request;

public class LoginRequest {
	private String userId;
	private String password;
	private String loginToken;
	
	public LoginRequest(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public LoginRequest(String loginToken) {
		this.loginToken = loginToken;
	}

	public String getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getLoginToken() {
		return loginToken;
	}
}

