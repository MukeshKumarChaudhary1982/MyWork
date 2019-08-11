package com.demo.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	

    public static final String URL = "jdbc:sqlserver://20.198.58.32;databaseName=Product2";
    public static final String USER = "sompo";
    public static final String PASS = "sompo12#$";
    public static Connection connObj;
    
    public static Connection getConnection()
    {
      try {
    	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	  connObj=DriverManager.getConnection(URL, USER, PASS);
    	  return connObj;
      
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connObj;
    }

    

}
