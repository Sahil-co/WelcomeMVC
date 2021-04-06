package com.cg.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/hello")
public class WelcomeController {

	@RequestMapping("/show")
	public String sayHello(Model m) {
		
		m.addAttribute("message", "Hello World from SpringBoot MVC...>!!!!");
		return "success";
	}
}
