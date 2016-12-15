package com.whoayoo.requestReceiver.request;

public class ResetPasswordRequest {
	private String userId;
	
	public ResetPasswordRequest(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
}
