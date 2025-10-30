package org.example.hostelserviceproject.sevice.concurate;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.RoomRequest;
import org.example.hostelserviceproject.dto.response.RoomResponse;
import org.example.hostelserviceproject.entity.Room;
import org.example.hostelserviceproject.mapper.RoomMapper;
import org.example.hostelserviceproject.repository.RoomRepository;
import org.example.hostelserviceproject.sevice.abstraction.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public RoomResponse getRoomById(Long id) {
        Room room = roomRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found room!"));
        return roomMapper.entityToResponse(room);
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
