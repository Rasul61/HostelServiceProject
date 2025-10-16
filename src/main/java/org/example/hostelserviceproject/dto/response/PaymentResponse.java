package org.example.hostelserviceproject.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.hostelserviceproject.entity.Reservation;
import org.example.hostelserviceproject.entity.User;
import org.example.hostelserviceproject.enums.PaymentEnum;
@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class PaymentResponse {
    Double amount;
    User user;
    Reservation reservation;
    @Enumerated(EnumType.STRING)
    PaymentEnum status;
}
