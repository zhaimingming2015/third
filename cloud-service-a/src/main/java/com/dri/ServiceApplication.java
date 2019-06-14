package com.dri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(ServiceApplication.class, args);
	}

}
