package com.whoayoo.requestReceiver.handler;

import com.whoayoo.factory.Factory;
import com.whoayoo.requestReceiver.request.VerifyUserRequest;
import com.whoayoo.requestReceiver.response.SimpleSuccessResponse;
import com.whoayoo.service.user.UserService;

public class VerifyUserHandler implements RequestHandler{

	@Override
	public Object handle(Object request) {
		
		try {
			VerifyUserRequest req = (VerifyUserRequest) request;
			UserService userService = Factory.getUserService();
			userService.verify(req.getEmailVerificationCode());
		
		
			return new SimpleSuccessResponse(true, null);
		}
		catch(Exception e) {
			return new SimpleSuccessResponse(false, e.getMessage());
		}
		
	}
}
