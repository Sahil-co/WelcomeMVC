package com.cg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.controllers.MovieControllers;

@SpringBootApplication
public class MovieAppRestDataJpaLab3Application {

	private static final Logger logger = LoggerFactory.getLogger(MovieAppRestDataJpaLab3Application.class);
	
	public static void main(String[] args) {
		logger.info("**************Tomcat has started*******************");
		SpringApplication.run(MovieAppRestDataJpaLab3Application.class, args);
	}

}
