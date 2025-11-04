package org.example.hostelserviceproject.service.abstraction;

import org.example.hostelserviceproject.dto.request.UserRequest;
import org.example.hostelserviceproject.dto.response.UserResponse;
import org.example.hostelserviceproject.entity.User;

import java.util.List;

public interface UserService {
    void addUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    User updateUser(Long id, UserRequest userRequest);

    void deleteUser(Long id);


}
