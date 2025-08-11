package pagerduty.pruebaback.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pagerduty.pruebaback.dtos.UserDTO;
import pagerduty.pruebaback.dtos.user.CreateUserRequest;
import pagerduty.pruebaback.dtos.user.CreateUserResponse;
import pagerduty.pruebaback.dtos.user.GetAllUsersResponse;
import pagerduty.pruebaback.dtos.user.GetUserResponse;
import pagerduty.pruebaback.entities.User;
import pagerduty.pruebaback.repositories.UserRepository;
import pagerduty.pruebaback.utils.PasswordEncoderConfig;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoderConfig passwordEncoder;

    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public GetUserResponse findUserById(long id){
        User user = userRepository.findById(id).orElse(null);
        return GetUserResponse.builder().user(user).build();
    }

    public CreateUserResponse createUser(CreateUserRequest request){
        User user = modelMapper.map(request, User.class);
        user.setPassword(passwordEncoder.passwordEncoder().encode(request.getPassword()));
        userRepository.save(user);
        return CreateUserResponse.builder().user(user).build();
    }

    public User updateUser(){
        return null;
    }

    public User deleteUser(){
        return null;
    }

    public GetAllUsersResponse getUsers(){
        List<User> users = userRepository.findAll();

        return GetAllUsersResponse.builder().users(users).build();
    }
}