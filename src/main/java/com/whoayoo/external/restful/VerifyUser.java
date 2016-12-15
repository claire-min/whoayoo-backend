package com.whoayoo.external.restful;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.whoayoo.requestReceiver.handler.VerifyUserHandler;
import com.whoayoo.requestReceiver.handler.RequestHandler;
import com.whoayoo.requestReceiver.request.VerifyUserRequest;

@Path("verifyUser")
public class VerifyUser {
	
	private RequestHandler handler = new VerifyUserHandler();
	
    @POST
    @Consumes("application/x-www-form-urlencoded") // expect the input 
    @Produces(MediaType.TEXT_PLAIN) // what to return
    public String getIt(
    		@FormParam("emailVerificationCode") UUID emailVerificationCode) {
    	VerifyUserRequest request = new VerifyUserRequest(emailVerificationCode);
    	Object response = handler.handle(request);
    	Gson gson = new Gson();
    	return gson.toJson(response);
    }
}