package com.miniproject;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminPage
{
	void getUserList()  
	{

		
		String check1="P";
		String check2="R";
		String check3="U";
		Scanner scanner=new Scanner(System.in);
		

		System.out.println("welcome to Admin Page ");
		System.out.println("Select one from Given List");
		System.out.println(" To Check  Product Quantity Enter letter P");
		System.out.println("To Check Registerd Users Enter letter R");
		System.out.println("To check user purchase history Enter letter U");
		
		
		String check=scanner.next();

		
		if(check.equals(check1))
		{
		CheckQuantity checkQuantity=new CheckQuantity();
		try {
			
			checkQuantity.getProductQuantity();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		 }
		else if(check.equals(check2)) 
		{
			 DisplayUserList displayUserList=new DisplayUserList();
			 displayUserList.userList();
		 }
		else if(check.equals(check3)) {
			 UserBuyProductHistory userbuyproducthistory=new UserBuyProductHistory();
			 userbuyproducthistory.history();
		 }
		else {
			 System.out.println("Invalid Input");
		 }
		}
	}




