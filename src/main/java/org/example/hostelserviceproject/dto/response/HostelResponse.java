package org.example.hostelserviceproject.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class HostelResponse {
    String name;
    String address;
    Integer stars;
}
