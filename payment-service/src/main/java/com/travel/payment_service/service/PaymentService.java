package com.travel.payment_service.service;

import com.travel.payment_service.entity.Payment;
import com.travel.payment_service.entity.PaymentStatus;  // New import
import com.travel.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Long bookingId, Double amount) {
        Payment payment = new Payment(bookingId, amount);
        payment.setStatus(PaymentStatus.SUCCESS);  // Now simple, no red line
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public void createSamplePayments() {
        if (paymentRepository.count() == 0) {
            Payment payment = new Payment(1L, 650.0);
            payment.setStatus(PaymentStatus.SUCCESS);  // Fixed
            paymentRepository.save(payment);
        }
    }
}