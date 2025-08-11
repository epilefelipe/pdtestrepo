package pagerduty.pruebaback.dtos;

import lombok.Getter;
import lombok.Setter;
import pagerduty.pruebaback.dtos.pagerduty.services.ServicePD;

@Getter
@Setter
public class ServiceResponse {
    private ServicePD service;
}


