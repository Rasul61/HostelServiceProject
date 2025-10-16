package org.example.hostelserviceproject.sevice.concurate;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.UserRequest;
import org.example.hostelserviceproject.dto.response.UserResponse;
import org.example.hostelserviceproject.entity.Customer;
import org.example.hostelserviceproject.entity.Student;
import org.example.hostelserviceproject.entity.User;
import org.example.hostelserviceproject.mapper.UserMapper;
import org.example.hostelserviceproject.repository.UserRepository;
import org.example.hostelserviceproject.sevice.abstraction.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceHandle implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
                    orElseThrow(() -> new RuntimeException("Not found user!"));

            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPhoneNumber(userRequest.getPhoneNumber());
            // user.setReservation(reservation);
            user.setUniversityName(user.getUniversityName());
            user.setStudentCardNumber(user.getStudentCardNumber());

            return userRepository.save(user);
        } else {
            Customer user = (Customer) userRepository.findById(id).
                    orElseThrow(() -> new RuntimeException("Not found user!"));


            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPhoneNumber(userRequest.getPhoneNumber());
            user.setCountry(userRequest.getCountry());
            user.setPassportNumber(userRequest.getPassportNumber());

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
