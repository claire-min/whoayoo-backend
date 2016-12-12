package com.whoayoo.requestReceiver.request;

import java.util.UUID;

public class RegisterUserRequest {
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private UUID emailVerificationCode;
	
	public RegisterUserRequest(String userId, String password,
			String firstName, String lastName) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		emailVerificationCode = UUID.randomUUID();
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public UUID getEmailVerificationCode() {
		return emailVerificationCode;
	}
}
