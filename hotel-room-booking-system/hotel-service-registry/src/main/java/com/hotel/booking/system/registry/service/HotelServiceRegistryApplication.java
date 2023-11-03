package com.hotel.booking.system.registry.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HotelServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelServiceRegistryApplication.class, args);
	}

}
