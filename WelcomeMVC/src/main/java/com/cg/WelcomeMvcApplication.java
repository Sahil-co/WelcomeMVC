package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cg.controller"})
public class WelcomeMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(WelcomeMvcApplication.class, args);
	}

}
