package com.one.experiment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Experiment1Application {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Experiment1Application.class, args);

//		String sql = "INSERT INTO students (name) VALUES ('sam');";
//		int rows = jdbcTemplate.update(sql);
	}

}
