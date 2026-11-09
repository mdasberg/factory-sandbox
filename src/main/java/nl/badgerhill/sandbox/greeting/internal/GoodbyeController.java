package nl.badgerhill.sandbox.greeting.internal;

import nl.badgerhill.sandbox.greeting.internal.api.GoodbyeApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GoodbyeController implements GoodbyeApi {

    @Override
    public String goodbye() {
        return "Goodbye!";
    }
}
