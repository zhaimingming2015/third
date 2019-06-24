package com.dri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//https://www.jianshu.com/p/c274f4acadb5
//https://www.cnblogs.com/mujingyu/p/10701026.html

@SpringBootApplication
@EnableDiscoveryClient
public class AuthServerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(AuthServerApplication.class, args);

	}

}
