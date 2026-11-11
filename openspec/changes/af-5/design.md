# Design

Telling the time has nothing to do with greetings, so it gets its own Spring Modulith module
`nl.badgerhill.sandbox.clock`, laid out like `greeting`: `ClockService` and `CurrentTime` in the root package,
`DefaultClockService` and `ClockController` in `internal/`. The controller calls `ClockService.now()`; there is no
repository.

The time is an `Instant` from `Instant.now()`, so it is always UTC and independent of the server's zone. Spring Boot's
Jackson defaults write it as an ISO-8601 string (`2026-11-11T10:15:30.123Z`); no formatter or config is added. The
response is wrapped in `CurrentTime` rather than a bare string so it is a JSON object like the greeting responses.

No timezone or format parameter, no persistence and no `Clock` bean: nobody asked for them. The test checks that the
returned instant lies between two `Instant.now()` calls taken around the request.
