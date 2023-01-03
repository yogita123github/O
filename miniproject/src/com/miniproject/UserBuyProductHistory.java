package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserBuyProductHistory 
{
	void history() {
		try {
			System.out.println("Enter username to search product history");
			Scanner scanner=new Scanner(System.in);
					String username=scanner.next();
				
				Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
				
				
			   PreparedStatement preparedStatement=connection.prepareStatement("Select *from buy_product_history where USERNAME=?");
			   preparedStatement.setString(1, username);
			   	ResultSet resultSet=preparedStatement.executeQuery();
				System.out.println("Registerd User List >>>");
				
				while(resultSet.next()) {
					
				System.out.println("SRNO : "+resultSet.getString(1)+ "Username : "+resultSet.getString(2)+",Product Name : "+resultSet.getString(3)+
						",Quantity : "+resultSet.getString(4)+" ,Unit Price : "+resultSet.getString(5)+","
						+ "Total Price : "+resultSet.getString(6));
		
				}
		}catch(Exception e) {
			System.out.println(e);
		}
		}

	}



