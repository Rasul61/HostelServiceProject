package org.example.hostelserviceproject.sevice.concurate;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.PaymentRequest;
import org.example.hostelserviceproject.dto.response.PaymentResponse;
import org.example.hostelserviceproject.entity.Payment;
import org.example.hostelserviceproject.entity.Reservation;
import org.example.hostelserviceproject.entity.User;
import org.example.hostelserviceproject.enums.PaymentEnum;
import org.example.hostelserviceproject.mapper.PaymentMapper;
import org.example.hostelserviceproject.repository.PaymentRepository;
import org.example.hostelserviceproject.repository.ReservationRepository;
import org.example.hostelserviceproject.repository.UserRepository;
import org.example.hostelserviceproject.sevice.abstraction.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceHandle implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;


    @Override
    public Payment addPayment(PaymentRequest paymentRequest) {
        Payment payment = paymentMapper.requestToEntity(paymentRequest);
        payment.setPayment(PaymentEnum.PAID);

        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found payment!"));
        return paymentMapper.entityToResponse(payment);
    }

    @Override
    public Payment updatePayment(Long id, PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found payment!"));
        User user = userRepository.findById(paymentRequest.getUserId()).
                orElseThrow(() -> new RuntimeException("Not found user!"));
        Reservation reservation = reservationRepository.findById(paymentRequest.getReservationId()).
                orElseThrow(() -> new RuntimeException("Not found reservation!"));

        payment.setPayment(paymentRequest.getStatus());
        payment.setAmount(paymentRequest.getAmount());
        payment.setUser(user);
        payment.setReservation(reservation);


        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);

    }
}
