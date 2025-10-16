package org.example.hostelserviceproject.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.hostelserviceproject.entity.Hostel;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RoomResponse {
    Integer roomNumber;
    Integer pricePerNight;
    Hostel hostel;
}
