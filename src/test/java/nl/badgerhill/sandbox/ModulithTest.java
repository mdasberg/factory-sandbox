package nl.badgerhill.sandbox;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

/** Module boundaries: only a module's root package is public; {@code internal} stays private. */
class ModulithTest {

    @Test
    void modulesAreWellFormed() {
        ApplicationModules.of(SandboxApplication.class).verify();
    }
}
