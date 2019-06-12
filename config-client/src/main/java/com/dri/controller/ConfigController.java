package com.dri.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//https://www.cnblogs.com/shamo89/p/8016908.html

@RestController
@RefreshScope
public class ConfigController {
	
	@Value("${mytest}")
	private String mytest;
	
	@Value("${zuul.route}")
	private String route;
	
	/**
	 * 2个配置项
	 * management.endpoint.env.enabled= true
	 * management.endpoints.web.exposure.include=refresh
	 * 
	 * 更新用这个POST请求
	 * http://localhost:7020/actuator/refresh
	 * 
	 * @return
	 * 
	 * http://localhost:7020/hi
	 */
	@GetMapping(value = "/hi")
	public String hi() {
		return mytest+"-------"+route;
	}

}
