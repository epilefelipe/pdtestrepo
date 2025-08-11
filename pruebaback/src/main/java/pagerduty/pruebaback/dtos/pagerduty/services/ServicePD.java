package pagerduty.pruebaback.dtos.pagerduty.services;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ServicePD {
    private String id;
    private String summary;
    private String type;
    private String self;
    private String htmlURL;
    private String name;
    private String description;
    private long autoResolveTimeout;
    private long acknowledgementTimeout;
    private Date createdAt;
    private String status;
    private String alertCreation;
    private AlertGroupingParameters alertGroupingParameters;
    private EscalationPolicy[] integrations;
    private EscalationPolicy escalationPolicy;
    private EscalationPolicy[] teams;
    private IncidentUrgencyRule incidentUrgencyRule;
    private SupportHoursClass supportHours;
    private ScheduledAction[] scheduledActions;
    private AutoPauseNotificationsParameters autoPauseNotificationsParameters;
}
