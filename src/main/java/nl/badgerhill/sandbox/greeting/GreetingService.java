package nl.badgerhill.sandbox.greeting;

import java.util.List;

/** Public API of the greeting module. */
public interface GreetingService {

    Greeting greet(String name);

    Greeting farewell(String name);

    List<Greeting> history();
}
