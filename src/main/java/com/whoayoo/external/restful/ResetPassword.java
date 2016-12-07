package com.whoayoo.external.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.whoayoo.requestReceiver.handler.RequestHandler;
import com.whoayoo.requestReceiver.handler.ResetPasswordHandler;
import com.whoayoo.requestReceiver.request.ResetPasswordRequest;


@Path("resetPassword")
public class ResetPassword {
	
	private RequestHandler handler = new ResetPasswordHandler();
	
	@POST
    @Consumes("application/x-www-form-urlencoded") // expect the input 
    @Produces(MediaType.TEXT_PLAIN) // what to return
    public String getIt(@FormParam("userId") String userId) {
    	ResetPasswordRequest request = new ResetPasswordRequest(userId);
    	Object response = handler.handle(request);
    	Gson gson = new Gson();
    	return gson.toJson(response);
    }
	
}
