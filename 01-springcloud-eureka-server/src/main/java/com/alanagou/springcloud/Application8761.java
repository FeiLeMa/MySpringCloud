package com.alanagou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Application8761 {

	public static void main(String[] args) {
		SpringApplication.run(Application8761.class, args);
	}

}

