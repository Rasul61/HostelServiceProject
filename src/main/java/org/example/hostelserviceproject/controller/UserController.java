package org.example.hostelserviceproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.hostelserviceproject.dto.request.UserRequest;
import org.example.hostelserviceproject.dto.response.UserResponse;
import org.example.hostelserviceproject.entity.User;
import org.example.hostelserviceproject.service.abstraction.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createUser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
    }

    @GetMapping("/id/{id}")
    UserResponse findUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @GetMapping
    List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    User updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }

    @DeleteMapping("/id/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
