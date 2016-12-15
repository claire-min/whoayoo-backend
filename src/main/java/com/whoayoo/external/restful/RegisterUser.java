package com.whoayoo.external.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.whoayoo.requestReceiver.handler.RegisterUserHandler;
import com.whoayoo.requestReceiver.handler.RequestHandler;
import com.whoayoo.requestReceiver.request.RegisterUserRequest;

@Path("registerUser")
public class RegisterUser {
	
	private RequestHandler handler = new RegisterUserHandler();
	
    @POST
    @Consumes("application/x-www-form-urlencoded") // expect the input 
    @Produces(MediaType.TEXT_PLAIN) // what to return
    public String getIt(
    		@FormParam("userId") String userId, 
    		@FormParam("password") String password,
    		@FormParam("firstName") String firstName,
    		@FormParam("lastName") String lastName) {
    	RegisterUserRequest request = new RegisterUserRequest(userId, password, firstName, lastName);
    	Object response = handler.handle(request);
    	Gson gson = new Gson();
    	return gson.toJson(response);
    }
}
