package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserLogin
{
	String userName1;
	String password2;
	String Admin="admin";
	String Apassword="admin123";
	
	UserLogin(){
		Scanner sc=new Scanner(System.in);
		System.out.println("hello,please Enter Login Details");
		System.out.println("Enter Username");
		 userName1=sc.next();
		System.out.println("Enter Password");
		 password2=sc.next();
		
	}
	void signIn() throws SQLException 
	{
		if(userName1.equals(Admin) && password2.equals(Apassword)) 
		{
		
			   AdminPage adminpage=new AdminPage();
			   adminpage.getUserList();
				  
		}else 
		{
		 saveData();
	    }

	}
	void saveData()
	{
		try {
			Connection connection=null;
			PreparedStatement ps=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			   connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
			   ps=connection.prepareStatement("select Password from userdetails where UserName=?");
			   ps.setString(1, userName1);
				 ResultSet resultSet= ps.executeQuery();
				 
				 while(resultSet.next()) 
				 {
						String UPassword =resultSet.getString(1);
						 if(UPassword.equals(password2)) 
						 {
							 
							 ProductDisplay pd= new ProductDisplay();
								pd.choice();
								
								
								DisplayUserList displayUserList=new DisplayUserList();
								 displayUserList.userList();

							 UserBuyProductHistory userbuyproducthistory=new UserBuyProductHistory();
							 userbuyproducthistory.history();
								
						 }
					    else 
						{
								System.out.println("Invalid Password or Username");
					    }
				 }	
					
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
	
	}


	       
	}
		



