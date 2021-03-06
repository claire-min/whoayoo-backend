package com.whoayoo.requestReceiver.handler;

import com.whoayoo.factory.Factory;
import com.whoayoo.requestReceiver.request.UserIdAvailabilityCheckRequest;
import com.whoayoo.requestReceiver.response.UserIdAvailabilityCheckResponse;
import com.whoayoo.service.user.UserService;

public class UserIdAvailabilityCheckHandler implements RequestHandler{
	@Override
	public Object handle(Object request) {
		UserIdAvailabilityCheckRequest req = (UserIdAvailabilityCheckRequest)request;
		UserService userService = Factory.getUserService();
		boolean isAvailable = userService.isUserIdAvailable(req.getUserId());		
		return new UserIdAvailabilityCheckResponse(isAvailable);
		
	}

}
