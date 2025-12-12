package com.travel.booking_service.dto;

import com.travel.booking_service.entity.Booking;
import com.travel.booking_service.entity.BookingStatus;
import java.time.LocalDate;

public class BookingResponseDto {
    private Long id;
    private Long userId;
    private Long flightId;
    private Long hotelId;
    private LocalDate travelDate;
    private Double totalCost;
    private BookingStatus status;

    // Constructor from entity
    public BookingResponseDto(Booking booking) {
        this.id = booking.getId();
        this.userId = booking.getUserId();
        this.flightId = booking.getFlightId();
        this.hotelId = booking.getHotelId();
        this.travelDate = booking.getTravelDate();
        this.totalCost = booking.getTotalCost();
        this.status = booking.getStatus();
    }

    // Getters (no setters for response)
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getFlightId() { return flightId; }
    public Long getHotelId() { return hotelId; }
    public LocalDate getTravelDate() { return travelDate; }
    public Double getTotalCost() { return totalCost; }
    public BookingStatus getStatus() { return status; }
}