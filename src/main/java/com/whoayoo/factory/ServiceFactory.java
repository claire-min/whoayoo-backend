package com.whoayoo.factory;

import com.whoayoo.service.data.DataService;
import com.whoayoo.service.user.UserService;

public class ServiceFactory {
	
	private static UserService userService = new UserService();
	private static DataService dataService = new DataService();
	
	public static UserService getUserService() {
		return userService;
	}
	
	public static DataService getDataService() {
		return dataService;
	}
}
