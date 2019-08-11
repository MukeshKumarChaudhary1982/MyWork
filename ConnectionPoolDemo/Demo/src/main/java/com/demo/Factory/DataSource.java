package com.demo.Factory;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {
	
private static HikariConfig config = new HikariConfig();
private static HikariDataSource ds;

public static final String URL = "jdbc:sqlserver://20.198.58.32;databaseName=Product2";
public static final String USER = "sompo";
public static final String PASS = "sompo12#$";

		static 
		{
		config.setJdbcUrl(URL);
		config.setUsername(USER);
		config.setPassword(PASS);
		config.addDataSourceProperty( "cachePrepStmts" , "true" );
		config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
		config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
		config.addDataSourceProperty("useLocalTransactionState","true");
		ds=new HikariDataSource(config);
		}

		private DataSource() {}
		
		public static Connection getConnection() throws SQLException {
			System.out.println("MAxPoolSize"+ds.getMaximumPoolSize());
			return ds.getConnection();
			}
}