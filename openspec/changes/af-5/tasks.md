## 1. Clock module
- [ ] 1.1 Add `nl.badgerhill.sandbox.clock` with a `package-info.java` (`@ApplicationModule(displayName = "Clock")`),
  `ClockService` and `CurrentTime(Instant time)`
- [ ] 1.2 Implement `DefaultClockService` in `clock/internal` returning `new CurrentTime(Instant.now())`
- [ ] 1.3 Add `ClockController` in `clock/internal` with `GET /time` calling `ClockService.now()`
- [ ] 1.4 Add a `ClockApiTest` asserting the returned time lies between instants taken before and after the call;
  `./gradlew check` passes (`ModulithTest`, `ArchitectureTest`)
