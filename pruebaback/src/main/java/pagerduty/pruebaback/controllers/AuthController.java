package pagerduty.pruebaback.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pagerduty.pruebaback.dtos.*;
import pagerduty.pruebaback.services.AuthService;

@RestController
@RequestMapping("/api/v1/auth")

@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public SigninResponse signIn(@RequestBody @Valid SigninRequest request){
        return authService.signIn(request);
    }

    @PostMapping("/signup")
    public SignupResponse signUp(@RequestBody @Valid SignupRequest request){
        return authService.signUp(request);
    }
}
