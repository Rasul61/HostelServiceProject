package org.example.hostelserviceproject.sevice.concurate;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.ReservationRequest;
import org.example.hostelserviceproject.dto.response.ReservationResponse;
import org.example.hostelserviceproject.entity.Reservation;
import org.example.hostelserviceproject.entity.Room;
import org.example.hostelserviceproject.entity.User;
import org.example.hostelserviceproject.mapper.ReservationMapper;
import org.example.hostelserviceproject.repository.ReservationRepository;
import org.example.hostelserviceproject.repository.RoomRepository;
import org.example.hostelserviceproject.repository.UserRepository;
import org.example.hostelserviceproject.sevice.abstraction.ReservationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceHandle implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;


    @Override
    public Reservation addReservation(ReservationRequest reservationRequest) {
        Reservation reservation = reservationMapper.requestToEntity(reservationRequest);
        reservation.setStartDate(LocalDateTime.now());
        reservation.setEndDate(LocalDateTime.now().plusDays(1));
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public ReservationResponse getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found reservation!"));


        return reservationMapper.entityToResponse(reservation);
    }

    @Override
    public Reservation updateReservation(Long id, ReservationRequest reservationRequest) {
        Reservation reservation = reservationRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found reservation!"));
        Room room = roomRepository.findById(reservationRequest.getRoomId()).
                orElseThrow(() -> new RuntimeException("Not found room!"));
        User user = userRepository.findById(reservationRequest.getUserId()).
                orElseThrow(() -> new RuntimeException("Not found user !"));

        reservation.setStartDate(reservationRequest.getStartDate());
        reservation.setEndDate(reservationRequest.getEndDate());
        if (reservationRequest.getUserId() != null) {
            reservation.setUser(user);
        }
        if (reservationRequest.getRoomId() != null) {
            reservation.setRoom(room);
        }


        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        roomRepository.deleteById(id);

    }
}
