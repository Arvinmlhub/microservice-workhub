package com.metlife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GradeMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeMsApplication.class, args);
	}

}
