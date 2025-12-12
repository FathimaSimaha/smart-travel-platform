package com.travel.booking_service.service;

import com.travel.booking_service.entity.Booking;
import com.travel.booking_service.entity.BookingStatus;
import com.travel.booking_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking createPendingBooking(Long userId, Long flightId, Long hotelId, LocalDate travelDate) {
        Booking booking = new Booking(userId, flightId, hotelId, travelDate);
        booking.setStatus(BookingStatus.PENDING);
        booking.setTotalCost(0.0);  // Placeholder
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId);
    }

    public void updateStatus(Long bookingId, BookingStatus status) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        optionalBooking.ifPresent(booking -> {
            booking.setStatus(status);
            bookingRepository.save(booking);
        });
    }

    public void createSampleBookings() {
        if (bookingRepository.count() == 0) {
            LocalDate sampleDate = LocalDate.of(2025, 1, 10);
            bookingRepository.save(new Booking(1L, 1L, 1L, sampleDate));
        }
    }
}