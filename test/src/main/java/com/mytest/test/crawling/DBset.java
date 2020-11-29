package com.mytest.test.crawling;

import java.sql.Connection;
import java.sql.SQLException;

public class DBset
{
	public void main(String[] args)
	{
		String  url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = " select * from board";
		Connection conn=null;
		java.sql.Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}