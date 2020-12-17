package com.mytest.test.ct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Insert_Japan {
	public static void main(String name, float rate, int review, String address) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:XE",
						"C##abc", "1234"
						);
				
				conn.setAutoCommit(false);
				PreparedStatement stmt = null;
				String sql ="insert into JAPAN values(?, ?, ?, ?)";
				
				stmt = conn.prepareStatement(sql); 
				stmt.setString(1, name);
				stmt.setFloat(2, rate);
				stmt.setInt(3, review);
				stmt.setString(4, address);
				
				stmt.executeUpdate();
				
				conn.commit();
				conn.close();
				
		} catch (Exception e) {
			System.err.println("error : " + e);
		}	
	}
}

