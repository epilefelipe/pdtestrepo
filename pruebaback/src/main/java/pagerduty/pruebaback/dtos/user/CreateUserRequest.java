package pagerduty.pruebaback.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
