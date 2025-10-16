package org.example.hostelserviceproject.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserResponse {
    String name;
    String email;
    String phoneNumber;
    String universityName;
    String country;

}
