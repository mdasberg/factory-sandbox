# factory-sandbox

Sandbox for the AI Factory: a stripped Spring Modulith service with the conventions the factory targets
(Java 21, Spring Boot 3, Gradle Kotlin DSL, Liquibase-owned schema, ArchUnit + Modulith boundary tests).
No real domain, no real data.

## Layout
- `nl.badgerhill.sandbox.<module>`: a Spring Modulith module. Its root package is the public API
  (interfaces + records). `internal/` holds entities, repositories, controllers and service impls.
- Schema changes go in `src/main/resources/db/changelog/` as a new changeSet; never edit an applied one.
  `ddl-auto: validate` makes a drifted entity fail at startup.

## Rules
- Constructor injection only. Controllers call the module's service API, never a repository.
- `./gradlew check` must pass: unit tests, `ModulithTest` (module boundaries), `ArchitectureTest`.
- Smallest change that satisfies the ticket. No new dependencies unless the ticket asks for one.
- Do not commit or push; the factory does that.

## Commands
- build: `./gradlew build -x test --quiet`
- test:  `./gradlew test --quiet`
- check: `./gradlew check --quiet`
