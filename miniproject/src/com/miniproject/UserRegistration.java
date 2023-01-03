package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration implements Registration
{
	UserDetailsData userdetailsdata=new   UserDetailsData();
	private String fName;
	private String lName;
	private String emailId;
	private String mobileNumber;
	private String userName;
	private String password;
	@Override
	public void getUserDetails()
	{
         UserDetailsData userdetailsdata=new   UserDetailsData();
         
		 System.out.println("Hello,Welcome to Registration of E-commerce platform,please enter your details below");
		 
		 System.out.println("Enter first Name:-");
		 Scanner sc=new Scanner(System.in);
		fName=sc.next();
		
		System.out.println("Enter Last Name:-");
		 lName=sc.next();
		
		System.out.println("Enter EmailId:-");
		 emailId=sc.next();
		
		System.out.println("Enter MobileNumber:-");
		mobileNumber=sc.next();
		
		System.out.println("Enter UserName:-");
		userName=sc.next();
		
		System.out.println("Enter password:-");
		password=sc.next();
		
		UserRegistration userregistration =new UserRegistration();
		userregistration.userDatabase(fName,lName,emailId,mobileNumber,userName,password);
		}
   public void userDatabase(String fname,String lname,String emailid,String mNumber,String username,String password) 
	{
		Connection connection =null;
		
		PreparedStatement ps=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
			ps=connection.prepareStatement("insert into userdetails(FirstName,LastName,EmailId,MobileNumber,UserName,Password)"+"values(?,?,?,?,?,?)");
		    ps.setString(1, fname);
		   ps.setString(2, lname);
		    ps.setString(3, emailid);
		    ps.setString(4, mNumber);
		    ps.setString(5, username);
		    ps.setString(6, password);
			ps.executeUpdate();
			System.out.println(" Thank you ! "+username+" Registered  successfully");
			UserLogin userlogin=new UserLogin();
			userlogin.signIn();
			}
		catch (Exception e) 
		{
			System.out.println(e);

		}
		finally {
			try {
				connection.close();
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			
		}
		

}

}