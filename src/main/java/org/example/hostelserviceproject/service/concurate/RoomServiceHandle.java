package org.example.hostelserviceproject.service.concurate;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.RoomRequest;
import org.example.hostelserviceproject.dto.response.RoomResponse;
import org.example.hostelserviceproject.entity.Room;
import org.example.hostelserviceproject.mapper.RoomMapper;
import org.example.hostelserviceproject.repository.RoomRepository;
import org.example.hostelserviceproject.service.abstraction.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.hostelserviceproject.mapper.RoomMapper.entityToResponse;

@Service
@RequiredArgsConstructor
public class RoomServiceHandle implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;


    @Override
    public void addRoom(RoomRequest roomRequest) {
        Room room = roomMapper.requestToEntity(roomRequest);
        roomRepository.save(room);
    }

    @Override
    public List<RoomResponse> getAllRooms() {
        return roomRepository.findAll().stream().
                map(RoomMapper::entityToResponse).toList();
    }

    @Override
    public RoomResponse getRoomById(Long id) {
        Room room = roomRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found room!"));
        return entityToResponse(room);
    }

    @Override
    public Room updateRoom(Long id, RoomRequest roomRequest) {
        Room room = roomRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found room!"));
        if (roomRequest.getRoomNumber() != null) {
            room.setRoomNumber(room.getRoomNumber());
        }
        if (roomRequest.getPricePerNight() != null) {
            room.setPricePerNight(room.getPricePerNight());
        }
        if (roomRequest.getHostelId() != null) {
            room.setHostel(room.getHostel());
        }


        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.delete(roomRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found room!")));

    }
}
