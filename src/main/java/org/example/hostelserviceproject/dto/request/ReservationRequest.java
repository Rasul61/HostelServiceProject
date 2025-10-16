package org.example.hostelserviceproject.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ReservationRequest {
    LocalDateTime startDate;
    LocalDateTime endDate;
    Long userId;
    Long roomId;
}
