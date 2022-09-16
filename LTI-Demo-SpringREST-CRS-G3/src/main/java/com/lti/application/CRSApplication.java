package com.lti.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lti.controller.UserController;
import com.lti.exception.Studentalreadyregistered;

@SpringBootApplication
@Configuration
@ComponentScan( {"com.lti.*"})
@EnableAutoConfiguration

public class CRSApplication {

	public static void main(String[] args) throws Studentalreadyregistered{
		SpringApplication.run(CRSApplication.class, args);
	//UserController obj = new UserController();
	//obj.displaymain();
	}

}
