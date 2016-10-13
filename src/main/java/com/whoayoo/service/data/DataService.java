package com.whoayoo.service.data;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataService {
	
	public boolean doesUserIdExist(String userId) {
		//Connection connection = databaseConnectionManager.getConnection();
		Connection connection = MySqlJDBCConnectionManager.getConnection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("MySQL JDBC Driver Registered!");
		//Connection connection = null;

		try {
			connection = (Connection) DriverManager
			.getConnection("jdbc:mysql://localhost:3306/mkyongcom","root", "password");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return false;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		// ===================
		
		Statement statement = null;
		try {
			statement = (Statement) connection.createStatement();
			statement.executeUpdate("insert into");
		} catch (Exception e) {
			
		}
		
		
		
		return false;
	}
}
