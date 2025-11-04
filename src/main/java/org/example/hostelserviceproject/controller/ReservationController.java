package org.example.hostelserviceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.ReservationRequest;
import org.example.hostelserviceproject.dto.response.ReservationResponse;
import org.example.hostelserviceproject.entity.Reservation;
import org.example.hostelserviceproject.service.abstraction.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")

public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Reservation createReservation(@RequestBody ReservationRequest reservationRequest) {
        return reservationService.addReservation(reservationRequest);
    }

    @GetMapping
    List<ReservationResponse> findAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/id/{id}")
    ReservationResponse findReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Reservation updateReservation(@PathVariable Long id, @RequestBody ReservationRequest reservationRequest) {
        return reservationService.updateReservation(id, reservationRequest);
    }

    @DeleteMapping("/id/{id}")
    void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }

}
