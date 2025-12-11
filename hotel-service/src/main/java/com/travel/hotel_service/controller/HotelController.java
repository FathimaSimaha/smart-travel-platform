package com.travel.hotel_service.controller;

import com.travel.hotel_service.entity.Hotel;
import com.travel.hotel_service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id) {
        return hotelService.getHotelById(id)
                .map(hotel -> ResponseEntity.ok(hotel))
                .orElse(ResponseEntity.notFound().build());
    }
}