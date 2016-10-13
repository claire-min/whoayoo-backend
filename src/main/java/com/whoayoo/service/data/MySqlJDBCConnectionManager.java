package com.whoayoo.service.data;

import com.mysql.jdbc.Connection;

public class MySqlJDBCConnectionManager {
	private static Connection connection;
	
	public void connect() {
		
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
