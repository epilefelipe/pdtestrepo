package pagerduty.pruebaback.dtos;

import lombok.Getter;
import lombok.Setter;
import pagerduty.pruebaback.services.pagerduty.PDBusinessServices;

@Getter
@Setter
public class BusinessServicesResponse {
    private PDBusinessServices[] services;
    private long limit;
    private long offset;
    private boolean more;
    private Object total;
}


