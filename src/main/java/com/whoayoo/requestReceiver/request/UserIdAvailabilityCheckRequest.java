package com.whoayoo.requestReceiver.request;

public class UserIdAvailabilityCheckRequest {
	private String userId;
	
	public UserIdAvailabilityCheckRequest(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}
}
