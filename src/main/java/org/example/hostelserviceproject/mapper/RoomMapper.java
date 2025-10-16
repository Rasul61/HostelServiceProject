package org.example.hostelserviceproject.mapper;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.RoomRequest;
import org.example.hostelserviceproject.dto.response.RoomResponse;
import org.example.hostelserviceproject.entity.Hostel;
import org.example.hostelserviceproject.entity.Room;
import org.example.hostelserviceproject.repository.HostelRepository;
import org.example.hostelserviceproject.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomMapper {
    private final UserRepository userRepository;
    private final HostelRepository hostelRepository;

    public Room requestToEntity(RoomRequest roomRequest) {
        // User user = userRepository.getById(roomRequest.getUserId());
        Hostel hostel = hostelRepository.getById(roomRequest.getHostelId());
        return Room.builder()
                .roomNumber(roomRequest.getRoomNumber())
                .pricePerNight(roomRequest.getPricePerNight())
                .hostel(hostel)
                .build();
    }

    public RoomResponse entityToResponse(Room room) {

        return RoomResponse.builder()
                .roomNumber(room.getRoomNumber())
                .pricePerNight(room.getPricePerNight())
                // .user(room.getUser())
                .hostel(room.getHostel())
                .build();
    }

}
