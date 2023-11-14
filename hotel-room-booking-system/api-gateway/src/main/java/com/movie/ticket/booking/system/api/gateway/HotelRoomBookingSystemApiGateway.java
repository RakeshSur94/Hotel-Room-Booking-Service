package com.movie.ticket.booking.system.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelRoomBookingSystemApiGateway {
    public static void main(String[] args) {
        SpringApplication.run(HotelRoomBookingSystemApiGateway.class, args);
    }
}