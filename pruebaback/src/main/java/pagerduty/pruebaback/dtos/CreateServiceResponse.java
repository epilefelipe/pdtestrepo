package pagerduty.pruebaback.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CreateServiceResponse {

    private ServiceDTO service;

    @Data
    public static class ServiceDTO {
        private String type;
        private String name;
        private String description;
        private int auto_resolve_timeout;
        private int acknowledgement_timeout;
        private String status;
        private EscalationPolicyDTO escalation_policy;
        private IncidentUrgencyRuleDTO incident_urgency_rule;
        private SupportHoursDTO support_hours;
        private List<ScheduledActionDTO> scheduled_actions;
        private String alert_creation;
        private AlertGroupingParametersDTO alert_grouping_parameters;
        private AutoPauseNotificationsParametersDTO auto_pause_notifications_parameters;
    }

    @Data
    public static class EscalationPolicyDTO {
        private String id;
        private String type;
    }

    @Data
    public static class IncidentUrgencyRuleDTO {
        private String type;
        private DuringSupportHoursDTO during_support_hours;
        private OutsideSupportHoursDTO outside_support_hours;
    }

    @Data
    public static class DuringSupportHoursDTO {
        private String type;
        private String urgency;
    }

    @Data
    public static class OutsideSupportHoursDTO {
        private String type;
        private String urgency;
    }

    @Data
    public static class SupportHoursDTO {
        private String type;
        private String time_zone;
        private String start_time;
        private String end_time;
        private List<Integer> days_of_week;
    }

    @Data
    public static class ScheduledActionDTO {
        private String type;
        private AtDTO at;
        private String to_urgency;
    }

    @Data
    public static class AtDTO {
        private String type;
        private String name;
    }

    @Data
    public static class AlertGroupingParametersDTO {
        private String type;
        private ConfigDTO config;
    }

    @Data
    public static class ConfigDTO {
        private int timeout;
    }

    @Data
    public static class AutoPauseNotificationsParametersDTO {
        private boolean enabled;
        private int timeout;
    }
}
