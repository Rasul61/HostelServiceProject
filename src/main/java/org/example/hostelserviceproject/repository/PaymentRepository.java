package org.example.hostelserviceproject.repository;

import org.example.hostelserviceproject.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
