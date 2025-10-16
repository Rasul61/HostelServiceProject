package org.example.hostelserviceproject.mapper;


import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.ReservationRequest;
import org.example.hostelserviceproject.dto.response.ReservationResponse;
import org.example.hostelserviceproject.entity.Reservation;
import org.example.hostelserviceproject.entity.Room;
import org.example.hostelserviceproject.entity.User;
import org.example.hostelserviceproject.repository.RoomRepository;
import org.example.hostelserviceproject.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationMapper {
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public Reservation requestToEntity(ReservationRequest reservationRequest) {
        User user = userRepository.getById(reservationRequest.getUserId());
        Room room = roomRepository.getById(reservationRequest.getRoomId());
        return Reservation.builder()
                .startDate(reservationRequest.getStartDate())
                .endDate(reservationRequest.getEndDate())
                .user(user)
                .room(room)
                .build();
    }

    public ReservationResponse entityToResponse(Reservation reservation) {
        return ReservationResponse.builder()
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .user(reservation.getUser())
                .room(reservation.getRoom())
                .build();
    }

}
