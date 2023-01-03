package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountProducts 
{
	int getProductsCount() throws SQLException {
		Connection connection=null;
		PreparedStatement ps=null;

		int count=0;
		
		
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	   connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
		
		
	    ps=connection.prepareStatement("Select count(*)from  productitem");
	    
	
		
		ResultSet resultSet=ps.executeQuery();
		
		while(resultSet.next()) {
	    count=resultSet.getInt(1);
	    
		}
	}
	catch (Exception e) {
		e.getMessage();
		
	}
	finally {
		connection.close();
		ps.close();
		
	}
return count;
}
	
	}


