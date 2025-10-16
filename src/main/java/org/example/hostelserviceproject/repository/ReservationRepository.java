package org.example.hostelserviceproject.repository;

import org.example.hostelserviceproject.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
