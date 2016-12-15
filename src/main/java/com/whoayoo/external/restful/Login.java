package com.whoayoo.external.restful;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.whoayoo.requestReceiver.handler.LoginHandler;
import com.whoayoo.requestReceiver.handler.RequestHandler;
import com.whoayoo.requestReceiver.request.LoginRequest;



@Path("login")
public class Login {
	
	private RequestHandler handler = new LoginHandler();
	
    @POST
    @Consumes("application/x-www-form-urlencoded") // expect the input 
    @Produces(MediaType.TEXT_PLAIN) // what to return
    public String getIt(
    	@FormParam("userId") String userId, 
    	@FormParam("password") String password,
    	@FormParam("loginToken") String loginToken) {
    	LoginRequest request = null;
    	if (userId != null && password != null) {
    		request = new LoginRequest(userId, password);
    	} else {
    		request = new LoginRequest(loginToken);
    	}
    	
    	Object response = handler.handle(request);
    	Gson gson = new Gson();
    	return gson.toJson(response);
    }
}