package pagerduty.pruebaback.dtos.pagerduty.services;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutoPauseNotificationsParameters {
    private boolean enabled;
    private long timeout;
}
