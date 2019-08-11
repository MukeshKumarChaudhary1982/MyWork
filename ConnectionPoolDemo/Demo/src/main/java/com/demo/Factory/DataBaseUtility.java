package com.demo.Factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.apache.commons.dbcp2.BasicDataSource;
 
 
public class DataBaseUtility
{
    private static BasicDataSource dataSource;
    public static final String URL = "jdbc:sqlserver://20.198.58.32;databaseName=Product2";
    public static final String USER = "sompo";
    public static final String PASS = "sompo12#$";
 
    public static BasicDataSource getDataSource()
    {
 
        if (dataSource == null)
        {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl(URL);
            ds.setUsername(USER);
            ds.setPassword(PASS);
 
 
            ds.setMinIdle(2);
            ds.setMaxIdle(2);
            ds.setMaxOpenPreparedStatements(10);
            ds.setInitialSize(5);
            ds.setMaxTotal(5);
 
            dataSource = ds;
        }
        return dataSource;
    }
 
    public static void main(String[] args) throws SQLException
    {
    	
    	BasicDataSource dataSource = DataBaseUtility.getDataSource();
 
    	for(int i=1;i<=100;i++)
    	{
		        try 
		        {
		        	Connection connection = dataSource.getConnection();
		        	System.out.println("IDLE"+dataSource.getNumIdle());
		        	System.out.println("Active"+dataSource.getNumActive());
		        		System.out.println("The Connection Object is of Class: "+connection.hashCode());
		        }
		            catch (Exception e)
		            {
		            	 e.printStackTrace();
		            		
		            	}
		               
		               
		            
		        }
    	System.out.println("Active"+dataSource.getNumActive());
    	System.out.println("IDLE"+dataSource.getNumIdle());
    	dataSource.close();
    	}
    }
 
