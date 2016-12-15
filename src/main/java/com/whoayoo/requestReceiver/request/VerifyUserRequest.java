package com.whoayoo.requestReceiver.request;

import java.util.UUID;

public class VerifyUserRequest {
	private UUID emailVerificationCode;
	
	public VerifyUserRequest(UUID emailVerificationCode) {
		this.emailVerificationCode = emailVerificationCode;
	}
	
	public UUID getEmailVerificationCode() {
		return emailVerificationCode;
	}

}
