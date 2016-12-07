package com.whoayoo.service.user;

import java.io.IOException;

import com.whoayoo.factory.Factory;
import com.whoayoo.util.data.DataUtil;
import com.whoayoo.util.email.EmailUtil;
import com.whoayoo.util.jwt.JwtUtil;

public class UserService {
	
	public boolean isUserIdAvailable(String userId) {
		DataUtil dataUtil = Factory.getDataUtil();
		return !dataUtil.doesUserIdExist(userId);
	}
	
	public void register(String userId, String password, String firstName, String lastName) {
		DataUtil dataUtil = Factory.getDataUtil();
		dataUtil.addUser(userId, password, firstName, lastName);
	}
	
	public boolean resetPassword(String userId) throws IOException {
		DataUtil dataUtil = Factory.getDataUtil();
	
		if(dataUtil.doesUserIdExist(userId)) {
			EmailUtil emailUtil = Factory.getEmailUtil();
			emailUtil.send("mhyuns4140@gmail.com", userId, "Reset Password Test", "link");
			
			return true;
		}
		
		return false;

	}
	
	public String login(String userId, String password) {
		DataUtil dataUtil = Factory.getDataUtil();
		JwtUtil jwtUtil = Factory.getJwtUtil();
		
		if (dataUtil.doesUserIdExist(userId)) {
			String loginToken = jwtUtil.createNewToken("id","issuer","subject",1000L);
			return loginToken;
		}
		
		return null;
		
		
	}
}
