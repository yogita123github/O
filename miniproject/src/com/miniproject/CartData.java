package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CartData 
{
	
	
		  void cDetails() {
		
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
	 
	          System.out.println( " productid: "+rs.getInt(1)+ "  \n description: "+rs.getString(2)+" \n price: "+rs.getString(3)+
			   " \n name: "+rs.getString(4)+ " \n quantity:"+rs.getString(5));

	          System.out.println();
	
             }
           System.out.println("enter size of the cart");
           int cartsize=sc.nextInt();
           for(int i=0;i<cartsize;i++) 
            {
              System.out.println("enter product id to add product to cart:");
               int id=sc.nextInt();

               System.out.println("enter quantity of the selected product :");
           	int quantity=sc.nextInt();
           	Statement st1=con.createStatement();


           	ResultSet rs1=st1.executeQuery("select * from productitem where product_id="+id+"");
           	while(rs1.next())
           	{
           	System.out.println("Name: "+rs1.getString(4)+"  Price: "+rs1.getInt(3));
           	float total=rs1.getInt(3) * quantity;
           	System.out.println("Total: "+total);

           		sum+=total;
}
}
           System.out.println("grandtotal: "+sum);

			} catch (ClassNotFoundException |SQLException e)
			{
				
				e.printStackTrace();
			}

	

	}
}