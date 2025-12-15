package com.travel.payment_service.service;

import com.travel.payment_service.entity.Payment;
import com.travel.payment_service.entity.PaymentStatus;
import com.travel.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import jakarta.annotation.PostConstruct;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private WebClient webClient;

    @Autowired 
    private PaymentRepository paymentRepository;

    public Payment processPayment(Long bookingId, Double amount) {
        Payment payment = new Payment(bookingId, amount);
        payment.setStatus(PaymentStatus.SUCCESS);
        Payment saved = paymentRepository.save(payment);

        
        try {
            webClient.post()
                    .uri("http://localhost:8080/api/bookings/confirm/{id}", bookingId)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            System.err.println("Callback to Booking failed: " + e.getMessage());
        }

        return saved;
    }

    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @PostConstruct
    public void createSamplePayments() {
        if (paymentRepository.count() == 0) {
            Payment payment = new Payment(1L, 650.0);
            payment.setStatus(PaymentStatus.SUCCESS);
            paymentRepository.save(payment);
        }
    }
}