package org.example.hostelserviceproject.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.hostelserviceproject.entity.Reservation;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserResponse {
    String name;
    String email;
    String phoneNumber;
    String universityName;
    String country;
    Reservation reservation;

}
