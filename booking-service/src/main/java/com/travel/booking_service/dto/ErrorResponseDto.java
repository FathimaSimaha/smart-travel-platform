package com.travel.booking_service.dto;

import java.time.LocalDateTime;

public class ErrorResponseDto {
    private String message;
    private String timestamp;

    public ErrorResponseDto(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now().toString();
    }

    // Getters
    public String getMessage() { return message; }
    public String getTimestamp() { return timestamp; }
}