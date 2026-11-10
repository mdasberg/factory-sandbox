package nl.badgerhill.sandbox.greeting.internal;

import jakarta.validation.constraints.NotBlank;
import java.util.List;
import nl.badgerhill.sandbox.greeting.Greeting;
import nl.badgerhill.sandbox.greeting.GreetingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
@Validated
class GreetingController {

    private final GreetingService service;

    GreetingController(GreetingService service) {
        this.service = service;
    }

    record GreetRequest(@NotBlank String name) {
    }

    @PostMapping
    Greeting greet(@RequestBody @jakarta.validation.Valid GreetRequest request) {
        return service.greet(request.name());
    }

    @PostMapping("/farewell")
    Greeting farewell(@RequestBody @jakarta.validation.Valid GreetRequest request) {
        return service.farewell(request.name());
    }

    @GetMapping
    List<Greeting> history() {
        return service.history();
    }
}
