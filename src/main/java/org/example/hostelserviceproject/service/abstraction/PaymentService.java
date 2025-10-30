package org.example.hostelserviceproject.service.abstraction;

import org.example.hostelserviceproject.dto.request.PaymentRequest;
import org.example.hostelserviceproject.dto.response.PaymentResponse;
import org.example.hostelserviceproject.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment addPayment(PaymentRequest paymentRequest);

    List<Payment> getAllPayments();

    PaymentResponse getPaymentById(Long id);

    Payment updatePayment(Long id, PaymentRequest paymentRequest);

    void deletePayment(Long id);
}
