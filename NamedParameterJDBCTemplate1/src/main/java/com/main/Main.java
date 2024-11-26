package com.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.config.AppConfig;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt=new AnnotationConfigApplicationContext(AppConfig.class);
		
		NamedParameterJdbcTemplate t= cxt.getBean("getTemplate",NamedParameterJdbcTemplate.class);
		if(t!=null)
		{
			System.out.println("Connected to Database");
		}
		else
		{
			System.out.println("Not Connected To Database");
		}
	}
	
}
