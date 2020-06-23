package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.myapp")
@SpringBootApplication
@EnableSwagger2
public class JpaAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(JpaAppApplication.class, args);
		System.out.println("Execution started");
	}

}
