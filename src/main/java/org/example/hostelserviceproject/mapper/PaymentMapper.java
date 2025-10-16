package org.example.hostelserviceproject.mapper;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.PaymentRequest;
import org.example.hostelserviceproject.dto.response.PaymentResponse;
import org.example.hostelserviceproject.entity.Payment;
import org.example.hostelserviceproject.entity.Reservation;
import org.example.hostelserviceproject.entity.User;
import org.example.hostelserviceproject.repository.ReservationRepository;
import org.example.hostelserviceproject.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentMapper {
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    public Payment requestToEntity(PaymentRequest paymentRequest) {
        User user = userRepository.getById(paymentRequest.getUserId());
        Reservation reservation = reservationRepository.getById(paymentRequest.getReservationId());
        return Payment.builder()
                .amount(paymentRequest.getAmount())
                .user(user)
                .reservation(reservation)
                .payment(paymentRequest.getStatus())
                .build();
    }

    public PaymentResponse entityToResponse(Payment payment) {
        return PaymentResponse.builder()
                .amount(payment.getAmount())
                .user(payment.getUser())
                .reservation(payment.getReservation())
                .status(payment.getPayment())
                .build();
    }
}
