package com.whoayoo.requestReceiver.handler;


import com.whoayoo.factory.Factory;
import com.whoayoo.requestReceiver.request.ResetPasswordRequest;
import com.whoayoo.service.user.UserService;
import com.whoayoo.requestReceiver.response.SimpleSuccessResponse;


public class ResetPasswordHandler implements RequestHandler {
	@Override
	public Object handle(Object request) {
		
		try {
			ResetPasswordRequest req = (ResetPasswordRequest) request;
			UserService userService = Factory.getUserService();
			
			boolean isReset = userService.resetPassword(req.getUserId());
			
			if(isReset) {
				return new SimpleSuccessResponse(true, null);
			}
			else {
				return new SimpleSuccessResponse(false, "Email does not exist.");
			}
			
			
			
		}
		catch(Exception e) {
			return new SimpleSuccessResponse(false, e.getMessage());
		}
		
	}
}
