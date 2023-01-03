package com.miniproject;

import java.sql.SQLException;

public class MainProject {

	public static void main(String[] args) throws SQLException
	{
		
		WelcomeUser welcomeUser=new WelcomeUser();
		int result=welcomeUser.welcomeUser();
		//System.out.println(result);
		if (result==1) {
			
		
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.getUserDetails();
	}else {
		UserLogin userlogin=new UserLogin();
		userlogin.signIn();
	}
	}
	

	}


