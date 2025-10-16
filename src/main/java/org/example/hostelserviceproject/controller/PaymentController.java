package org.example.hostelserviceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.PaymentRequest;
import org.example.hostelserviceproject.dto.response.PaymentResponse;
import org.example.hostelserviceproject.entity.Payment;
import org.example.hostelserviceproject.sevice.abstraction.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Payment createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.addPayment(paymentRequest);
    }

    @GetMapping
    List<Payment> findAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/id/{id}")
    PaymentResponse getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    Payment updatePayment(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest) {
        return paymentService.updatePayment(id, paymentRequest);
    }

    @DeleteMapping
    void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }


}
