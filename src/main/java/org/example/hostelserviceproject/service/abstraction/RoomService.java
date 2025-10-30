package org.example.hostelserviceproject.service.abstraction;

import org.example.hostelserviceproject.dto.request.RoomRequest;
import org.example.hostelserviceproject.dto.response.RoomResponse;
import org.example.hostelserviceproject.entity.Room;

import java.util.List;

public interface RoomService {
    void addRoom(RoomRequest roomRequest);

    List<Room> getAllRooms();

    RoomResponse getRoomById(Long id);

    Room updateRoom(Long id, RoomRequest roomRequest);

    void deleteRoom(Long id);
}
