package com.bookmark.middele.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestConnection {

	static Connection connection = null;
	
	public static Connection getConnection() throws Exception{
		
		// JDBC driver name and database URL
		   
		   final String DB_URL = "jdbc:hsqldb:mem:testdb;shutdown=false";
		   
		   final String USER = "sa";
		   final String PASS = "";
		   
			   if(connection == null){
				   try{
				      //STEP 2: Register JDBC driver
				      Class.forName("org.hsqldb.jdbcDriver");
		
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
