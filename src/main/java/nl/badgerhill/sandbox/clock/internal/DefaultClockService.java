package nl.badgerhill.sandbox.clock.internal;

import java.time.Instant;
import nl.badgerhill.sandbox.clock.ClockService;
import nl.badgerhill.sandbox.clock.CurrentTime;
import org.springframework.stereotype.Service;

@Service
class DefaultClockService implements ClockService {

    @Override
    public CurrentTime now() {
        return new CurrentTime(Instant.now());
    }
}
