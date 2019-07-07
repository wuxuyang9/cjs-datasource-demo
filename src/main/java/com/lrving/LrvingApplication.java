package com.lrving;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lrving.mapper")
public class LrvingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LrvingApplication.class, args);
	}

}
