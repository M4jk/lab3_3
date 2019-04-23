package edu.iis.mto.time;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class RealClock extends Clock {
    private Instant onClockStart = Instant.now();
    private long count = 0L;

    @Override
    public ZoneId getZone() {
        return ZoneId.systemDefault();
    }

    @Override
    public Clock withZone(ZoneId zone) {
        return Clock.fixed(onClockStart, zone);
    }

    @Override
    public Instant instant() {
        ++count;
        return onClockStart.plusSeconds(count);
    }
}
