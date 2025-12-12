package com.travel.payment_service;  // Fixed: camelCase, no underscore

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import com.travel.payment_service.service.PaymentService;  // Import your service

@SpringBootApplication
@Configuration  // Explicit for bean definitions
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(PaymentService paymentService) {
        return args -> paymentService.createSamplePayments();
    }
}