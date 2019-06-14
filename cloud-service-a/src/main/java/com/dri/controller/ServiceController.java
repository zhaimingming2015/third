package com.dri.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dri.service.BusinessService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

import javafx.beans.DefaultProperty;



@RestController
public class ServiceController {
	private final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private BusinessService businessService;
	
	@HystrixCommand
	@GetMapping("/get")
	public String get() throws Exception {
		
		/*
		 * try { //Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		logger.info(System.currentTimeMillis()+"start");
		//Thread.sleep(12000);
		logger.info(System.currentTimeMillis()+"end");
		return  "get A service";
	}
	
	@PostMapping("/test")
	public String test() {
		String param="good";
		return businessService.test(param);
	}

}
