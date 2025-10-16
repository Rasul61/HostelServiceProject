package org.example.hostelserviceproject.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.hostelserviceproject.enums.PaymentEnum;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PaymentRequest {
    Double amount;
    Long userId;
    Long reservationId;
    @Enumerated(EnumType.STRING)
    PaymentEnum status;

}
