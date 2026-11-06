package nl.badgerhill.sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nl.badgerhill.sandbox.greeting.Greeting;
import nl.badgerhill.sandbox.greeting.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GreetingApiTest {

    @Autowired
    GreetingService greetings;

    @Test
    void greetsAndRemembers() {
        Greeting g = greetings.greet("factory");
        assertThat(g.text()).isEqualTo("Hello, factory!");
        List<Greeting> all = greetings.history();
        assertThat(all).extracting(Greeting::name).contains("factory");
    }
}
