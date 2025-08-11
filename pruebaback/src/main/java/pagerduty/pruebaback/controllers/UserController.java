package pagerduty.pruebaback.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pagerduty.pruebaback.dtos.user.CreateUserRequest;
import pagerduty.pruebaback.dtos.user.CreateUserResponse;
import pagerduty.pruebaback.dtos.user.GetAllUsersResponse;
import pagerduty.pruebaback.dtos.user.GetUserResponse;
import pagerduty.pruebaback.entities.User;
import pagerduty.pruebaback.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public GetAllUsersResponse getAllUser() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public GetUserResponse getUserById(@PathVariable long id ) {
        return userService.findUserById(id);
    }

    @PostMapping("/users")
    public CreateUserResponse createUsers(@RequestBody @Valid CreateUserRequest request) {
        return userService.createUser(request);
    }

}