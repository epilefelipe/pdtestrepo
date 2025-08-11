package pagerduty.pruebaback.dtos;

import lombok.Getter;
import lombok.Setter;
import pagerduty.pruebaback.dtos.pagerduty.services.ServicePD;

@Getter
@Setter
public class ServicesResponse {
    private ServicePD[] services;
    private long limit;
    private long offset;
    private boolean more;
    private Object total;
}


