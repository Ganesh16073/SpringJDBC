package com.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the email to find the data");
		String email=sc.nextLine();
		List<Register> li=t.query("select * from register where email=?",new RowMapper<Register>()
				{

					@Override
					public Register mapRow(ResultSet rs, int rowNum) throws SQLException {
						Register r=new Register();
						r.setId(rs.getInt(1));
						r.setName(rs.getString(2));
						r.setEmail(rs.getString(3));
						r.setContact(rs.getInt(4));
						return r;
					}
			
				},email);// here we pass the conditional data
		
		System.out.println("The data is "+li);
		
	}
}
