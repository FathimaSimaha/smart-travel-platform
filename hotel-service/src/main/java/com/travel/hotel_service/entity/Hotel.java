package com.travel.hotel_service.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;  

    @Column(nullable = false)
    private String name;  

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private Double pricePerNight;

    @Column(nullable = false)
    private Integer roomsAvailable = 10;  // Default available rooms

    private LocalDateTime createdAt = LocalDateTime.now();

    // Default constructor
    public Hotel() {}

    // Constructor with params
    public Hotel(String location, String name, LocalDate checkInDate, Double pricePerNight) {
        this.location = location;
        this.name = name;
        this.checkInDate = checkInDate;
        this.pricePerNight = pricePerNight;
    }

    // Getters and Setters
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