package org.example.hostelserviceproject.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RoomRequest {
    Integer roomNumber;
    Integer pricePerNight;
    Long hostelId;

}
