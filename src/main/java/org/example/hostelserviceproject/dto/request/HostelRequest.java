package org.example.hostelserviceproject.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class HostelRequest {
    String name;
    String address;
    Integer stars;
}
