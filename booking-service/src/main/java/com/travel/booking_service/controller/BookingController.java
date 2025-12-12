package com.travel.booking_service.controller;

import com.travel.booking_service.entity.Booking;
import com.travel.booking_service.entity.BookingStatus;
import com.travel.booking_service.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(
            @RequestParam Long userId,
            @RequestParam Long flightId,
            @RequestParam Long hotelId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate travelDate) {
        Booking booking = bookingService.createPendingBooking(userId, flightId, hotelId, travelDate);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/confirm/{id}")
    public ResponseEntity<String> confirmBooking(@PathVariable Long id) {
        bookingService.updateStatus(id, BookingStatus.CONFIRMED);
        return ResponseEntity.ok("Booking confirmed");
    }

    @RestControllerAdvice
    public class BookingExceptionHandler {
        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}