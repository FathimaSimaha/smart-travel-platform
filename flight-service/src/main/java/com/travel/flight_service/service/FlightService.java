package com.travel.flight_service.service;

import com.travel.flight_service.entity.Flight;
import com.travel.flight_service.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public Optional<Flight> getFlightById(Long flightId) {
        return flightRepository.findById(flightId);
    }

    // Seed test data
    public void createSampleFlights() {
        if (flightRepository.count() == 0) {
            LocalDate sampleDate = LocalDate.of(2025, 1, 10);  // Matches booking example
            flightRepository.save(new Flight("New York", "London", sampleDate, 500.0));
            flightRepository.save(new Flight("Paris", "Tokyo", sampleDate, 800.0));
            // Flight ID 200 for testing (manual if needed, or let auto-gen)
        }
    }
}