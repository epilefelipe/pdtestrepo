package pagerduty.pruebaback.dtos.pagerduty.services;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetTime;

@Getter
@Setter
class SupportHoursClass {
    private String type;
    private String timeZone;
    private OffsetTime startTime;
    private OffsetTime endTime;
    private long[] daysOfWeek;
}
