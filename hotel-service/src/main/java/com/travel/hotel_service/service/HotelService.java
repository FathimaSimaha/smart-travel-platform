package com.travel.hotel_service.service;

import com.travel.hotel_service.entity.Hotel;
import com.travel.hotel_service.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Optional<Hotel> getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId);
    }

    // Seed test data
    public void createSampleHotels() {
        if (hotelRepository.count() == 0) {
            LocalDate sampleDate = LocalDate.of(2025, 1, 10);  // Matches booking example
            hotelRepository.save(new Hotel("London", "Grand Hotel", sampleDate, 150.0));
            hotelRepository.save(new Hotel("Paris", "Eiffel Inn", sampleDate, 200.0));
            // Hotel ID 55 for testing (auto-gen starts at 1; manual insert later if needed)
        }
    }
}