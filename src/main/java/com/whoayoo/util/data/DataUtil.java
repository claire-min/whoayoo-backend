package com.whoayoo.util.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.whoayoo.factory.Factory;

public class DataUtil {
	
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	
	public boolean doesUserIdExist(String userId) {
		boolean isExist;
	
		MySqlJDBCConnectionManager connManager = Factory.getMySqlJDBCConnectionManager();
		Statement statement = connManager.getStatement();
		
		try {
    		String sqlStatement = "SELECT COUNT(*) AS rowcount FROM user where user_id = '" + userId + "'";
    		resultSet = statement.executeQuery(sqlStatement);
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
}
