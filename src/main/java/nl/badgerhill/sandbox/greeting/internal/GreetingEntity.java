package nl.badgerhill.sandbox.greeting.internal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "greeting")
class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String text;

    protected GreetingEntity() {
    }

    GreetingEntity(String name, String text) {
        this.name = name;
        this.text = text;
    }

    Long getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getText() {
        return text;
    }
}
