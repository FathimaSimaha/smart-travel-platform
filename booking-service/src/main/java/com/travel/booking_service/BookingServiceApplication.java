package com.travel.booking_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.travel.booking_service.service.BookingService;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BookingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(BookingService bookingService) {
        return args -> bookingService.createSampleBookings();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}