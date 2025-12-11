package com.travel.flight_service;  

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.travel.flight_service.service.FlightService;  

@SpringBootApplication
public class FlightServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(FlightService flightService) {
        return args -> flightService.createSampleFlights();
    }
}