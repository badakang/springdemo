package com.acorp.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringdemoApplication {

	//https://github.com/soongon/restapp/

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

}
