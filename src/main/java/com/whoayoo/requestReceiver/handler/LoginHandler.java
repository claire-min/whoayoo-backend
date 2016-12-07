package com.whoayoo.requestReceiver.handler;

import com.whoayoo.factory.Factory;
import com.whoayoo.requestReceiver.request.LoginRequest;
import com.whoayoo.requestReceiver.response.LoginResponse;
import com.whoayoo.service.user.UserService;

public class LoginHandler implements RequestHandler {
	@Override
	public Object handle(Object request) {
		
			LoginRequest req = (LoginRequest) request;
			UserService userService = Factory.getUserService();
			String loginToken = userService.login(req.getUserId(), req.getPassword());
			
			if(loginToken != null) {
				return new LoginResponse(true, loginToken);
			}
			
	
			return new LoginResponse(false, null);
		
		
		
		
		/*
		boolean isExist = userService.doesUserExist(userId, password);
		if (isExist) {
			String loginToken = jwtUtil.createNewToken();
			return new LoginResponse(true, loginToken);
		} else {
			return new LoginResponse(false, null);
		}
		
		var loginToken = response.getLoginToken();
		*/
		
		
		
	}
}
