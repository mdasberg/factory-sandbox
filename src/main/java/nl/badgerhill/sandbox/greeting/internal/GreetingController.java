package nl.badgerhill.sandbox.greeting.internal;

import java.util.List;
import nl.badgerhill.sandbox.greeting.Greeting;
import nl.badgerhill.sandbox.greeting.GreetingService;
import nl.badgerhill.sandbox.greeting.internal.api.GreetingsApi;
import nl.badgerhill.sandbox.greeting.internal.api.model.GreetRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GreetingController implements GreetingsApi {

    private final GreetingService service;

    GreetingController(GreetingService service) {
        this.service = service;
    }

    @Override
    public Greeting greet(GreetRequest request) {
        return service.greet(request.getName());
    }

    @Override
    public List<Greeting> history() {
        return service.history();
    }
}
