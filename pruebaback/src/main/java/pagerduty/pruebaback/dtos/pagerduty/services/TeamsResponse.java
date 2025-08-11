package pagerduty.pruebaback.dtos.pagerduty.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamsResponse {
    private ServicePD[] services;
    private long limit;
    private long offset;
    private boolean more;
    private Object total;
}


