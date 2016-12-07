package com.whoayoo.external.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.whoayoo.requestReceiver.handler.RequestHandler;
import com.whoayoo.requestReceiver.handler.UserIdAvailabilityCheckHandler;
import com.whoayoo.requestReceiver.request.UserIdAvailabilityCheckRequest;
import com.whoayoo.requestReceiver.response.UserIdAvailabilityCheckResponse;


@Path("userIdAvailabilityCheck")
public class UserIdAvailabilityCheck {
	
	private RequestHandler handler = new UserIdAvailabilityCheckHandler();
	
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@FormParam("userId") String userId) {
    	UserIdAvailabilityCheckRequest request = new UserIdAvailabilityCheckRequest(userId);
    	Object response = handler.handle(request);
    	Gson gson = new Gson();
    	return gson.toJson(response);
    }
}