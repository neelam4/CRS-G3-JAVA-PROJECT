package com.lti.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DemoCrsSpringG3MicroserviceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCrsSpringG3MicroserviceEurekaServerApplication.class, args);
	}

}
