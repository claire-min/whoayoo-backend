package com.whoayoo.service.user;

import java.io.IOException;
import java.util.UUID;

import com.whoayoo.factory.Factory;
import com.whoayoo.service.user.result.LogInResult;
import com.whoayoo.util.data.DataUtil;
import com.whoayoo.util.email.EmailUtil;
import com.whoayoo.util.jwt.JwtUtil;

public class UserService {
	
	public boolean isUserIdAvailable(String userId) {
		DataUtil dataUtil = Factory.getDataUtil();
		return !dataUtil.doesUserIdExist(userId);
	}
	
	public void register(String userId, String password, String firstName, String lastName, UUID emailVerificationCode) {
		DataUtil dataUtil = Factory.getDataUtil();
		dataUtil.addUser(userId, password, firstName, lastName, emailVerificationCode);
	}
	
	public boolean resetPassword(String userId) throws IOException {
		DataUtil dataUtil = Factory.getDataUtil();
		
	
		if(dataUtil.doesUserIdExist(userId)) {
			UUID resetPasswordCode = UUID.randomUUID();
			dataUtil.addPasswordCode(userId, resetPasswordCode);
			
			EmailUtil emailUtil = Factory.getEmailUtil();
			emailUtil.send("mhyuns4140@gmail.com", userId, "Reset Password", "Please click the following link : http://whoayoo.com/" + resetPasswordCode);
			
			return true;
		}
		
		return false;

	}
	
	public LogInResult login(String userId, String password) {
		DataUtil dataUtil = Factory.getDataUtil();
		JwtUtil jwtUtil = Factory.getJwtUtil();
		
		// Create Token
		if (!dataUtil.doesUserIdExist(userId, password)) {
			return new LogInResult(null, "User ID or password is incorrect.");
			
		} else if (!dataUtil.isUserEmailVerified(userId)) {
			return new LogInResult(null, "Email has not been verified.");
		} else {
			String loginToken = jwtUtil.createNewToken(userId,"issuer","subject",-1);
			return new LogInResult(loginToken, null);
		}
	}
	
	public boolean login(String loginToken) {
		JwtUtil jwtUtil = Factory.getJwtUtil();
		return jwtUtil.getUserIdFromToken(loginToken) != null;
	}
	
	public void verify(UUID emailVerificationCode) {
		DataUtil dataUtil = Factory.getDataUtil();
		dataUtil.verifyUser(emailVerificationCode);
	}
	
}
