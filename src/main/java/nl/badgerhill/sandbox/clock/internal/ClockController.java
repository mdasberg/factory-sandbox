package nl.badgerhill.sandbox.clock.internal;

import nl.badgerhill.sandbox.clock.ClockService;
import nl.badgerhill.sandbox.clock.CurrentTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ClockController {

    private final ClockService service;

    ClockController(ClockService service) {
        this.service = service;
    }

    @GetMapping("/time")
    CurrentTime time() {
        return service.now();
    }
}
