package com.dri.controller;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 *https://blog.csdn.net/forezp/article/details/83792388 
 *
 *https://blog.csdn.net/zhuyu19911016520/article/details/86499528
 *
 *https://www.cnblogs.com/Irving/p/9343377.html
 * 
 * @author Administrator
 *
 */

@RestController
public class GateController {

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route(p -> p.path("/get")
				.filters(f -> f.addRequestHeader("hello", "test"))
				.uri("http://httpbin.org:80"))
				.build();
	}
}
