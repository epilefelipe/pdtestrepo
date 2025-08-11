package pagerduty.pruebaback.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pagerduty.pruebaback.dtos.*;
import pagerduty.pruebaback.dtos.user.CreateUserRequest;
import pagerduty.pruebaback.entities.User;
import pagerduty.pruebaback.exceptions.errors.ApiError;
import pagerduty.pruebaback.security.JwtSecurityConfig;
import pagerduty.pruebaback.utils.PasswordEncoderConfig;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtSecurityConfig jwtSecurityConfig;
    private final PasswordEncoderConfig passwordEncoder;
    private final ModelMapper modelMapper;


    public SigninResponse signIn(SigninRequest request){
        Optional<User> user = userService.findUserByEmail(request.getEmail());

        if(user.isEmpty()){
            throw new RuntimeException("Invalid email or password");
        }

        boolean matches = passwordEncoder.passwordEncoder().matches(request.getPassword(), user.get().getPassword());

        if(!matches){
            throw new ApiError(HttpStatus.UNAUTHORIZED, "Email o contraseña invalida");
        }

        String token = jwtSecurityConfig.generateToken(user.get().getEmail());
        return SigninResponse.builder().accessToken(token).build();
    }

    public SignupResponse signUp(SignupRequest request){
        Optional<User> user = userService.findUserByEmail(request.getEmail());

        if(user.isPresent()){
            throw new RuntimeException("Email existente");
        }

        CreateUserRequest createUser = modelMapper.map(request, CreateUserRequest.class);

        userService.createUser(createUser);

        return SignupResponse.builder().success("true").build();
    }

    public void signOut(){

    }
}
