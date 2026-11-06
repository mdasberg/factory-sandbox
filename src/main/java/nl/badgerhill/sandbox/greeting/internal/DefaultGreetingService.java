package nl.badgerhill.sandbox.greeting.internal;

import java.util.List;
import nl.badgerhill.sandbox.greeting.Greeting;
import nl.badgerhill.sandbox.greeting.GreetingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class DefaultGreetingService implements GreetingService {

    private final GreetingRepository repository;

    DefaultGreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Greeting greet(String name) {
        var saved = repository.save(new GreetingEntity(name, "Hello, " + name + "!"));
        return toGreeting(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Greeting> history() {
        return repository.findAllByOrderByIdAsc().stream().map(DefaultGreetingService::toGreeting).toList();
    }

    private static Greeting toGreeting(GreetingEntity e) {
        return new Greeting(e.getId(), e.getName(), e.getText());
    }
}
