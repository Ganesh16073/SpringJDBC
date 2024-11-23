package com.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.config.AppConfig;
import com.model.Register;

public class AppMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt=new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate t=cxt.getBean("getTemplate",JdbcTemplate.class);
		if(t!=null)
		{
			System.out.println("Connected to database");
		}
		
	}
}
