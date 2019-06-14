package com.dri.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class BServiceController {

	@HystrixCommand
	@PostMapping("/get")
	public String query(String param) throws Exception {
		
		//Thread.sleep(12000);
		System.out.println("you are pass!!!"+param);
	
		return "query B service";
	}
	
}
