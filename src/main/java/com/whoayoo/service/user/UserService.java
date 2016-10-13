package com.whoayoo.service.user;

import com.whoayoo.factory.ServiceFactory;
import com.whoayoo.service.data.DataService;

public class UserService {
	
	private DataService dataService = ServiceFactory.getDataService();
	
	public boolean isUserIdAvailable(String userId) {
		
		return !dataService.doesUserIdExist(userId);
	
	}
}
