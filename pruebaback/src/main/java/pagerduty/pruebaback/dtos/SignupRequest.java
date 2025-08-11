package pagerduty.pruebaback.dtos;

import lombok.Getter;

@Getter
public class SignupRequest {
    private String email;
    private String password;
    private String repeatPassword;
}
