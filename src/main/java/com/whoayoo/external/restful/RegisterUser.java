package com.whoayoo.external.restful;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("registerUser")
public class RegisterUser {
    @POST
    @Consumes("application/x-www-form-urlencoded") // expect the input 
    @Produces(MediaType.TEXT_PLAIN) // what to return
    public String getIt(@FormParam("userId") String userId, @FormParam("password") String password) {
    	
        return "Got!";
    }
}
