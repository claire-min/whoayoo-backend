package com.whoayoo.requestReceiver.handler;

import com.whoayoo.factory.ServiceFactory;
import com.whoayoo.requestReceiver.request.UserIdAvailabilityCheckRequest;
import com.whoayoo.requestReceiver.response.UserIdAvailabilityCheckResponse;
import com.whoayoo.service.user.UserService;

public class UserIdAvailabilityCheckHandler implements RequestHandler{
	
	private UserService userService = ServiceFactory.getUserService();

	@Override
	public Object handle(Object request) {
		UserIdAvailabilityCheckRequest req = (UserIdAvailabilityCheckRequest)request;		
		boolean isAvailable = userService.isUserIdAvailable(req.getUserId());		
		return new UserIdAvailabilityCheckResponse(isAvailable);
	}

}
