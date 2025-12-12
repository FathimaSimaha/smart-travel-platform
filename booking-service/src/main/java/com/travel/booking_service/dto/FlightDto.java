package com.travel.booking_service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FlightDto {
    private Long id;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private Double price;
    private Boolean available;
    private LocalDateTime createdAt;

    // Default constructor
    public FlightDto() {}

    // Getters and Setters (copy from your Flight entity)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }
    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }
    public LocalDate getDepartureDate() { return departureDate; }
    public void setDepartureDate(LocalDate departureDate) { this.departureDate = departureDate; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}