package pagerduty.pruebaback.dtos.user;

import lombok.Builder;
import lombok.Getter;
import pagerduty.pruebaback.entities.User;

import java.util.List;

@Builder
@Getter
public class GetAllUsersResponse {

    private List<User> users;
}
