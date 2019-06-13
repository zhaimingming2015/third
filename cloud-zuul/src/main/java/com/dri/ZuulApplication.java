package com.dri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.dri.filter.MyFilter;
/**
 * https://www.liangzl.com/get-article-detail-20957.html
 * https://www.cnblogs.com/lexiaofei/p/7080257.html
 * https://www.cnblogs.com/duanxz/p/7527765.html
 * 
 * 
 * 
 * @author Administrator
 *实现了接口权限校验与微服务业务逻辑的解耦
 *实现了断路器，不会因为具体微服务的故障而导致服务网关的阻塞，依然可以对外服务
 */

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ZuulApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(ZuulApplication.class, args);
	}

	@Bean
	public MyFilter myFilter() {
		return new MyFilter();
	}
}
