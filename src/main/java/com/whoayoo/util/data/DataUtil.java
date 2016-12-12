package com.whoayoo.util.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

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
	
	public boolean doesUserIdExist(String userId, String password) {
		//boolean isExist;
	
		MySqlJDBCConnectionManager connManager = Factory.getMySqlJDBCConnectionManager();
		Statement statement = connManager.getStatement();
		try {
			String sqlStatement = "CALL get_user_count_with_id_password('" + userId + "','" + password + "')";
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
	
	public void addUser(String userId, String password, String firstName, String lastName, UUID emailVerificationCode) {
		MySqlJDBCConnectionManager connManager = Factory.getMySqlJDBCConnectionManager();
		Statement statement = connManager.getStatement();
		try {
			////
			String sqlStatement = "CALL add_user('" + userId + "','" + 
					password + "','" + 
					firstName + "','" + 
					lastName + "','" +
					emailVerificationCode + "')";
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
	
	public void addPasswordCode(String userId, UUID resetPasswordCode) {
		MySqlJDBCConnectionManager connManager = Factory.getMySqlJDBCConnectionManager();
		Statement statement = connManager.getStatement();
		try {
			String sqlStatement = "CALL add_password_code('" + userId + "','" + resetPasswordCode + "')";
			statement.executeQuery(sqlStatement);
    		
    	} catch (SQLException e) {
    		throw new RuntimeException(e.getMessage());
		}
	}
	
	public void verifyUser(UUID emailVerificationCode) {
		MySqlJDBCConnectionManager connManager = Factory.getMySqlJDBCConnectionManager();
		Statement statement = connManager.getStatement();
		try {
			String sqlStatement = "CALL verify_user('" + emailVerificationCode + "')";
			statement.executeQuery(sqlStatement);

    	} catch (SQLException e) {
    		throw new RuntimeException(e.getMessage());
    	}
		
	}
	
	public boolean isUserEmailVerified(String userId) {
		MySqlJDBCConnectionManager connManager = Factory.getMySqlJDBCConnectionManager();
		Statement statement = connManager.getStatement();
		try {
			String sqlStatement = "CALL is_user_email_verified('" + userId + "')";
			ResultSet resultSet = statement.executeQuery(sqlStatement);
    		resultSet.next();
    		int isVerified = resultSet.getInt("isVerified");
    		resultSet.close();
    		if( isVerified == 0 ){
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
