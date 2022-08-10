package com.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantserviceApplication.class, args);
	}

}
