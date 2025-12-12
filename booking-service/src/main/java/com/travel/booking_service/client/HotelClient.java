package com.travel.booking_service.client;

import com.travel.booking_service.dto.HotelDto;  
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hotel-service", url = "http://localhost:8083")
public interface HotelClient {
    @GetMapping("/api/hotels/{id}")
    HotelDto getHotel(@PathVariable Long id);  
}