package com.bookmarks.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	static Connection connection = null;
	
	public static Connection getConnection() throws Exception{
		
		// JDBC driver name and database URL
		   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/bookmark";
		   
		   final String USER = "root";
		   final String PASS = "root";
		   
			   if(connection == null){
				   try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");
		
				      //STEP 3: Open a connection
				      System.out.println("Connecting to database...");
				      connection = DriverManager.getConnection(DB_URL,USER,PASS);
					   }catch(Exception exception){
					   throw exception;
				   }
			   }
		return connection;
	}
}
