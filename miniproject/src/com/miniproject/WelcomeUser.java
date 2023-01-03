package com.miniproject;

import java.util.Scanner;

public class WelcomeUser 
{
	int welcomeUser() {
		System.out.println("hello,welcome to E-commerce Platform ,for using platform Register first");
		String signUp="N";
		System.out.println("If new User then Enter letter N");
		System.out.println("For existing user then Enter any Key on Keypad ");
		Scanner sc=new Scanner(System.in);
        String a=sc.next();
        int no;
		if(a.equals(signUp)) {
			no=1;
	
		}else {
			no=0;
		
		}
		return no;

}
	
	
	}



