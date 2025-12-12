package com.travel.booking_service.service;

import com.travel.booking_service.entity.Booking;
import com.travel.booking_service.entity.BookingStatus;
import com.travel.booking_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;
import com.travel.booking_service.client.FlightClient;
import com.travel.booking_service.client.HotelClient;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;    

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightClient flightClient;

    @Autowired
    private HotelClient hotelClient;

    @Autowired
    private WebClient webClient;

    public Booking createPendingBooking(Long userId, Long flightId, Long hotelId, LocalDate travelDate) {
        if (!validateUser(userId)) {
            throw new RuntimeException("Invalid user");
        }
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

    public boolean validateUser(Long userId) {
        try {
            String response = webClient.get()
                    .uri("http://localhost:8081/api/users/{id}", userId)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            return response != null && !response.contains("Not Found");
        } catch (Exception e) {
            return false;
        }
    }

    public void sendNotification(Long userId, String message) {
        try {
            webClient.post()
                    .uri("http://localhost:8085/api/notifications?userId={userId}&message={message}", userId, message)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            System.err.println("Notification failed: " + e.getMessage());
        }
    }

    public Long processPayment(Long bookingId, Double amount) {
        try {
            String response = webClient.post()
                    .uri("http://localhost:8084/api/payments?bookingId={bookingId}&amount={amount}", bookingId, amount)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            // Parse response for paymentId (simple – assume first number)
            return Long.parseLong(response.split("\"id\":")[1].split(",")[0]);
        } catch (Exception e) {
            return -1L;  // Failed
        }
    }

}