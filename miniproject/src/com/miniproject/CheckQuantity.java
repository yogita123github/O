package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CheckQuantity
{

	 void getProductQuantity() throws SQLException   {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		System.out.println("Enter ProductID");
		Scanner scanner=new Scanner(System.in);
	   int  id=scanner.nextInt();
	  
	  try {
		CountProducts countproducts=new CountProducts();
		int count=countproducts.getProductsCount();
		if(id<0||id>count) {
			throw new UserDefinedException("Invalid Input");
		}
		Class.forName("com.mysql.cj.jdbc.Driver");
	   connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
		
		
	    preparedStatement=connection.prepareStatement("Select  product_quantity from productitem where product_id=? ");
	    
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) {
		System.out.println("Product Quantity ="+resultSet.getString(1));
		}
	}catch (Exception e) {
		e.getMessage();
		
	}
	finally {
		
			
				connection.close();
			
		
		
				preparedStatement.close();
		
	
		scanner.close();
	}
	}
	}



