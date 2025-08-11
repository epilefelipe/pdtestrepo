package pagerduty.pruebaback.dtos.user;

import lombok.Builder;
import lombok.Getter;
import pagerduty.pruebaback.entities.User;

@Builder
@Getter
public class GetUserResponse {
    private User user;
}
