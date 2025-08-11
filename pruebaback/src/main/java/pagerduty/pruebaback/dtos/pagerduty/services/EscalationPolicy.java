package pagerduty.pruebaback.dtos.pagerduty.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EscalationPolicy {
    private String id;
    private String type;
    private String summary;
    private String self;
    private String htmlURL;
}
