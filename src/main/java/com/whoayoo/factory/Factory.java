package com.whoayoo.factory;

import com.whoayoo.service.user.UserService;
import com.whoayoo.util.data.DataUtil;
import com.whoayoo.util.data.MySqlJDBCConnectionManager;

public class Factory {
	
	private static UserService userService = new UserService();
	private static DataUtil dataUtil = new DataUtil();
	private static MySqlJDBCConnectionManager mySqlJDBCConnectionManager = new MySqlJDBCConnectionManager();
	
	public static UserService getUserService() {
		return userService;
	}
	
	public static DataUtil getDataUtil() {
		return dataUtil;
	}
	
	public static MySqlJDBCConnectionManager getMySqlJDBCConnectionManager() {
		return mySqlJDBCConnectionManager;
	}
}
