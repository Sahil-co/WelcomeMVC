package com.cg.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHelloWorldController {

	@RequestMapping("/hello")
	public String sayHello1() {
		System.out.println("In Hello1() .... ");
		
		return "Hello World from rest";
	}
	
	@RequestMapping("/hi/{name}")
	public String sayHello2(@PathVariable String name) {
		System.out.println("In Hello2() .... ");
		
		return "Hello World from rest "+name;
	}
}
