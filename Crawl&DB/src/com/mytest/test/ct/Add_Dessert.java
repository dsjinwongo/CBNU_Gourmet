package com.mytest.test.ct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mytest.test.ct.Insert_Dessert;

public class Add_Dessert {
	public static void main(String store_name, float rate, int review, String address) {
		
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
				ResultSet rs = null;
				
				String sql ="SELECT name, rate, review, address from DESSERT where name = ?";
				
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, store_name);
				
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					do {
						float yogiyo_rate = rs.getFloat("rate");
						int yogiyo_review = rs.getInt("review");
						
						int new_review = yogiyo_review+review;
						float new_rate = ((yogiyo_rate*yogiyo_review)+(rate*review))/new_review;
						
						if (new_rate>=4.0&&new_review>50) {
						String sql2 = "UPDATE DESSERT SET NAME = ?, RATE = ?, REVIEW = ?, ADDRESS = ? WHERE NAME = ?";
						
						stmt = conn.prepareStatement(sql2);
						stmt.setString(1, store_name);
						stmt.setFloat(2, new_rate);
						stmt.setInt(3, new_review);
						stmt.setString(4, address);
						stmt.setString(5, store_name);
						
						stmt.executeUpdate();
						}
					}while(rs.next());
				}
				else {
					if (rate>=4.0&&review>50) {
					Insert_Dessert.main(store_name, rate, review, address);
					}
				}
				
				conn.commit();
				conn.close();
				
				
		} catch (Exception e) {
			System.err.println("오류발생 : " + e);
		}	
	}
}


