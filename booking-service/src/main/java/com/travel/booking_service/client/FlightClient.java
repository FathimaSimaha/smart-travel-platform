package com.travel.booking_service.client;

import com.travel.booking_service.dto.FlightDto;  
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "flight-service", url = "http://localhost:8082")
public interface FlightClient {
    @GetMapping("/api/flights/{id}")
    FlightDto getFlight(@PathVariable Long id);  
}