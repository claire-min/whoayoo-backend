package com.whoayoo.requestReceiver.response;

public class LoginResponse {
	private boolean isSuccess;
	private String loginToken;
	
	public LoginResponse(boolean isSuccess, String loginToken) {
		this.isSuccess = isSuccess;
		this.loginToken = loginToken;
	}

	public boolean isSuccess() {
		return isSuccess;
	}
	
	public String loginToken() {
		return loginToken;
	}
}
