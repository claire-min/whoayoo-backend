package com.whoayoo.factory;

import com.whoayoo.service.user.UserService;
import com.whoayoo.util.data.DataUtil;
import com.whoayoo.util.data.MySqlJDBCConnectionManager;
import com.whoayoo.util.email.EmailUtil;
import com.whoayoo.util.jwt.EncodedKey;
import com.whoayoo.util.jwt.JwtUtil;

public class Factory {
	
	private static UserService userService = new UserService();
	private static DataUtil dataUtil = new DataUtil();
	private static MySqlJDBCConnectionManager mySqlJDBCConnectionManager = new MySqlJDBCConnectionManager();
	private static EmailUtil emailUtil = new EmailUtil();
	private static JwtUtil jwtUtil = new JwtUtil();
	private static EncodedKey encodedKey = new EncodedKey();
	
	public static UserService getUserService() {
		return userService;
	}
	
	public static DataUtil getDataUtil() {
		return dataUtil;
	}
	
	public static MySqlJDBCConnectionManager getMySqlJDBCConnectionManager() {
		return mySqlJDBCConnectionManager;
	}
	
	public static EmailUtil getEmailUtil() {
		return emailUtil;
	}
	
	public static JwtUtil getJwtUtil() {
		return jwtUtil;
	}
	
	public static EncodedKey getEncodedKey() {
		return encodedKey;
	}
	
	
}
