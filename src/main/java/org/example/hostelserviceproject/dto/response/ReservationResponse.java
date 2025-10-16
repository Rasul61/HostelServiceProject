package org.example.hostelserviceproject.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.hostelserviceproject.entity.Room;
import org.example.hostelserviceproject.entity.User;

import java.time.LocalDateTime;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ReservationResponse {
    LocalDateTime startDate;
    LocalDateTime endDate;
    User user;
    Room room;
}
