package com.whoayoo.requestReceiver.handler;

import com.whoayoo.factory.Factory;
import com.whoayoo.requestReceiver.request.LoginRequest;
import com.whoayoo.requestReceiver.response.LoginResponse;
import com.whoayoo.service.user.UserService;
import com.whoayoo.service.user.result.LogInResult;

public class LoginHandler implements RequestHandler {
	@Override
	public Object handle(Object request) {
		
			LoginRequest req = (LoginRequest) request;
			UserService userService = Factory.getUserService();
			if (req.getUserId() != null) {
				LogInResult result = userService.login(req.getUserId(), req.getPassword());
				
				if(result.getLoginToken() != null) {
					return new LoginResponse(true, result.getLoginToken());
				} else {
					return new LoginResponse(false, result.getFailedReason());
				}
			} else {
				boolean isSuccess = userService.login(req.getLoginToken());
				
				if (isSuccess) {
					return new LoginResponse(true, null);
				} else {
					return new LoginResponse(false, "Invalid login token.");
				}
			}
		
	}
}
