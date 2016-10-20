package com.whoayoo.util.data;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySqlJDBCConnectionManager {
	
	// initialize database constants
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/whoayoo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "min0414";
    private static final String MAX_POOL = "250";
	
    
    // Once the connection is established, it is better to store for reuse purpose.
    // initialize connection object
    private Connection connection = null;
    // initialize properties object
    private Properties properties = null;
	
    public MySqlJDBCConnectionManager() {
    	connect();
    }
    
    // The properties object hold the connection information, check if it is already set.
    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }
	
	
    // connect to database using the constants and properties initialized
    private void connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = (Connection) DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // get connection
    public Connection getConnection() {
    	return connection;
    }
    
    public Statement getStatement() {
    	Statement statement = null;
        if(connection != null) {
        	try {
        		statement = (Statement) connection.createStatement();
        	} catch (SQLException e) {
        		throw new RuntimeException("Failed to create JDBC SQL statement.");
        	}
        }
        return statement;
    }
     
    
    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
}


