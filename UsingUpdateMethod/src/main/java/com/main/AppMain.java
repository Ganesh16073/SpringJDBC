package com.main;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.config.AppConfig;

public class AppMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt=new AnnotationConfigApplicationContext(AppConfig.class);
		
		JdbcTemplate template=cxt.getBean("getTemplate",JdbcTemplate.class);
		System.out.println("Connected to Database successfull.................");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Name of player");
		String name=sc.nextLine();
		
		System.out.println("Enter the Run Of player");
		int run=sc.nextInt();
		
		int val=template.update("insert into player value ('0',?,?)",new Object[] {name,run});
		if(val>0)
		{
			System.out.println("Data inserted into player table successfull................");
		}
		else
		{
			System.out.println("Data not inserted");
		}
	}
}
