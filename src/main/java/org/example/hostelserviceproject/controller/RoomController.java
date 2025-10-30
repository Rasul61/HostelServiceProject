package org.example.hostelserviceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.RoomRequest;
import org.example.hostelserviceproject.dto.response.RoomResponse;
import org.example.hostelserviceproject.entity.Room;
import org.example.hostelserviceproject.service.abstraction.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/room")

public class RoomController {
    private final RoomService roomService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createRoom(@RequestBody RoomRequest roomRequest) {
        roomService.addRoom(roomRequest);
    }

    @GetMapping
    List<Room> findAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/id/{id}")
    RoomResponse findRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Room updateRoom(@PathVariable Long id, @RequestBody RoomRequest roomRequest) {
        return roomService.updateRoom(id, roomRequest);
    }

    @DeleteMapping("/id/{id}")
    void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }


}
