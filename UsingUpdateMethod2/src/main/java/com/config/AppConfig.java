package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.main")
public class AppConfig {
	
	@Bean
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource d=new DriverManagerDataSource();
		d.setUsername("root");
		d.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		d.setPassword("Ganesh4237@");
		return d;
	}
	
	@Bean
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate t=new JdbcTemplate();
		t.setDataSource(getDataSource());
		return t;
	}

}
