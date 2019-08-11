package com.demo.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.Query;

import org.apache.log4j.Logger;

import com.demo.Factory.ConnectionFactory;

public class Application {
	
	private static Logger logger=Logger.getLogger(Application.class);
	

	public static void main(String[] args) {
		System.out.println("Inside Main");
		logger.debug("Inside Logger");
		String query="select clntnum into #My_Temp from clntpf where unique_number=1";
		String queryRead="select * from #My_Temp";
		Statement ps=null;
		Statement ps1=null;
		PreparedStatement ps3=null;
		ResultSet rs=null;
		Connection con=ConnectionFactory.getConnection();
		try {
			ps=con.createStatement();
			boolean flag=ps.execute(query);
			logger.info("Table1"+flag);
			ps3=con.prepareStatement(queryRead);
			rs=ps3.executeQuery();
			while(rs.next()) {
				
				logger.debug("Resultset1"+rs.getInt(1));
			}
			
			ps1=con.createStatement();
			boolean flag1=ps1.execute(query);
			
			logger.info("Table2"+flag1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		

	}

}
