package com.tap.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private static final String url = "jdbc:mysql://localhost:3306/food_delivery_app";
	private static final String username = "root";
	private static final String password = "Yuvraj@221306";
	
	public static final Connection getConnection(){
		
		Connection con = null;
		
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection(url , username , password);
		   
		   Statement st = con.createStatement();
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

	

}
