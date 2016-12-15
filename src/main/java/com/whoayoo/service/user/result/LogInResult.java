package com.whoayoo.service.user.result;

public class LogInResult {
	private String loginToken;
	private String failedReason;
	
	public LogInResult(String loginToken, String failedReason) {
		super();
		this.loginToken = loginToken;
		this.failedReason = failedReason;
	}
	
	public String getLoginToken() {
		return loginToken;
	}
	
	public String getFailedReason() {
		return failedReason;
	}
}
