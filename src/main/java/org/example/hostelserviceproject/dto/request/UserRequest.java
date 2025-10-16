package org.example.hostelserviceproject.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserRequest {
    String name;
    String email;
    String phoneNumber;
    //Long reservationId;
    String universityName;
    String studentCardNumber;
    String passportNumber;
    String country;

}
