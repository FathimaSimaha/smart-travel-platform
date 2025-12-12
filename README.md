# Smart Travel Booking Platform


## Services & Ports
| Service | Port | Key Endpoint |
|---------|------|--------------|
| Booking | 8080 | POST /api/bookings |
| User | 8081 | GET /api/users/{id} |
| Flight | 8082 | GET /api/flights/{id} |
| Hotel | 8083 | GET /api/hotels/{id} |
| Payment | 8084 | POST /api/payments |
| Notification | 8085 | POST /api/notifications |

## Communication Flow
1. POST to Booking with {userId, flightId, hotelId, travelDate}.
2. Validate user (WebClient to 8081).
3. Check flight/hotel (Feign to 8082/8083).
4. Calculate cost, save PENDING.
5. Process payment (WebClient to 8084).
6. Send notification (WebClient to 8085).
7. Update CONFIRMED.

## Setup
- Java 17+, Maven, Spring Boot 3.2+.
- Run each: `cd <service> && mvn spring-boot:run`.
- H2 Console: http://localhost:<port>/h2-console.

## Testing
- Postman Collection: smart-travel-postman-collection.json.
- Screenshots: See /screenshots/ folder.

## Submission
- GitHub Repo: [link].
- Postman JSON attached.
- Screenshots of successful flow/errors.