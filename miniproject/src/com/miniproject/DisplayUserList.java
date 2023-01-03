package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayUserList
{
	void userList() {
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
			
			
		   PreparedStatement preparedStatement=connection.prepareStatement("Select  FirstName,LastName from userdetails");
		   	ResultSet resultSet=preparedStatement.executeQuery();
			System.out.println("Registerd User List >>>");
			
			while(resultSet.next()) {
				
			System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
	
			}
	}catch(Exception e) {
		System.out.println(e);
	}

}
	
}



