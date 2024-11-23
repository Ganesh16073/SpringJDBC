package com.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.config.AppConfig;

public class MainApp {
	public static void main(String[] args) { // ONLY CONFIGURATION
		
		AnnotationConfigApplicationContext cxt=new AnnotationConfigApplicationContext(AppConfig.class);
		
		JdbcTemplate t=cxt.getBean("getTemplate",JdbcTemplate.class);
		
		t.execute("insert into player value ('0','Ganesh',45)");
		System.out.println("Connected to dataBase.....................");
	}

}
