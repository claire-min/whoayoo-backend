package com.whoayoo.requestReceiver.handler;

import com.whoayoo.factory.Factory;
import com.whoayoo.requestReceiver.request.RegisterUserRequest;
import com.whoayoo.requestReceiver.response.SimpleSuccessResponse;
import com.whoayoo.service.user.UserService;
import com.whoayoo.util.email.EmailUtil;

public class RegisterUserHandler implements RequestHandler {
	@Override
	public Object handle(Object request) {
		try {
			RegisterUserRequest req = (RegisterUserRequest) request;
			UserService userService = Factory.getUserService();
			userService.register(
					req.getUserId(),
					req.getPassword(),
					req.getFirstName(),
					req.getLastName()
			);
			
			
			EmailUtil emailUtil = Factory.getEmailUtil();
			emailUtil.send("mhyuns4140@gmail.com", req.getUserId(), "Confirmation Email", "link");
			
			
			
			return new SimpleSuccessResponse(true, null);
		}
		catch(Exception e) {
			return new SimpleSuccessResponse(false, e.getMessage());
		}
	}
}
