package org.example.hostelserviceproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.hostelserviceproject.enums.PaymentEnum;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double amount;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    User user;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    PaymentEnum payment;


    @OneToOne
    @JoinColumn(name = "reservation_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    Reservation reservation;
}
