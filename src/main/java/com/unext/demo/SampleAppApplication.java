package com.unext.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class SampleAppApplication {
	
	/*
	 * @GetMapping("/api") public String greeting() { return "Good Morning"; }
	 */
	

	public static void main(String[] args) {
		SpringApplication.run(SampleAppApplication.class, args);
	}

}
