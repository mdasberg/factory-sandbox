package nl.badgerhill.sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import nl.badgerhill.sandbox.clock.ClockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClockApiTest {

    @Autowired
    ClockService clock;

    @Test
    void tellsCurrentTime() {
        Instant before = Instant.now();
        Instant time = clock.now().time();
        assertThat(time).isBetween(before, Instant.now());
    }
}
