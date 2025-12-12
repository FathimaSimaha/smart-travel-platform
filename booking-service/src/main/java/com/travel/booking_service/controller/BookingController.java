package com.travel.booking_service.controller;

import com.travel.booking_service.dto.BookingResponseDto;
import com.travel.booking_service.dto.ErrorResponseDto;
import com.travel.booking_service.entity.Booking;
import com.travel.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<?> createBooking(
            @RequestParam Long userId,
            @RequestParam Long flightId,
            @RequestParam Long hotelId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate travelDate) {
        try {
            Booking booking = bookingService.createPendingBooking(userId, flightId, hotelId, travelDate);
            BookingResponseDto dto = new BookingResponseDto(booking);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            ErrorResponseDto error = new ErrorResponseDto("Booking failed: " + e.getMessage());
            return ResponseEntity.badRequest().body(error);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBooking(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .map(booking -> ResponseEntity.ok(new BookingResponseDto(booking)))
                .orElse(ResponseEntity.notFound().build());
    }
}