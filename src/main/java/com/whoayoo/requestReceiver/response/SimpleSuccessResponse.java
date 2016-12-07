package com.whoayoo.requestReceiver.response;

public class SimpleSuccessResponse {
	private boolean isSuccess;
	private String message;
	
	public SimpleSuccessResponse(boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message;
	}

	public boolean isSuccess() {
		return isSuccess;
	}
	
	public String getMessage() {
		return message;
	}
}
