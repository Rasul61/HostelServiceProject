package org.example.hostelserviceproject.repository;

import org.example.hostelserviceproject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
