package com.travel.booking_service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HotelDto {
    private Long id;
    private String location;
    private String name;
    private LocalDate checkInDate;
    private Double pricePerNight;
    private Integer roomsAvailable;
    private LocalDateTime createdAt;

    // Default constructor
    public HotelDto() {}

    // Getters and Setters (mirror your Hotel entity)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }
    public Double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(Double pricePerNight) { this.pricePerNight = pricePerNight; }
    public Integer getRoomsAvailable() { return roomsAvailable; }
    public void setRoomsAvailable(Integer roomsAvailable) { this.roomsAvailable = roomsAvailable; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}