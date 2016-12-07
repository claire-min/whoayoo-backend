package com.whoayoo.requestReceiver.response;

public class UserIdAvailabilityCheckResponse {
	private boolean isAvailable;
	
	public UserIdAvailabilityCheckResponse(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
}
