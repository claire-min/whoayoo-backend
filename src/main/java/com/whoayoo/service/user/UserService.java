package com.whoayoo.service.user;

import com.whoayoo.factory.Factory;
import com.whoayoo.util.data.DataUtil;

public class UserService {
	DataUtil dataService = Factory.getDataUtil();
	
	public boolean isUserIdAvailable(String userId) {
		DataUtil dataUtil = Factory.getDataUtil();
		return !dataUtil.doesUserIdExist(userId);
	}
}
