package pagerduty.pruebaback.dtos.pagerduty.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduledAction {
    private String type;
    private At at;
    private String toUrgency;

}
