package pagerduty.pruebaback.dtos.pagerduty.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentUrgencyRule {
    private String type;
    private SupportHours duringSupportHours;
    private SupportHours outsideSupportHours;

}
