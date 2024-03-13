package com.metlife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ScoreServiceMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreServiceMsApplication.class, args);
	}

}
