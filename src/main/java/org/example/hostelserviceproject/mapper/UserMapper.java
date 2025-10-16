package org.example.hostelserviceproject.mapper;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.UserRequest;
import org.example.hostelserviceproject.dto.response.UserResponse;
import org.example.hostelserviceproject.entity.Customer;
import org.example.hostelserviceproject.entity.Student;
import org.example.hostelserviceproject.entity.User;
import org.example.hostelserviceproject.repository.ReservationRepository;
import org.example.hostelserviceproject.repository.UserRepository;
import org.springframework.stereotype.Component;

@Builder
@Component
@RequiredArgsConstructor
public class UserMapper {

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    public User studentBuilder(UserRequest userRequest) {

        // Reservation reservation = reservationRepository.getById(userRequest.getReservationId());

        Student student = Student.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                //.reservation(reservation)
                .universityName(userRequest.getUniversityName())
                .studentCardNumber(userRequest.getStudentCardNumber())
                .country(userRequest.getCountry())
                .build();
        return userRepository.save(student);
    }


    public User customerBuilder(UserRequest userRequest) {

        //  Reservation reservation = reservationRepository.getById(userRequest.getReservationId());

        Customer customer = Customer.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                //.reservation(reservation)
                .passportNumber(userRequest.getPassportNumber())
                .country(userRequest.getCountry())
                .build();
        return userRepository.save(customer);

    }


    public UserResponse userResponse(User user) {
        // Проверяем что это Student а не обычный User
        if (user instanceof Student student) {
            return UserResponse.builder()
                    .name(student.getName())
                    .email(student.getEmail())
                    .phoneNumber(student.getPhoneNumber())
                    //.reservation(student.getReservation())
                    .universityName(student.getUniversityName())
                    .country(student.getCountry())
                    .build();
        }

        // Если это не Student возвращаем только базовые поля
        if (user instanceof Customer customer) {
            return UserResponse.builder()
                    .name(customer.getName())
                    .email(customer.getEmail())
                    .phoneNumber(customer.getPhoneNumber())
                    .country(customer.getCountry())
                    // .reservation(customer.getReservation())
                    .build();
        }
        return null;
    }
}

