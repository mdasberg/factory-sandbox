package nl.badgerhill.sandbox.clock;

import java.time.Instant;

/** Read model returned by the module's API. */
public record CurrentTime(Instant time) {
}
