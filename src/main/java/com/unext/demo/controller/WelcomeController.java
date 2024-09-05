package com.unext.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/api")
	public String greeting() {
		return "<h1>Good Morning</h1>";
	}
	
	@GetMapping("/api/all")
	public String greetingAll() {
		return "Good Morning to All";
	}
	
}















