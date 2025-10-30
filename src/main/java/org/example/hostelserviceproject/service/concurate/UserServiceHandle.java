package org.example.hostelserviceproject.service.concurate;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.UserRequest;
import org.example.hostelserviceproject.dto.response.UserResponse;
import org.example.hostelserviceproject.entity.Customer;
import org.example.hostelserviceproject.entity.Reservation;
import org.example.hostelserviceproject.entity.Student;
import org.example.hostelserviceproject.entity.User;
import org.example.hostelserviceproject.mapper.UserMapper;
import org.example.hostelserviceproject.repository.ReservationRepository;
import org.example.hostelserviceproject.repository.UserRepository;
import org.example.hostelserviceproject.service.abstraction.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceHandle implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ReservationRepository reservationRepository;

    @Override
    public void addUser(UserRequest userRequest) {
        if (userRequest.getStudentCardNumber() != null) {
            userMapper.studentBuilder(userRequest);
        } else {
            userMapper.customerBuilder(userRequest);
        }


    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found user!"));

        return userMapper.userResponse(user);
    }

    @Override
    public User updateUser(Long id, UserRequest userRequest) {

        if (userRequest.getStudentCardNumber() != null) {
            Student user = (Student) userRepository.findById(id).
                    orElseThrow(() -> new RuntimeException("Not found student!"));
            Reservation reservation = reservationRepository.findById(userRequest.getReservationId()).
                    orElseThrow(() -> new RuntimeException("Not found reservation!"));
            if (userRequest.getName() != null && !userRequest.getName().isEmpty()) {
                user.setName(userRequest.getName());
            }
            if (userRequest.getEmail() != null && !userRequest.getEmail().isEmpty()) {
                user.setEmail(userRequest.getEmail());
            }
            if (userRequest.getPhoneNumber() != null && !userRequest.getPhoneNumber().isEmpty()) {
                user.setPhoneNumber(userRequest.getPhoneNumber());
            }
            if (userRequest.getUniversityName() != null && !userRequest.getUniversityName().isEmpty()) {
                user.setUniversityName(user.getUniversityName());
            }
            if (userRequest.getStudentCardNumber() != null && !userRequest.getStudentCardNumber().isEmpty()) {
                user.setStudentCardNumber(user.getStudentCardNumber());
            }
            user.setReservation(reservation);
            return userRepository.save(user);
        } else {
            Customer user = (Customer) userRepository.findById(id).
                    orElseThrow(() -> new RuntimeException("Not found customer!"));

            Reservation reservation = reservationRepository.findById(userRequest.getReservationId()).
                    orElseThrow(() -> new RuntimeException("Not found reservation!"));

            if (userRequest.getName() != null && !userRequest.getName().isEmpty()) {
                user.setName(userRequest.getName());
            }
            if (userRequest.getEmail() != null && !userRequest.getEmail().isEmpty()) {
                user.setEmail(userRequest.getEmail());
            }
            if (userRequest.getPhoneNumber() != null && !userRequest.getPhoneNumber().isEmpty()) {
                user.setPhoneNumber(userRequest.getPhoneNumber());
            }
            if (userRequest.getCountry() != null && !userRequest.getCountry().isEmpty()) {
                user.setCountry(userRequest.getCountry());
            }
            if (userRequest.getPassportNumber() != null && !userRequest.getPassportNumber().isEmpty()) {
                user.setPassportNumber(userRequest.getPassportNumber());
            }
            user.setReservation(reservation);


            return userRepository.save(user);

        }
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Not found user!"));
        userRepository.delete(user);

    }
}
