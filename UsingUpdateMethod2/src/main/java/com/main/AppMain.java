package com.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.config.AppConfig;

public class AppMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt=new AnnotationConfigApplicationContext(AppConfig.class);
		JdbcTemplate tp=cxt.getBean("getTemplate",JdbcTemplate.class);
		if(tp!=null)
		{
			System.out.println("Connected to database");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Name of player");
			String name=sc.nextLine();
			
			System.out.println("Enter the Run Of player");
			int run=sc.nextInt();
			
			int val=tp.update("insert into Player value ('0',?,?) ",new PreparedStatementSetter()
					{

						@Override
						public void setValues(PreparedStatement ps) throws SQLException {
							ps.setString(1, name);
							ps.setInt(2, run);
							
						}
				
					});
			if(val>0)
			{
				System.out.println("Data inserted into Player Table");
			}
			else
			{
				System.out.println("Data Not Inserted");
			}
		}
	}
	
}
