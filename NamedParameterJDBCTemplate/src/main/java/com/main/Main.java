package com.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
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
		
		String query="insert into register value('0',:n,:e,:c)";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Name to Insert");
		String name=sc.nextLine();
		System.out.println("Enter the Email to insert");
		String email=sc.nextLine();
		System.out.println("Enter the Contact to insert");
		String contact=sc.nextLine();
		Map<String,Object> m=new LinkedHashMap<>();
		m.put("n", name);
		m.put("e", email);
		m.put("c", contact);
		
//		int value=t.execute(query, m,new PreparedStatementCallback<T>() // not working some problem
//				{
//
//					@Override
//					public T doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
//						
//						return ps.executeUpdate();
//					}
//			
//				});
		
		int val=t.execute(query, m, (ps-> ps.executeUpdate()));
		if(val>0)
		{
			System.out.println("Data Inserted");
		}
		else
		{
			System.out.println("Data Not Inserted");
		}
	}
	
}
