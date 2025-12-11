package com.travel.flight_service.controller;

import com.travel.flight_service.entity.Flight;
import com.travel.flight_service.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id) {
        return flightService.getFlightById(id)
                .map(flight -> ResponseEntity.ok(flight))
                .orElse(ResponseEntity.notFound().build());
    }
}