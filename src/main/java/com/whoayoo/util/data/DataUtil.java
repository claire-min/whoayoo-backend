package com.whoayoo.util.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import com.whoayoo.factory.Factory;

public class DataUtil {
	
	public boolean doesUserIdExist(String userId) {
		//boolean isExist;
	
		MySqlJDBCConnectionManager connManager = Factory.getMySqlJDBCConnectionManager();
		Statement statement = connManager.getStatement();
		try {
			String sqlStatement = "CALL get_user_count('" + userId + "')";
			ResultSet resultSet = statement.executeQuery(sqlStatement);
    		resultSet.next();
    		int count = resultSet.getInt("rowcount");
    		resultSet.close();
    		if( count == 0 ){
    			return false;
    		}
    		else {
    			return true;
    		}
    	} catch (SQLException e) {
    		throw new RuntimeException("Failed to execute SQL query.");
    	}
	}
	
	
	public void addUser(String userId, String password, String firstName, String lastName) {
		MySqlJDBCConnectionManager connManager = Factory.getMySqlJDBCConnectionManager();
		Statement statement = connManager.getStatement();
		try {
			String sqlStatement = "CALL add_user('" + userId + "','" + 
					password + "','" + 
					firstName + "','" + 
					lastName + "')";
    		ResultSet resultSet = statement.executeQuery(sqlStatement);
    		resultSet.next();
    		String failedMessage = resultSet.getString("FailedMessage");
    		resultSet.close();
    		if( failedMessage != null ){
    			throw new SQLException(failedMessage);
    		}
    	} catch (SQLException e) {
    		throw new RuntimeException(e.getMessage());
    	}
	}
}
