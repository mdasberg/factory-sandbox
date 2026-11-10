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

    @Test
    void farewellIsKeptInHistoryAfterGreeting() {
        greetings.greet("Ada");
        Greeting bye = greetings.farewell("Ada");
        assertThat(bye.text()).isEqualTo("Goodbye, Ada!");
        List<String> texts = greetings.history().stream().map(Greeting::text).toList();
        assertThat(texts.indexOf("Hello, Ada!")).isLessThan(texts.indexOf("Goodbye, Ada!"));
    }

    @Test
    void frenchTexts() {
        assertThat(greetings.greetInFrench("Ada").text()).isEqualTo("Bonjour, Ada!");
        assertThat(greetings.farewellInFrench("Ada").text()).isEqualTo("Au revoir, Ada!");
    }

    @Test
    void historyKeepsEnglishAndFrenchInOrder() {
        greetings.greet("Zoe");
        greetings.greetInFrench("Zoe");
        greetings.farewellInFrench("Zoe");
        List<String> texts = greetings.history().stream().map(Greeting::text).toList();
        int hello = texts.indexOf("Hello, Zoe!");
        int bonjour = texts.indexOf("Bonjour, Zoe!");
        int revoir = texts.indexOf("Au revoir, Zoe!");
        assertThat(hello).isNotNegative();
        assertThat(hello).isLessThan(bonjour);
        assertThat(bonjour).isLessThan(revoir);
    }
}
