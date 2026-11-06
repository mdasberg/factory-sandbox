package nl.badgerhill.sandbox.greeting;

/** Read model returned by the module's API. */
public record Greeting(long id, String name, String text) {
}
