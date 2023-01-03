package com.miniproject;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductDisplay 
{
	int choice() {
		
		int num;
		String c="C";
	
		
		System.out.println("If you want buy product Enter letter  C");
	
		System.out.println("If you want to add product to Cart, Enter any key on Keypad");
		Scanner sc=new Scanner(System.in);
		String Choice=sc.next();
		
		if(Choice.equals(c)) 
		{
       	 num=1;
    		
       	 System.out.println("Confirm Username to complete shopping ");
    		//Scanner scanner=new Scanner(System.in);
            String user=sc.next();
       	   buyProduct(user);
       }else {
				num=0;
				CartData cartdata=new CartData();
				cartdata.cDetails();
			}
	
			return num;
		}
	          void buyProduct(String user) 
	          {
	             	double sum=0.0;
	      	        Scanner sc=new Scanner(System.in);
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root");
                 Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from productitem Order by product_name");

                while(rs.next())
            	{
            		 
            		System.out.println( " productid: "+rs.getInt(1)+ "  \n description: "+rs.getString(2)+" \n price: "+rs.getInt(3)+
            				" \n name: "+rs.getString(4)+ " \n quantity:"+rs.getString(5));

            		System.out.println();
            		
            	}
                System.out.println("How many products do you want to buy?");
            	int buyP=sc.nextInt();
            	for(int i=0;i<buyP;i++) 
            	{
            	System.out.println("enter product id");
            	int id=sc.nextInt();

            	System.out.println("Enter product quantity:");
            	int quantity=sc.nextInt();
            	Statement st1=con.createStatement();

         
            	ResultSet rs1=st1.executeQuery("select * from productitem where product_id= "+id+" ");
            	while(rs1.next())
            	{
            	System.out.println("Name: "+rs1.getString(4)+"  Price: "+rs1.getInt(3));
            	double total=+rs1.getInt(3)*quantity;
            	System.out.println("Total: "+total);
            	int oQuantity=rs1.getInt(5);
            		sum+=total;

            		String quant=String.valueOf(quantity);
            		String price=String.valueOf(rs1.getInt(3));
            		String totalS=String.valueOf(sum);
            		
            		
           PreparedStatement ps=con.prepareStatement("insert into buy_product_history(USERNAME,PRODUCT_NAME,PRODUCT_QUANTITY,PRICE,TOTAL_PRICE)values(?,?,?,?,?)");
            		ps.setString(1, user);
            		ps.setString(2, rs1.getString(4));
            		ps.setString(3, quant);
            		ps.setString(4, price);
            		ps.setString(5, totalS);
            		ps.executeUpdate();
            		
            		int uQuantity=oQuantity-quantity;
            		String updateQ=String.valueOf(uQuantity);
            		
            		PreparedStatement ps1=con.prepareStatement("update productitem set product_quantity=? where product_name=?");
            		ps1.setString(1, updateQ);
            		ps1.setString(2, rs1.getString(4));
            		ps1.executeUpdate();
}
            		
            		}
            		System.out.println("grandtotal: "+sum);

            					} catch (ClassNotFoundException |SQLException e) {
            						
            						e.printStackTrace();
            					}

            			}
            		}


		
            
	          
