package edu.iis.mto.time;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class FakeClock extends Clock {
    private Instant onClockStart = Instant.now();
    private long count = 0L;
    private long secondsToBeAddedToInstantOfClock;

    public FakeClock(long secondsToBeAddedToInstantOfClock) {
        this.secondsToBeAddedToInstantOfClock = secondsToBeAddedToInstantOfClock;
    }

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
        Instant returnedInstant = Instant.now().plusSeconds(count);
        count += secondsToBeAddedToInstantOfClock;
        return returnedInstant;
    }
}
