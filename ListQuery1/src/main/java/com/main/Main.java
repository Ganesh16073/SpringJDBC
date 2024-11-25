package com.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.AppConfig.AppConfig;
import com.model.Register;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext cxt=new AnnotationConfigApplicationContext(AppConfig.class);
		
		JdbcTemplate t=cxt.getBean("getTemplate",JdbcTemplate.class);
		if(t!=null)
		{
			System.out.println("Connected to DataBase");
		}
		else
		{
			System.out.println("Not Connected to Database");
		}
		
		Scanner sc=new Scanner(System.in);
		
		boolean running=false;
		while(!running)
		{

			System.out.println("Enter the choice");
			System.out.println("1 : Add Regiser");
			System.out.println("2 : get all Register");
			System.out.println("3 : Exit ");
			int choice=sc.nextInt();
			
			switch(choice)
			{
			
			case 1:
				System.out.println("Enter the Name");
				sc.nextLine();
				String name=sc.nextLine();
				
				System.out.println("Enter the Email");
				String email=sc.nextLine();
				
				System.out.println("Enter the Mobile number");
				int no=sc.nextInt();
				
				int val=t.update("insert into register value ('0',?,?,?)",new Object[] {name, email,no});
				if(val>0)
				{
					System.out.println("Data Inserted");
					
				}
				else
				{
					System.out.println("Data Not Inserted ");
				}
				break;
				
			case 2:
				List<Register> li=t.query("Select * from register",new RowMapper<Register>()
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
					
						});
				
				li.forEach(r -> System.out.println(r));
				break;
				
			case 3:
				System.out.println(">>>>>>>>>>>>>>>>> Thankyou <<<<<<<<<<<<<<<<<");
				running=true;
				break;
				
				default:
					System.out.println("Invalid Choice");
				
			}
			
			
		}
		
		
		
		
	}
}
