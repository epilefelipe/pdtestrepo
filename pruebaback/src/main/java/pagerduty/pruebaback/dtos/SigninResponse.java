package pagerduty.pruebaback.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SigninResponse {

    private final String accessToken;

    private final String refreshToken;
}
