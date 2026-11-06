package nl.badgerhill.sandbox.greeting.internal;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {

    List<GreetingEntity> findAllByOrderByIdAsc();
}
