package pagerduty.pruebaback.dtos.user;

import lombok.Builder;
import lombok.Getter;
import pagerduty.pruebaback.entities.User;

@Getter
@Builder
public class CreateUserResponse {
    private User user;
}
