package com.travel.hotel_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.travel.hotel_service.service.HotelService;

@SpringBootApplication
public class HotelServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(HotelService hotelService) {
        return args -> hotelService.createSampleHotels();
    }
}