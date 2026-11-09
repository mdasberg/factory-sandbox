package nl.badgerhill.sandbox.greeting.internal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GoodbyeController {

    @GetMapping("/goodbye")
    String goodbye() {
        return "Goodbye!";
    }
}
