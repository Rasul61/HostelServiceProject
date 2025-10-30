package org.example.hostelserviceproject.sevice.abstraction;

import org.example.hostelserviceproject.dto.request.ReservationRequest;
import org.example.hostelserviceproject.dto.response.ReservationResponse;
import org.example.hostelserviceproject.entity.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(ReservationRequest reservationRequest);

    List<Reservation> getAllReservations();

    ReservationResponse getReservationById(Long id);

    Reservation updateReservation(Long id, ReservationRequest reservationRequest);

    void deleteReservation(Long id);
}
